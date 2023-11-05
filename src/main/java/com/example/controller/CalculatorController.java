package com.example.controller;

import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.CalculatorDto;
import com.example.service.impl.CalculatorService;

//POST - http://localhost:9090/sum
//{
//    "number1": "10",
//    "number2": "5",
//    "apiName": "sub"
//}

@RestController
public class CalculatorController {

	@Autowired
	private CalculatorService calculatorService;

	@PostMapping(value = "/sum")
	public int sum(@RequestBody CalculatorDto calculatorDto)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return (int) calculatorService.callReflectionServiceMethods(calculatorDto);
	}

}
