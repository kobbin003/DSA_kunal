import java.util.Arrays;

public class MultiDimensianalArray {
    public static void main(String[] args) {
        int[][] arr = new int[3][];

        int[][] arr2 = { { 1, 2 }, { 3, 4, 5 } };
        // [row][column]
        // specifying column not necessary.

        // System.out.println(Arrays.toString(arr2));
        // System.out.println(Arrays.toString(arr));

        //
        loopArray(arr2);
    }

    static void loopArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            int[] row = arr[i];
            System.out.println(Arrays.toString((row)));

            for (int j = 0; j < row.length; j++) {
                int el = row[j];
                System.out.println(el);
            }
        }
    }
}
