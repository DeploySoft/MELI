package com.deploysoft.meli.mapper.impl;

import com.deploysoft.meli.domain.model.Item;
import com.deploysoft.meli.dto.ItemDto;
import com.deploysoft.meli.mapper.IMapperGeneric;
import com.deploysoft.meli.service.dto.ItemResponse;
import org.mapstruct.Mapper;

/**
 * @author : J. Andrés Boyacá Silva
 * @since : 8/11/2020, Tue
 **/
@Mapper(componentModel = "spring")
public interface WsToDbMapper extends IMapperGeneric<Item, ItemResponse> {

}
