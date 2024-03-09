public class Armstrong {
    public static void main(String[] args) {
        // int po = power(1, 3);
        // System.out.println(po);
        System.out.println(countDigits(-320));
        // System.out.println(isArmstrong(153));
    }

    static int power(int base, int exponent) {
        int power = 1;
        for (int i = 0; i < exponent; i++) {
            // int temp =base;
            power = power * base;
        }
        return power;
    }

    static int countDigits(int n) {
        int count = 0;

        // negative case
        if (n < 0) {
            n = n * -1;
        }
        // while (n % 10 != 0) {
        while (n > 0) {
            n = n / 10;
            count++;
        }
        return count;
    }

    /**
     * armstrong number:
     * num = sum of all digits to the power of number of digits in the number.
     * 
     * if sum of digits^i == num, where i is the number of digits in num
     * THEN, it is armstrong number.
     * 
     * @param n
     */
    static boolean isArmstrong(int n) {
        int ogNum = n;
        int digits = countDigits(n);
        int powerSum = 0;
        do {
            int rem = n / 10;
            powerSum = powerSum + power(rem, digits);
            n = n / 10;
        } while (n % 10 != 0); // does not miss the last digit
        // while (n / 10 != 0); // misses the last digit

        return ogNum == powerSum;
    }

}
