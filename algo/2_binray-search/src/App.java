public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        int[] arrAsc = { -12, -9, 0, 0, 22, 26, 44, 61, 69, 75 };
        int[] arrDesc = { 99, 82, 50, 41, 40, 31, 30, 26, 9, -12, -34, -99 };
        int target = 26;
        System.out.println(binarySearchAsc(arrAsc, target));
        // System.out.println(binarySearchOrderAgnostic(arrDesc, target));
        // System.out.println(binarySearchOrderAgnostic(arrAsc, target));
    }

    static int binarySearchAsc(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            // int mid = (int) Math.floor((left + right) / 2);

            // might be possible that for very large numbers
            // left+right might exceed the capacity of int

            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            /* ------------------------- corner case ------------------------- */
            if (arr[left] == target) {
                return left;
            }
            if (arr[right] == target) {
                return right;
            }
            /* --------------------------------------------------------------- */
            if (arr[mid] > target) {
                right = mid - 1;
            } else { // arr[mid] < target
                left = mid + 1;
            }
        }
        return -1;
    }

    // binary search for when we don't know if the array is sorted ascendingly or
    // descendingly
    static int binarySearchOrderAgnostic(int[] arr, int target) {
        boolean isAsc = isAsc(arr);
        System.out.println(isAsc);
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            // // int mid = left + ((left + right) / 2);

            int mid = (int) Math.floor(left + (right - left) / 2);
            if (arr[mid] == target) {
                return mid;
            }

            /* ------------------------- corner case ------------------------- */
            if (arr[left] == target) {
                return left;
            }
            if (arr[right] == target) {
                return right;
            }
            /* --------------------------------------------------------------- */

            if (isAsc) {
                if (arr[mid] < target) {
                    left = mid + 1;
                } else { // arr[mid] > target
                    right = mid - 1;
                }
            } else {
                if (arr[mid] < target) {
                    right = mid - 1;
                } else { // arr[mid] > target
                    left = mid + 1;
                }
            }

        }

        return -1;
    }

    static boolean isAsc(int[] arr) {
        if (arr[0] < arr[arr.length - 1]) {
            return true;
        }
        return false;
    }

}
