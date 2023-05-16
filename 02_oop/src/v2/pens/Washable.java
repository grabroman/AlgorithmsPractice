package v2.pens;

/**
 * Interface that extends functionality allowing to wash what was written
 *
 * @author Roman Grabovetskyi
 * @version 1.0.0
 */
public interface Washable {
    /**
     * This function washs last simvol
     *
     * @param str StringBuilder where we wash symbols from
     */
    default void wash(StringBuilder str) {
        str.deleteCharAt(str.length() - 1);
    }
}
