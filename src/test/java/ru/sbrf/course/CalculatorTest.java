package ru.sbrf.course;

import org.junit.Assume;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;

@Category( { SlowTests.class, FastTests.class } )
@RunWith( Parameterized.class )
public class CalculatorTest {

    private enum OperationEnum {
        Add, Multiply
    }

    @Parameter()
    public OperationEnum operation;

    @Parameter( 1 )
    public int a;

    @Parameter( 2 )
    public int b;

    @Parameter( 3 )
    public int expected;

    private Calculator calculator = new Calculator();

    @Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList( new Object[][]{
                { OperationEnum.Add, 5, 2, 7 }, { OperationEnum.Add, 1, 1, 2 }, { OperationEnum.Add, 2, 1, 3 },
                { OperationEnum.Multiply, 5, 2, 10 }, { OperationEnum.Multiply, 1, 1, 1 }, { OperationEnum.Multiply, 2, 1, 2 }
        } );
    }

    @Test
    public void testAdd() throws Exception {
        Assume.assumeTrue( operation == OperationEnum.Add );
        assertEquals( expected, calculator.add( a, b ) );
    }

    @Test
    public void testMultiply() throws Exception {
        Assume.assumeTrue( operation == OperationEnum.Multiply );
        assertEquals( expected, calculator.multiply( a, b ) );
    }
}
