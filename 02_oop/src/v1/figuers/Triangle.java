package v1.figuers;

import v1.figureparts.Corner;
import v1.figureparts.Side;

/**
 * Class that describes Triangle
 *
 * @author Roman Grabovetskyi
 * @version 1.0.0
 */
public abstract class Triangle extends Figure {
    private Corner firstCorner;
    private Corner secondCorner;
    private Corner thirdCorner;
    private Side secondSide;
    private Side thirdSide;

    /**
     * Constructor with arguments.
     * Creates a Triangle.
     * That quantity of arguments is en enough to create a triangle
     *
     * @param firstCorner  the value of the first corner of the triangle
     * @param secondCorner the value of the second corner of the triangle
     * @param secondSide   the length of the second side of the triangle
     * @param thirdSide    the length of the third  side of the triangle
     */
    protected Triangle(double firstCorner, double secondCorner,
                       double secondSide, double thirdSide) {
        double thirdCorner = findCorner(firstCorner, secondCorner);
        double firstSide = findSideLength(secondSide, thirdSide);
        this.firstCorner = new Corner(firstCorner);
        this.secondCorner = new Corner(secondCorner);
        this.thirdCorner = new Corner(thirdCorner);
        this.firstSide = new Side(firstSide);
        this.secondSide = new Side(secondSide);
        this.thirdSide = new Side(thirdSide);
        this.firstCorner.setBothSides(this.firstSide, this.secondSide);
        this.secondCorner.setBothSides(this.secondSide, this.thirdSide);
        this.thirdCorner.setBothSides(this.thirdSide, this.firstSide);
        this.firstSide.setBothCorners(this.firstCorner, this.thirdCorner);
        this.secondSide.setBothCorners(this.firstCorner, this.secondCorner);
        this.thirdSide.setBothCorners(this.secondCorner, this.thirdCorner);
    }

    /**
     * Sipmle class constructor without arguments
     * Creates Triangle
     */
    public Triangle() {
    }

    /**
     * Calculates the length of the unknown side.
     *
     * @param cornerSecond the value of the second corner of the triangle
     * @param sideThird    the length of the third side of the triangle
     */
    public double findSideLength(double cornerSecond, double sideThird) {
        return Math.sqrt(
                (secondSide.getSideLength() * secondSide.getSideLength())
                        + (sideThird * sideThird)
                        - (2 * secondSide.getSideLength() * sideThird * Math.cos(cornerSecond))
        );
    }

    /**
     * Calculates the value of the corner.
     *
     * @param cornerFirst  the value of the first corner of the triangle
     * @param cornerSecond the value of the second corner of the triangle
     * @return the value of the third corner of the triangle
     */
    public double findCorner(double cornerFirst, double cornerSecond) throws RuntimeException {
        cornerFirst = 180 - cornerFirst - cornerSecond;
        if (cornerFirst <= 0) {
            throw new RuntimeException("Wrong corners");
        }
        return cornerFirst;
    }

    /**
     * This function returns corner one.
     *
     * @return Gets cornerOne of the triangle
     */
    public Corner getFirstCorner() {
        return firstCorner;
    }

    /**
     * This is function returns second side
     *
     * @return Gets second side of the triangle
     */
    public Side getSecondSide() {
        return secondSide;
    }
}
