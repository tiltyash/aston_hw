public class CheckSumSign {
    public static void checkSumSign() {
        int a = 123, b = -123;

        if (a + b >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }
}
