package v2.pens;

/**
 * Class that describes Pen
 *
 * @author Roman Grabovetskyi
 * @version 1.0.0
 */
public class Pen extends WritingInstrument implements Washable {
    /**
     * This function implements pen's writing
     *
     * @param str   link to the StringBuilder where we write by our marker
     * @param array char array of symbols that are written into StringBuilder
     */
    @Override
    public void write(StringBuilder str, char[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            str.append(array[i]);
            if (i == 0
                    && writingResource > (maxWritingResource / 100) * (0.95)) {
                writingResource =
                        writingResource - (maxWritingResource / 100) * (0.95);
            } else {
                if (writingResource > (maxWritingResource / 100) * (0.15)) {
                    writingResource = writingResource
                            - (maxWritingResource / 100) * (0.15);
                } else {
                    break;
                }
            }
        }
        wash(str);
    }
}
