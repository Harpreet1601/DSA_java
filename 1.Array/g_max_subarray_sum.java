//BRUTE FORCE

public class g_max_subarray_sum {
    public static void max_subarray_sum(int num[]){

        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i=0; i<num.length; i++){
            
            for(int j=i; j<num.length; j++){
                
                currSum = 0;   //Reinitialize currSum with 0 as we calculate sum of new subarray.
                for(int k=i; k<=j; k++){
                    //subarray sum
                    currSum += num[k];
                }
                if(maxSum < currSum){
                    maxSum = currSum;
                }
            }
        }
        System.out.println("max sum = " + maxSum);
    }
    
    public static void main(String[] args) {
        int num[] = {1,-1,6,-1,3};
        max_subarray_sum(num);
    }
}



