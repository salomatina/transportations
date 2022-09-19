package ru.mephi.transportations.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
//@Component
public class Truck {

    private int numberOfBoxes;

    private int spaceAvailable = 10;
    public void increment() {
        numberOfBoxes++;
        spaceAvailable--;
    }

    public void decrement() {
        numberOfBoxes -= 10;
        spaceAvailable += 10;
    }

    public boolean isEmpty() {
        return numberOfBoxes == 0;
    }

    public boolean isFull() {
        return spaceAvailable == 0;
    }
}
