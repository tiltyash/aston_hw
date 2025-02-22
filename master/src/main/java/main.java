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
        fillArray();
        doubleNumberLessSix(new int[] {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1});
        makeDiagonalWith1(new int[10][10]);
        makeAndFillArray(3, 1);
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

    public static void fillArray(){
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++){
            arr[i] = i + 1;
        }
        //for (int i : arr) {
            //System.out.print(i + " ");
        //}
    }

    public static void doubleNumberLessSix(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] < 6) ? arr[i]*2 : arr[i];
        }
        //for (int i : arr) {
            //System.out.print(i + " ");
        //}
    }

    public static void makeDiagonalWith1(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++){
                arr[i][j] = (i == j || i + j == arr.length - 1) ? 1 : 0;
            }
                }
//       for (int i = 0; i < arr.length; i++) {
//           for (int j = 0; j < arr.length; j++){
//               arr[i][j] = (i + j == 9) ? 1 : 0;
//            }
//        }
//
//            for (int i = 0; i < arr.length; i++) {
//                for (int j = 0; j < arr[i].length; j++) {
//                    System.out.print(arr[i][j] + "\t");
//                }
//                System.out.println();
//            }
    }

    public static void makeAndFillArray(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
            //System.out.print(arr[i] + " ");
        }
    }
}
