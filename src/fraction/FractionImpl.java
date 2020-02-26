package fraction;

public class FractionImpl implements Fraction {

    private int numerator, denominator;

    /**
     * This helper method computes the greatest common divisor of two integers.
     * @param a, b are both of type int.
     * @return The greatest common divisor of a and b.
     */
    private int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        return b == 0 ? a : gcd(b, a % b);
    }

    /**
     * Main Fraction Constructor
     * @param numerator of the fraction as type int.
     * @param denominator of the fraction as type int.
     * Normalises the fraction.
     * Throws an exception if the denominator is zero.
     */
    public FractionImpl(int numerator, int denominator) {
        int gcd = gcd(numerator, denominator);
        if(denominator != 0) {
            if(denominator < 0) {
                this.denominator = denominator * -1 / gcd;
                this.numerator = numerator * -1 / gcd;
            } else {
                this.numerator = numerator / gcd;
                this.denominator = denominator / gcd;
            }
        } else {
            throw new ArithmeticException("Denominator can't be zero!");
        }
    }

    /**
     * Whole number Fraction Constructor
     * Uses the first constructor with default denominator of 1.
     * @param wholeNumber representing the numerator as type int.
     */
    public FractionImpl(int wholeNumber) {
        this(wholeNumber, 1);
    }

    /**
     * String Fraction Constructor
     * The parameter is a <pre>String</pre> containing either a whole number, such as `5` or `-3`, or a fraction,
     * such as "8/-12".
     * Allow blanks around (but not within) integers.
     * The constructor should throw an ArithmeticException
     * if given a string representing a fraction whose denominator is zero.
     * @param fraction the string representation of the fraction
     */
    public FractionImpl(String fraction) {
        String[] fractionArray = fraction.split("/");
        try {
            if (fractionArray.length != 2 ) {
                if (fractionArray.length == 1) {
                    //if legal integer, convert string to int
                    this.numerator = Integer.parseInt(fraction);
                    this.denominator = 1;
                } else {
                    throw new IllegalArgumentException("Invalid input value!!!");
                }
            } else {
                int numerator = Integer.parseInt(fractionArray[0].trim());
                int denominator = Integer.parseInt(fractionArray[1].trim());
                int gcd = gcd(numerator, denominator);
                if(denominator != 0) {
                    if(denominator < 0) {
                        this.denominator = denominator * -1 / gcd;
                        this.numerator = numerator * -1 / gcd;
                    } else {
                        this.numerator = numerator / gcd;
                        this.denominator = denominator / gcd;
                    }
                } else {
                    throw new ArithmeticException("Denominator can't be zero!");
                }
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
        FractionImpl fraction = (FractionImpl)f;
        //the expression (FractionImpl)f means to check that the object is of class FractionImpl
        // or a subclass of that (and throw a ClassCastException if it isn't). Now, a FractionImpl is Fraction,
        // but the inverse isn't necessarily true; the cast here ensures that other will either be FractionImpl;
        // if it's not further instructions will not be executed because an exception will have been thrown.
        int numerator = this.numerator * fraction.denominator + this.denominator * fraction.numerator;
        int denominator = this.denominator * fraction.denominator;
        return new FractionImpl(numerator, denominator);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction subtract(Fraction f) {
        FractionImpl fraction = (FractionImpl)f;
        int numerator =  this.numerator * fraction.denominator - this.denominator * fraction.numerator;
        int denominator = this.denominator * fraction.denominator;
        return new FractionImpl(numerator, denominator);
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
        if (denominator == 1) {
            return "" + numerator;
        } else {
            return "" + numerator + "/" + denominator;
        }
    }
}