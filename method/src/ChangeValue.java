import java.util.Arrays;

public class ChangeValue {
    public static void main(String[] args) {
        // create an array
        int[] arr = { 1, 2, 3 };
        change(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * not pass by reference in,
     * passed by the copy of the value of the reference
     */
    static void change(int[] arr) {
        arr[1] = 99;
    }
}
