package com.btpn.app;

import org.junit.jupiter.api.Test;

import static com.btpn.app.Cell.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CellTest {
    @Test
    void isDead_shouldReturnTrue_whenLivingCellNeighborIsZero() {
        Cell cell = new Cell(0, State.ALIVE);

        boolean result = cell.isDead();

        assertTrue(result);
    }

    @Test
    void isDead_shouldReturnFalse_whenLivingCellNeighborIsTwo() {
        Cell cell = new Cell(2, State.ALIVE);

        boolean result = cell.isDead();

        assertFalse(result);
    }

    @Test
    void isDead_shouldReturnFalse_whenLivingCellNeighborIsThree() {
        Cell cell = new Cell(3, State.ALIVE);

        boolean result = cell.isDead();

        assertFalse(result);
    }

    @Test
    void isDead_shouldReturnTrue_whenLivingCellNeighborIsFour() {
        Cell cell = new Cell(4, State.ALIVE);

        boolean result = cell.isDead();

        assertTrue(result);
    }

    @Test
    void isDead_shouldReturnFalse_whenCellIsDeadAndLivingCellNeighborIsThree() {
        Cell cell = new Cell(3, State.DEAD);

        boolean result = cell.isDead();

        assertFalse(result);
    }

    @Test
    void isDead_shouldReturnTrue_whenCellIsDeadAndLivingCellNeighborIsTwo() {
        Cell cell = new Cell(2, State.DEAD);

        boolean result = cell.isDead();

        assertTrue(result);
    }
}
