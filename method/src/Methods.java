public class Methods {
    public static void main(String[] args) {
        log();
        swap(1, 5);
    }

    // returns void
    static void log() {
        // to be able to call inside the static main
        // you have assign "static" access_modifier to method.
        System.out.println("this will log");
    }

    static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println("a: " + a + "b: " + b);
    }
}
