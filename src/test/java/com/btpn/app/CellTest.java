package com.btpn.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CellTest {
    @Test
    void isDead_shouldReturnTrue_whenCellIsAliveAndLiveCellNeighborIsZero() {
        Cell cell = new Cell(0, 8);

        boolean result=cell.isDead();

        assertTrue(result);
    }
}
