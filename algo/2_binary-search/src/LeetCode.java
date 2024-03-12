
public class LeetCode {
    public static void main(String[] args) {
        // char[] letters = { 'c', 'f', 'j' };
        // char target = 'c';
        // System.out.println(nextGreatestLetter(letters, target));

        // int[] arr = { 1, 4 };
        // int target = 8;
        // int[] arr = { -1, 1, 0, -3, 3 };
        // System.out.println(Arrays.toString(searchRange(arr, target)));
        // System.out.println(findFirstOccurence(arr, target));
        // System.out.println(findLastOccurence(arr, target));
        // int[] arr = { 40, 48, 61, 99, 100, 98, 39, 30, 21, 10 };
        // System.out.println(peakIndexInMountainArray(arr));
        int[] arr = { 1, 4, 4 };
        int k = 3;
        System.out.println("minimized largest sum: " + splitArray(arr, k));
    }

    // LC-410 : split array largest sum
    static int splitArray(int[] nums, int k) {
        /**
         * min number of partition we can make = 1;
         * in this case; minimised largest sum = sum of all the elements of the array
         * This is the max possible answer.
         * 
         * max number of partition we can make = nums.length;
         * in this case: minimised largest sum = max element in the array
         * This is the min possible answer.
         */

        // find out the max[right] and min[min] possible answers
        int left = 0;
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            right += nums[i];
            if (nums[i] > left) {
                left = nums[i];
            }
        }

        // in this case k =1, we don't ave to split
        // so return the sum of all elements of array.
        if (k == 1) {
            return right;
        }
        /**
         * int[] arr = { 7, 2, 5, 10, 8 };
         * 
         * irrespective of k
         * min = 10; for k = no. of element
         * max = 32; for k = 1
         * 
         * minimised largest sum will be between 10 and 32
         * 
         * binary search between this two endpoints
         * 
         * if(pieces < k) -> maxPossible should be less
         * if(pieces > k) -> maxPossible should be more
         */

        System.out.println("min: " + left + " max: " + right);
        // 7, 2, 5, 10, 8
        // binary search
        while (left < right) {
            int mid = left + (right - left) / 2;
            // mid = possible max sum

            // calculate how many pieces we can divide this in with this max sum
            int pieces = 1;
            int currentSum = 0;

            for (int i = 0; i < nums.length; i++) {
                if (currentSum + nums[i] > mid) {
                    // you cannot add this n this sub array, make new one
                    currentSum = nums[i];
                    pieces++;
                } else {
                    currentSum += nums[i];
                }
            }
            if (pieces == k) {
                right = mid;
                // could be the answer
            } else if (pieces < k) {
                // maxPossible should be lower
                right = mid - 1;
            } else {
                // maxPossble should be higher
                left = mid + 1;
            }
            // if (pieces <= k) {
            // // maxPossible should be lower
            // right = mid;
            // } else {
            // // maxPossble should be higher
            // left = mid + 1;
            // }
        }

