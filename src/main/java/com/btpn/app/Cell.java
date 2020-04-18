package com.btpn.app;

class Cell {
    enum State {
        ALIVE, DEAD;
    }

    private int neighboringLivingCell;
    private State state;

    Cell(int neighboringLivingCell, State state) {
        this.neighboringLivingCell = neighboringLivingCell;
        this.state = state;
    }

    boolean isDead() {
        return (this.state == State.DEAD);
    }

    void updateCellState() {
        if (this.neighboringLivingCell < 2) {
            this.state = State.DEAD;
        }
    }
}
