//worst case T.C occur when pivot is always the samllest or the largest element(n2)
public class f_quickSort {
    public static void printArr(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }

    public static void quickSort(int arr[], int si, int ei){
        //Base case
        if(si >= ei){
            return;
        }

        int pivotIdx = partition(arr, si, ei);
        quickSort(arr, si, pivotIdx-1);
        quickSort(arr, pivotIdx+1, ei);
    }

    public static int partition(int arr[], int si, int ei){
        int pivot = arr[ei];
        int i = si-1;    // make place for els smaller than than pivot

        for(int j=si; j<ei; j++){
            if(arr[j] <= pivot){
                i++;

                //swap -- Move every element that is smaller than or equal to the pivot into the left side region.
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;  //Move to the pivot's final position.

        //After all smaller elements have been collected on the left side, the pivot is still sitting at the end (ei).
        //Now we place the pivot exactly between:

        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;
    }
    public static void main(String[] args) {
        int arr[] = {6,3,9,8,2,5};
        quickSort(arr,0 , arr.length-1);
        printArr(arr);
    }
}
