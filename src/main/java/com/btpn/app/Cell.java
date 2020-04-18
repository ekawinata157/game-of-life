package com.btpn.app;

class Cell {
    private enum State {
        LIVING, DEAD
    }

    private State state;

    private Cell(State state) {
        this.state = state;
    }

    static Cell createLivingCell() {
        return new Cell(State.LIVING);
    }

    static Cell createDeadCell() {
        return new Cell(State.DEAD);
    }

    boolean isDead() {
        return (this.state == State.DEAD);
    }

    Cell updateState(int neighboringLivingCell) {
        if (this.state == State.LIVING && (neighboringLivingCell < 2 || neighboringLivingCell > 3)) {
            return new Cell(State.DEAD);
        }
        if (this.state == State.DEAD && neighboringLivingCell == 3) {
            return new Cell(State.LIVING);
        }
        return new Cell(this.state);
    }
}
