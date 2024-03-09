import java.util.Arrays;

/**
 * two or more functions of the same name can exist
 * IF the parameters are different
 * i.e either the number of or type of should be different.
 */
public class Overloading {
    public static void main(String[] args) {

    }

    static void fun(int a) {
        System.out.println(a);
    }

    static void fun(String a) {
        System.out.println(a);
    }
}
