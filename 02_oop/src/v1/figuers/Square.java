package v1.figuers;

/**
 * Class that describes Square
 *
 * @author Roman Grabovetskyi
 * @version 1.0.0
 */
public class Square extends Figure {
    /**
     * Sipmle class constructor without arguments for creating objects
     * Creates object of the square
     *
     * @param sideFirst the side of the Square
     */
    public Square(double sideFirst) {
        super(sideFirst);
    }

    /**
     * Sipmle class constructor without arguments for creating objects
     * Creates empty object of the square
     */
    public Square() {
    }

    /**
     * This function generates figure with random characteristics
     *
     * @return Gets square with random value of the side
     */
    @Override
    public Square generateRandomFigure() {
        return new Square(((int) (Math.random() * MAX + 4) + MIN));
    }

    /**
     * This function calculates square of this type of figure
     *
     * @return Gets square area  of the Square
     */
    @Override
    public double getSquareArea() {
        return (getFirstSide().getSideLength() * getFirstSide().getSideLength());
    }
}
