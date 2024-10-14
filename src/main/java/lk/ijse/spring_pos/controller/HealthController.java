package lk.ijse.spring_pos.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/health")
public class HealthController {

    static Logger logger = LoggerFactory.getLogger(HealthController.class);

    @GetMapping
    public String healthCheck() {
        System.out.println("Spring POS API is running");
        logger.info("Spring POS API is running");
        return "Spring POS API is running";
    }

}
