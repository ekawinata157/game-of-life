package com.btpn.app;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class InputParser {
    private final Scanner scanner;

    public InputParser(Scanner scanner) {
        this.scanner = scanner;
    }

    Set<Coordinate> handleLivingCellsCoordinateInput() {
        final String INPUT_DELIMITER = "next";
        final String COORDINATE_SEPARATOR = ",";
        Set<Coordinate> livingCellsCoordinate = new HashSet<>();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals(INPUT_DELIMITER)) {
                break;
            }
            String[] coordinateString = input.split(COORDINATE_SEPARATOR);
            Coordinate coordinate = new Coordinate(Integer.parseInt(coordinateString[0]), Integer.parseInt(coordinateString[1]));
            livingCellsCoordinate.add(coordinate);
        }
        return livingCellsCoordinate;
    }
}
