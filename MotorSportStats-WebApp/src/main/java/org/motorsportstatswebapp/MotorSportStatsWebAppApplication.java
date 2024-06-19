package org.motorsportstatswebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ComponentScan({"org.motorsportstatswebapp", "org.motorsportstats.services", "org.motorsportstatscore"})
@ImportResource("classpath:spring-config.xml")
public class MotorSportStatsWebAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MotorSportStatsWebAppApplication.class, args);
    }

}
