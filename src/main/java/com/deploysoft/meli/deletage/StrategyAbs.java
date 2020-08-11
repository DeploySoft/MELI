package com.deploysoft.meli.deletage;

import com.deploysoft.meli.dto.ItemDto;
import org.springframework.http.ResponseEntity;

/**
 * Template pattern
 *
 * @author : J. Andrés Boyacá Silva
 * @since : 8/11/2020, Tue
 **/
public abstract class StrategyAbs<T> implements Strategy<T> {

    public abstract ResponseEntity<ItemDto> getItemResponse(T Item);

}