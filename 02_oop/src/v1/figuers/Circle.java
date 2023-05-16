package v1.figuers;

/**
 * Class that describes Circle
 *
 * @author Roman Grabovetskyi
 * @version 1.0.0
 */
public class Circle extends Figure {
    private double radius;
    double pi = 3.14;

    /**
     * Sipmle class constructor without arguments for creating objects
     * Creates empty object of the circle
     */
    public Circle() {
    }

    /**
     * Constructor with arguments.
     * That quantity of arguments is en enough to create a circle
     * Creates circle with given radius
     *
     * @param radius radius of the circle
     */
    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * This function returns radius of the circle
     *
     * @return Gets radius of the Circle
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Generates circle with random parameters
     *
     * @return link to the circle with random radius
     */
    @Override
    public Circle generateRandomFigure() {
        return new Circle((Math.random() * MAX) + MIN);
    }

    /**
     * Makes circle bigger by increasing of this radius
     *
     * @param times how many times bigger should we make the figure
     */
    @Override
    public void makeBigger(double times) {
        setRadius((getRadius() * times));
    }

    /**
     * This function returns calculated square  of the circle
     *
     * @return Gets Square Area of the Circle
     */
    @Override
    public double getSquareArea() {
        return (pi * getRadius() * getRadius());
    }

    /**
     * Sets radius of the circle
     *
     * @param radius of the Circle
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }
}
