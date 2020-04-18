package com.btpn.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CellTest {
    @Test
    void updateState_shouldMakeIsDeadReturnTrue_whenCellIsAliveAndLivingCellNeighborIsZero() {
        Cell cell = Cell.createLivingCell();

        cell = cell.updateState(0);
        boolean result = cell.isDead();

        assertTrue(result);
    }

    @Test
    void updateState_shouldMakeIsDeadReturnFalse_whenCellIsAliveAndLivingCellNeighborIsTwo() {
        Cell cell = Cell.createLivingCell();

        cell = cell.updateState(2);
        boolean result = cell.isDead();

        assertFalse(result);
    }

    @Test
    void updateState_shouldMakeIsDeadReturnTrue_whenCellIsAliveAndLivingCellNeighborIsOne() {
        Cell cell = Cell.createLivingCell();

        cell = cell.updateState(1);
        boolean result = cell.isDead();

        assertTrue(result);
    }

    @Test
    void updateState_shouldMakeIsDeadReturnTrue_whenCellIsAliveAndLivingCellNeighborIsFour() {
        Cell cell = Cell.createLivingCell();

        cell = cell.updateState(4);
        boolean result = cell.isDead();

        assertTrue(result);
    }

    @Test
    void updateState_shouldMakeIsDeadReturnTrue_whenCellIsAliveAndLivingCellNeighborIsFive() {
        Cell cell = Cell.createLivingCell();

        cell = cell.updateState(5);
        boolean result = cell.isDead();

        assertTrue(result);
    }

    @Test
    void updateState_shouldMakeIsDeadReturnFalse_whenCellIsDeadAndLivingCellNeighborIsThree() {
        Cell cell = Cell.createDeadCell();

        cell = cell.updateState(3);
        boolean result = cell.isDead();

        assertFalse(result);
    }
}
