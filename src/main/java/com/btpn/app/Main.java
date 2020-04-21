package com.btpn.app;

public class Main {
    public static void main(String[] args) {
        GameOfLife gameOfLife = new GameOfLife();
        InputParser inputParser = new InputParser();
        gameOfLife.promptNextGeneration(inputParser.handleLivingCellsCoordinateInput());
        System.out.println(gameOfLife);
    }
}
