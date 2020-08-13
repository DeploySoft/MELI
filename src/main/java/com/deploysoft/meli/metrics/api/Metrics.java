package com.deploysoft.meli.metrics.api;

import com.deploysoft.meli.metrics.constants.Category;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author : J. Andrés Boyacá Silva
 * @since : 8/12/2020, Wed
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Metrics {
    Category type() default Category.INBOUND;
}
