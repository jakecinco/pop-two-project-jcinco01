package fraction;

import java.lang.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

public class FractionImplTest {

    private static FractionImpl oneHalf, oneFourth, twoThirds;
    private static FractionImpl negOneHalf, negOneFourth, negThreeNinths, negEightTwelfths;
    private static FractionImpl zeroTenth, zero,one, negOne;

    /**
     * Create test values before main tests starts.
     */
    @BeforeAll
    public static void beforeEverything() {
        //Create valid positive fractions
        oneHalf = new FractionImpl(1,2);
        oneFourth = new FractionImpl(1,4);
        twoThirds = new FractionImpl(2,3);

        //Create valid fractions with negative numerator
        negOneHalf = new FractionImpl(-1, 2);
        negOneFourth = new FractionImpl(-1, 4);

        //Create valid fractions with negative denominator
        negThreeNinths = new FractionImpl(3, -9);
        negEightTwelfths = new FractionImpl(8,-12);

        //Create valid fractions with zero value
        zeroTenth = new FractionImpl(0, 10);

        //Create valid fraction with whole number
        zero = new FractionImpl(0);
        one = new FractionImpl(1);
        negOne = new FractionImpl(-1);


    }

    /**
     * Clears values after each test cases.
     */
    @AfterAll
    public static void afterEverything() {
        //Set all instance variable to null
        oneHalf = null;
        oneFourth = null;
        twoThirds = null;
        negOneHalf = null;
        negOneFourth = null;
        negThreeNinths = null;
        zeroTenth = null;
        zero = null;
        one = null;
        negOne = null;
    }

    @Test
    public void testExpectedException() {
        assertThrows(ArithmeticException.class, () -> {
            new FractionImpl(1, 0);
            zeroTenth.inverse();
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
    public void testFractionImplZeroDivisionException() {
        //Valid integer fraction but division by zero
        assertThrows(ArithmeticException.class, () -> {
            new FractionImpl(1,0);
        });
        //Valid string fraction but division by zero
        assertThrows(ArithmeticException.class, () -> {
            new FractionImpl("1/0");
        });
    }

    @Test
    public void testStringFractionImplInvalidStrings() {
        //Input value with blanks within integers
        assertThrows(NumberFormatException.class, () -> {
            new FractionImpl("9 9 0/2");
        });
        //Input value which is not a number
       assertThrows(NumberFormatException.class, () -> {
           new FractionImpl("One");
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
        assertEquals("1/8", oneHalf.multiply(oneFourth).toString());
        assertEquals("1/4", oneHalf.multiply(oneHalf).toString());
        assertEquals("-1/8", oneHalf.multiply(negOneFourth).toString());
    }

    @Test
    public void testDivide() {
        assertEquals("1/2", oneFourth.divide(oneHalf).toString());
        assertEquals("-1", negEightTwelfths.divide(twoThirds).toString());
    }

    @Test
    public void testAbs() {
        assertEquals("1/3", negThreeNinths.abs().toString());
        assertEquals("0", zeroTenth.abs().toString());

    }

    @Test
    public void testNegate() {
        assertEquals("1/2", negOneHalf.negate().toString());
        assertEquals("-1/4", oneFourth.negate().toString());
        assertEquals("1/3", negThreeNinths.negate().toString());
        assertEquals("0", zeroTenth.negate().toString());
    }

    @Test
    public void testInverse() {
        assertEquals("2", oneHalf.inverse().toString());
        assertEquals("-4", negOneFourth.inverse().toString());
        assertEquals("3/2", twoThirds.inverse().toString());
    }

    @Test
    public void testEquals() {
        assertTrue(new FractionImpl(1,2).equals(oneHalf));
        assertTrue("-1/3".equals(negThreeNinths.toString()));
        assertTrue("-2/3".equals(negEightTwelfths.toString()));
        assertFalse(oneHalf.equals(new FractionImpl(1)));
    }

    @Test
    public void testCompareTo() {
        assertEquals(0, oneFourth.compareTo(new FractionImpl("1/4")));
        assertEquals(0, zero.compareTo(zeroTenth));
        assertTrue(oneHalf.compareTo(oneFourth) > 0);
        assertTrue(one.compareTo(negOne) > 0);
        assertTrue(negOneHalf.compareTo(negOneFourth) < 0);
        assertTrue(negThreeNinths.compareTo(negOneFourth) < 0);
    }

    @Test
    public  void testToString() {
        assertEquals("0", zeroTenth.toString());
        assertEquals("1/2", oneHalf.toString());
        assertEquals("-1/2", negOneHalf.toString());
        assertEquals("-1/3", negThreeNinths.toString());
        assertEquals("0", zero.toString());
        assertEquals("-1",negOne.toString());
    }
}