package fraction;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class FractionImplTest {

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
        assertThrows(ArithmeticException.class, () -> {
            new FractionImpl(1, 0);
        });
    }

    @Test
    public void testFractionNotNull() {
        FractionImpl f = new FractionImpl(1, 2);
        assertNotNull(f);
    }

    //TODO - test case for gcd method


    @Test
    public void testStringFractionZeroDivision() {
        assertThrows(ArithmeticException.class, () -> {
            FractionImpl f = new FractionImpl(1/0);
        });
    }

    @Test
    public void testStringFractionInvalidStrings() {
        assertThrows(NumberFormatException.class, () -> {
            FractionImpl f1 = new FractionImpl("One");
            FractionImpl f2 = new FractionImpl("Three/4");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new FractionImpl("3//4");
            new FractionImpl("9 0 9/4"); //should be break!!
        });
    }

    @Test
    public void testAdd() {
        Fraction f1 = new FractionImpl(1, 4);
        assertEquals("1", new FractionImpl(-3, -4).add(f1).toString());
    }

}