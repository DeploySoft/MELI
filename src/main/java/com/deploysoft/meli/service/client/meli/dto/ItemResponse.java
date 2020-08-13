package com.deploysoft.meli.service.client.meli.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemResponse {
    private String id;
    private String title;
    private String categoryId;
    private Float price;
    private LocalDateTime startTime;
    private LocalDateTime stopTime;
    private List<ItemResponse> children;
}