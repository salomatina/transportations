package ru.mephi.transportations.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Manager {
    @Autowired
    private Driver driver;
    @Autowired
    Warehouse warehouse;

    public int orderToTransport() {
        return driver.transport();
    }

    public void doChecking() {
        int numberOfRides = driver.getNumberOfRides();
        if (numberOfRides % 5 == 0) {
            alert();
        }
    }

    public void alert() {
        warehouse.increment();
    }

    public int toSumUp() {
        return driver.getNumberOfRides();
    }

}
