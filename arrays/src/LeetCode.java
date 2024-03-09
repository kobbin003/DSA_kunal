import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode {
    public static void main(String[] args) {
        // int[] arr = { 580, -0317, -98 };
        // int res = findNumber(arr);
        // int[] nums = { 1, 2, 3, 4, 0 };
        // int[] index = { 0, 1, 2, 3, 0 };
        // int[] target = createTargetArray(nums, index);
        // System.out.println(Arrays.toString(target));
        // int[] gain = { -4, -3, -2, -1, 4, 3, 2 };
        // int[] gain = { -5, 1, 5, 0, -7 };
        // int alt = largestAltitude(gain);
        // System.out.println(alt);

        // int[][] mat = { { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1
        // } };
        // // int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        // int sum = diagonalSum(mat);
        // System.out.println(sum);

        // int[] num = { 9, 9, 9, 9, 9, 9, 9, 9, 9, 9 };
        // System.out.println(arrayToNumber(num));
        int k = 993;
        int[] num = { 7 };
        System.out.println(addToArrayForm(num, k));
        // int[] nums = { 3, 2, 4 };
        // System.out.println(Arrays.toString(twoSum(nums, 6)));
    }

    // 1
    static int[] twoSum(int[] nums, int target) {
        int[] indexes = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - a) {
                    indexes[0] = i;
                    indexes[1] = j;
                }
            }
        }

        return indexes;
    }

    // 989:
    static public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<Integer>();
        int carry = 0;
        for (int i = num.length - 1; i >= 0; i--) {
            int rightmostOfK = 0;
            if (k > 0) {
                rightmostOfK = k % 10;
                k = k / 10;
            }
            int sum = (num[i] + rightmostOfK + carry);
            int digit = sum % 10;

            carry = sum / 10;

            result.add(0, digit);
        }
        if (k > 0) {
            while (k > 0) {
                int rem = k % 10;
                if (carry > 0) {
                    // TODO
                    /**
                     * some problem is here
                     * 
                     */
                    rem = (rem + carry) % 10;
                    carry = rem / 10;
                }
                result.add(0, rem);
                k = k / 10;
            }
        } else {
            if (carry > 0) {
                result.add(0, carry);
            }
        }
        return result;
    }

    static BigInteger arrayToNumber(int[] arr) {
        BigInteger sum = BigInteger.ZERO;
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                sum = sum.add(BigInteger.valueOf(arr[i]));
                // sum = sum + num[i];
            } else {
                // sum = (sum + num[i]) * 10;
                sum = sum.add(BigInteger.valueOf(arr[i])).multiply(BigInteger.TEN);
            }
        }
        return sum;
    }
    // static long arrayToNumber(int[] arr) {
    // long sum = 0;
    // for (int i = 0; i < arr.length; i++) {
    // if (i == arr.length - 1) {
    // sum = sum + arr[i];
    // } else {

    // sum = (sum + arr[i]) * 10;
    // // sum = (arr[i] * 10) + sum;
    // }
    // }
    // return sum;
    // }

    // 989
    // * using BigInteger -first attempt version*/
    // static List<Integer> addToArrayForm(int[] num, int k) {
    // List<Integer> list = new ArrayList<Integer>();
    // BigInteger sum = BigInteger.ZERO;
    // for (int i = 0; i < num.length; i++) {
    // if (i == num.length - 1) {
    // sum = sum.add(BigInteger.valueOf(num[i]));
    // } else {
    // sum = sum.add(BigInteger.valueOf(num[i])).multiply(BigInteger.TEN);

    // }
    // }
    // sum = sum.add(BigInteger.valueOf(k));

    // while (sum.compareTo(BigInteger.ZERO) > 0) {
    // BigInteger rem = sum.remainder(BigInteger.TEN);
    // list.add(0, rem.intValue());// since arraylist shifts number to right on
    // sum = sum.divide(BigInteger.valueOf(10));
    // }
    // return list;
    // }
    // * initial attempt */
    // static List<Integer> addToArrayForm(int[] num, int k) {
    // List<Integer> list = new ArrayList<Integer>();
    // long sum = 0;
    // for (int i = 0; i < num.length; i++) {
    // // * checkout the arrayToNumber method: this is done without using Math.pow
    // long thisnum = (long) (num[i] * Math.pow(10, num.length - 1 - i));
    // sum += thisnum;
    // }
    // sum += k;
    // System.out.println(sum);
    // while (sum > 0) {
    // long rem = sum % 10;
    // list.add(0, (int) rem);
    // // since arraylist shifts number to right on adding
    // // into an index
    // sum = sum / 10;
    // }
    // return list;
    // }

    // 1572
    static int diagonalSum(int[][] mat) {

        int sum = 0;

        for (int i = 0; i < mat.length; i++) {
            int[] col = mat[i];
            // two ends to sum on each row is i & lastindex-i;
            int index1 = i;
            int index2 = col.length - 1 - i;
            System.out.println("a: " + col[index1] + "b: " + col[index2]);
            if (index1 != index2) {
                sum += col[index1] + col[index2];
            } else {
                // if index1 == index2, then it means it is the center.
                sum += col[index1];
            }
        }
        return sum;
    }

    // 1732
    static int largestAltitude(int[] gain) {

        int prevAlt = 0;
        int highestAlt = 0;
        for (int i = 0; i < gain.length; i++) {
            // int altitude = gain[i] + prev;
            int altitude = prevAlt + gain[i];
            if (altitude > highestAlt) {
                highestAlt = altitude;
            }
            prevAlt = altitude;
        }
        return highestAlt;
    }

    static int[] createTargetArray(int[] nums, int[] index) {
        ArrayList<Integer> targetList = new ArrayList<Integer>();
        int[] target = new int[index.length];
        for (int i = 0; i < nums.length; i++) {
            // target[index[i]] = nums[i];
            targetList.add(index[i], nums[i]);
        }
        for (int i = 0; i < target.length; i++) {
            target[i] = targetList.get(i);
        }

        return target;
    }

    static int findNumber(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int digits = 0;
            int num = nums[i];
            if (num < 0) {
                num = num * -1;
            }
            while (num > 0) {
                num = num / 10;
                digits++;
            }
            if (digits % 2 == 0) {
                count++;
            }
        }
        return count;
    }
}
