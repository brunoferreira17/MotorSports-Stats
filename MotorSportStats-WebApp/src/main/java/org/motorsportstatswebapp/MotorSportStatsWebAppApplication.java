package org.motorsportstatswebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "org.motorsportswebapp.entity")
@EnableJpaRepositories(basePackages = "org.motorsportstatswebapp.repository")
public class MotorSportStatsWebAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MotorSportStatsWebAppApplication.class, args);
    }

}
