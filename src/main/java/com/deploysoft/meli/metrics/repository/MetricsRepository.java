package com.deploysoft.meli.metrics.repository;

import com.deploysoft.meli.metrics.model.Metric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : J. Andrés Boyacá Silva
 * @since : 8/11/2020, Tue
 **/
@Repository
public interface MetricsRepository extends JpaRepository<Metric, Long> {
}
