package com.btpn.app;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

        assertTrue(result);
    }

    @Test
    void countNeighboringLivingCells_shouldReturn3_whenInputIsCoordinate1And1AndGamePatternIsBlock() {
        GameOfLife gameOfLife = new GameOfLife();
        HashSet<Coordinate> livingCellInput = new HashSet<>();
        livingCellInput.add(new Coordinate(1, 1));
        livingCellInput.add(new Coordinate(1, 2));
        livingCellInput.add(new Coordinate(2, 1));
        livingCellInput.add(new Coordinate(2, 2));
        gameOfLife.seed(livingCellInput);
        int expected = 3;

        int result = gameOfLife.countNeighboringLivingCells(new Coordinate(1, 1));

        assertEquals(expected, result);
    }

    @Test
    void countNeighboringLivingCells_shouldReturn5_whenInputIsCoordinate1And1AndGamePatternIsBoat() {
        GameOfLife gameOfLife = new GameOfLife();
        HashSet<Coordinate> livingCellInput = new HashSet<>();
        livingCellInput.add(new Coordinate(0, 1));
        livingCellInput.add(new Coordinate(1, 0));
        livingCellInput.add(new Coordinate(2, 1));
        livingCellInput.add(new Coordinate(0, 2));
        livingCellInput.add(new Coordinate(1, 2));
        gameOfLife.seed(livingCellInput);
        int expected = 5;

        int result = gameOfLife.countNeighboringLivingCells(new Coordinate(1, 1));

        assertEquals(expected, result);
    }

    @Test
    void updateGameState_shouldMakeToStringReturnTheSameInput_whenInputIsBlockPattern() {
        GameOfLife gameOfLife = new GameOfLife();
        HashSet<Coordinate> livingCellInput = new HashSet<>();
        livingCellInput.add(new Coordinate(1, 1));
        livingCellInput.add(new Coordinate(1, 2));
        livingCellInput.add(new Coordinate(2, 1));
        livingCellInput.add(new Coordinate(2, 2));
        gameOfLife.seed(livingCellInput);
        String expected = "1,1\n1,2\n2,1\n2,2\n";

        gameOfLife.updateGameState();
        String result = gameOfLife.toString();

        assertEquals(expected, result);
    }

    @Test
    void updateGameState_shouldMakeToStringReturnTheSameInput_whenInputIsBoatPattern() {
        GameOfLife gameOfLife = new GameOfLife();
        HashSet<Coordinate> livingCellInput = new HashSet<>();
        livingCellInput.add(new Coordinate(0, 1));
        livingCellInput.add(new Coordinate(1, 0));
        livingCellInput.add(new Coordinate(2, 1));
        livingCellInput.add(new Coordinate(0, 2));
        livingCellInput.add(new Coordinate(1, 2));
        gameOfLife.seed(livingCellInput);
        String expected = "0,1\n0,2\n1,0\n1,2\n2,1\n";

        gameOfLife.updateGameState();
        String result = gameOfLife.toString();

        assertEquals(expected, result);
    }

    @Test
    void updateGameState_shouldMakeToStringReturn1And1_0And1_2And1_whenInputIsOscillatorPattern() {
        GameOfLife gameOfLife = new GameOfLife();
        HashSet<Coordinate> livingCellInput = new HashSet<>();
        livingCellInput.add(new Coordinate(1, 1));
        livingCellInput.add(new Coordinate(1, 0));
        livingCellInput.add(new Coordinate(1, 2));
        gameOfLife.seed(livingCellInput);
        String expected = "0,1\n1,1\n2,1\n";

        gameOfLife.updateGameState();
        String result = gameOfLife.toString();

        assertEquals(expected, result);
    }

    @Test
    void updateGameState_shouldMakeToStringReturn0And2_1And1_1And4_2And1_2And4_3And3_whenInputIsToadPattern() {
        GameOfLife gameOfLife = new GameOfLife();
        HashSet<Coordinate> livingCellInput = new HashSet<>();
        livingCellInput.add(new Coordinate(1, 1));
        livingCellInput.add(new Coordinate(1, 2));
        livingCellInput.add(new Coordinate(1, 3));
        livingCellInput.add(new Coordinate(2, 2));
        livingCellInput.add(new Coordinate(2, 3));
        livingCellInput.add(new Coordinate(2, 4));
        gameOfLife.seed(livingCellInput);
        String expected = "0,2\n1,1\n1,4\n2,1\n2,4\n3,3\n";

        gameOfLife.updateGameState();
        String result = gameOfLife.toString();

        assertEquals(expected, result);
    }
}
