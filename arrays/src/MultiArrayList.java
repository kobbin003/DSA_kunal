import java.util.ArrayList;
import java.util.Scanner;

public class MultiArrayList {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>(3);
        System.out.println("row" + arr.size());
        // arr.add();
        int rowSize = 3;
        int colSize = 2;

        // initialisation
        for (int i = 0; i < rowSize; i++) {
            arr.add(new ArrayList<Integer>());

        }

        // add elements
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                arr.get(i).add(in.nextInt());
            }
        }
        System.out.println(arr);
        System.out.println(arr.size());
    }
}
