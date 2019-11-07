/**
 * 日期格式验证.
 */
package com.sys.common.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = { DateTimeValidator.class })
@Documented
@Target({ ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface DateTime {

	/**
	 * 
	 * @return message
	 */
	String message() default "错误的日期格式";

	/**
	 * 
	 * @return pattern
	 */
	String pattern() default "yyyy-MM-dd HH:mm:ss";

	/**
	 * 
	 * @return groups
	 */
	Class<?>[] groups() default {};

	/**
	 * 
	 * @return payload
	 */
	Class<? extends Payload>[] payload() default {};

}
