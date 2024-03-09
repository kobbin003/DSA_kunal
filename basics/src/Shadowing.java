public class Shadowing {
    static int x = 10;

    public static void main(String[] args) {
        System.out.println(x);
        int x = 11;
        // the higher level is overridden by the lower level
        // this is called as shadowing.
        System.out.println(x);
        fun();
    }

    static void fun() {
        System.out.println(x);
    }
}
