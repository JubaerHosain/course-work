package TypeCasting;

public class Main {
    public static void main(String[] args) {
        A a = new B1(2, 3);
        System.out.println(a.getArea());

        B1 b = (B1) a;
        b.setSize(4, 5);
        System.out.println(b.getArea());

        System.out.println(a instanceof A);
        System.out.println(a instanceof B1);
        System.out.println(a instanceof B2);

        // this is wrong
        /**
        B2 b2 = (B2) a;
        System.out.println(b2.getArea());
        */
    }
}
