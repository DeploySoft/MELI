package com.deploysoft.meli.deletage.impl;

import com.deploysoft.meli.deletage.StrategyAbs;
import com.deploysoft.meli.dto.ItemDto;
import com.deploysoft.meli.mapper.impl.WebServiceMapper;
import com.deploysoft.meli.service.client.meli.IMercadoLibre;
import com.deploysoft.meli.service.client.meli.dto.ItemResponse;
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

    /**
     * This method will remove its children if children is false
     *
     * @param itemId   item
     * @param children default true to get information just one time and save
     * @return
     */
    @Override
    public Optional<ItemResponse> getItem(String itemId, boolean children) {
        ResponseEntity<ItemResponse> response = iMercadoLibre.getItem(itemId);
        if (HttpStatus.BAD_REQUEST.equals(response.getStatusCode())) {
            return Optional.empty();
        }
        ItemResponse item = response.getBody();
        if (children) {
            ResponseEntity<List<ItemResponse>> responseChildren = iMercadoLibre.getItemChildren(item.getId());
            if (HttpStatus.OK.equals(responseChildren.getStatusCode())) {
                item.setChildren(responseChildren.getBody());
            }
        }
        return Optional.ofNullable(item);
    }
}
