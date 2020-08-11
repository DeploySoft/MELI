package com.deploysoft.meli.deletage;

import com.deploysoft.meli.deletage.impl.StrategyDataBase;
import com.deploysoft.meli.deletage.impl.StrategyWebService;
import com.deploysoft.meli.domain.model.Item;
import com.deploysoft.meli.dto.ItemDto;
import com.deploysoft.meli.service.dto.ItemResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Facade pattern
 *
 * @author : J. Andrés Boyacá Silva
 * @since : 8/11/2020, Tue
 **/
@Service
@AllArgsConstructor
public class Facade {

    private final StrategyDataBase strategyDataBase;
    private final StrategyWebService strategyWebService;

    public ResponseEntity<ItemDto> getItem(String itemId) {
        Optional<Item> item = strategyDataBase.getItem(itemId);
        if (item.isPresent()) {
            return strategyDataBase.getItemResponse(item.get());
        } else {
            Optional<ItemResponse> ws = strategyWebService.getItem(itemId);
            if (ws.isPresent()) {
                strategyDataBase.save(ws.get());
                return strategyWebService.getItemResponse(ws.get());
            }
        }
        return ResponseEntity.badRequest().body(null);
    }
}
