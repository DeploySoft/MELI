package com.deploysoft.meli.deletage;


/**
 * @author : J. Andrés Boyacá Silva
 * @since : 8/11/2020, Tue
 **/
public interface Strategy<T> {
    T getItem(String itemId);
}
