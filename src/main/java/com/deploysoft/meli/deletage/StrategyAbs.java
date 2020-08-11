package com.deploysoft.meli.deletage;

import org.springframework.http.ResponseEntity;

/**
 * Template pattern
 *
 * @author : J. Andrés Boyacá Silva
 * @since : 8/11/2020, Tue
 **/
public abstract class StrategyAbs<T> implements Strategy<T> {

    public abstract ResponseEntity<T> getItemResponse(String itemId);




}