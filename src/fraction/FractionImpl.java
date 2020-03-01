package fraction;

import java.util.IllegalFormatException;

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
     * <p>Normalises the fraction.</p>
     * @param numerator of the fraction as type 'int'.
     * @param denominator of the fraction as type 'int'.
     * @throws ArithmeticException if the denominator is zero.
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
            if(fractionArray.length == 1 ) {
                //if legal integer, convert string to int
                this.numerator = Integer.parseInt(fraction);
                this.denominator = 1;
            } else if(fractionArray.length == 2 ) {
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
            //OK to ignore "nfe" because this is the documented behaviour on invalid input.
            throw new NumberFormatException(fraction + " is not a valid number.");
        }
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction add(Fraction f) {
        FractionImpl fraction = (FractionImpl) f;
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
        FractionImpl fraction = (FractionImpl) f;
        int numerator =  this.numerator * fraction.denominator - this.denominator * fraction.numerator;
        int denominator = this.denominator * fraction.denominator;
        return new FractionImpl(numerator, denominator);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction multiply(Fraction f) {
        FractionImpl fraction = (FractionImpl) f;
        int numerator = this.numerator * fraction.numerator;
        int denominator = this.denominator * fraction.denominator;
        return new FractionImpl(numerator, denominator);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction divide(Fraction f) {
        FractionImpl fraction = (FractionImpl) f;
        int numerator = this.numerator * fraction.denominator;
        int denominator = this.denominator * fraction.numerator;
        return new FractionImpl(numerator, denominator);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction abs() {
        return new FractionImpl(Math.abs(numerator), Math.abs(denominator));
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction negate() {
        return new FractionImpl(numerator * -1, denominator);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction inverse() {
        if (numerator != 0) {
            return new FractionImpl(denominator, numerator);
        } else {
            throw new ArithmeticException();
        }
    }

    /**
     * @inheritDoc
     */
    @Override
    public boolean equals(Object o) {
        FractionImpl f = (FractionImpl) o;
        if(o != null) {
            return this.numerator * f.denominator == f.numerator * this.denominator;
        } else {
            return false;
        }
    }

    /**
     * @inheritDoc
     */
    @Override
    public int compareTo(Fraction o) {
        FractionImpl fraction = (FractionImpl) this.subtract(o);
        return fraction.numerator * fraction.denominator;
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