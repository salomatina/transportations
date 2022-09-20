package ru.mephi.transportations.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Component
public class Truck {

    private int fullness;

    private int capacity = 10;

    public void load(Box box) {
        fullness += box.value();
        capacity -= box.value();
    }

    public void offload() {
        fullness--;
        capacity++;
    }

    public boolean isNotEmpty() {
        return fullness != 0;
    }

    public boolean isNotFull() {
        return capacity != 0;
    }
}
