public class e_mergeSort {
    public static void printArr(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void mergeSort(int arr[], int si, int ei){
        //Base case when we have only 1 element left
        if(si >= ei){
            return;
        }

        //mid = step1
        int mid = si + (ei-si)/2;

        //left part --- here we assume our function recursively sort this part and find mid to divide them in again till the base value
        //step2 
        mergeSort(arr, si, mid);
        //right part
        mergeSort(arr, mid+1, ei);

        //Merge both sorted left and right part
        merge(arr, si, mid, ei);
    }

    public static void merge(int arr[], int si, int mid, int ei){
        //step3
        //in this part we assume we got the both sorted part and now we compare elemnts to store the in temp array
        //create temp arr to merge the sorted elements
        //left(0,3)=4 el   right(4,6)=3  -> 6-0+1 = 7
        int temp[] = new int[ei-si+1];
        int i = si;   //iterator for left part
        int j = mid+1;  //iterator for right part
        int k = 0;   //iterator for temp arr

        while(i <= mid && j<=ei){
            if(arr[i] < arr[j]){
                temp[k] = arr[i];
                i++;
            }else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
            //loop for leftover elements when length of sorted arr is not same --- left part
            while(i <= mid){
                temp[k++] = arr[i++];
            }

            //right part
            while(j <= ei){
                temp[k++] = arr[j++];
            }

            //Now copy temp to original arr
            for(k=0, i=si; k<temp.length; k++, i++){
                arr[i] = temp[k];
            }
    }
    public static void main(String args[]) {
        int arr[] = {6,3,9,5,2,8,1};
        mergeSort(arr,0, arr.length-1);
        printArr(arr);
    }
}
