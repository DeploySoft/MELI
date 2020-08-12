package com.deploysoft.meli.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * @author : J. Andrés Boyacá Silva
 * @since : 8/11/2020, Tue
 **/
@Data
@Entity
@Table(name = "item")
public class Item implements Serializable {
    @Id
    private String id;

    private String title;

    @Column(name = "category_id")
    private String categoryId;

    private Float price;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "stop_time")
    private LocalDateTime stopTime;

    @ManyToMany
    @JoinTable(name = "item_children", joinColumns = @JoinColumn(name = "parent"), inverseJoinColumns = @JoinColumn(name = "children"))
    private Set<Item> children;

}