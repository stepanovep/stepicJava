
public class A {
    private double x;
    private int y;
    private String z;
    public A () {
        x = 0;
        y = 0;
    }
    public A (double x, int y, String z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString () {
        return "x = " + x +
                ", y = " + y;
    }
}