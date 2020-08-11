package com.deploysoft.meli.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author : J. Andrés Boyacá Silva
 * @since : 8/11/2020, Tue
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemChildrenDto {
    private String id;
    private LocalDateTime stopTime;
}
