package ru.mephi.transportations.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.FileNotFoundException;

@Getter
@Setter
public class Manager {

    public void orderToTransport(Driver driver, Warehouse warehouse) {
        driver.transport(warehouse);
    }

    public void incrementIfNeeded(Warehouse warehouse, int numberOfRides) throws FileNotFoundException {
        if (numberOfRides % 5 == 0) {
            inform(warehouse);
        }
    }

    public void inform(Warehouse warehouse) throws FileNotFoundException {
        warehouse.increment();
    }

    public int getResult(Driver driver) {
        return driver.getNumberOfRides();
    }

}
