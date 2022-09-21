package ru.mephi.transportations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.mephi.transportations.entities.Driver;
import ru.mephi.transportations.entities.Manager;
import ru.mephi.transportations.entities.Truck;
import ru.mephi.transportations.entities.Warehouse;

import java.io.FileNotFoundException;

@SpringBootApplication
public class TransportationsApplication {
    public static void main(String[] args) throws FileNotFoundException {
        SpringApplication.run(TransportationsApplication.class, args);
        new TransportationsApplication().countNumberOfRides();
    }

    public void countNumberOfRides() throws FileNotFoundException {
        Manager manager = new Manager();
        Warehouse warehouse = new Warehouse();
        Truck truck = new Truck();
        Driver driver = new Driver(truck);
        while (warehouse.isNotEmpty()) {
            manager.orderToTransport(driver, warehouse);
            warehouse.writeData(warehouse.getNumberOfPieces());
            int numberOfRides = manager.getResult(driver);
            manager.incrementIfNeeded(warehouse, numberOfRides);
        }
        int result = manager.getResult(driver);
        System.out.printf("All the pieces have been moved in %d rides", result);
    }

}
