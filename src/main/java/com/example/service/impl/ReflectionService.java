package com.example.service.impl;

import org.springframework.stereotype.Service;

import com.example.dto.ApplyCalculator;
import com.example.dto.CalculatorDto;
import com.example.util.Constant;

@Service
public class ReflectionService {

	@ApplyCalculator(Constant.SUM)
	public Object sumOfNumber(CalculatorDto calculatorDto) {
		return calculatorDto.getNumber1() + calculatorDto.getNumber2();
	}

	@ApplyCalculator(Constant.SUB)
	public Object subOfNumber(CalculatorDto calculatorDto) {
		return Math.abs(calculatorDto.getNumber1()) - Math.abs(calculatorDto.getNumber2());
	}

}
