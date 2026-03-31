//largest number in an array

public class b_largest_in_array {
    
    public static int getLargest(int numbers[]){
        int largest= Integer.MIN_VALUE;
        for(int i=0; i<numbers.length; i++){
            if(largest<numbers[i]){
                largest = numbers[i];
            }
        }
        return largest;
    }
    public static void main(String[] args) {
        int numbers[] = {1,2,3,6,3,9,2,7};
        System.out.println("largest value is : " + getLargest(numbers));
    }
}
