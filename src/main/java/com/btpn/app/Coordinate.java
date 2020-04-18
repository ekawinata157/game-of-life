package com.btpn.app;

import java.util.ArrayList;

class Coordinate {
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
    public int hashCode()
    {
        int tmp = ( y +  ((x+1)/2));
        return x +  ( tmp * tmp);
    }

    Coordinate translate(int xTranslation, int yTranslation) {
        return new Coordinate(this.x + xTranslation, this.y + yTranslation);
    }

    ArrayList<Coordinate> getAdjacentCoordinates(){
        ArrayList<Coordinate> adjacentCoordinates=new ArrayList<>();
        adjacentCoordinates.add(this.translate(1, 0));
        adjacentCoordinates.add(this.translate(1, -1));
        adjacentCoordinates.add(this.translate(0, -1));
        adjacentCoordinates.add(this.translate(-1, -1));
        adjacentCoordinates.add(this.translate(-1, 0));
        adjacentCoordinates.add(this.translate(-1, 1));
        adjacentCoordinates.add(this.translate(0, 1));
        adjacentCoordinates.add(this.translate(1, 1));
        return adjacentCoordinates;
    }

    @Override
    public String toString() {
        return this.x + " " + this.y;
    }
}
