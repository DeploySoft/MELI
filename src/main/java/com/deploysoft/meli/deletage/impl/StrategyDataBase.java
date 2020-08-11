package com.deploysoft.meli.deletage.impl;

import com.deploysoft.meli.deletage.StrategyAbs;
import com.deploysoft.meli.domain.model.Item;
import com.deploysoft.meli.dto.ItemDto;
import com.deploysoft.meli.mapper.impl.DataBaseMapper;
import com.deploysoft.meli.mapper.impl.WsToDbMapper;
import com.deploysoft.meli.repository.ItemRepository;
import com.deploysoft.meli.service.dto.ItemResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

/**
 * @author : J. Andrés Boyacá Silva
 * @since : 8/11/2020, Tue
 **/
@Service
@AllArgsConstructor
public class StrategyDataBase extends StrategyAbs<Item> {

    private final ItemRepository itemRepository;
    private final DataBaseMapper dataBaseMapper;
    private final WsToDbMapper wsToDbMapper;

    @Override
    public ResponseEntity<ItemDto> getItemResponse(Item item) {
        return ResponseEntity.ok(dataBaseMapper.entityToDTO(item));
    }

    @Override
    public Optional<Item> getItem(String itemId) {
        return itemRepository.findById(itemId);
    }


    public void save(ItemResponse itemResponse) {
        CompletableFuture.runAsync(() -> itemRepository.save(wsToDbMapper.dtoToEntity(itemResponse)));
    }
}
