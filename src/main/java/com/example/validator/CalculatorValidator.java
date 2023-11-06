package com.example.validator;

import java.util.function.Function;

import com.example.dto.CalculatorDto;
import com.example.util.Constant;

public interface CalculatorValidator extends Function<CalculatorDto, String> {

	static CalculatorValidator isApiNotNull() {
		return calculatorDto -> ParentValidator.isNotBlank("apiName", calculatorDto.getApiName());

	}

	default CalculatorValidator and(CalculatorValidator other) {
		return calculatorDto -> {
			String result = this.apply(calculatorDto);
			return result.equals(Constant.SUCCESS) ? other.apply(calculatorDto) : result;
		};
	}

}
