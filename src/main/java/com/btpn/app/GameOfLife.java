package com.btpn.app;

import java.util.*;

import static com.btpn.app.Cell.*;

class GameOfLife {
    private HashMap<Coordinate, Cell> grid = new HashMap<>();

    int countLivingCells() {
        int count = 0;
        for (HashMap.Entry<Coordinate, Cell> entry : grid.entrySet()) {
            if (entry.getValue().equals(new Cell(State.LIVING))) {
                count++;
            }
        }
        return count;
    }

    int countDeadCells() {
        int count = 0;
        for (HashMap.Entry<Coordinate, Cell> entry : grid.entrySet()) {
            if (entry.getValue().equals(new Cell(State.DEAD))) {
                count++;
            }
        }
        return count;
    }

    void seed(HashSet<Coordinate> livingCellInputs) {
        this.grid = new HashMap<>();
        HashSet<Coordinate> deadCellsCoordinate = this.generateNeighboringDeadCells(livingCellInputs);
        for (Coordinate livingCellCoordinate : livingCellInputs) {
            grid.put(livingCellCoordinate, new Cell(State.LIVING));
        }
        for (Coordinate deadCellCoordinate : deadCellsCoordinate) {
            if (!grid.containsKey(deadCellCoordinate)) {
                grid.put(deadCellCoordinate, new Cell(State.DEAD));
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

    int countNeighboringLivingCells(Coordinate coordinate) {
        int count = 0;
        for (Coordinate neighboringCellCoordinate : coordinate.getNeighboringCoordinates()) {
            if (grid.containsKey(neighboringCellCoordinate) && new Cell(State.LIVING).equals(grid.get(neighboringCellCoordinate))) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuilder livingCells = new StringBuilder("");
        ArrayList<Coordinate> livingCellsCoordinate = new ArrayList<>();
        for (HashMap.Entry<Coordinate, Cell> entry : grid.entrySet()) {
            if (!entry.getValue().isDead()) {
                livingCellsCoordinate.add(entry.getKey());
            }
        }
        Collections.sort(livingCellsCoordinate);
        for (Coordinate coordinate : livingCellsCoordinate) {
            livingCells.append(coordinate);
            livingCells.append("\n");
        }
        return livingCells.toString();
    }

    void updateGameState() {
        HashSet<Coordinate> nextGenerationLivingCell = new HashSet<>();
        for (HashMap.Entry<Coordinate, Cell> entry : grid.entrySet()) {
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

    void promptNextGeneration(HashSet<Coordinate> livingCellsCoordinateInput, int iteration) {
        this.seed(livingCellsCoordinateInput);
        for(int i=0;i<iteration;i++){
            updateGameState();
        }
    }
}
