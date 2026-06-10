import java.util.*;
public class k_maxAreaHistogram {
    public static void maxArea(int arr[]){
        int maxArea = 0;
        int nsR[] = new int[arr.length];
        int nsL[] = new int[arr.length];

        //next smaller right
        Stack<Integer> s = new Stack<>();

        for(int i=arr.length-1; i>=0; i--){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsR[i] = arr.length;
            }else{
                nsR[i] = s.peek();
            }
            s.push(i);
        }

        //next smaller left
        s = new Stack<>();

        for(int i=0; i<=arr.length-1; i++){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsL[i] = -1;
            }else{
                nsL[i] = s.peek();
            }
            s.push(i);
        }

        //current area : width = j-i-1 = nsR[i]-nsL[i]-1
        for(int i=0; i<=arr.length-1; i++){
            int height = arr[i];
            int width = nsR[i]-nsL[i]-1;
            int currArea = height * width;
            
            maxArea = Math.max(currArea, maxArea);
        }

        System.out.println("Max area in histogram = " + maxArea);

    }
    public static void main(String[] args) {
        int arr[] = {2,1,5,6,2,3};
        maxArea(arr);
    }
}
