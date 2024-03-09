import java.util.Arrays;

public class LCMedium {
    public static void main(String[] args) {
        // int[] arr = { 5, 7, 7, 8, 8, 10 };
        int target = 3;
        // int[] arr = { -1, 1, 0, -3, 3 };
        // int[] arr = { 3, 0, 8, 2, 0, 0, 1 };
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        // 5, 6, 7, 1, 2, 3, 4
        rotate(arr, target);
        // reverseArray(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void reverseArray(int[] nums, int start, int end) {
        System.out.println("reverse called");
        /* ------------------------ using for loop ----------------------- */
        if (start > end)
            return;

        int half = start + (end - start) / 2;

        // works for even, make it work for odd too.
        for (int i = start; i <= half; i++) {
            int temp = nums[i];
            nums[i] = nums[end - i + start];
            nums[end - i + start] = temp;
        }

        /* ----------------------- using while loop ---------------------- */
        int left = start;
        int right = end;
        while (left <= right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    /**
     * 1234 567
     * 4321 765
     * 4321765
     * 5671234
     */
    // LC-189: rotate array
    static private void rotate(int[] nums, int k) {

        /* ------------------ Solution 2 : using reverse ----------------- */
        // k may be greater than nums length
        k = k % nums.length;
        // rotate 0 to lastIndex-k
        reverseArray(nums, 0, nums.length - 1 - k);
        // System.out.println("fore-reverse: " + Arrays.toString(nums));

        /**
         * if k=0;
         * while reversing the second half
         * start > end;
         * hence while loop is better
         */
        // rotate lastIndex-k to lastIndex
        reverseArray(nums, nums.length - 1 - k + 1, nums.length - 1);
        // System.out.println("back-reverse: " + Arrays.toString(nums));

        // rotate the whole
        reverseArray(nums, 0, nums.length - 1);
        // System.out.println("whole-reverse: " + Arrays.toString(nums));

        /* --------------- Solution 1: using an extra array -------------- */
        // int[] arr = new int[nums.length];
        // for (int i = 0; i < nums.length; i++) {
        // int exchangeIndex = i - k < 0 ? nums.length - k + i : i - k;

        // arr[i] = nums[exchangeIndex];
        // }

        // nums = arr;
        // System.out.println(Arrays.toString(nums));
    }

    // lC-55 : Jump Game
    static boolean canJump(int[] nums) {

        /* ------------------- solution 1 : destination ------------------ */

        int destination = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= destination) {
                destination = i;
            }
        }
        return destination == 0;

        /* ---------------------- solution: 2: macJumped --------------------- */
        // int maxJumped = 0;
        // for (int i = 0; i < nums.length; i++) {
        // if (i > maxJumped) {
        // /*
        // * we will loop through nums and find "jumped" index
        // * if i > "jumped"-index then it means it is stuck
        // * for e.g
        // * int nums = {0, 2, 1}
        // * at i=0; jumped-index = 0
        // * at i=1; i > jumped-index, so return false
        // */
        // return false;
        // }
        // int currentJump = i + nums[i];
        // // return true if jump reaches the end or crosses it.
        // // no need to iterate further.
        // if (currentJump >= nums.length - 1) {
        // return true;
        // }
        // // maxJumped = Math.max(maxJumped, currentJump);
        // if (maxJumped < currentJump) {
        // maxJumped = currentJump;
        // }

        // }
        // return true;

    }

    // LC-238
    static int[] productExceptSelf(int[] nums) {
        int[] newNums = new int[nums.length];

        /** suffix product */

        // int[] suffix = new int[nums.length];
        // int multiply = 1;
        // for (int i = nums.length - 1; i >= 0; i--) {
        // /** suffix excluding current element */
        // // newNums[i] = multiply;
        // // multiply *= nums[i];

        // /** suffix */
        // suffix[i] = nums[i] * multiply;
        // multiply = suffix[i];
        // }
        // return suffix;

        /** prefix */

        int[] prefix = new int[nums.length];
        int multiply = 1;
        for (int i = 0; i < nums.length; i++) {
            /** prefix */
            // prefix[i] = nums[i] * multiply;
            // multiply = prefix[i];

            /** prefix excluding current element */
            prefix[i] = multiply;
            multiply *= nums[i];
        }
        return prefix;

        /* --------------- solution 1 : brute force method --------------- */

        // for (int i = 0; i < nums.length; i++) {
        // int multiply = 1;
        // for (int j = 0; j < nums.length; j++) {
        // if (j != i) {
        // System.out.println("i:" + i + "J:" + j);
        // multiply = multiply * nums[j];
        // }
        // }
        // newNums[i] = multiply;
        // }

        /* ------------ solution 2 : issue if any element is 0 ----------- */

        // int multiply = nums[0];
        // for (int i = 1; i < nums.length; i++) {
        // multiply *= nums[i];
        // }

        // for (int j = 0; j < nums.length; j++) {
        // newNums[j] = multiply / nums[j];
        // }

        /* ------------- Solution 3-a : using prefix and suffix ------------ */
        // int[] pre = new int[nums.length];
        // pre[0] = nums[0];
        // int[] suf = new int[nums.length];
        // suf[nums.length - 1] = nums[nums.length - 1];

        // for (int i = 1; i < nums.length; i++) {
        // pre[i] = nums[i] * pre[i - 1];
        // }

        // for (int i = nums.length - 2; i >= 0; i--) {
        // suf[i] = nums[i] * suf[i + 1];
        // }

        // for (int i = 0; i < nums.length; i++) {
        // if (i - 1 < 0) {
        // newNums[i] = suf[i + 1];
        // } else if (i + 1 > nums.length - 1) {

        // newNums[i] = pre[i - 1];
        // } else {

        // newNums[i] = pre[i - 1] * suf[i + 1];
        // }
        // }

        // return newNums;

        /* --- Solution 3-b using prefix-suffix minus the current element -- */

        // int[] pre = new int[nums.length];
        // pre[0] = 1;
        // int[] suf = new int[nums.length];
        // suf[nums.length - 1] = 1;

        // for (int i = 1; i < nums.length; i++) {
        // pre[i] = nums[i - 1] * pre[i - 1];
        // }

        // for (int i = nums.length - 2; i >= 0; i--) {
        // suf[i] = nums[i + 1] * suf[i + 1];
        // }

        // for (int i = 0; i < nums.length; i++) {

        // newNums[i] = pre[i] * suf[i];
        // }

        // return newNums;

        /* ------------- Solution 4: using prefix and suffix ------------- */
        /** BUT without suf and pre array */

        // int n = nums.length;
        // int ans[] = new int[n];
        // int multiply = 1;
        // for (int i = 0; i < n; i++) {
        // ans[i] = multiply;
        // multiply *= nums[i];
        // }

        // multiply = 1;
        // for (int i = n - 1; i >= 0; i--) {
        // ans[i] *= multiply;
        // multiply *= nums[i];
        // }

        // return ans;
    }
}
