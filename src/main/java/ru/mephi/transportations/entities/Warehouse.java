package ru.mephi.transportations.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Getter
@Setter
//@Component
public class Warehouse {

    private int numberOfPieces = 10591;

    public boolean isNotEmpty() {
        return numberOfPieces != 0;
    }

    public Box giveBox() {
        return new Box();
    }

    public PieceOfLuck givePL() {
        numberOfPieces--;
        return new PieceOfLuck();
    }

    public void increment() {
        numberOfPieces += 112;
        System.out.printf("Pieces have been increased to %d", numberOfPieces);
        System.out.println();
    }
}
