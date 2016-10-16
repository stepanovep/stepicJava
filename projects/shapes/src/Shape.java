/**
 * Created by captain_nemo on 22.09.16.
 */
public abstract class Shape {

    private final Color color;

    public Shape (Color color)  { this.color = color; }

    public Color getColor ()    { return color; }

    public abstract double getArea ();
}
