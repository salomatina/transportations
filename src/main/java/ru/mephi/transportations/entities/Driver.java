package ru.mephi.transportations.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Getter
@Setter
//@Component
public class Driver {

    public Driver(Truck truck, Warehouse warehouse) {
        this.truck = truck;
        this.warehouse = warehouse;
    }
//     @Autowired
     private Truck truck;

     private int numberOfRides;

//     @Autowired
     Warehouse warehouse;

     public int transport() {
         while (!checkWarehouse()) {
             while (!checkWarehouse() && !checkTruck()) {
                 Box box = takeBox();
                 while (!checkWarehouse() && !check(box)) {
                     PieceOfLuck pieceOfLuck = takePL();
                     put(pieceOfLuck,box);
                 }
                 put(box);
             }
             drive();
             tellManager();
         }
         return alert();
     }
//    public int transport() {
//        do {
//            do {
//                Box box = takeBox();
//                do {
//                    PieceOfLuck pieceOfLuck = takePL();
//                    put(pieceOfLuck, box);
//                    if (checkWarehouse()) {
//                        break;
//                    }
//                }
//                while (!check(box) && !checkWarehouse());
//                put(box);
//            }
//            while (!checkTruck() && !checkWarehouse());
//            drive();
//            tellManager();
//        }
//        while (!checkWarehouse());
//        return alert();
//    }

    private int alert() {
        return warehouse.getManager().toSumUp(this);
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
        warehouse.getManager().doChecking(warehouse, this);
    }
}
