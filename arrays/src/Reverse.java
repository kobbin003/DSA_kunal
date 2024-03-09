import java.util.Arrays;

public class Reverse {
    public static void main(String[] args) {
        int[] arr = { 2, 6, 3, 19 };
        reverse(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void reverse(int[] arr) {
        // my-implementation
        // for (int i = 0; i < arr.length; i++) {
        // if (i == arr.length - 1 - i || i > arr.length - 1 - i) {
        // continue;
        // }
        // // swapping the first and the last value.
        // int index1 = i;
        // int index2 = arr.length - 1 - i;
        // int temp = arr[index1];
        // arr[i] = arr[index2];
        // arr[index2] = temp;
        // ;

        // }

        // kunal's implementation:
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            // swap(arr, start, end);
            System.out.println(start + ":" + end);
            start++;
            end--;
        }
    }

    private static void swap(int[] arr, int index1, int index2) {
        // System.out.println(arr.length);
        if (index1 >= arr.length || index2 >= arr.length) {
            System.out.println("invalid index input");
            return;
        }
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
