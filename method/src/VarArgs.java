import java.util.Arrays;

/**
 * Variable argmuent parameter should be last in the list of aargument.
 */
public class VarArgs {

    public static void main(String[] args) {
        fun(1, 2, 3, 4, 5);
        fun2(1, "hi", "yo");
    }

    static void fun(int... v) {// takes array of int as argument.
        System.out.println(Arrays.toString(v));
    }

    static void fun2(int a, String... s) {
        System.out.println(a + Arrays.toString(s));
    }
}