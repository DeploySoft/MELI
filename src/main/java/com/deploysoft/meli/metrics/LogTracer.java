package com.deploysoft.meli.metrics;

import com.deploysoft.meli.metrics.api.Metrics;
import com.deploysoft.meli.metrics.constants.Category;
import com.deploysoft.meli.metrics.model.Metric;
import com.deploysoft.meli.metrics.repository.MetricsRepository;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;

/**
 * @author : J. Andrés Boyacá Silva
 * @since : 8/12/2020, Wed
 **/
@Aspect
@Component
public class LogTracer {

    private final MetricsRepository metricsRepository;

    public LogTracer(MetricsRepository metricsRepository) {
        this.metricsRepository = metricsRepository;
    }

    @Around("@annotation(metrics)")
    public Object generateMetric(ProceedingJoinPoint joint, Metrics metrics) throws Throwable {
        Instant start = Instant.now();
        Object proceed = joint.proceed();
        CompletableFuture.runAsync(() -> saveMetric(proceed, start, metrics));
        return proceed;
    }

    private void saveMetric(Object proceed, Instant start, Metrics metrics) {
        Metric.MetricBuilder builder = Metric.builder();
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        if (Category.OUTBOUND.equals(metrics.type()) && proceed instanceof ResponseEntity) {
            HttpStatus statusCode = ((ResponseEntity) proceed).getStatusCode();
            builder.code(statusCode.value());
        }
        builder.requestIn(metrics.type().isValue());
        builder.time(timeElapsed);
        builder.dateTime(LocalDateTime.now());
        metricsRepository.save(builder.build());
    }
}


