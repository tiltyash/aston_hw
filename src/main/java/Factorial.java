public class Factorial {
    public static long findFactorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Факториал не может быть отрицательным");
        }

        long factorial = 1;

        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
