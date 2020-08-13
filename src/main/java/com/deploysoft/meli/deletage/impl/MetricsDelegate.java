package com.deploysoft.meli.deletage.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author : J. Andrés Boyacá Silva
 * @since : 8/13/2020, Thu
 **/
@Component
@Slf4j
public class MetricsDelegate {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Object getMetrics() {
        String query = null;
        ClassPathResource resource = new ClassPathResource("/metrics.sql");
        try {
            byte[] dataArr = FileCopyUtils.copyToByteArray(resource.getInputStream());
            query = new String(dataArr, StandardCharsets.UTF_8);
        } catch (IOException e) {
            log.error("Error with file path {}", e.getMessage());
            return "No metrics";
        }
        return jdbcTemplate.queryForObject(query, Object.class);
    }

}
