package ru.mephi.transportations.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Getter
@Setter
public class Manager {

    public void orderToTransport(Warehouse warehouse, Driver driver) {
        driver.transport(warehouse, this);
    }

    public void doChecking(Warehouse warehouse, Driver driver) {
        int numberOfRides = driver.getNumberOfRides();
        if (numberOfRides % 5 == 0) {
            alert(warehouse);
        }
    }

    public void alert(Warehouse warehouse) {
        warehouse.increment();
    }

    public int getResult(Driver driver) {
        return driver.getNumberOfRides();
    }

}
