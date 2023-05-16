

public class Factorial {
    public static void main(String[] args) {
        int n = 5;
        int factorial = 1;
        //Factorial=5!=1*2*3*4*5
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        System.out.print(factorial);
    }
    static int factorial(int number){
        int factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }
}

