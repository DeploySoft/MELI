package com.deploysoft.meli.controller;

import com.deploysoft.meli.deletage.Facade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class Controller {
    @Autowired
    private Facade facade;


    @GetMapping("/test")
    public ResponseEntity getUsers() {
        return ResponseEntity.ok(facade.getItem("MLU460998489"));
    }

}
