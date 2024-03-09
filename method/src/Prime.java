public class Prime {
    public static void main(String[] args) {
        System.out.println(isPrime(133));
    }

    static boolean isPrime(int n) {
        // my implementation

        // *** for-loop
        // corner case
        // if (n <= 1) {
        // return false;
        // }
        // for (int i = 2; i < n; i++) {
        // if (n % i == 0) {
        // return false;
        // }
        // }
        // return true;

        // *** while-loop
        // corner case
        if (n <= 1) {
            return false;
        }
        int div = 2;
        boolean isPrime = true;
        while ((div < n - 1)) {
            if (n % div == 0) {
                isPrime = false;
                break;
            } else {
                div += 1;
            }
        }
        return isPrime;

        // kunal implementation
    }
}
