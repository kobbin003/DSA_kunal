import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        // make user select operation
        System.out.println("Select opertion: + / - / % / *");
        // show result when user presses "x" or "X"
        Scanner in = new Scanner(System.in);
        char operation = in.next().trim().charAt(0);
        // System.out.println(operation);

        if (operation == '+' || operation == '-' || operation == '%' || operation == '*' || operation == '/') {

            System.out.println("Enter two numbers");
            int num1 = in.nextInt();
            int num2 = in.nextInt();
            int result = 0;
            // in.close();
            switch (operation) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '%':
                    if (num2 != 0) {
                        result = num1 % num2;
                    }
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 % num2;
                    }
                    break;
                case '*':
                    result = num1 * num2;

                    break;

                default:
                    break;
            }

            System.out.println("The result is : " + result);
        } else {
            System.out.println("Invalid operation");

        }
    }
}
