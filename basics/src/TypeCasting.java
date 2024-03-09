// import java.util.Scanner;

public class TypeCasting {
    public static void main(String[] args) {
        // Scanner input= new Scanner(System.in);
        // float num =input.nextFloat();
        // float num2 =input.nextInt();
        // // int num =input.nextFloat();
        // System.out.println(num);

        // type casting
        int num =(int)(0.29f);
        System.out.println(num);

        // automatic type promotion
        // 1.
        int a = 257;
        byte b =(byte)(a); 
        // 257 % 256 = 1; 
        // since 256 is the max number 1 byte can hold. 2^8=256
        // Therefore it prints out the remainder after the max number.
        System.out.println(b);
        
        // 2.
        byte c =40;
        byte d =40;
        byte e =40;
        int f =(c*d)/e;
        // c * d = 1600; 
        // even though 1600 is greater than 256
        // the calculation is carried by automatic converting byte to int.
        System.out.println(f);

        // 3.
        int number = 'a';
        System.out.println(number);
    }
}
