public class doubleNumberLessSix {
    public static void doubleNumberLessSix(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] < 6) ? arr[i]*2 : arr[i];
        }
        //for (int i : arr) {
        //System.out.print(i + " ");
        //}
    }
}
