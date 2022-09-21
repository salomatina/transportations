package ru.mephi.transportations.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Driver {

    public Driver(Truck truck) {
        this.truck = truck;
    }

    private Truck truck;
    private int numberOfRides;

    public void transport(Warehouse warehouse) {
        //while truck isn't full and there are pieces left in the warehouse
        //driver takes boxes to put pieces in them
        do {
            Box box = getBox(warehouse);
            System.out.printf("Box number %d was taken\n", truck.getOccupancy() + 1);
            //while box isn't full and there are pieces left in the warehouse
            //driver takes pieces from the warehouse and places them in the box
            do {
                PieceOfLuck pieceOfLuck = getPieceOfLuck(warehouse);
                putInBox(box, pieceOfLuck);
                System.out.printf("There are %d pieces in the box now\n", box.getNumberOfPieces());
            }
            while (boxIsNotFull(box) && warehouseIsNotEmpty(warehouse));
            putInTruck(box);
            System.out.printf("Loaded %d/10 boxes\n", truck.getOccupancy());
        }
        while (truckIsNotFull() && warehouseIsNotEmpty(warehouse));
        System.out.println("Driver is ready to drive");
        drive(warehouse);
    }

    public boolean warehouseIsNotEmpty(Warehouse warehouse) {
        return warehouse.isNotEmpty();
    }

    public boolean truckIsNotFull() {
        return truck.isNotFull();
    }

    public Box getBox(Warehouse warehouse) {
        return warehouse.getBox();
    }

    public boolean boxIsNotFull(Box box) {
        return box.isNotFull();
    }

    public PieceOfLuck getPieceOfLuck(Warehouse warehouse) {
        return warehouse.getPieceOfLuck();
    }

    public void putInBox(Box box, PieceOfLuck pieceOfLuck) {
        box.load(pieceOfLuck);
    }

    public void putInTruck(Box box) {
        truck.load(box);
    }

    public void drive(Warehouse warehouse) {
        //Freeing up space in the truck
        while (truck.isNotEmpty()) {
            truck.offload();
        }
        numberOfRides++;
        System.out.printf("Transportation number %d was made. Number of pieces left: %d\n", numberOfRides, warehouse.getNumberOfPieces());
    }

}
