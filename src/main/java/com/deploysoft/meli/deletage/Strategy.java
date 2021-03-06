package com.deploysoft.meli.deletage;


import java.util.Optional;

/**
 * Template pattern
 *
 * @author : J. Andrés Boyacá Silva
 * @since : 8/11/2020, Tue
 **/
public interface Strategy<T> {
    Optional<T> getItem(String itemId, boolean children);
}
