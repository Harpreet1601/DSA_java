import java.util.*;
public class h_nextGreaterEl {
   public static void main(String[] args) {
        int arr[] = {6,8,0,1,3};
        Stack<Integer> s = new Stack<>();
        int nxTGreater[] = new int[arr.length];
        
        for(int i=arr.length-1; i>=0; i--){
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]){
                s.pop();
            }

            if(s.isEmpty()){
                nxTGreater[i] = -1;
            }else{
                nxTGreater[i] = arr[s.peek()];
            }

            //now the element into our stack
            s.push(i);
        }

        for(int i=0; i<nxTGreater.length; i++){
            System.out.println(nxTGreater[i] + " ");
        }
        System.out.println();
   } 
}