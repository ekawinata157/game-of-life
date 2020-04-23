package com.btpn.app;

public class Main {
    public static void main(String[] args) {
        GameOfLife gameOfLife = new GameOfLife();
        InputParser inputParser = new InputParser();
        gameOfLife.seed(inputParser.handleLivingCellsCoordinateInput());
        gameOfLife.updateGameState();
        System.out.println(gameOfLife);
    }
}
