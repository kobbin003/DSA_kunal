public class Kunal {
    public static void main(String[] args) {
        int[] arr = {};
        int target = 14;// ceiling: 14; floor: 11;
        // System.out.println("ceiling: " + ceilingNumber(arr, target));
        // System.out.println("floor: " + floorNumber(arr, target));
        System.out.println("position-infinite: " + rotationCount(arr));
    }

    // find rotation count in rotated sorted array
    static int rotationCount(int[] arr) {

        return -1;
    }

    // find position of an element in a sorted array of infinite numbers:
    static int positionInfinite(int[] arr, int target) {
        // keep on increasing the target
        int left = 0;
        int right = 1;

        while (arr[right] < target) {
            int temp = right + 1;
            // since the target is not within current left and right
            // shift the left to next right.
            // left = right + 1;

            // right *= 2;// double the range, if target not found
            // * right = previous right + (size-of-box * 2) */
            right = right + (right - left + 1) * 2;
            // we are adding 1
            // because when we find length using indexes
            // we have to add 1 to the difference.
            /**
             * e.g: arr = {1,5,6,7,10}
             * find the length of 5-7
             * index of 5 = 1
             * index of 7 = 3
             * difference = 3-1 = 2
             * Therefore, length = 2+1 = 3
             */
            left = temp;
        }

        // perform binary search within the range
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    // ceiling:
    // the smallest number in a given array that is
    // GREATER THEN OR EQUAL to the target element.
    static int ceilingNumber(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        /**
         * edge case:
         * if target is greater than the greatest number in the array
         */
        if (target > arr[arr.length - 1]) {
            return -1;
        }

        while (left <= right) {
            int center = (left + right) / 2;
            if (arr[center] == target) {
                return center;
            }
            if (arr[center] > target) {
                right = center - 1;
            } else {
                left = center + 1;
            }
        }

        // when while loop breaks, right & left will be interchanged.
        // Therefore, left will be the answer.
        return left;
        // step 1: find all the number greater than target.
    }

    static int floorNumber(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        /**
         * edge case:
         * if target is smaller than the smallest number in the array
         */
        if (target < arr[0]) {
            return -1;
        }

        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == arr[mid]) {
                return mid;
            }
            if (target > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // after the while loop is broken,
        // left & right will get interchanged,
        // Therefore, right will be the floor
        return right;
    }
}
