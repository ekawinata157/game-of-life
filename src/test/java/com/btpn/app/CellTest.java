package com.btpn.app;

import org.junit.jupiter.api.Test;

import static com.btpn.app.Cell.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CellTest {
    @Test
    void updateCellState_shouldMakeIsDeadReturnTrue_whenCellIsAliveAndLivingCellNeighborIsZero() {
        Cell cell = new Cell(State.LIVING);

        cell = cell.updateCellState(0);
        boolean result = cell.isDead();

        assertTrue(result);
    }

    @Test
    void updateCellState_shouldMakeIsDeadReturnFalse_whenCellIsAliveAndLivingCellNeighborIsTwo() {
        Cell cell = new Cell(State.LIVING);

        cell = cell.updateCellState(2);
        boolean result = cell.isDead();

        assertFalse(result);
    }

    @Test
    void updateCellState_shouldMakeIsDeadReturnTrue_whenCellIsAliveAndLivingCellNeighborIsOne() {
        Cell cell = new Cell(State.LIVING);

        cell = cell.updateCellState(1);
        boolean result = cell.isDead();

        assertTrue(result);
    }

    @Test
    void updateCellState_shouldMakeIsDeadReturnTrue_whenCellIsAliveAndLivingCellNeighborIsFour() {
        Cell cell = new Cell(State.LIVING);

        cell = cell.updateCellState(4);
        boolean result = cell.isDead();

        assertTrue(result);
    }

    @Test
    void updateCellState_shouldMakeIsDeadReturnTrue_whenCellIsAliveAndLivingCellNeighborIsFive() {
        Cell cell = new Cell(State.LIVING);

        cell = cell.updateCellState(5);
        boolean result = cell.isDead();

        assertTrue(result);
    }

    @Test
    void updateCellState_shouldMakeIsDeadReturnFalse_whenCellIsDeadAndLivingCellNeighborIsThree() {
        Cell cell = new Cell(State.DEAD);

        cell = cell.updateCellState(3);
        boolean result = cell.isDead();

        assertFalse(result);
    }
}
