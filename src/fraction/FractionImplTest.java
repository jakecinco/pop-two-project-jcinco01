package fraction;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
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
    public void testStringSplit() {
        String s = "3/4";
        String[] expected1 = new String[] { "3", "/", "4" };
        Assertions.assertArrayEquals(expected1, s.split(""));
    }

    @Test
    public void testStringSplitSubstringSlash() {
        String s1 = "3/4";
        String s2 = "34";
        Assertions.assertTrue(s1.contains("/"));
        Assertions.assertFalse(s2.contains("/"));
    }
}