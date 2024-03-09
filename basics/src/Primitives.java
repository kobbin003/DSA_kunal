/**
 * Primitives
 */
public class Primitives {

    public static void main(String[] args) {
        int num = 30; // max size: 4bytes --> means 2^32
        char word = 'k';
        float marks=98.67f; // end with 'f' / max size: 4bytes
        double largeDecimalNumbers =4567896.984; // max size: 8bytes
        // by default decimal types are of double
        long largeInteger = 26548975548L; // end with 'L' / max size: 8bytes
        boolean isTrue = true;

        // primitives are those which cannot be broken down further into another data type
        // String is not primitive
        String name = "kobin";

        // every primitives has their own class a.k.a wrapper classes
        // gets extra method
        Integer numClass = 33;

        int a= 23_000_000; // better way of writing long integers.
        
    }
}