package com.btpn.app;

import com.btpn.app.Cell.State;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertTrue;

class GameOfLifeTest {
    @Test
    void seed_shouldMakeCountLivingCellReturn4AndCountDeadCellReturn12_whenLivingCellInputCoordinateIs_1And1_1And2_2And1_2And2() {
        GameOfLife gameOfLife = new GameOfLife();
        HashMap<Coordinate, Cell> livingCellInput = new HashMap<>();
        livingCellInput.put(new Coordinate(1, 1), new Cell(State.ALIVE));
        livingCellInput.put(new Coordinate(1, 2), new Cell(State.ALIVE));
        livingCellInput.put(new Coordinate(2, 1), new Cell(State.ALIVE));
        livingCellInput.put(new Coordinate(2, 2), new Cell(State.ALIVE));
        gameOfLife.seed(livingCellInput);
        int expectedLivingCellCount = 4;
        int expectedDeadCellCount = 12;

        boolean result = (gameOfLife.countLivingCell() == expectedLivingCellCount) && (gameOfLife.countDeadCell() == expectedDeadCellCount);

        assertTrue(result);
    }

    @Test
    void seed_shouldMakeCountLivingCellReturn5AndCountDeadCellReturn17_whenLivingCellInputCoordinateIs_0And1_1And0_2And1_0And2_1And2() {
        GameOfLife gameOfLife = new GameOfLife();
        HashMap<Coordinate, Cell> livingCellInput = new HashMap<>();
        livingCellInput.put(new Coordinate(0, 1), new Cell(State.ALIVE));
        livingCellInput.put(new Coordinate(1, 0), new Cell(State.ALIVE));
        livingCellInput.put(new Coordinate(2, 1), new Cell(State.ALIVE));
        livingCellInput.put(new Coordinate(0, 2), new Cell(State.ALIVE));
        livingCellInput.put(new Coordinate(1, 2), new Cell(State.ALIVE));
        gameOfLife.seed(livingCellInput);
        int expectedLivingCellCount = 5;
        int expectedDeadCellCount = 17;

        boolean result = (gameOfLife.countLivingCell() == expectedLivingCellCount) && (gameOfLife.countDeadCell() == expectedDeadCellCount);

        assertTrue(result);
    }
}
