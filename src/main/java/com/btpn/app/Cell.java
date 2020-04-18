package com.btpn.app;

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
}
