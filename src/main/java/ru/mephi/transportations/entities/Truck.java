package ru.mephi.transportations.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Truck {

    private int occupancy;
    private final int capacity = 10;

    public void load(Box box) {
        occupancy += box.value();
    }

    public void offload() {
        occupancy--;
    }

    public boolean isNotEmpty() {
        return occupancy != 0;
    }

    public boolean isNotFull() {
        return occupancy != capacity;
    }
}
