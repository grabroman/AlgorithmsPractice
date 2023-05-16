package v2.pens;

/**
 * Class that describes AbstractPen
 *
 * @author Roman Grabovetskyi
 * @version 1.0.0
 */
public abstract class WritingInstrument {
    protected double writingResource;
    final static double maxWritingResource = 10000;

    /**
     * Sipmle class constructor without arguments for creating object
     */
    public WritingInstrument() {
        this.writingResource = maxWritingResource;
    }

    /**
     * This abstract function is to be implemented in child classes.
     * It is wrriten here to secure the contract of the function
     */
    public abstract void write(StringBuilder str, char[] array);

    /**
     * This function returns string with data about our object
     * We have the name of class and value of writingResource in persents
     *
     * @return Gets string with information about the pen, its name and writing resource
     */
    @Override
    public String toString() {
        return String.format(super.toString(), getClass().getName(),
                " Left ", writingResourcePercent(writingResource), "%");
    }

    /**
     * This function value of resource which is used to write in presents
     *
     * @param writingResource the value of writing resource of the pen
     * @return value of writing resource in percent
     */
    public double writingResourcePercent(double writingResource) {
        return (writingResource / (maxWritingResource / 100));
    }

    /**
     * Returns value of resource which is used to write
     *
     * @return value of the writing resource
     */
    public double getWritingResource() {
        return writingResource;
    }
}
