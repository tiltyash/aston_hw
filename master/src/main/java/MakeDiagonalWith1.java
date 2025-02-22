public class MakeDiagonalWith1 {
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
}
