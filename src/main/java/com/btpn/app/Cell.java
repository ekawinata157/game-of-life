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
        return true;
    }

    void updateCellState(){

    }
}
