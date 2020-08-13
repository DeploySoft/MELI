package com.deploysoft.meli.service.client.meli;

import com.deploysoft.meli.service.client.meli.dto.ItemResponse;
import com.deploysoft.meli.metrics.api.Metrics;
import com.deploysoft.meli.metrics.constants.Category;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@FeignClient(name = "meli", url = "${meli.app.urls.items}")
public interface IMercadoLibre {
    /**
     * @param itemId item value
     * @return {@link ItemResponse}
     */
    @Metrics(type = Category.OUTBOUND)
    @GetMapping(value = "/{itemId}", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<ItemResponse> getItem(@PathVariable(value = "itemId") String itemId);

    /**
     * @param itemId item value
     * @return {@link List<ItemResponse>}
     */
    @Metrics(type = Category.OUTBOUND)
    @GetMapping(value = "/{itemId}/children", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<List<ItemResponse>> getItemChildren(@PathVariable(value = "itemId") String itemId);

}
