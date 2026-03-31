// SUBARRAY - continous part of array

public class f_print_sub_array {

    public static void subarrays(int num[]){
        int ts = 0;

        for(int i=0; i<num.length; i++){
             
            for(int j=i; j<num.length; j++){
                
                for (int k=i; k<=j; k++){
                    System.out.print(num[k] + " ");
                    
                }
                ts++;
                System.out.println();//just to create space while
            }
             System.out.println();
        }
        System.out.println("Total subarrays : " + ts);
    }
    public static void main(String[] args) {
        int num[] = {2,4,6,8,10};
        subarrays(num);
    }
}
