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
}
