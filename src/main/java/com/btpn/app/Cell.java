package com.btpn.app;

public class Cell {

    private int neighboringLivingCell;
    private int neighboringDeadCell;

    Cell(int neighboringLivingCell, int neighboringDeadCell) {
        this.neighboringLivingCell = neighboringLivingCell;
        this.neighboringDeadCell = neighboringDeadCell;
    }

    boolean isDead() {
        if(neighboringLivingCell==2){
            return false;
        }
        return true;
    }
}
