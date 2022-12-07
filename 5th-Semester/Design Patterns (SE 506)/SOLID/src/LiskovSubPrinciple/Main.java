package LiskovSubPrinciple;

public class Main {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(5, 4);
        System.out.println(rectangle.getArea());

        rectangle.setSize(6, 7);

        System.out.println(rectangle.getArea());
    }
}
