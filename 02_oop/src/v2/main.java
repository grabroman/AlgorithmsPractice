package v2;

import v2.pens.WritingInstrument;
import v2.pens.Marker;
import v2.pens.Pen;
import v2.pens.Pencil;

import java.util.Random;

/**
 * Class that shows work of figure classes according to the task
 *
 * @author Roman Grabovetskyi
 * @version 1.0.0
 */
public class main {
    public static void main(String[] args) {
        WritingInstrument[] pens = new WritingInstrument[10];
        char[] array = {'a', 'd', 'i', 'n'};
        final int MIN = 0;
        final int MAX = 2;
        int choice;
        for (int i = 0; i < 10; i++) {
            if (i == 0) {
                choice = 0;
            } else if (i == 5) {
                choice = ((int) (Math.random() * MAX) + MIN);
            } else {
                choice = (new Random().nextInt(3));
            }
            switch (choice) {
                case 0:
                    pens[i] = new Marker();
                    break;
                case 1:
                    pens[i] = new Pen();
                    break;
                case 2:
                    pens[i] = new Pencil();
                    break;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = pens.length - 1; i >= 0; i--) {
            for (int j = 0; j < 10; j++) {
                for (int n = 0; n < array.length; n++) {
                    pens[i].write(stringBuilder, array);
                }
            }
        }
        System.out.println("UnSorted array");
        for (WritingInstrument element : pens) {
            System.out.println(element);
        }
        System.out.println("stringBuilder");
        System.out.println(stringBuilder);
        System.out.println("Sorted array");
        for (int i = pens.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (pens[j].getWritingResource() < pens[j
                        + 1].getWritingResource()) {
                    WritingInstrument f = pens[j];
                    pens[j] = pens[j + 1];
                    pens[j + 1] = f;
                }
            }
        }
        for (WritingInstrument element : pens) {
            System.out.println(element);
        }
    }
}
