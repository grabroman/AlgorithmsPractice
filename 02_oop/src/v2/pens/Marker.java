package v2.pens;

/**
 * Class that describes Marker
 *
 * @author Roman Grabovetskyi
 * @version 1.0.0
 */
public class Marker extends WritingInstrument {
    /**
     * This function implements marker's writing
     *
     * @param str   link to the StringBuilder where we write by our marker
     * @param array char array of symbols that are written into StringBuilder
     */
    @Override
    public void write(StringBuilder str, char[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            str.append(array[i]);
            if (i < 21 && writingResource > (maxWritingResource / 100)) {
                writingResource = writingResource - (maxWritingResource / 100);
            } else if (i < 41 && writingResource
                    > (maxWritingResource / 100) * (1.09)) {
                writingResource = writingResource
                        - (maxWritingResource / 100) * (1.09);
            } else if (writingResource > (maxWritingResource / 100) * (1.21)) {
                writingResource = writingResource
                        - (maxWritingResource / 100) * (1.21);
            } else {
                break;
            }
        }
    }
}
