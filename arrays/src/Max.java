public class Max {
    public static void main(String[] args) {
        // int[] arr = { 0, 0, 0 };
        int[] arr = { 1, 3, 23, 9, 18 };
        int max = max(arr);
        int maxRange = maxRange(arr, 3, 2);
        System.out.println("max: " + max);
        System.out.println("max-range: " + maxRange);
    }

    private static int max(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    private static int maxRange(int[] arr, int startIndex, int endIndex) {
        if (endIndex < startIndex) {
            System.out.println("endIndex should be greater than startIndex!");
            return -1;
        }
        int max = arr[startIndex];
        for (int i = startIndex; i <= endIndex; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
