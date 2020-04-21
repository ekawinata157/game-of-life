package com.btpn.app;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertTrue;

class GameOfLifeTest {
    @Test
    void promptNextGeneration_shouldMakeToStringReturnTheSameInput_whenInputIsBlockPattern() {
        GameOfLife gameOfLife = new GameOfLife();
        HashSet<Coordinate> livingCellInput = new HashSet<>();
        livingCellInput.add(new Coordinate(1, 1));
        livingCellInput.add(new Coordinate(1, 2));
        livingCellInput.add(new Coordinate(2, 1));
        livingCellInput.add(new Coordinate(2, 2));
        HashSet<Coordinate> expectedLivingCellOutput = new HashSet<>();
        expectedLivingCellOutput.add(new Coordinate(1, 1));
        expectedLivingCellOutput.add(new Coordinate(1, 2));
        expectedLivingCellOutput.add(new Coordinate(2, 1));
        expectedLivingCellOutput.add(new Coordinate(2, 2));

        gameOfLife.promptNextGeneration(livingCellInput);
        boolean result = gameOfLife.getLivingCellsCoordinate().equals(expectedLivingCellOutput);

        assertTrue(result);
    }

    @Test
    void promptNextGeneration_shouldMakeToStringReturnTheSameInput_whenInputIsBoatPattern() {
        GameOfLife gameOfLife = new GameOfLife();
        HashSet<Coordinate> livingCellInput = new HashSet<>();
        livingCellInput.add(new Coordinate(0, 1));
        livingCellInput.add(new Coordinate(1, 0));
        livingCellInput.add(new Coordinate(2, 1));
        livingCellInput.add(new Coordinate(0, 2));
        livingCellInput.add(new Coordinate(1, 2));
        HashSet<Coordinate> expectedLivingCellOutput = new HashSet<>();
        expectedLivingCellOutput.add(new Coordinate(0, 1));
        expectedLivingCellOutput.add(new Coordinate(0, 2));
        expectedLivingCellOutput.add(new Coordinate(1, 0));
        expectedLivingCellOutput.add(new Coordinate(1, 2));
        expectedLivingCellOutput.add(new Coordinate(2, 1));

        gameOfLife.promptNextGeneration(livingCellInput);
        boolean result = gameOfLife.getLivingCellsCoordinate().equals(expectedLivingCellOutput);

        assertTrue(result);
    }

    @Test
    void promptNextGeneration_shouldMakeToStringReturn1And1_0And1_2And1_whenInputIsOscillatorPattern() {
        GameOfLife gameOfLife = new GameOfLife();
        HashSet<Coordinate> livingCellInput = new HashSet<>();
        livingCellInput.add(new Coordinate(1, 1));
        livingCellInput.add(new Coordinate(1, 0));
        livingCellInput.add(new Coordinate(1, 2));
        HashSet<Coordinate> expectedLivingCellOutput = new HashSet<>();
        expectedLivingCellOutput.add(new Coordinate(0, 1));
        expectedLivingCellOutput.add(new Coordinate(1, 1));
        expectedLivingCellOutput.add(new Coordinate(2, 1));

        gameOfLife.promptNextGeneration(livingCellInput);
        boolean result = gameOfLife.getLivingCellsCoordinate().equals(expectedLivingCellOutput);

        assertTrue(result);
    }

    @Test
    void promptNextGeneration_shouldMakeToStringReturn0And2_1And1_1And4_2And1_2And4_3And3_whenInputIsToadPattern() {
        GameOfLife gameOfLife = new GameOfLife();
        HashSet<Coordinate> livingCellInput = new HashSet<>();
        livingCellInput.add(new Coordinate(1, 1));
        livingCellInput.add(new Coordinate(1, 2));
        livingCellInput.add(new Coordinate(1, 3));
        livingCellInput.add(new Coordinate(2, 2));
        livingCellInput.add(new Coordinate(2, 3));
        livingCellInput.add(new Coordinate(2, 4));
        HashSet<Coordinate> expectedLivingCellOutput = new HashSet<>();
        expectedLivingCellOutput.add(new Coordinate(0, 2));
        expectedLivingCellOutput.add(new Coordinate(1, 1));
        expectedLivingCellOutput.add(new Coordinate(1, 4));
        expectedLivingCellOutput.add(new Coordinate(2, 1));
        expectedLivingCellOutput.add(new Coordinate(2, 4));
        expectedLivingCellOutput.add(new Coordinate(3, 3));

        gameOfLife.promptNextGeneration(livingCellInput);
        boolean result = gameOfLife.getLivingCellsCoordinate().equals(expectedLivingCellOutput);

        assertTrue(result);
    }
}
