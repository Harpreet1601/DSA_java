public class g_firstOccurence {
    //first compare with self and then look forward
    public static int firstOccur(int arr[], int i, int key){
        if(i == arr.length){
            return -1;
        }

        if(arr[i] == key){
            return i;
        }

        return firstOccur(arr, i+1, key);
    }

    //Last occurence 
    // first look forward and then compare with self
    public static int lastOccur(int arr[],int i, int key){
        if(i == arr.length){
            return -1;
        }

        int isFound = lastOccur(arr,i+1, key);
        if(isFound == -1 && arr[i] == key){
            return i;
        }

        return isFound;
    }

    public static void main(String[] args) {
        int arr[] = {8,3,6,9,5,6,7};
        //int key = 9;
        System.out.println(firstOccur(arr,0, 6));
        System.out.println(lastOccur(arr,0, 6));
    }
}