        return right;
    }

    // lC-81 : search in rotated non-decreasing array
    static boolean search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            // corner case
            if (nums[left] == nums[right]) {
                if (nums[left] == target) {
                    return true; // If nums[left] is equal to target, return true
                }
                left++;
                right--;
                continue;
            }

            if (nums[mid] <= nums[right]) {
                // right side of mid is sorted
                if (target > nums[mid] && target <= nums[right]) {
                    // target is on sorted(right) side
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }

            } else {
                // left side if mid is sorted
                if (target < nums[mid] && target >= nums[left]) {
                    // target is on sorted(left) side
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            }

        }
        return false;
    }

    // lC-33 : search in rotated sorted(ascending) array
    static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        // int last = nums[nums.length - 1];

        /* --------------------- LC loop -------------------- */
        /**
         * BASED ON:
         * - finding which side of mid is the sorted array
         */
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {
                // left side of mid is sorted
                if (target < nums[mid] && target >= nums[left]) {
                    // means target is on the left-side sorted array.
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // right side of the mid is sorted
                if (target > nums[mid] && target <= nums[right]) {
                    // means target is on the right-side sorted array.
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        /* --------------------------- my loop optimizzed --------------------------- */
        /**
         * based on :
         * - there are two ascending arrays
         * - find which ascending array is
         * 1. nums[mid]
         * 2. target
         */
        // int last = nums[nums.length - 1];

        // while (left <= right) {
        // int mid = left + (right - left) / 2;

        // if (nums[mid] == target) {
        // return mid;
        // } else if (nums[mid] > last) {
        // // we are on first ascend

        // if (target > last && nums[mid] > target) {
        // // if target is on first ascend and target less than mid
        // right = mid - 1;
        // } else {
        // left = mid + 1;
        // }
        // } else {
        // // we are on second ascend

        // if (target <= last && target > nums[mid]) {
        // // if target is on second ascend && target > mid; left=left
        // left = mid + 1;
        // } else {
        // right = mid - 1;
        // }

        // }
        // }
        /* --------------------------- my loop --------------------------- */
        /**
         * based on :
         * - there are two ascending arrays
         * - find which ascending array is
         * 1. nums[mid]
         * 2. target
         */
        // int last = nums[nums.length - 1];

        // while (left <= right) {
        // int mid = left + (right - left) / 2;

        // if (nums[mid] == target) {
        // return mid;
        // } else if (nums[mid] > last) {
        // // we are on first ascend
        // if (target > last) {
        // // target is on first ascend
        // if (nums[mid] > target) {
        // right = mid - 1;
        // } else {
        // left = mid + 1;
        // }
        // } else {
        // // target is on second ascend
        // left = mid + 1;
        // }
        // } else {
        // // we are on second ascend
        // if (target > last) {
        // // target is on first ascend
        // right = mid - 1;
        // } else {
        // // target is on second ascend
        // if (nums[mid] > target) {
        // right = mid - 1;
        // } else {
        // left = mid + 1;
        // }
        // }

        // }
        // }

        return -1;
    }

    // LC-1095
    static int findInMountainArray(int target, int[] mountainArr) {

        // int peakIndex = peakIndexInMountainArray(mountainArr);
        // find the peak element
        int peakIndex = 0;
        int left = 0;
        int right = mountainArr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr[mid] < mountainArr[mid + 1]) {
                // ascending slope
                left = mid + 1;
            } else {
                // descending slope
                right = mid;
            }
        }
        peakIndex = left;

        // find the target in ascending slope
        left = 0;
        right = peakIndex;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mountainArr[mid] == target) {
                return mid;
            } else if (mountainArr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // if not found in ascending slope
        // find the target in descending slope
        left = peakIndex;
        right = mountainArr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mountainArr[mid] == target) {
                return mid;
            } else if (mountainArr[mid] < target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    // LC-162
    static int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // I am taking right side of the slope
            // you can take left side too; then you have to check for arr[mid-1]
            if (nums[mid] > nums[mid + 1]) {
                // descending part of the mountain
                right = mid - 1;
            } else {
                // ascending part of the mountain
                left = mid + 1;
            }

        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            // I am taking right side of the slope
            // you can take left side too; then you have to check for arr[mid-1]
            if (nums[mid] > nums[mid + 1]) {// descending part of the mountain
                // this may be the potential answer
                // but look at left
                // this is why right !=mid -1;
                right = mid; // potential peak
            } else {
                // ascending part of the mountain
                left = mid + 1;
            }

        }
        return left;
    }

    // LC-852
    // * given there are no repeating elements like this:

    // int[] arr = { 40, 48, 61, 99, 99, 99, 99, 100, 98, 39, 30, 10 };
    // int[] arr = { 40, 48, 61, 99, 100, 98, 39, 30, 21, 10 };

    // */
    public static int peakIndexInMountainArray(int[] arr) {
        System.out.println("peakIndexInMountainArray called");
        int left = 0;
        int right = arr.length - 1;
        /**
         * can do either one or two
         * one: loop break when left>right;
         * two: loop breaks when left=right;
         */

        // one : just like a normal binary search
        /**
         * on last loop
         * left and right will be pointing to the same element
         * so after the last loop
         * if(element> next element){index will be previous left}
         * else { index will be previous left + 1 }
         */
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // I am taking right side of the slope
            // you can take left side too; then you have to check for arr[mid-1]
            if (arr[mid] > arr[mid + 1]) {
                // descending part of the mountain
                right = mid - 1;
            } else {
                // ascending part of the mountain
                left = mid + 1;
            }

        }

        // two : using potential peak element.
        /**
         * since loop breaks at left=right
         * both will point to potential peak element.
         */
        while (left < right) {
            int mid = left + (right - left) / 2;
            // I am taking right side of the slope
            // you can take left side too; then you have to check for arr[mid-1]
            if (arr[mid] > arr[mid + 1]) {
                // descending part of the mountain
                right = mid;
                // since it is a potential peak
                // we are keeping the current mid in the search range
                // hence we are not doing this: right = mid - 1;
            } else {
                // ascending part of the mountain
                left = mid + 1;
            }

        }
        return left;
    }

    // LC-34
    static int[] searchRange(int[] nums, int target) {
        /* ---------------------------- binary --------------------------- */
        int left = 0;
        int right = nums.length - 1;
        int[] arr = new int[] { -1, -1 };

        // first index
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                arr[0] = mid;
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        // run the find last index loop only if first index is found
        // otherwise it means that the target is not in the array.
        if (arr[0] != -1) {

            left = 0;
            right = nums.length - 1;
            // last index
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {

                    arr[1] = mid;
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            }
        }
        return arr;

        /* ---------------------- 2 pointer approach --------------------- */

        /* ----------------------- linear : 2 scan approach ---------------------- */
        // int start = -1;
        // int end = -1;
        // for (int i = 0; i < nums.length; i++) {
        // if (nums[i] == target) {
        // start = i;
        // break;
        // }
        // }

        // for (int i = nums.length - 1; i >= 0; i--) {
        // if (nums[i] == target) {
        // end = i;
        // break;
        // }
        // }

        // int[] range = { start, end };
        // return range;
        /* ---------------------------- linear --------------------------- */
        // int start = -1;
        // int end = -1;
        // for (int i = 0; i < nums.length; i++) {
        // if (nums[i] == target) {
        // if (start == -1) {
        // start = i;
        // }
        // end = i;
        // }

        // }

        // // int[] arr = { start, end };

        // return new int[] { start, end };

    }

    static int findFirstOccurence(int[] nums, int target) {
        int index = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // System.out.println("mid" + mid);
                // if (mid == 0 || nums[mid - 1] != target) {
                // index = mid;
                // break;
                // } else {
                // right = mid - 1;
                // }
                // * we will set index till we get to the left most target */
                index = mid;
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index;
    }

    static int findLastOccurence(int[] nums, int target) {
        int index = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                if (mid == nums.length - 1 || nums[mid + 1] != target) {
                    index = mid;
                    break;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index;
    }

    // LC-744
    static char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;

        /** letters wrap around */
        // if (target >= letters[letters.length - 1]) {
        // return letters[0];
        // }

        while (left <= right) {
            // int mid = (left + right) / 2;
            int mid = left + (right - left) / 2;

            if (target >= letters[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // on while loop break
        // right will become left
        // hence left is the answer
        int modulo = left % letters.length;
        System.out.println("left" + left);
        System.out.println("modulo" + modulo);
        return letters[modulo];
        // return letters[left];

    }
}
