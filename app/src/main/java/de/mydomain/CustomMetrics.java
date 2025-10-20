package de.mydomain;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

@Component
public class CustomMetrics {

    private final Counter requestCounter;

    public CustomMetrics(MeterRegistry registry) {
        requestCounter = Counter.builder("custom_requests_total")
                .description("Anzahl der /hello-Anfragen")
                .register(registry);
    }

    public void increment() {
        requestCounter.increment();
    }
}
