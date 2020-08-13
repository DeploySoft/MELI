package com.deploysoft.meli.deletage.impl;

import com.deploysoft.meli.deletage.StrategyAbs;
import com.deploysoft.meli.domain.model.Item;
import com.deploysoft.meli.dto.ItemDto;
import com.deploysoft.meli.mapper.impl.DataBaseMapper;
import com.deploysoft.meli.mapper.impl.WsToDbMapper;
import com.deploysoft.meli.repository.ItemRepository;
import com.deploysoft.meli.service.client.meli.dto.ItemResponse;
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
    public Optional<Item> getItem(String itemId, boolean children) {
        Optional<Item> byId = itemRepository.findById(itemId);
        return byId.map(item -> {
            if (!children)
                item.setChildren(null);
            return item;
        });
    }


    public void save(ItemResponse itemResponse) {
        CompletableFuture.supplyAsync(() -> {
            itemResponse.getChildren().forEach(children -> itemRepository.save(wsToDbMapper.dtoToEntity(children)));
            return itemRepository.save(wsToDbMapper.dtoToEntity(itemResponse));
        });
    }
}
