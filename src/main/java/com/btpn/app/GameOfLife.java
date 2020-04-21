package com.btpn.app;

import java.util.*;

class GameOfLife {
    private HashMap<Coordinate, Cell> grid = new HashMap<>();

    private void seed(HashSet<Coordinate> livingCellInputs) {
        this.grid = new HashMap<>();
        HashSet<Coordinate> deadCellsCoordinate = this.generateNeighboringDeadCells(livingCellInputs);
        for (Coordinate livingCellCoordinate : livingCellInputs) {
            grid.put(livingCellCoordinate, Cell.createLivingCell());
        }
        for (Coordinate deadCellCoordinate : deadCellsCoordinate) {
            if (!grid.containsKey(deadCellCoordinate)) {
                grid.put(deadCellCoordinate, Cell.createDeadCell());
            }
        }
    }

    private HashSet<Coordinate> generateNeighboringDeadCells(HashSet<Coordinate> livingCellsCoordinate) {
        HashSet<Coordinate> deadCells = new HashSet<>();
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
        HashSet<Coordinate> livingCellsCoordinate = this.getLivingCellsCoordinate();
        for (Coordinate coordinate : livingCellsCoordinate) {
            livingCells.append(coordinate);
            livingCells.append("\n");
        }
        return livingCells.toString();
    }

    HashSet<Coordinate> getLivingCellsCoordinate() {
        HashSet<Coordinate> livingCellsCoordinate = new HashSet<>();
        for (Map.Entry<Coordinate, Cell> entry : grid.entrySet()) {
            if (!entry.getValue().isDead()) {
                livingCellsCoordinate.add(entry.getKey());
            }
        }
        return livingCellsCoordinate;
    }

    private void updateGameState() {
        HashSet<Coordinate> nextGenerationLivingCell = new HashSet<>();
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

    void promptNextGeneration(HashSet<Coordinate> livingCellsCoordinateInput) {
        this.seed(livingCellsCoordinateInput);
        updateGameState();
    }
}
