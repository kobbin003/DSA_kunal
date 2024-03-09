public class Scope {
    public static void main(String[] args) {
        call();
        int x = 12;
        for (int i = 0; i < 10; i++) {
            System.out.println(x);
        }
    }

    static void call() {
        int a = 10;
        {
            a = 9;
            int b = 2;
        }
        System.out.println(a);
        // System.out.println(b);
    }
}
