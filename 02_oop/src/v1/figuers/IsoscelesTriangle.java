package v1.figuers;

/**
 * Class that describes IsoscelesTriangle
 *
 * @author Roman Grabovetskyi
 * @version 1.0.0
 */
public class IsoscelesTriangle extends Triangle {
    /**
     * Sipmle class constructor without arguments for creating objects
     */
    public IsoscelesTriangle() {
    }

    /**
     * Constructor with arguments. That quantity of arguments is en enough to create a triangle
     *
     * @param cornerFirst one of two same corners of Isosceles Triangle
     * @param sideSecond  one of two same sides of Isosceles Triangle
     */
    public IsoscelesTriangle(double cornerFirst, double sideSecond) throws RuntimeException {
        super(cornerFirst, cornerFirst, sideSecond, sideSecond);
        if (cornerFirst > 89.5) {
            throw new RuntimeException(String.format("This  ", getClass().getName(), "is not a Isosceles Triangle"));
        }
    }

    /**
     * This function calculates height of the trianfle
     * It is needed in square calculation
     * This function makes circle bigger by increasing of this radius
     *
     * @return Gets the height of the triangle, it is needed to get the square area
     */
    public double getHeight() {
        return ((getFirstSide().getSideLength() * getFirstSide().getSideLength()) - (
                (getFirstSide().getSideLength() / 2) * (getFirstSide().getSideLength()
                        / 2)));
    }

    /**
     * Generates triangle with random characteristics
     *
     * @return the link to the object of Isosceles Triangle with random parameters.
     */
    @Override
    public IsoscelesTriangle generateRandomFigure() {
        return new IsoscelesTriangle(((int) (Math.random() * MAX + 2) + MIN),
                ((int) (Math.random() * MAX + 1) + MIN));
    }

    /**
     * Calculates square of this type of triangle
     *
     * @return Gets square area of the Isosceles Triangle
     */
    @Override
    public double getSquareArea() {
        return (0.5 * getFirstSide().getSideLength() * getHeight());
    }
}
