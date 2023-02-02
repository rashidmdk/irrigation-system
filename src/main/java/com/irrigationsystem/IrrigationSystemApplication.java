package com.irrigationsystem;

import com.irrigationsystem.model.Irrigation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IrrigationSystemApplication {

    public static void main(String[] args) {

        Irrigation irrigation;

        SpringApplication.run(IrrigationSystemApplication.class, args);
    }

}
