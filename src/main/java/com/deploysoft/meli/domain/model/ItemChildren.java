package com.deploysoft.meli.domain.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author : J. Andrés Boyacá Silva
 * @since : 8/11/2020, Tue
 **/
@Data
@Entity
@Table(name = "item_children")
public class ItemChildren implements Serializable {
    @Id
    private String parent;
    @Id
    private String children;
}
