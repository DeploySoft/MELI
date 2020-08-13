package com.deploysoft.meli.metrics.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author : J. Andrés Boyacá Silva
 * @since : 8/12/2020, Wed
 **/
@Getter
@AllArgsConstructor
public enum Category {
    INBOUND(true),
    OUTBOUND(false);
    private boolean value;
}
