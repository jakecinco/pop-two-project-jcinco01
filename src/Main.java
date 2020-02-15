import fraction.FractionImpl;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        FractionImpl f1 = new FractionImpl(20,40);
        FractionImpl f2 = new FractionImpl(8);
        FractionImpl f3 = new FractionImpl("3/4");
        FractionImpl f4 = new FractionImpl("3/4");
        FractionImpl f5 = new FractionImpl("One");

        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f3);
        System.out.println(f4);
        System.out.println(f5);

//        Fraction add = Fraction.fractionAddition(f1, f2);
//        Fraction sub = Fraction.fractionSubtraction(f1, f2);
//        Fraction mul = Fraction.fractionMultiplication(f1, f2);
//        Fraction div = Fraction.fractionDivision(f1, f2);

//        System.out.println(add);
//        System.out.println(sub);
//        System.out.println(mul);
//        System.out.println(div);
    }

}