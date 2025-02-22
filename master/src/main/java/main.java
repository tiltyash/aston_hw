public class main {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        checkSumIsBetweenTenAndTwenty(10, 10);
        checkNumberSign(0);
        isNumberNegative(0);
        printStringMultipleTimes("Test", 3);
        isLeapYear(2024);
        switchArray(new int[] {1, 1, 0, 0, 1, 0, 1, 1, 0, 0});

    }

    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana ");
        System.out.println("Apple");
    }

    public static void checkSumSign() {
        int a = 123, b = -123;

        if (a + b >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor() {
        int value = 255;

        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 100) {
                System.out.println("Зеленый");
            } else {
                System.out.println("Желтый");
            }
    }

    public static void compareNumbers() {
        int a = 10, b = 11;

        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static boolean checkSumIsBetweenTenAndTwenty(int a, int b) {
        return ((a + b >= 10) && (a + b <= 20));
    }

    public static void checkNumberSign(int number) {
        if (number >= 0) {
            System.out.println("Передали положительное число");
        } else {
            System.out.println("Передали отрицательное число");
        }
    }

    public static boolean isNumberNegative(int number) {
        return number < 0;
    }

    public static void printStringMultipleTimes(String string, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(string);
        }
    }

    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ;
    }

    public static void switchArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
           arr[i] = (arr[i] == 0) ? 1 : 0;
        }
        //for (int i : arr) {
            //System.out.print(i + " ");
        //}
    }
}
