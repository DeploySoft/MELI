package com.deploysoft.meli.mapper.impl;

import com.deploysoft.meli.domain.model.Item;
import com.deploysoft.meli.dto.ItemDto;
import com.deploysoft.meli.mapper.IMapperGeneric;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author : J. Andrés Boyacá Silva
 * @since : 8/11/2020, Tue
 **/
@Mapper(componentModel = "spring" ,unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DataBaseMapper extends IMapperGeneric<Item, ItemDto> {

}
