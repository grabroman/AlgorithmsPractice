package v1.figureparts;

/**
 * Class that describes Corner
 *
 * @author Roman Grabovetskyi
 * @version 1.0.0
 */
public class Corner {
    private double cornerValue;
    private Side sideOne;
    private Side sideTwo;

    /**
     * Constructor with arguments.
     * Creates a corner with no sides.
     *
     * @param corner the value of the corner
     */
    public Corner(double corner) {
        this.cornerValue = corner;
    }

    /**
     * Gets corner value
     *
     * @return the value of the corner
     */
    public double getCorner() {
        return cornerValue;
    }

    /**
     * Sets links for the both sidses of the corner
     *
     * @param sideFirst  link for the object of the first side of the corner
     * @param sideSecond link for the object of the second side of the corner
     */
    public void setBothSides(Side sideFirst, Side sideSecond) {
        this.sideOne = sideFirst;
        this.sideTwo = sideSecond;
    }
}
