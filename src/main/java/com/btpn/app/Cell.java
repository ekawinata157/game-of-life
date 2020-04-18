package com.btpn.app;

import java.util.Objects;

class Cell {
    enum State {
        LIVING, DEAD
    }

    private State state;

    Cell(State state) {
        this.state = state;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return state == cell.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(state);
    }

    @Override
    public String toString() {
        return this.state.toString();
    }
}
