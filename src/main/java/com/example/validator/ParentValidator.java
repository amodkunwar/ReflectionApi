package com.example.validator;

import org.apache.commons.lang3.StringUtils;

import com.example.util.Constant;

public interface ParentValidator {

	static String isNotBlank(String fieldName, String fieldValue) {
		if (StringUtils.isBlank(fieldValue)) {
			return String.join("", fieldName, " should not be empty or blank");
		}
		return Constant.SUCCESS;
	}

}
