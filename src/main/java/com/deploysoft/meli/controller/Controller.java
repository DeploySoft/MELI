package com.deploysoft.meli.controller;

import com.deploysoft.meli.deletage.Facade;
import com.deploysoft.meli.dto.ItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private Facade facade;

    @GetMapping("/items/{itemId}")
    public ResponseEntity<ItemDto> getItem(@PathVariable("itemId") String itemId) {
        return facade.getItem(itemId, false);
    }

    @GetMapping("/items/{itemId}/children")
    public ResponseEntity<ItemDto> getItemWithChildren(@PathVariable("itemId") String itemId) {
        return facade.getItem(itemId, true);
    }

}
