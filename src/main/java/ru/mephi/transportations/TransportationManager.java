package ru.mephi.transportations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.support.DataBindingMethodResolver;
import org.springframework.stereotype.Service;
import ru.mephi.transportations.entities.Driver;
import ru.mephi.transportations.entities.Manager;
import ru.mephi.transportations.entities.Truck;
import ru.mephi.transportations.entities.Warehouse;

//@Service
public class TransportationManager {
//    @Autowired
//    private Manager manager;

    public int run() {
        Manager manager = new Manager();
        Warehouse warehouse = new Warehouse(manager);
        Truck truck = new Truck();
        Driver driver = new Driver(truck,warehouse);
        return manager.orderToTransport(driver);
    }

}
