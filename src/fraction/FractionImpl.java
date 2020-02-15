package fraction;

public class FractionImpl implements Fraction {
    /**
     * Parameters are the <em>numerator</em> and the <em>denominator</em>.
     * Normalize the fraction as you create it.
     * For instance, if the parameters are <pre>(8, -12)</pre>, create a <pre>Fraction</pre> with numerator
     * <pre>-2</pre> and denominator <pre>3</pre>.
     *
     * The constructor should throw an <pre>ArithmeticException</pre> if the denominator is zero.
     *
     * @param numerator
     * @param denominator
     */
    private int numerator;
    private int denominator;

    /** Helper method: To find the GCD (greatest common divisor) */
    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    /** Helper method: Check and split string */
//    String[] stringSplit(String str) {
//        String[] strings = new String[2];
//        if (str.contains("/")) {
//            strings = str.split("/");
//        }
//        return strings;
//    }
    private String[] stringSplit(String s) {
        String[] str = s.split("/");
        return str;
    }

    public FractionImpl(int numerator, int denominator) {
        if(denominator == 0) {
            throw new ArithmeticException("Denominator can't be zero!");
        } else if (denominator < 0) {
            denominator = -denominator;
            numerator = -numerator;
        }
        int gcd = gcd(numerator, denominator);
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }


    /**
     * The parameter is the numerator and <pre>1</pre> is the implicit denominator.
     *
     * @param wholeNumber representing the numerator
     */
    public FractionImpl(int wholeNumber) {
        this.numerator = wholeNumber;
        this.denominator = 1;
    }

    /**
     * The parameter is a <pre>String</pre> containing either a whole number, such as `5` or `-3`, or a fraction,
     * such as "8/-12".
     * Allow blanks around (but not within) integers.
     * The constructor should throw an <pre>ArithmeticException</pre>
     * if given a string representing a fraction whose denominator is zero.
     * <p>
     * You may find it helpful to look at the available String API methods in the Java API.
     *
     * @param fraction the string representation of the fraction
     */
    public FractionImpl(String fraction) {
        String[] fractionArray = fraction.split("/");
        try {
            if (fractionArray.length != 2 ) {
                if (fractionArray.length == 1) {
                    //if legal integer, convert string to int
                    new FractionImpl(Integer.parseInt(fraction));
                } else {
                    throw new IllegalArgumentException("Invalid input value!!!");
                }
            } else {
                new FractionImpl(Integer.parseInt(fractionArray[0]), Integer.parseInt(fractionArray[1]));
            }
        }
        catch (NumberFormatException nfe) {
            //if illegal value, print error
            throw nfe;
        }
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction add(Fraction f) {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction subtract(Fraction f) {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction multiply(Fraction f) {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction divide(Fraction f) {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction abs() {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction negate() {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * @inheritDoc
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /**
     * @inheritDoc
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction inverse() {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public int compareTo(Fraction o) {
        return 0;
    }

    /**
     * @inheritDoc
     */
    @Override
    public String toString() {
        if (this.denominator == 1) {
            return "" + numerator;
        }
        else {
            return "["+ numerator + "/" + denominator + "]";
        }
    }
}