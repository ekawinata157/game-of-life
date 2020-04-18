package com.btpn.app;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class CoordinateTest {
    @Test
    void equals_shouldReturnTrue_whenInputIsTheSameObject() {
        Coordinate coordinate = new Coordinate(9, 9);

        assertEquals(coordinate, coordinate);
    }

    @Test
    void equals_shouldReturnFalse_whenInputIsNotInstanceOfCoordinate() {
        Coordinate coordinate = new Coordinate(1, 1);
        Object object = new Object();

        assertNotEquals(coordinate, object);
    }

    @Test
    void toString_shouldReturn1space2_whenCoordinateXIs1AndYIs2() {
        Coordinate coordinate = new Coordinate(1, 2);
        String expected = "1,2";

        assertEquals(expected, coordinate.toString());
    }

    @Test
    void getNeighboringCoordinates_shouldReturn0And1_1And1_1And0_1AndMinus1_0AndMinus1_Minus1AndMinus1_Minus1And0_Minus1And1_whenInputCoordinateIs0And0() {
        Coordinate coordinate = new Coordinate(0, 0);
        ArrayList<Coordinate> expected = new ArrayList<>();
        expected.add(new Coordinate(0, 1));
        expected.add(new Coordinate(1, 1));
        expected.add(new Coordinate(1, 0));
        expected.add(new Coordinate(1, -1));
        expected.add(new Coordinate(0, -1));
        expected.add(new Coordinate(-1, -1));
        expected.add(new Coordinate(-1, 0));
        expected.add(new Coordinate(-1, 1));
        Collections.sort(expected);

        ArrayList<Coordinate> result = coordinate.getNeighboringCoordinates();
        Collections.sort(result);

        assertArrayEquals(expected.toArray(), result.toArray());
    }

    @Test
    void getNeighboringCoordinates_shouldReturn1And2_2And2_2And1_2And0_1And0_0And0_0And1_0And2_whenInputCoordinateIs1And1() {
        Coordinate coordinate = new Coordinate(1, 1);
        ArrayList<Coordinate> expected = new ArrayList<>();
        expected.add(new Coordinate(1, 2));
        expected.add(new Coordinate(2, 2));
        expected.add(new Coordinate(2, 1));
        expected.add(new Coordinate(2, 0));
        expected.add(new Coordinate(1, 0));
        expected.add(new Coordinate(0, 0));
        expected.add(new Coordinate(0, 1));
        expected.add(new Coordinate(0, 2));
        Collections.sort(expected);

        ArrayList<Coordinate> result = coordinate.getNeighboringCoordinates();
        Collections.sort(result);

        assertArrayEquals(expected.toArray(), result.toArray());
    }
}
