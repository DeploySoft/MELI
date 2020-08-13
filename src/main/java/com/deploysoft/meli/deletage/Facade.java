package com.deploysoft.meli.deletage;

import com.deploysoft.meli.deletage.impl.StrategyDataBase;
import com.deploysoft.meli.deletage.impl.StrategyWebService;
import com.deploysoft.meli.domain.model.Item;
import com.deploysoft.meli.dto.ItemDto;
import com.deploysoft.meli.service.client.meli.dto.ItemResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;

/**
 * Facade pattern
 *
 * @author : J. Andrés Boyacá Silva
 * @since : 8/11/2020, Tue
 **/
@Component
public class Facade {

    private final ResponseEntity<ItemDto> badRequest = ResponseEntity.badRequest().body(null);

    private final List<BiFunction<String, Boolean, ResponseEntity<ItemDto>>> listStrategy;


    public Facade(StrategyDataBase strategyDataBase, StrategyWebService strategyWebService) {
        BiFunction<String, Boolean, ResponseEntity<ItemDto>> db = (itemId, children) -> {
            Optional<Item> item = strategyDataBase.getItem(itemId, children);
            return item.map(strategyDataBase::getItemResponse).orElse(badRequest);
        };
        BiFunction<String, Boolean, ResponseEntity<ItemDto>> ws = (itemId, children) -> {
            Optional<ItemResponse> item = strategyWebService.getItem(itemId, true);
            item.ifPresent(strategyDataBase::save);
            if (!children) {
                item = item.map(itemResponse -> {
                    itemResponse.setChildren(null);
                    return itemResponse;
                });
            }
            return item.map(strategyWebService::getItemResponse).orElse(badRequest);
        };
        listStrategy = Arrays.asList(db, ws);
    }

    public ResponseEntity<ItemDto> getItem(String itemId, boolean withChildren) {
        for (BiFunction<String, Boolean, ResponseEntity<ItemDto>> function : listStrategy) {
            ResponseEntity<ItemDto> apply = function.apply(itemId, withChildren);
            if (HttpStatus.BAD_REQUEST.equals(apply.getStatusCode())) {
                continue;
            }
            return apply;
        }
        return badRequest;
    }
}
