package v2.pens;

/**
 * Class that describes Pencil
 *
 * @author Roman Grabovetskyi
 * @version 1.0.0
 */
public class Pencil extends WritingInstrument implements Washable {
    /**
     * This function implements pencil's writing
     *
     * @param str   link to the StringBuilder where we write by our marker
     * @param array char array of symbols that are written into StringBuilder
     */
    @Override
    public void write(StringBuilder str, char[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            str.append(array[i]);
            if (writingResource > (maxWritingResource / 100) * (1.15)) {
                writingResource =
                        writingResource - (maxWritingResource / 100) * (1.15);
            } else {
                break;
            }
        }
        wash(str);
    }
}
