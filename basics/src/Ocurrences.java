public class Ocurrences {
    public static void main(String[] args) {
        int num = 1385757879;
        int count7 = 0;
        while (num > 0) {
            int remainder = num % 10;
            if (remainder == 7) {
                count7++;
            }
            int quotent = num / 10;
            num = quotent;
            System.out.println("digits: " + remainder);
            // System.out.println(num+" : "+quotent+" : "+remainder);
        }
        System.out.println("ocurrence of 7:" + count7);
    }
}
