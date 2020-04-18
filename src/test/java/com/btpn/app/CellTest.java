package com.btpn.app;

import org.junit.jupiter.api.Test;

import static com.btpn.app.Cell.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CellTest {
    @Test
    void updateCellState_shouldMakeIsDeadReturnTrue_whenCellIsAliveAndLivingCellNeighborIsZero() {
        Cell cell = new Cell(0, State.ALIVE);

        cell.updateCellState();
        boolean result = cell.isDead();

        assertTrue(result);
    }

    @Test
    void updateCellState_shouldMakeIsDeadReturnFalse_whenCellIsAliveAndLivingCellNeighborIsTwo() {
        Cell cell = new Cell(2, State.ALIVE);

        cell.updateCellState();
        boolean result = cell.isDead();

        assertFalse(result);
    }

    @Test
    void updateCellState_shouldMakeIsDeadReturnTrue_whenCellIsAliveAndLivingCellNeighborIsOne() {
        Cell cell = new Cell(1, State.ALIVE);

        cell.updateCellState();
        boolean result = cell.isDead();

        assertTrue(result);
    }
}
