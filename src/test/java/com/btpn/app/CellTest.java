package com.btpn.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CellTest {
    @Test
    void isDead_shouldReturnTrue_whenLivingCellNeighborIsZero() {
        Cell cell = new Cell(0, 8);

        boolean result=cell.isDead();

        assertTrue(result);
    }

    @Test
    void isDead_shouldReturnFalse_whenLivingCellNeighborIsTwo(){
        Cell cell = new Cell(2, 6);

        boolean result=cell.isDead();

        assertFalse(result);
    }
}
