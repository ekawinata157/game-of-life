package com.btpn.app;

public class Cell {
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
        if(state==State.ALIVE) {
            return !(neighboringLivingCell==2 || neighboringLivingCell==3);
        }
        return !(neighboringLivingCell==3);
    }
}
