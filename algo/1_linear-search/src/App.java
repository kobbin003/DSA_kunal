import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        // int[][] mat = { { 1, 10, 4, 2 }, { 9, 3, 8, 7 }, { 15, 16, 17, 12 } };
        // System.out.println(luckyNumbers(mat));
        // int[][] mat = { { 1, 2 }, { 3, 4 } };
        // int[][] forMat = matrixReshape(mat, 1, 4);

        // // System.out.println();
        // for (int i = 0; i < forMat.length; i++) {
        // System.out.println(Arrays.toString(forMat[i]));
        // // for (int j = 0; j < forMat[i].length; j++) {
        // // System.out.println(Arrays.toString(forMat[i]));
        // // }
        // }

        // int[] position = { 2, 2, 2, 3, 3 };
        // int[] position = { 1, 2, 3 };
        // System.out.println(maxCountInArray(position));
        int[] position = { 1, 1000000000 };
        System.out.println(minCostToMoveChips(position));

    }

    // LC-1217
    // TODO
    static int minCostToMoveChips(int[] position) {
        int even = 0;
        // int odd = 0;
        for (int index : position) {
            if (index % 2 == 0) {
                even++;
            }
            // else{
            // odd++;
            // }
        }
        // if odd has minimum, then cost =total-odd
        // even hass minimum,
        int total = position.length;
        // int cost = even > odd ? total - even : total - odd;
        // int cost = even > odd ? odd : even;

        return Math.min(even, total - even);

    }

    static int maxCountInArray(int[] position) {
        int prev = position[0];
        int count = position.length > 0 ? 1 : 0;
        int maxCount = 1;
        // max count
        // find all the unique numbers
        for (int i = 1; i < position.length; i++) {
            if (position[i] != prev) {
                prev = position[i];
                if (count > maxCount) {
                    maxCount = count;
                }
                count = 1;

            } else {
                count++;
            }
        }
        return count;
    }

    // lC-66
    static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;

        return digits;
    }

    /** This one will be suitable for adding other than 1 */
    static int[] plusOne1(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            System.out.println("sum:" + sum);
            if (sum >= 10) {
                carry = sum / 10;
                int rem = sum % 10;
                digits[i] = rem;
            } else {
                carry = 0;
                digits[i] = sum;
            }
        }
        if (carry > 0) {
            System.out.println("carry:" + carry);
            int[] newArr = new int[digits.length + 1];
            newArr[0] = carry;

            return newArr;
        }
        return digits;
    }

    // LC-566
    // constraints: r >= 1; c <=300;
    static int[][] matrixReshape(int[][] mat, int r, int c) {
        // mat's n * m should be equal to r * c
        int row = mat.length;
        int col = mat[0].length;
        boolean condition1 = row * col == r * c;// both should be equal
        // boolean condition2 = r <= row;
        // r should be less than or equal than row. -> this is not necessary

        // if any of the condition are not met then return the empty array
        if (!condition1) {
            // return the original output
            return mat;
        }
        int[][] arr = new int[r][c];

        int x = 0;
        int y = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // System.out.println("y:" + y);
                if (y == c) {
                    x++;
                    y = 0;
                    // System.out.println("x:" + x);
                }
                arr[x][y] = mat[i][j];
                y++;

            }
        }

        return arr;
    }

    // LC-1380
    static List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 0; i < row; i++) {
            int smallestInRow = matrix[i][0];
            int index = 0;// which column has the smallest no in a row.
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] < smallestInRow) {
                    smallestInRow = matrix[i][j];
                    index = j;
                }

            }

            // loop over index column and find if the smallestInRow is the largest in
            // column.
            int maxCol = matrix[0][index];
            for (int k = 0; k < row; k++) {
                if (matrix[k][index] > maxCol) {
                    maxCol = matrix[k][index];
                }

                // System.out.println("k: "+);
            }

            if (maxCol == smallestInRow) {
                list.add(maxCol);
            }
        }

        return list;
    }

    // LC-1304
    static int[] sumZero(int num) {
        /** centering 0 */
        // int[] arr = new int[num];
        // int center = 0;
        // // if num is odd, set arr[0] as 0;
        // if (num % 2 != 0) {
        // center = num / 2;
        // arr[center] = 0;
        // }
        // for (int i = 1; i <= num / 2; i++) {
        // arr[center + i] = i;
        // arr[center - i] = -i;
        // }
        // return arr;

        int[] arr = new int[num];
        for (int i = 1; i < num; i += 2) {
            arr[i - 1] = i;
            arr[i] = -i;
        }

        return arr;

    }

    // LC-1886
    static boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;

        int c90 = 0;
        int c180 = 0;
        int c270 = 0;
        int c0 = 0;
        // without roating we are only comapring
        // if the target's present position is equal to mat's rotated position
        // then increment the count
        // if count is n*n, that means the matrix has been rotated by either 90,180,270
        // or 0/360 degree.
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (target[i][j] == mat[i][j]) // A = A(from my samsung notes)
                    c0++;
                if (target[i][j] == mat[j][n - 1 - i]) // A = B
                    c90++;
                if (target[i][j] == mat[n - 1 - i][n - 1 - j]) // A = C
                    c180++;
                if (target[i][j] == mat[n - 1 - j][i]) // A = B
                    c270++;
            }
        }

        System.out.println("90-180-270-0" + c90 + c180 + c270 + c0);
        if (c90 == n * n || c180 == n * n || c270 == n * n || c0 == n * n) {
            return true;
        }

        return false;
    }

    static int[][] rotateMatrix(int[][] mat) {

        // no of cycle will be equal to mat.length / 2
        int n = mat.length;
        int cycle = n / 2; // cycle as in concentric cycle
        /**
         * i represents the number of cycle
         * j represents the number of loops a cycle
         * e.g
         * lets take n=4(a 4x4 matrix)
         * for i=0 it is the outer cycle;
         * this outer cycle edge will have n-i-1 = 4-0-1= 3 loops(j -> 0 to 3)
         * 
         */
        // for n=3; cycle =1
        for (int i = 0; i < cycle; i++) {
            // for n=3;
            // i=0: j=3-0-1=2
            // i=1: j=3-1-1=1
            // i=2: j=3-2-1=0
            for (int j = i; j < n - i - 1; j++) {
                int a = mat[i][j];
                int b = mat[j][n - 1 - i];
                int c = mat[n - 1 - i][n - 1 - j];
                int d = mat[n - 1 - j][i];
                System.out.println("a: " + a + " b: " + b + " c: " + c + " d: " + d);

                int temp = mat[n - 1 - j][i];
                mat[n - 1 - j][i] = mat[n - 1 - i][n - 1 - j];
                mat[n - 1 - i][n - 1 - j] = mat[j][n - 1 - i];
                mat[j][n - 1 - i] = mat[i][j];
                mat[i][j] = temp;

                // int temp = mat[i][j]; // Store the current element in temp
                // mat[i][j] = mat[n - 1 - j][i]; // Move value from bottom left to top left
                // mat[n - 1 - j][i] = mat[n - 1 - i][n - 1 - j]; // Move value from bottom
                // right to bottom left
                // mat[n - 1 - i][n - 1 - j] = mat[j][n - 1 - i]; // Move value from top right
                // to bottom right
                // mat[j][n - 1 - i] = temp;
            }

        }
        return mat;
    }
    // static int[][] rotateMatrix(int[][] mat) {

    // // no of cycle will be equal to mat.length / 2
    // int n = mat.length;
    // int cycle = n / 2; // cycle as in concentric cycle
    // // for n=3; cycle =1
    // for (int i = 0; i < cycle; i++) {
    // // for n=3;
    // // i=0: j=3-0-1=2
    // // i=1: j=3-1-1=1
    // // i=2: j=3-2-1=0
    // for (int j = 0; j < n - i - 1; j++) {
    // // System.out.println();
    // int a = mat[i][j];
    // int b = mat[j][n - 1 - i];
    // int c = mat[n - 1 - i][n - 1 - j];
    // int d = mat[n - 1 - j][i];
    // // swap [ using temp ]
    // // b by a
    // // c by b
    // // d by c
    // // a by d
    // // int temp = a;
    // // a = b;
    // // b = temp;
    // // temp = c;
    // // c = a;
    // // a = d;
    // // d = temp;
    // System.out.println("a:" + a + "b:" + b + "c:" + c + "d:" + d);
    // int temp = mat[i][j];
    // mat[i][j] = mat[j][n - 1 - i];
    // mat[j][n - 1 - i] = temp;
    // temp = mat[n - 1 - i][n - 1 - j];
    // mat[n - 1 - i][n - 1 - j] = mat[i][j];
    // mat[i][j] = mat[n - 1 - j][i];
    // mat[n - 1 - j][i] = temp;

    // }

    // }
    // return mat;
    // }

    // LC-1854: Maximum Population Year
    static int maximumPopulation(int[][] logs) {
        // int[] arr = new int[2051];
        // int max = 0;
        // for (int i = 0; i < logs.length; i++) {
        // arr[logs[i][0]] += 1;
        // arr[logs[i][1]] += -1;
        // }

        // int year = arr[0];
        // for (int i = 1; i < arr.length; i++) {
        // arr[i] += arr[i - 1];
        // if (arr[i] > max) {
        // max = arr[i];
        // year = i;
        // }

        // }

        // return year;

        /** optimizing for space */
        int[] arr = new int[101];
        for (int i = 0; i < logs.length; i++) {
            arr[logs[i][0] - 1950] += 1;
            arr[logs[i][1] - 1950] += -1;
        }

        int max = arr[0];
        int year = 1950;
        for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i - 1];
            if (arr[i] > max) {
                max = arr[i];
                year = i + 1950;
            }

        }

        return year;
    }

    static int[] prefixSum(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i - 1];
        }
        return arr;
    }

    // LC-26: Remove Duplicate from Sorted arrays:
    // ascending
    static int removeDuplicates(int[] nums) {
        int length = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[length++] = nums[i];// nums[length] =nums[i]; & length++; at the same time.

            }
        }
        return length;
    }

    // LC-53: Maximum Subarray
    //
    static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxSum;
    }

    // acc[i][j]
    public static int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int[] customer : accounts) {
            int total = 0;
            for (int amount : customer) {
                total += amount;
            }
            if (total > max) {
                max = total;
            }
        }
        return max;
    }

}
