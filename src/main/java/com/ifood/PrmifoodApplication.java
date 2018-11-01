package com.ifood;

import com.ifood.controller.DishController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.ifood")
@EnableJpaRepositories("com.ifood.repository")
public class PrmifoodApplication {
    public static void main(String[] args) {
        SpringApplication.run(PrmifoodApplication.class, args);
    }
}
