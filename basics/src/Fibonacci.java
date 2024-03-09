import java.util.ArrayList;
import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        // with ArrayList
        // ArrayList<Integer> fibonacci = new ArrayList<Integer>();
        // fibonacci.add(0);
        // fibonacci.add(1);
        // System.out.println(fibonacci);
        // // int count = 0;
        // int findNth = 10;
        // for(int b=0;b<findNth-2;b++){
        // // count++;
        // int length = fibonacci.size();
        // int lastItem = fibonacci.get(length-1);
        // int lastButOneItem = fibonacci.get(length-2);
        // int newAddition = lastItem+lastButOneItem;
        // fibonacci.add(newAddition);
        // System.out.println(lastItem);
        // }

        // System.out.println(fibonacci);

        // without ArrayList
        // System.out.println("enter a nth");
        // Scanner input = new Scanner(System.in);
        int n = 3;
        // int n = input.nextInt();
        // System.out.println(a);

        int a = 0;
        int b = 1;
        int count = 2;
        while (count < n) {
            int temp = b;
            b = a + b;
            a = temp;
            count++;
            System.out.println(b);
        }
        System.out.println("end-a" + a + "b" + b);
        // input.close();
    }

}
