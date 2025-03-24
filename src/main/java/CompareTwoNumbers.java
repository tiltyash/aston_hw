public class CompareTwoNumbers {
    public static String compare(int a, int b) {
        return a > b ? a + " больше чем " + b :
               a < b ? a + " меньше чем " + b :
               a + " равно " + b;
    }
}
