package com.deploysoft.meli.metrics.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author : J. Andrés Boyacá Silva
 * @since : 8/12/2020, Wed
 **/
@Data
@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Table(name = "metrics")
public class Metric implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "date")
    private LocalDateTime dateTime;

    private boolean requestIn;

    private Integer code;

    private Long time;

}

