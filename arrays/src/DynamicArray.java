import java.util.ArrayList;

public class DynamicArray {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>(10);

        list.add(1);
        list.add(123);
        System.out.println(list);
        // * internally calls toString(), no need to call like in the case of array.

        // wrapper functions:
        // list.set(0, 3);
        // list.remove(0);
        list.get(0);
        System.out.println(list);
    }
}
