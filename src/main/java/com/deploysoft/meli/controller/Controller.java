package com.deploysoft.meli.controller;

import com.deploysoft.meli.service.IMercadoLibre;
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


    @GetMapping("/test")
    public ResponseEntity getUsers() {
        return ResponseEntity.ok(iMercadoLibre.getItem("MLU468887129"));
    }

}
