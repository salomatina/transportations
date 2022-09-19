package ru.mephi.transportations.entities;

public class Box {
    private int numberOfPieces;

    public boolean isFull() {
        return numberOfPieces >= 4;
    }

    public void increment() {
        numberOfPieces++;
    }

}
