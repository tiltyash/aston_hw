public class switchArray {
    public static void switchArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] == 0) ? 1 : 0;
        }
        //for (int i : arr) {
        //System.out.print(i + " ");
        //}
    }
}
