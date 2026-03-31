public class i_kadanes_sum {

    public static void kadanes(int num[]){
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for(int i=0; i<num.length; i++){
            currSum = currSum + num[i];
            if(currSum<0){
                currSum=0;
            }  
            maxSum = Math.max(currSum,maxSum);
        }
        System.out.println("Max subarray sum is : "+ maxSum);
    }
    public static void main(String[] args) {
        int num[] = {-2,-3,4,-1,-2,1,5,8};
        kadanes(num);
    }
}

    