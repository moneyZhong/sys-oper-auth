package com.sys.common.annotation;

import java.lang.annotation.*;

/**
 *校验签名
 */
@Target({ ElementType.PARAMETER, ElementType.METHOD,ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ValidSign {
	 public String name() default "";
}
