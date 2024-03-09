import java.util.Arrays;

public class Swap {
    public static void main(String[] args) {
        int[] arr = { 1, 4, 2, 6 };
        swap(arr, 2, 3);
        System.out.println(Arrays.toString(arr));
    }

    static void swap(int[] arr, int index1, int index2) {
        System.out.println(arr.length);
        if (index1 >= arr.length || index2 >= arr.length) {
            System.out.println("invalid index input");
            return;
        }
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
