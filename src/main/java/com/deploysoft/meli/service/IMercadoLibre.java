package com.deploysoft.meli.service;

import com.deploysoft.meli.service.dto.ItemResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@FeignClient(name = "meli", url = "${meli.app.urls.items}")
public interface IMercadoLibre {

    @GetMapping(value = "/{itemId}", produces = APPLICATION_JSON_VALUE)
    ItemResponse getItem(@PathVariable(value = "itemId") String itemId);

    @GetMapping(value = "/{itemId}/children", produces = APPLICATION_JSON_VALUE)
    List<ItemResponse> getItemChildren(@PathVariable(value = "itemId") String itemId);

}
