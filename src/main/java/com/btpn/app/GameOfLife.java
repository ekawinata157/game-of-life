package com.btpn.app;

import java.util.HashMap;
import java.util.HashSet;


import static com.btpn.app.Cell.*;

class GameOfLife {
    private HashMap<Coordinate, Cell> grid = new HashMap<Coordinate, Cell>();

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

    HashSet<Coordinate> generateAdjacentDeadCells(HashSet<Coordinate> livingCellsCoordinate) {
        HashSet<Coordinate> deadCells = new HashSet<>();
        for (Coordinate livingCellCoordinate : livingCellsCoordinate) {
            for(Coordinate adjacentOfLivingCellCoordinate : livingCellCoordinate.getAdjacentCoordinates()){
                deadCells.add(adjacentOfLivingCellCoordinate);
            }
        }
        return deadCells;
    }

    int countNeighboringLivingCells(Coordinate coordinate){
        return 3;
    }


    @Override
    public String toString() {
        String temp = "";
        for (HashMap.Entry<Coordinate, Cell> entry : this.grid.entrySet()) {
            temp += (entry.getKey() + " " + entry.getValue()) + "\n";
        }
        temp += this.countLivingCell() + " " + this.countDeadCell();
        return temp;
    }
}
