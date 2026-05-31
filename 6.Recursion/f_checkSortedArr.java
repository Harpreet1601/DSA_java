public class f_checkSortedArr {
    public static boolean checkSorted(int arr[], int i){
        //Here i is considered as starting index to start comparision
        if(i == arr.length-1){
            return true;
        }

        if(arr[i] >= arr[i+1]){
            return false;
        }

        return checkSorted(arr, i+1);
    }
    public static void main(String[] args) {
        int arr[] = {1,5,8,9,10};
        System.out.println(checkSorted(arr,0));
    }
}
