package com.deploysoft.meli.deletage.impl;

import com.deploysoft.meli.deletage.StrategyAbs;
import com.deploysoft.meli.dto.ItemDto;
import com.deploysoft.meli.mapper.impl.WebServiceMapper;
import com.deploysoft.meli.service.IMercadoLibre;
import com.deploysoft.meli.service.dto.ItemResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author : J. Andrés Boyacá Silva
 * @since : 8/11/2020, Tue
 **/
@Service
@AllArgsConstructor
public class StrategyWebService extends StrategyAbs<ItemResponse> {

    private final IMercadoLibre iMercadoLibre;

    private final WebServiceMapper webServiceMapper;

    @Override
    public ResponseEntity<ItemDto> getItemResponse(ItemResponse item) {
        return ResponseEntity.ok(webServiceMapper.entityToDTO(item));
    }

    @Override
    public Optional<ItemResponse> getItem(String itemId) {

        ResponseEntity<ItemResponse> response = iMercadoLibre.getItem(itemId);
        if (HttpStatus.BAD_REQUEST.equals(response.getStatusCode())) {
            return Optional.empty();
        }
        ItemResponse item = response.getBody();
        ResponseEntity<List<ItemResponse>> responseChildren = iMercadoLibre.getItemChildren(item.getId());
        if (HttpStatus.OK.equals(responseChildren.getStatusCode())) {
            item.setChildren(responseChildren.getBody());
        }

        return Optional.ofNullable(item);
    }
}
