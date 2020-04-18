package com.btpn.app;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> userInputs = new ArrayList<>();
        HashSet<Coordinate> livingCellsCoordinate = new HashSet<>();
        GameOfLife gameOfLife = new GameOfLife();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("next")) {
                break;
            }
            userInputs.add(input);
        }

        for (String input : userInputs) {
            String[] coordinateString;
            coordinateString = input.split(",");
            Coordinate coordinate = new Coordinate(Integer.valueOf(coordinateString[0]), Integer.valueOf(coordinateString[1]));
            livingCellsCoordinate.add(coordinate);
        }

        gameOfLife.promptNextGeneration(livingCellsCoordinate);
        System.out.println(gameOfLife);
    }
}
