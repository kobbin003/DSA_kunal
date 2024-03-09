public class PassingReference {
    public static void main(String[] args) {
        int num = 10;
        changeNum(num);// new object naam = "Takha" is created instead of updating name = "Kobin"
        num = 15;
        System.out.println(num);
    }

    /** primitives are only passed by value. */

    static void changeNum(int number) {
        number = 11;
    }
    // static void changeName(String naam) {
    // naam = "Takha";
    // }
}
