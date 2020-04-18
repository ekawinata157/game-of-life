package com.btpn.app;

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
    public int hashCode() {
        return Integer.hashCode(this.x) * Integer.hashCode(this.y);
    }

    private Coordinate translate(int xTranslation, int yTranslation) {
        return new Coordinate(this.x + xTranslation, this.y + yTranslation);
    }

    @Override
    public String toString() {
        return this.x + " " + this.y;
    }

}
