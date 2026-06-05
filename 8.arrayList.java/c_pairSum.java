//Two Pointers
import java.util.ArrayList;

public class c_pairSum {
    public static boolean pairSum1(ArrayList<Integer> list, int target){
        int i = 0;
        int j = list.size()-1;

        while(i <= j){
            if(list.get(i) + list.get(j) == target){
                return true;
            }

            if(list.get(i) + list.get(j) <= target){
                i++;
            }else{
                j--;
            }
        }
        return false;
    }
     public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int target = 0;
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        System.out.println(pairSum1(list, target));
     }
}
