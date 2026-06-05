//container with most water
import java.util.*;
public class b_container {
    public static int storeWater(ArrayList<Integer> height){
        int maxWater = 0;
        int lP = 0;
        int rP = height.size()-1;

        while(lP < rP){
            //calculate water area
            int ht = Math.min(height.get(lP), height.get(rP));
            int width = rP-lP;
            int currWater = ht * width;

            maxWater = Math.max(maxWater, currWater);

            if(height.get(lP) < height.get(rP)){
                lP++;
            }else{
                rP--;
            }
        }

        //Brute Force
        // for(int i=0; i<height.size(); i++){
        //     for(int j=i+1; j<height.size(); j++){
        //         int ht = Math.min(height.get(i),height.get(j));
        //         int width = j-i;
        //         int currWater = ht * width;
        //         maxWater = Math.max(maxWater, currWater);
        //     }
        // }
         return maxWater;
    }
    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        System.out.println(storeWater(height));
    }
}
