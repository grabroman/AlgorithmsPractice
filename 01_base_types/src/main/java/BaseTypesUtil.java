import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.stream.IntStream;

public class BaseTypesUtil implements com.nixsolutions.ppp.basetypes.BaseTypesUtil {
    /**
     * Changes form of the number
     *
     * @param str some number in string
     * @return the number in normal or exponential form
     */
    @Override
    public String toggleScientificNotation(String str) {
        if (str.contains(",")) {
            str = str.replaceFirst(",", ".");
        }
        if (str.contains("e") || str.contains("E")) {
            return BigDecimal.valueOf(Double.parseDouble(str)).toPlainString();
        } else {
            BigDecimal n = new BigDecimal(str);
            NumberFormat formatter = new DecimalFormat("0.0E0");
            formatter.setMinimumFractionDigits(16);
            return formatter.format(n);
        }
    }

    /**
     * Sorts array from big to little
     *
     * @param array array of numbers
     * @return sorted array
     */
    @Override
    public int[] sort(int[] array) {
        return IntStream.of(array)
                .boxed()
                .sorted()
                .mapToInt(value -> value)
                .toArray();
    }

    /**
     * Finds arithmetic mean of an array
     *
     * @param array array of numbers
     * @return average number of the array
     */
    @Override
    public float arithmeticMean(int[] array) {
        float result = 0;
        for (int i = 0; i < array.length; i++) {
            result = result + array[i];
        }
        return result / array.length;
    }

    /**
     * Changes formate of the number according the language format
     *
     * @param n        some number point
     * @param language some language code
     * @return gets the string representation on the language
     */
    @Override
    public String format(double number, String language) {
        Locale locale = new Locale(language);
        NumberFormat formatter = NumberFormat.getNumberInstance(locale);
        return formatter.format(number);
    }

    /**
     * Makes addition  of two numbers.
     *
     * @param firstString  some number in string
     * @param secondString some number in string
     * @return gets result of addition  in string type
     */
    @Override
    public String plus(String firstString, String secondString) {
        BigDecimal decimalOne = new BigDecimal(firstString);
        BigDecimal decimalTwo = new BigDecimal(secondString);
        return String.valueOf(decimalOne.add(decimalTwo));
    }

    /**
     * Makes difference  of two numbers.
     *
     * @param firstString  some number in string
     * @param secondString some number in string
     * @return gets result of difference in string type
     */
    @Override
    public String minus(String firstString, String secondString) {
        BigDecimal decimalOne = new BigDecimal(firstString);
        BigDecimal decimalTwo = new BigDecimal(secondString);
        return String.valueOf(decimalOne.subtract(decimalTwo));
    }

    /**
     * Makes multiplication of two numbers.
     *
     * @param firstString  some number in string
     * @param secondString some number in string
     * @return gets result of multiplication in string type
     */
    @Override
    public String mul(String firstString, String secondString) {
        BigDecimal decimalOne = new BigDecimal(firstString);
        BigDecimal decimalTwo = new BigDecimal(secondString);
        return String.valueOf(decimalOne.multiply(decimalTwo));
    }

    /**
     * Makes division  of two numbers
     *
     * @param firstString  some number in string
     * @param secondString some number in string
     * @return gets result of division in string type
     */

    @Override
    public String div(String firstString, String secondString) {
        BigDecimal decimalOne = new BigDecimal(firstString);
        BigDecimal decimalTwo = new BigDecimal(secondString);
        return String.valueOf(decimalOne.divide(decimalTwo));
    }
}
