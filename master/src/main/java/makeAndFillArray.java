public class makeAndFillArray {
    public static void makeAndFillArray(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
            //System.out.print(arr[i] + " ");
        }
    }
}
