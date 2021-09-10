package com.btpn.app;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameOfLife gameOfLife = new GameOfLife();
        InputParser inputParser = new InputParser(scanner);
        gameOfLife.seed(inputParser.handleLivingCellsCoordinateInput());
        gameOfLife.updateGameState();
        System.out.println(gameOfLife);
    }
}
