package de.mydomain;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final CustomMetrics customMetrics;

    public HelloController(CustomMetrics customMetrics) {
        this.customMetrics = customMetrics;
    }

    @GetMapping("/hello")
    public String sayHello() {
        customMetrics.increment();
        return "Hallo Prometheus!";
    }
}
