import java.lang.reflect.Array;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        // syntax:
        // dataType[] variable_name = new dataType[size];
        int[] rolls1 = new int[5];
        // or directly:
        int[] rolls2 = { 1, 2, 3, 4, 5 };
        // * all element type should be same.

        // flow:
        int[] ros; // declaration: ros is getting defined in the stack
        ros = new int[5]; // initialization: here the object is being created in the memory(heap)

        // * declaration happens at compile time
        // *initialization happens at run time
        // * This is called dynamic memory allocation i.e memory is allocated during
        // runtime */

        // in c++ the array is a continous array
        // in java, it depends on the JVM whether the array created is a continous one.

        int[] arr = { 1, 2, 3, 4, 5 };
        // System.out.println(arr);
        // System.out.println(Arrays.toString(arr));

        // enhanced for-loop
        for (int el : arr) {
            System.out.println(el);
        }
    }
}
