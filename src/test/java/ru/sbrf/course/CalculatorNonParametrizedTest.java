package ru.sbrf.course;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Home on 09.07.2018.
 */
public class CalculatorNonParametrizedTest {
    private Calculator calculator = new Calculator();

    private static List<Number[]> dataAdd() {
        return Arrays.asList(
                new Number[][]{
                        { 5, 2, 7 }, { 1, 1, 2 }, { 2, 1, 3 }
                } );
    }

    private static List<Number[]> dataMultiply() {
        return Arrays.asList(
                new Number[][]{
                        { 5, 2, 10 }, { 1, 1, 1 }, { 2, 1, 2 }
                } );
    }

    @Test
    public void testAdd() throws Exception {
        dataAdd().stream()
                .forEach(
                        numbers -> assertEquals( "fails on array of " + Arrays.toString( numbers )
                                , numbers[ 2 ].intValue()
                                , calculator.add(
                                        numbers[ 0 ].intValue(),
                                        numbers[ 1 ].intValue()
                                )
                        )
                );

    }

    @Test
    public void testMultiply() {
        dataMultiply().stream()
                .forEach(
                        numbers -> assertEquals( "fails on array of " + Arrays.toString( numbers )
                                , numbers[ 2 ].intValue()
                                , calculator.multiply(
                                        numbers[ 0 ].intValue(),
                                        numbers[ 1 ].intValue()
                                )
                        )
                );
    }
}
