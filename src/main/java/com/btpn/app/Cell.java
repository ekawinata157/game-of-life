package com.btpn.app;

import javax.xml.transform.stax.StAXResult;

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
        if (this.state == State.ALIVE && (this.neighboringLivingCell < 2 || this.neighboringLivingCell > 3)) {
            this.state = State.DEAD;
        }
        if (this.state == State.DEAD && this.neighboringLivingCell == 3) {
            this.state = State.ALIVE;
        }
    }
}
