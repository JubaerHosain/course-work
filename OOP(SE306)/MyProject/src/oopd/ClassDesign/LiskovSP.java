package oopd.ClassDesign;

class Rectangle {
    int height, width;

    public Rectangle() {

    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}

class Square extends Rectangle {

}

class MyClass {
    public void drawShape() {
        Square square = new Square();
//        we can by only one side for square
//        violation of liskov
//        so in this case we should not extend Rectangle by Square
        square.setHeight(44);
        square.setHeight(44);
    }
}

public class LiskovSP {
}













