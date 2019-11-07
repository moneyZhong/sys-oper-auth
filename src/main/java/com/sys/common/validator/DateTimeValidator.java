/**
 * 日期格式验证.
 */
package com.sys.common.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class DateTimeValidator implements ConstraintValidator<DateTime, String> {

	/**
	 * 
	 */
	private SimpleDateFormat simpleDateFormat;

	@Override
	public void initialize(DateTime constraintAnnotation) {
		simpleDateFormat = new SimpleDateFormat(constraintAnnotation.pattern());
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		if (null == value || "".equals(value)){
			return true;
		}
		try {
			simpleDateFormat.parse(value);
		} catch (ParseException e) {
			return false;
		}

		return true;
	}

}
