package ru.mephi.transportations.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Component
public class Driver {

    public Driver(Truck truck) {
        this.truck = truck;
    }

    //     @Autowired
    private Truck truck;

    private int numberOfRides;

    public void transport(Warehouse warehouse, Manager manager) {
        //while truck isn't full and there are pieces left in the warehouse
        //driver takes boxes to put pieces in them
        do {
            Box box = getBox(warehouse);
            System.out.printf("Box number %d was taken", truck.getFullness() + 1);
            System.out.println();
            //while box isn't full and there are pieces left in the warehouse
            //driver takes pieces from the warehouse and places them in the box
            do {
                PieceOfLuck pieceOfLuck = getPieceOfLuck(warehouse);
                putInBox(box, pieceOfLuck);
                System.out.printf("There are %d pieces in the box now", box.getNumberOfPieces());
                System.out.println();
            }
            while (boxIsNotFull(box) && warehouseIsNotEmpty(warehouse));
            putInTruck(box);
            System.out.printf("Loaded %d/10 boxes", truck.getFullness());
            System.out.println();
        }
        while (truckIsNotFull() && warehouseIsNotEmpty(warehouse));
        System.out.println("Driver is ready to drive");
        drive(warehouse);
        informManager(manager, warehouse);
    }

    public boolean warehouseIsNotEmpty(Warehouse warehouse) {
        return warehouse.isNotEmpty();
    }

    public boolean truckIsNotFull() {
        return truck.isNotFull();
    }

    public Box getBox(Warehouse warehouse) {
        return warehouse.giveBox();
    }

    public boolean boxIsNotFull(Box box) {
        return box.isNotFull();
    }

    public PieceOfLuck getPieceOfLuck(Warehouse warehouse) {
        return warehouse.givePL();
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
        System.out.printf("Transportation number %d was made. Number of pieces left: %d", numberOfRides, warehouse.getNumberOfPieces());
        System.out.println();
    }

    public void informManager(Manager manager, Warehouse warehouse) {
        manager.doChecking(warehouse, this);
    }
}
