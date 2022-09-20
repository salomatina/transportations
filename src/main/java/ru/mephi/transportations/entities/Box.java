package ru.mephi.transportations.entities;

import lombok.Getter;
import ru.mephi.transportations.IntegerValue;
@Getter
public class Box implements IntegerValue {
    private int numberOfPieces;
    private final int capacity = 4;

    public boolean isNotFull() {
        return numberOfPieces < capacity;
    }

    public void load(PieceOfLuck pieceOfLuck) {
        numberOfPieces += pieceOfLuck.value();
    }

    @Override
    public int value() {
        return 1;
    }
}
