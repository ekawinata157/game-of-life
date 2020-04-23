package com.btpn.app;

class Cell {
    private boolean isLiving;

    private Cell(boolean isLiving) {
        this.isLiving = isLiving;
    }

    static Cell createLivingCell() {
        return new Cell(true);
    }

    static Cell createDeadCell() {
        return new Cell(false);
    }

    boolean isDead() {
        return (!this.isLiving);
    }

    Cell updateState(int neighboringLivingCell) {
        if (this.isLiving && (neighboringLivingCell < 2 || neighboringLivingCell > 3)) {
            return new Cell(false);
        }
        if (!this.isLiving && neighboringLivingCell == 3) {
            return new Cell(true);
        }
        return new Cell(this.isLiving);
    }
}
