package com.example.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.ApplyCalculator;
import com.example.dto.CalculatorDto;
import com.example.util.Constant;
import com.example.validator.CalculatorValidator;

@Service
public class CalculatorService {

	@Autowired
	private ReflectionService reflectionService;

	public Object callReflectionServiceMethods(CalculatorDto calculatorDto)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String validationResult = CalculatorValidator.isApiNotNull().apply(calculatorDto);
		if (!Constant.SUCCESS.equalsIgnoreCase(validationResult)) {
			return validationResult;
		}
		Class<? extends ReflectionService> clazz = reflectionService.getClass();
		for (Method method : clazz.getDeclaredMethods()) {
			String value = method.getAnnotation(ApplyCalculator.class).value();
			if (Objects.nonNull(value) && Objects.nonNull(calculatorDto)
					&& calculatorDto.getApiName().equalsIgnoreCase(value)) {
				return method.invoke(reflectionService, calculatorDto);
			}
		}
		return null;
	}

}
