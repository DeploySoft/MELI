package com.deploysoft.meli.exception;

import com.deploysoft.meli.metrics.api.Metrics;
import com.deploysoft.meli.metrics.constants.Category;
import feign.FeignException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author : J. Andrés Boyacá Silva
 * @since : 8/11/2020, Tue
 **/
@ControllerAdvice
public class Handler {

    @Metrics(type = Category.OUTBOUND)
    @ExceptionHandler(FeignException.class)
    public ResponseEntity<?> handlerFeignException(FeignException ex) {
        return ResponseEntity.status(ex.status()).build();
    }
}
