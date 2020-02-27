package fraction;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

public class FractionImplTest {

    private static FractionImpl oneHalf, oneFourth, twoThirds;
    private static FractionImpl negOneHalf, negOneFourth;

    /**
     * Create test values before main tests starts.
     */
    @BeforeAll
    public static void beforeEverything() {
        //Create valid positive fractions
        oneHalf = new FractionImpl(1,2);
        oneFourth = new FractionImpl(1,4);
        twoThirds = new FractionImpl(2,3);
        //Create valid negative fractions
        negOneHalf = new FractionImpl(-1, 2);
        negOneFourth = new FractionImpl(-1, 4);
    }

    /**
     * Clears values after each test cases.
     */
    @AfterAll
    public static void afterEverything() {
        oneHalf = null;
        oneFourth = null;
        twoThirds = null;
        negOneHalf = null;
        negOneFourth = null;
    }

    @Test
    public void testExpectedException() {
        assertThrows(ArithmeticException.class, () -> {
            new FractionImpl(1, 0);
        });
    }

    @Test
    public void testFractionImplNotNull() {
        FractionImpl f = new FractionImpl(1, 2);
        assertNotNull(f);
    }

    //TODO - test case for gcd method - private method not tested
//    @Test
//    public void testGCD() {
//        assertEquals(5, FractionImpl.gcd(20, 25));
//    }


    @Test
    public void testStringFractionImplZeroDivision() {
        assertThrows(ArithmeticException.class, () -> {
            new FractionImpl(1/0);
            new FractionImpl("1/0");
        });
    }

    @Test
    public void testStringFractionImplInvalidStrings() {
        assertThrows(NumberFormatException.class, () -> {
            new FractionImpl("One");
            new FractionImpl("Three/4");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new FractionImpl("3//4");
            new FractionImpl("9 9/4");
        });
    }

    @Test
    public void testAdd() {
        assertEquals("1", new FractionImpl(-3, -4).add(oneFourth).toString());
        assertEquals("1/4", new FractionImpl(1, -4).add(oneHalf).toString());
        assertEquals("0", new FractionImpl(-1, 4).add(oneFourth).toString());
        assertEquals("-1/4", new FractionImpl(-3, 4).add(oneHalf).toString());
        assertEquals("1/2", new FractionImpl(3, 4).add(negOneFourth).toString());
    }

    @Test
    public void testSubtract() {
        assertEquals("0", new FractionImpl(-2, -3).subtract(twoThirds).toString());
        assertEquals("-1", new FractionImpl(-3, 9).subtract(twoThirds).toString());
        assertEquals("1/4", new FractionImpl(6, 12).subtract(oneFourth).toString());
        assertEquals("1", new FractionImpl(5, 3).subtract(twoThirds).toString());
        assertEquals("-1/4", new FractionImpl(-3, 4).subtract(negOneHalf).toString());
    }

    @Test
    public void testMultiply() {
        assertEquals("1/8", (oneHalf.multiply(oneFourth)).toString());
        assertEquals("1/4", (oneHalf.multiply(oneHalf)).toString());
        assertEquals("-1/4", oneHalf.multiply(negOneFourth).toString());
    }

    @Test
    public void testDivide() {

    }

    @Test
    public void testAbs() {


    }

    @Test
    public void testNegate() {

    }

    @Test
    public void testInverse() {

    }

    @Test
    public void testEquals() {

    }

    @Test
    public void testCompareTo() {

    }

    @Test
    public  void testToString() {

    }
}