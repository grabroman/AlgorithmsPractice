package v1.figuers;

/**
 * Class that describes ScaleneTriangle
 *
 * @author Roman Grabovetskyi
 * @version 1.0.0
 */
public class ScaleneTriangle extends Triangle {
    /**
     * Constructor with arguments.
     * Creates the  Scalene Triangle
     * That quantity of arguments is en enough to create a triangle
     *
     * @param cornerA the corner of the Scalene Triangle
     * @param cornerB the corner of the Scalene Triangle
     * @param sideB   the side of the Scalene Triangle
     * @param sideC   the side of the Scalene Triangle
     */
    public ScaleneTriangle(double cornerA, double cornerB, double sideB,
                           double sideC) {
        super(cornerA, cornerB, sideB, sideC);
    }

    /**
     * Sipmle class constructor without arguments for creating objects
     * Creates an empty object of Scalene Triangle
     */
    public ScaleneTriangle() {
    }

    /**
     * This function generates triangle with random characteristics
     *
     * @return Gets ScaleneTriangle with random corners and sides
     */
    @Override
    public ScaleneTriangle generateRandomFigure() {
        return new ScaleneTriangle(((int) (Math.random() * MAX + 4) + MIN),
                ((int) (Math.random() * MAX + 1) + MIN),
                ((int) (Math.random() * MAX + 2) + MIN),
                ((int) (Math.random() * MAX + 3) + MIN));
    }

    /**
     * This function calculates square of this type of triangle
     *
     * @return Gets square of the triangle
     */
    @Override
    public double getSquareArea() {
        return (0.5 * getFirstSide().getSideLength() * getSecondSide().getSideLength()
                * Math.sin(getFirstCorner().getCorner()));
    }
}
