package com.deploysoft.meli.controller;

import com.deploysoft.meli.repository.ItemRepository;
import com.deploysoft.meli.service.IMercadoLibre;
import com.deploysoft.meli.service.dto.ItemResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class Controller {

    @Autowired
    private IMercadoLibre iMercadoLibre;
    @Autowired
    private ItemRepository itemRepository;



    @GetMapping("/test")
    public ResponseEntity getUsers() {
        ItemResponse mlu468887129 = iMercadoLibre.getItem("MLU460998489");
        mlu468887129.setChildren(iMercadoLibre.getItemChildren("MLU460998489"));
        itemRepository.findById("123");
        return ResponseEntity.ok(mlu468887129);
    }

}
