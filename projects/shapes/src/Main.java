import java.util.Objects;

/**
 * Created by captain_nemo on 22.09.16.
 */
public class Main {
    public static void main (String [] args) {
        final int a = 1;
        Circle circle = new Circle(
                new Point(0, 0), 1, Color.BLACK);

        Triangle triangle = new Triangle(
                new Point(0,0), new Point(1, 0), new Point(0, 1), Color.GREEN);

        Square square = new Square(
                new Point(5, 5), 2, Color.RED);


        Object object = triangle;
        triangle = (Triangle) object;
        Shape [] shapes = {circle, triangle, square};
        printArrayElements(shapes);

        Shape maxShape = findShapeWithMaxArea(shapes);
        System.out.println("Shape with max Area: " + maxShape);
    }

    private static void printArrayElements (Object[] objects) {
        for (int i = 0; i < objects.length; ++i)
            System.out.println(i + ": " + objects[i]);
    }

    private static Shape findShapeWithMaxArea (final Shape [] shapes) {
        Shape maxShape = null;
        shapes[0] = (Circle)shapes[0];
        double maxArea = Double.NEGATIVE_INFINITY;
        for (Shape shape : shapes) {
            double area = shape.getArea();
            if (area > maxArea) {
                maxArea = area;
                maxShape = shape;
            }
        }

        return maxShape;
    }
}
