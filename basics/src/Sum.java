import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        System.out.println("Enter one number");
        float num1 =input.nextFloat();
        System.out.println("Enter another number");
        float num2=input.nextFloat();
        float sum = num1+num2;
        System.out.println("The sum of both the number is: "+ sum);
        input.close();
    }
}
