//find if any pair is sorted or rotated array has a target sum 
//Two Pointers approach
public class m_twoSum2 {
    public static boolean twoSum2(int arr[], int target){
        int n = arr.length;

        //find out the pivot or breaking point(from where array is rotated)
        int bp = -1;
        for(int i=0; i<n-1; i++){
            if(arr[i] > arr[i+1]){
                bp = i;
                break;
            }
        }

        //  After finding bp:
        // - Largest element is at bp.
        // - Smallest element is at bp + 1.
        int lp = bp+1;
        int rp = bp;

        while(lp != rp){
            if(arr[lp]+arr[rp] == target){
                return true;
            }

            if(arr[lp]+arr[rp] < target){
                lp = (lp+1)%n;
            }else{
                rp = (n+rp-1)%n;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int arr[] = {11,15,6,8,9,10};
        int target = 16;
        System.out.println(twoSum2(arr, target));
    }
}
// Modulo (%) is used because the array is circular after rotation.
//   It helps pointers wrap around the array.