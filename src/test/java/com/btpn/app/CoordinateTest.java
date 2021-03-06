package com.btpn.app;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

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
        HashSet<Coordinate> expected = new HashSet<>();
        expected.add(new Coordinate(0, 1));
        expected.add(new Coordinate(1, 1));
        expected.add(new Coordinate(1, 0));
        expected.add(new Coordinate(1, -1));
        expected.add(new Coordinate(0, -1));
        expected.add(new Coordinate(-1, -1));
        expected.add(new Coordinate(-1, 0));
        expected.add(new Coordinate(-1, 1));

        boolean result = coordinate.getNeighboringCoordinates().equals(expected);

        assertTrue(result);
    }

    @Test
    void getNeighboringCoordinates_shouldReturn1And2_2And2_2And1_2And0_1And0_0And0_0And1_0And2_whenInputCoordinateIs1And1() {
        Coordinate coordinate = new Coordinate(1, 1);
        HashSet<Coordinate> expected = new HashSet<>();
        expected.add(new Coordinate(1, 2));
        expected.add(new Coordinate(2, 2));
        expected.add(new Coordinate(2, 1));
        expected.add(new Coordinate(2, 0));
        expected.add(new Coordinate(1, 0));
        expected.add(new Coordinate(0, 0));
        expected.add(new Coordinate(0, 1));
        expected.add(new Coordinate(0, 2));

        boolean result = coordinate.getNeighboringCoordinates().equals(expected);

        assertTrue(result);
    }

    @Test
    void hashCode_shouldReturnTheSameValue_whenInputIsBoth1And2() {
        Coordinate coordinate = new Coordinate(1, 2);
        Coordinate inputCoordinate = new Coordinate(1, 2);

        boolean instanceEquality = coordinate.equals(inputCoordinate);
        boolean hashCodeEquality = coordinate.hashCode() == inputCoordinate.hashCode();
        boolean result = instanceEquality && hashCodeEquality;

        assertTrue(result);
    }

    @Test
    void hashCode_shouldReturnDifferentValue_whenCoordinateIs2And1AndInputIs1And2() {
        Coordinate coordinate = new Coordinate(2, 1);
        Coordinate inputCoordinate = new Coordinate(1, 2);

        boolean instanceEquality = coordinate.equals(inputCoordinate);
        boolean hashCodeEquality = coordinate.hashCode() == inputCoordinate.hashCode();
        boolean result = instanceEquality || hashCodeEquality;

        assertFalse(result);
    }
}
