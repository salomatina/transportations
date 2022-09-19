package ru.mephi.transportations.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Getter
@Setter
@Component
public class Driver {
     @Autowired
     private Truck truck;

     private int numberOfRides;

     @Autowired
     Warehouse warehouse;
    public int transport() {
        do {
            do {
                Box box = takeBox();
                do {
                    PieceOfLuck pieceOfLuck = takePL();
                    put(pieceOfLuck, box);
                    if (checkWarehouse()) {
                        break;
                    }
                }
                while (!check(box));
                put(box);
            }
            while (!checkTruck());
            drive();
            tellManager();
        }
        while (!checkWarehouse());
        return alert();
    }

    private int alert() {
        return warehouse.getManager().toSumUp();
    }

    public boolean checkWarehouse() {
        return warehouse.isEmpty();
    }

    public boolean checkTruck() {
        return truck.isFull();
    }

    public Box takeBox() {
        return warehouse.giveBox();
    }

    public boolean check(Box box) {
        return box.isFull();
    }

    public PieceOfLuck takePL() {
        return warehouse.givePL();
    }

    public void put(PieceOfLuck pieceOfLuck, Box box) {
        box.increment();
    }

    public void put(Box box) {
        truck.increment();
    }

    public void drive() {
        while (!truck.isEmpty()) {
            truck.decrement();
            numberOfRides++;
        }
    }

    public void tellManager() {
        warehouse.getManager().doChecking();
    }
}
