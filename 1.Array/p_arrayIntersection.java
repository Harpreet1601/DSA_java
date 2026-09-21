import java.util.*;

public class p_arrayIntersection {
    public static void intersection(int arr1[], int arr2[]){
        HashSet<Integer> set = new HashSet<>();

        for(int num : arr1){
            set.add(num);
        }

        for(int num : arr2){
            if(set.contains(num)){
                System.out.println(num);
                set.remove(num);
            }
        }
    }
    public static void main(String[] args) {
        int arr1[] = {1, 2, 3, 4, 5};
        int arr2[] = {3, 4, 5, 6, 7};

        intersection(arr1, arr2);
    }
}
