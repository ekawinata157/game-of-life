package com.btpn.app;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameOfLife gameOfLife = new GameOfLife();
        gameOfLife.promptNextGeneration(handleUserInput(), 1);
        System.out.println(gameOfLife);
    }

    private static HashSet<Coordinate> handleUserInput() {
        final String INPUT_DELIMITER = "next";
        final String COORDINATE_SEPARATOR = ",";
        HashSet<Coordinate> livingCellsCoordinate = new HashSet<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            if (input.equals(INPUT_DELIMITER)) {
                break;
            }
            String[] coordinateString;
            coordinateString = input.split(COORDINATE_SEPARATOR);
            Coordinate coordinate = new Coordinate(Integer.valueOf(coordinateString[0]), Integer.valueOf(coordinateString[1]));
            livingCellsCoordinate.add(coordinate);
        }
        return livingCellsCoordinate;
    }
}
