import java.util.*;

public class o_findDuplicate {
    // public static void findDuplicate(int arr[]){
    //     HashSet<Integer> set = new HashSet<>();

    //     for(int num : arr){
    //         if(set.contains(num)){
    //             System.out.print(num + " ");
    //         }else{
    //             set.add(num);
    //         }
    //     }        
    // }

//find duplicates and their frequency
    public static void findDuplicate(int arr[]){
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : arr){
            if(map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            }else{
                map.put(num, 1);
            }
        }

        for(int num : map.keySet()){
            // if(map.get(num) > 1){
            //     System.out.println(num + ":" + map.get(num));
            // }
            System.out.println(num + ":" + map.get(num));
        }
    }



    public static void main(String[] args) {
      
        int[] arr = {1, 2,3,4,2,1,5};
        findDuplicate(arr);
        
    }
}
