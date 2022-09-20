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

    public void run() {
        Manager manager = new Manager();
        Warehouse warehouse = new Warehouse();
        Truck truck = new Truck();
        Driver driver = new Driver(truck);
        while (warehouse.isNotEmpty()) {
            manager.orderToTransport(warehouse, driver);
        }
        int result = manager.getResult(driver);
        System.out.printf("All the pieces have been moved in %d rides", result);
    }

}
