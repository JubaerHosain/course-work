package TypeCasting;

public class B1 implements A {
    private int x,  y;

    public B1(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }
    @Override
    public int getArea() {
        return this.x * this.y;
    }

    public void setSize(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
