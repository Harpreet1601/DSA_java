//largest in lexicographic order

public class d_largestString {
    // public static String largestString(String fruits){
    //     String largest = fruits[0];
    //     for(int i=1; i<fruits.length; i++){
    //         if(largest.comapreTo(fruits[i]) < 0){
    //             largest = fruits[i];
    //         }
    //     }
    // }
    public static void main(String[] args) {
        String fruits[] = {"apple","mango","banana"};
        String largest = fruits[0];
        for(int i=1; i<fruits.length; i++){
            if(largest.compareTo(fruits[i]) < 0){
                largest = fruits[i];
            }
        }
        System.out.println(largest);
    }
}
