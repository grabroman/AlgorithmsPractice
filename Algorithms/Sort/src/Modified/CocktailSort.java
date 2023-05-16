package Modified;

import java.util.Arrays;

public class CocktailSort {
    /**
     Сортировка перемешиванием, или Шейкерная сортировка, или двунаправленная (англ. Cocktail sort) — разновидность пузырьковой сортировки.
     Анализируя метод пузырьковой сортировки, можно отметить два обстоятельства.

     Во-первых, если при движении по части массива перестановки не происходят,
     то эта часть массива уже отсортирована и, следовательно, её можно исключить из рассмотрения.

     Во-вторых, при движении от конца массива к началу минимальный элемент «всплывает» на первую позицию,
     а максимальный элемент сдвигается только на одну позицию вправо.

     Эти две идеи приводят к следующим модификациям в методе пузырьковой сортировки.
     Границы рабочей части массива (то есть части массива, где происходит движение) устанавливаются в месте последнего обмена на каждой итерации.
     Массив просматривается поочередно справа налево и слева направо.
     */

    public static void main(String[] args) {
        int [] arr = new int[50];
        fillArray(arr);
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    private static void fillArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10 + 1);
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int arr[]) {
        int buff;
        int left = 0;
        int right = arr.length - 1;
        do {
            for (int i = left; i < right; i++) {
                if (arr[i] > arr[i + 1]) {
                    buff = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buff;
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (arr[i] < arr[i - 1]) {
                    buff = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = buff;
                }
            }
            left++;
        } while (left < right);
    }
}
