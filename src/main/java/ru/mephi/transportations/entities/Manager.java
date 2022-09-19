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

//    public Manager(Driver driver) {
//        this.driver = driver;
////        this.warehouse = warehouse;
//    }
//    @Autowired
//    private Driver driver;
//    @Autowired
//    private Warehouse warehouse;

    public int orderToTransport(Driver driver) {
        return driver.transport();
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

    public int toSumUp(Driver driver) {
        return driver.getNumberOfRides();
    }

}
