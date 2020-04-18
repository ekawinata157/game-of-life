package com.btpn.app;

import java.util.HashMap;
import java.util.HashSet;


import static com.btpn.app.Cell.*;

class GameOfLife {
    private HashMap<Coordinate, Cell> grid = new HashMap<>();

    int countLivingCell() {
        int count = 0;
        for (HashMap.Entry<Coordinate, Cell> entry : grid.entrySet()) {
            if (entry.getValue().equals(new Cell(State.ALIVE))) {
                count++;
            }
        }
        return count;
    }

    int countDeadCell() {
        int count = 0;
        for (HashMap.Entry<Coordinate, Cell> entry : grid.entrySet()) {
            if (entry.getValue().equals(new Cell(State.DEAD))) {
                count++;
            }
        }
        return count;
    }

    void seed(HashSet<Coordinate> livingCellInput) {
        HashSet<Coordinate> deadCellsCoordinate = this.generateAdjacentDeadCells(livingCellInput);
        for (Coordinate livingCellCoordinate : livingCellInput) {
            grid.put(livingCellCoordinate, new Cell(State.ALIVE));
        }
        for (Coordinate deadCellCoordinate : deadCellsCoordinate) {
            if (!grid.containsKey(deadCellCoordinate)) {
                grid.put(deadCellCoordinate, new Cell(State.DEAD));
            }
        }
    }

    private HashSet<Coordinate> generateAdjacentDeadCells(HashSet<Coordinate> livingCellsCoordinate) {
        HashSet<Coordinate> deadCells = new HashSet<>();
        for (Coordinate livingCellCoordinate : livingCellsCoordinate) {
            deadCells.addAll(livingCellCoordinate.getAdjacentCoordinates());
        }
        return deadCells;
    }

    int countNeighboringLivingCells(Coordinate coordinate) {
        int count = 0;
        for (Coordinate neighboringCellCoordinate : coordinate.getAdjacentCoordinates()) {
            if (grid.containsKey(neighboringCellCoordinate) && new Cell(State.ALIVE).equals(grid.get(neighboringCellCoordinate))) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return "1,1\n 1,2\n 2,1\n 2,2\n";
    }


    void updateGameState() {

    }
}
