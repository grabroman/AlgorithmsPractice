import java.util.Arrays;

public class RandomNumbers {
    public static void main(String[] args) {
        int[] numbers = new int[10];
        //Random numbers from 0-> 100
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 100);
        }
        System.out.println(Arrays.toString(numbers));

        //Random numbers from 20-> 100
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 100 / 20);
        }
        //Without Arrays.toString we receive array name
        System.out.println(Arrays.toString(numbers));
        //Out by foreach
        for (int num : numbers) {
            System.out.println(num);
        }
    }

    static int[] randomNumbers(int size, int min, int max) throws Exception {
        try {
            if (0 == size) {
                throw new ArrayIndexOutOfBoundsException("size is null");
            }
            if (0 == min) {
                min = 1;
            }
            if (0 == max) {
                throw new ArrayIndexOutOfBoundsException("max is null");
            }

            int[] numbers = new int[size];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = (int) (Math.random() * max / min);
            }

            return numbers;
        } catch (Exception e) {
            throw new ArithmeticException(e.toString());
        }
    }
}
