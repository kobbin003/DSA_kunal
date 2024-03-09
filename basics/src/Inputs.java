import java.util.Scanner;

/**
 * Inputs
 */
public class Inputs {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your roll number: ");
        int rollno = input.nextInt();
        System.out.println("your roll no. is"+rollno);
        input.close();
    }
}