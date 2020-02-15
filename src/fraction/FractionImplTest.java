package fraction;

import java.util.Arrays;

import com.sun.jdi.InvalidTypeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FractionImplTest {

//    // Instance variables numerator & denominator
//    private static int numerator;
//    private static int denominator;
//
//    //FractionImpl object
//    FractionImpl fraction;
//
//    // Set up initial fraction instance
//    @BeforeAll
//    public void setUp() {
//        fraction = new FractionImpl(numerator, denominator);
//    }

    @Test
    public void testExpectedException() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            FractionImpl f = new FractionImpl(1, 0);
        });
    }

    @Test
    public void testFractionNotNull() {
        FractionImpl f = new FractionImpl(1, 2);
        Assertions.assertNotNull(f);
    }

    //TODO - test case for gcd method



    @Test
    public void testStringFractionZeroDivision() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            FractionImpl f = new FractionImpl("1/0");
        });
    }

    @Test
    public void testStringFractionInvalidStrings() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            FractionImpl f1 = new FractionImpl("One");
            FractionImpl f2 = new FractionImpl("Three/4");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            FractionImpl f1 = new FractionImpl("3//4");
            FractionImpl f2 = new FractionImpl("1 0/4");
        });
    }

    @Test
    public void testStringSplitSubstringSlash() {
        String s1 = "3/4";
        String s2 = "34";
        Assertions.assertTrue(s1.contains("/"));
        Assertions.assertFalse(s2.contains("/"));
    }
}