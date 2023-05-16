package Basic;

public class BubbleSort {
    /**
    Сортировка пузырьком (Bubble Sort) — это один из наиболее известных алгоритмов,
     суть которого состоит в последовательном сравнении двух соседних элементов.
     В том случае, если предыдущий элемент больше последующего, они меняются местами.

     Сложность алгоритма: О(n2) n-число элементов

     Как видим из кода, метод bubbleSort() принимает массив в качестве входных данных для сортировки — sortArr.
     Далее мы создаём внешний цикл for, который перебирает каждый элемент массива,
     тогда как внутренний цикл for начинается с первого элемента массива до предпоследнего индекса: sortArr.length - i - 1.
     С помощью условия if мы проверяем, больше ли элемент слева элемента справа или нет.
     Если элемент слева действительно больше, он меняется местами с правым элементом.

     Внешний цикл for будет перебирать все элементы массива, даже если массив уже полностью отсортирован.


     Алгоритм хорошо себя показывает с большими наборами данных,
     где элементы почти отсортированы и требуется всего одна итерация, чтобы определить, отсортирован ли список до конца.

     В случае с совершенно неотсортированным списком, для пузырьковой сортировки он должен быть хотя бы небольшим.
      */

    public static void bubbleSort(int[] sortArr){
        for (int i = 0; i < sortArr.length - 1; i++) {
            for(int j = 0; j < sortArr.length - i - 1; j++) {
                if(sortArr[j + 1] < sortArr[j]) {
                    int swap = sortArr[j];
                    sortArr[j] = sortArr[j + 1];
                    sortArr[j + 1] = swap;
                }
            }
        }
    }
    public static void matrixBubbleSort(int[][] sortMatrix){
        int swap;
        for (int i = 0; i < sortMatrix.length; i++) {
            for (int j = 0; j < sortMatrix[i].length; j++) {
                for (int k = 0; k < sortMatrix.length; k++) {
                    for (int l = 0; l < sortMatrix[k].length; l++) {
                        if (sortMatrix[i][j] <= sortMatrix[k][l]) {
                            swap = sortMatrix[i][j];
                            sortMatrix[i][j] = sortMatrix[k][l];
                            sortMatrix[k][l] = swap;
                        }
                    }
                }
            }
        }
    }

    public static void main(String args[]) {
        int[] sortArr = {12, 6, 4, 1, 15, 10};
        bubbleSort(sortArr);
        for (int j : sortArr) {
            System.out.print(j + "\n");
        }
        int[][] sortMatrix = new int[][]{
                {8, 3, 5},
                {1, 4, 6},
                {9, 7, 2}
        };
        matrixBubbleSort(sortMatrix);

        //Вывод отсортированного двумерного массива:
        for (int i = 0; i < sortMatrix.length; i++) {
            for (int j = 0; j < sortMatrix[i].length; j++) {
                System.out.print(sortMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
