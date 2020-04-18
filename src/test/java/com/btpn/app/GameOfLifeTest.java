package com.btpn.app;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertTrue;

class GameOfLifeTest {
    @Test
    void seed_shouldMakeCountLivingCellReturn4AndCountDeadCellReturn12_whenLivingCellInputCoordinateIs_1And1_1And2_2And1_2And2() {
        GameOfLife gameOfLife = new GameOfLife();
        HashSet<Coordinate> livingCellInput = new HashSet<>();
        livingCellInput.add(new Coordinate(1, 1));
        livingCellInput.add(new Coordinate(1, 2));
        livingCellInput.add(new Coordinate(2, 1));
        livingCellInput.add(new Coordinate(2, 2));
        gameOfLife.seed(livingCellInput);
        int expectedLivingCellCount = 4;
        int expectedDeadCellCount = 12;

        boolean result = (gameOfLife.countLivingCell() == expectedLivingCellCount) && (gameOfLife.countDeadCell() == expectedDeadCellCount);
        System.out.println(gameOfLife);
        assertTrue(result);
    }

    @Test
    void seed_shouldMakeCountLivingCellReturn4AndCountDeadCellReturn12_whenLivingCellInputCoordinateIs_0And1_1And0_2And1_0And2_1And2() {
        GameOfLife gameOfLife = new GameOfLife();
        HashSet<Coordinate> livingCellInput = new HashSet<>();
        livingCellInput.add(new Coordinate(0, 1));
        livingCellInput.add(new Coordinate(1, 0));
        livingCellInput.add(new Coordinate(2, 1));
        livingCellInput.add(new Coordinate(0, 2));
        livingCellInput.add(new Coordinate(1, 2));
        gameOfLife.seed(livingCellInput);
        int expectedLivingCellCount = 5;
        int expectedDeadCellCount = 17;

        boolean result = (gameOfLife.countLivingCell() == expectedLivingCellCount) && (gameOfLife.countDeadCell() == expectedDeadCellCount);
        System.out.println(gameOfLife);
        assertTrue(result);
    }
}
