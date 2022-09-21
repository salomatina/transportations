package ru.mephi.transportations.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

@Getter
@Setter
public class Warehouse {

    private int numberOfPieces;
    private File file;

    public Warehouse() throws FileNotFoundException {
        initializeData();
        numberOfPieces = readData();
    }

    public boolean isNotEmpty() {
        return numberOfPieces != 0;
    }

    public Box getBox() {
        return new Box();
    }

    public PieceOfLuck getPieceOfLuck() {
        numberOfPieces--;
        return new PieceOfLuck();
    }

    public void increment() throws FileNotFoundException {
        numberOfPieces += 112;
        writeData(numberOfPieces);
        System.out.printf("Pieces have been increased to %d\n", numberOfPieces);
    }

    public void removeData() throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(file);
        writer.print("");
        writer.close();
    }

    public void writeData(int numberOfPieces) throws FileNotFoundException {
        removeData();
        PrintWriter writer = new PrintWriter(file);
        writer.print(numberOfPieces);
        writer.close();
    }
    public int readData() throws FileNotFoundException {
        Scanner input = new Scanner(file);
        return input.nextInt();
    }

    public void initializeData() throws FileNotFoundException {
        file = new File("src/main/resources/warehouse.txt");
        removeData();
        PrintWriter writer = new PrintWriter(file);
        writer.print(10591);
        writer.close();
    }
}
