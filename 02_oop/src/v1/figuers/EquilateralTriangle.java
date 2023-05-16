package v1.figuers;

/**
 * Class that describes EquilateralTriangle
 *
 * @author Roman Grabovetskyi
 * @version 1.0.0
 */
public class EquilateralTriangle extends IsoscelesTriangle {
    /**
     * Constructor with arguments.
     * Creates an object of the Equilateral Triangle with given side
     * That quantity of arguments is en enough to create a Equilateral triangle
     *
     * @param sideSecond the side of Equilateral Triangle
     */
    public EquilateralTriangle(double sideSecond) {
        super(60.0, sideSecond);
    }

    /**
     * Sipmle class constructor without arguments for creating objects
     * Creates an empty object of the Equilateral Triangle
     */
    public EquilateralTriangle() {
    }

    /**
     * This function generates random Equilateral Triangle
     *
     * @return Gets link to the object of Equilateral Triangle with random parameters
     */
    @Override
    public EquilateralTriangle generateRandomFigure() {
        return new EquilateralTriangle(((int) (Math.random() * MAX) + MIN));
    }
}