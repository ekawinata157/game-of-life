package com.btpn.app;

import java.util.*;


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
        this.grid = new HashMap<>();
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
        String livingCells = "";
        ArrayList<Coordinate> livingCellsCoordinate = new ArrayList<>();
        for (HashMap.Entry<Coordinate, Cell> entry : grid.entrySet()) {
            if (!entry.getValue().isDead()) {
                livingCellsCoordinate.add(entry.getKey());
            }
        }
        Collections.sort(livingCellsCoordinate);

        for (Coordinate coordinate : livingCellsCoordinate) {
            livingCells += coordinate + "\n";
        }
        return livingCells;
    }

    void updateGameState() {
        HashSet<Coordinate> nextGenerationLivingCell = new HashSet<>();
        for (HashMap.Entry<Coordinate, Cell> entry : grid.entrySet()) {
            Coordinate currentCoordinate = entry.getKey();
            Cell currentCell = entry.getValue();
            int surroundingLivingCellCount = this.countNeighboringLivingCells(currentCoordinate);
            Cell updatedCell = currentCell.updateCellState(surroundingLivingCellCount);
            if (!updatedCell.isDead()) {
                nextGenerationLivingCell.add(currentCoordinate);
            }
        }
        this.seed(nextGenerationLivingCell);
    }
}
