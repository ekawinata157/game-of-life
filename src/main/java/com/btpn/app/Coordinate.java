package com.btpn.app;

import java.util.HashSet;
import java.util.Set;

class Coordinate {
    private final int x;
    private final int y;

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Coordinate)) {
            return false;
        }

        Coordinate coordinate = (Coordinate) object;
        return (coordinate.x == this.x && coordinate.y == this.y);
    }

    @Override
    public int hashCode() {
        int hash = 31;
        hash += 31 * hash + Integer.hashCode(this.x);
        hash += 31 * hash + Integer.hashCode(this.y);
        return hash;
    }

    private Coordinate translate(int xTranslation, int yTranslation) {
        return new Coordinate(this.x + xTranslation, this.y + yTranslation);
    }

    Set<Coordinate> getNeighboringCoordinates() {
        Set<Coordinate> neighboringCoordinates = new HashSet<>();
        neighboringCoordinates.add(this.translate(1, 0));
        neighboringCoordinates.add(this.translate(1, -1));
        neighboringCoordinates.add(this.translate(0, -1));
        neighboringCoordinates.add(this.translate(-1, -1));
        neighboringCoordinates.add(this.translate(-1, 0));
        neighboringCoordinates.add(this.translate(-1, 1));
        neighboringCoordinates.add(this.translate(0, 1));
        neighboringCoordinates.add(this.translate(1, 1));
        return neighboringCoordinates;
    }

    @Override
    public String toString() {
        return this.x + "," + this.y;
    }
}
