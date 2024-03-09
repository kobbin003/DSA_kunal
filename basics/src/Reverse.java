/**
 * Question: n = 23597; reverse this number
 * Answer: 79532
 */
public class Reverse {
    public static void main(String[] args) {
        // int num = 23;
        int num = 23597;
        int reverse = 0;
        // int count = 10;
        while (num > 0) {
            int remainder = num % 10;
            num = num / 10;
            reverse = reverse * 10 + remainder;
        }

        System.out.println(reverse);
    }
}
