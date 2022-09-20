package ru.mephi.transportations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TransportationsApplication {
    public static void main(String[] args) {
        SpringApplication.run(TransportationsApplication.class, args);
        TransportationManager transportationManager = new TransportationManager();
        transportationManager.run();
        System.out.println();
    }

}
