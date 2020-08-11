package com.deploysoft.meli.deletage.impl;

import com.deploysoft.meli.deletage.StrategyAbs;
import com.deploysoft.meli.service.dto.ItemResponse;
import org.springframework.http.ResponseEntity;

/**
 * @author : J. Andrés Boyacá Silva
 * @since : 8/11/2020, Tue
 **/
public class StrategyDataBase extends StrategyAbs<ItemResponse> {

    @Override
    public ResponseEntity<ItemResponse> getItemResponse(String itemId) {
        return null;
    }

    @Override
    public ItemResponse getItem(String itemId) {
        return null;
    }
}
