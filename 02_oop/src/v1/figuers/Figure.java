package v1.figuers;

import v1.figureparts.Side;

/**
 * Class that describes Figure
 *
 * @author Roman Grabovetskyi
 * @version 1.0.0
 */
public abstract class Figure {
    protected final int MAX = 85;
    protected final int MIN = 1;
    protected Side firstSide;

    /**
     * Sipmle class constructor without arguments for creating objects
     */
    protected Figure() {
    }

    /**
     * Abstract function for realization in classes which will extend from figure
     * This one increases the size of figure
     */
    public abstract Figure generateRandomFigure();

    /**
     * Abstract function for realization in classes which will extend from figure
     * This one increases should calculate square
     */
    public abstract double getSquareArea();

    /**
     * This function helps us to write information about figure when it is needed
     * It writes square and name of the figure
     *
     * @return string that describes figure with its name and square area
     */
    @Override
    public String toString() {
        return super.toString() + " Square:" + (int) getSquareArea();
    }

    /**
     * Sipmle class constructor without one arguments for creating object
     * Creates figure with given side
     *
     * @param sideFirst the side of the figure
     */
    protected Figure(double sideFirst) {
        this.firstSide = new Side(sideFirst);
    }

    /**
     * Returns first side of the figure
     *
     * @return value of the side
     */
    public Side getFirstSide() {
        return firstSide;
    }

    /**
     * This function makes figure bigger by increasing one of it's sides
     *
     * @param times value how many times to make figure bigger
     */
    public void makeBigger(double times) {
        getFirstSide().setSideLength(getFirstSide().getSideLength() * times);
    }
}
