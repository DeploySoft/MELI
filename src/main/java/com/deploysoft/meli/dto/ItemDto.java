package com.deploysoft.meli.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * @author : J. Andrés Boyacá Silva
 * @since : 8/11/2020, Tue
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {
    private String id;
    private String title;
    private String categoryId;
    private Float price;
    private LocalDateTime startTime;
    private LocalDateTime stopTime;
    private Set<ItemDto> children;
}
