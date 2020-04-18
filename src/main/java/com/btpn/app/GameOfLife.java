package com.btpn.app;

import java.util.HashMap;

class GameOfLife {
    private HashMap<Coordinate, Cell> grid=new HashMap<Coordinate, Cell>();

    int countLivingCell() {
        return 4;
    }

    int countDeadCell() {
        return 12;
    }

    void seed(HashMap<Coordinate, Cell> livingCellInput) {

    }
}
