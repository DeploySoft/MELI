package com.deploysoft.meli.mapper;

import java.util.List;

/**
 * @author : J. Andrés Boyacá Silva
 * @since : 8/11/2020, Tue
 **/
public interface IMapperGeneric<T, D> {

    T dtoToEntity(D dto);

    D entityToDTO(T entity);

    List<D> entityToDTO(List<T> entity);

    List<T> dtoToEntity(List<D> entity);

}
