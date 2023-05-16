package v1.figureparts;

/**
 * Class that describes Side
 *
 * @author Roman Grabovetskyi
 * @version 1.0.0
 */
public class Side {
    private double sideLength;
    private Corner cornerOne;
    private Corner cornerTwo;

    /**
     * Constructor with arguments.
     * Creates a Side with no corners.
     *
     * @param sideLength the value of the length of the side
     */
    public Side(double sideLength) {
        this.sideLength = sideLength;
    }

    /**
     * Gets the value of the side length
     *
     * @return the length of the side
     */
    public double getSideLength() {
        return sideLength;
    }

    /**
     * Sets the value of the side length
     *
     * @param sideLength the value of the length of the side
     */
    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }

    /**
     * Sets both links to the both corner
     *
     * @param cornerFirst  link for the object of the first corner of the side
     * @param cornerSecond link for the object of the second corner of the side
     */
    public void setBothCorners(Corner cornerFirst, Corner cornerSecond) {
        this.cornerOne = cornerFirst;
        this.cornerTwo = cornerSecond;
    }
}
