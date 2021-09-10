package com.btpn.app;

import java.util.*;

class GameOfLife {
    private HashMap<Coordinate, Cell> grid = new HashMap<>();

    void seed(Set<Coordinate> livingCellInputs) {
        this.grid = new HashMap<>();
        Set<Coordinate> deadCellsCoordinate = this.generateNeighboringDeadCells(livingCellInputs);
        for (Coordinate livingCellCoordinate : livingCellInputs) {
            grid.put(livingCellCoordinate, Cell.createLivingCell());
        }
        for (Coordinate deadCellCoordinate : deadCellsCoordinate) {
            if (!grid.containsKey(deadCellCoordinate)) {
                grid.put(deadCellCoordinate, Cell.createDeadCell());
            }
        }
    }

    private Set<Coordinate> generateNeighboringDeadCells(Set<Coordinate> livingCellsCoordinate) {
        Set<Coordinate> deadCells = new HashSet<>();
        for (Coordinate livingCellCoordinate : livingCellsCoordinate) {
            deadCells.addAll(livingCellCoordinate.getNeighboringCoordinates());
        }
        return deadCells;
    }

    private int countNeighboringLivingCells(Coordinate coordinate) {
        int count = 0;
        for (Coordinate neighboringCellCoordinate : coordinate.getNeighboringCoordinates()) {
            Cell cellToCheck = grid.get(neighboringCellCoordinate);
            if (grid.containsKey(neighboringCellCoordinate) && !cellToCheck.isDead()) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuilder livingCells = new StringBuilder();
        Set<Coordinate> livingCellsCoordinate = this.getLivingCellsCoordinate();
        for (Coordinate coordinate : livingCellsCoordinate) {
            livingCells.append(coordinate);
            livingCells.append("\n");
        }
        return livingCells.toString();
    }

    Set<Coordinate> getLivingCellsCoordinate() {
        Set<Coordinate> livingCellsCoordinate = new HashSet<>();
        for (Map.Entry<Coordinate, Cell> entry : grid.entrySet()) {
            if (!entry.getValue().isDead()) {
                livingCellsCoordinate.add(entry.getKey());
            }
        }
        return livingCellsCoordinate;
    }

    void updateGameState() {
        Set<Coordinate> nextGenerationLivingCell = new HashSet<>();
        for (Map.Entry<Coordinate, Cell> entry : grid.entrySet()) {
            Coordinate currentCoordinate = entry.getKey();
            Cell currentCell = entry.getValue();
            int surroundingLivingCellCount = this.countNeighboringLivingCells(currentCoordinate);
            Cell updatedCell = currentCell.updateState(surroundingLivingCellCount);
            if (!updatedCell.isDead()) {
                nextGenerationLivingCell.add(currentCoordinate);
            }
        }
        this.seed(nextGenerationLivingCell);
    }
}
