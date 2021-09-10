package com.btpn.app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class InputParserTest {
    @Test
    public void handleLivingCellsCoordinateInput_shouldReturnAllInputtedCoordinate_whenInputIsNotEmpty() {
        Set<Coordinate> expectedCoordinates = new HashSet<>();
        expectedCoordinates.add(new Coordinate(1,2));
        expectedCoordinates.add(new Coordinate(3,4));
        String inputData = "1,2\n3,4\nnext\n";
        InputStream inputStream = System.in;
        System.setIn(new ByteArrayInputStream(inputData.getBytes()));
        Scanner scanner = new Scanner(System.in);
        System.setIn(inputStream);

        InputParser inputParser = new InputParser(scanner);
        Set<Coordinate> coordinateSet = inputParser.handleLivingCellsCoordinateInput();

        Assertions.assertTrue(coordinateSet.containsAll(expectedCoordinates));
    }
}
