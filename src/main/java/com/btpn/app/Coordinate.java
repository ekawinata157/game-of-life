package com.btpn.app;

import java.util.ArrayList;

class Coordinate implements Comparable<Coordinate> {
    private int x;
    private int y;

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
        final int BIJECTIVE_ADDER = 1;
        final int BIJECTIVE_DIVIDER = 2;
        int temp = (y + ((x + BIJECTIVE_ADDER) / BIJECTIVE_DIVIDER));
        return x + (temp * temp);
    }

    private Coordinate translate(int xTranslation, int yTranslation) {
        return new Coordinate(this.x + xTranslation, this.y + yTranslation);
    }

    ArrayList<Coordinate> getNeighboringCoordinates() {
        ArrayList<Coordinate> neighboringCoordinates = new ArrayList<>();
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

    @Override
    public int compareTo(Coordinate coordinate) {
        if (this.x == coordinate.x) {
            return Integer.compare(this.y, coordinate.y);
        }
        return Integer.compare(this.x, coordinate.x);
    }
}
