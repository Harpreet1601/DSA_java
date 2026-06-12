//print the arr using recursion and after reaching the base case at last index backtrack the array by decreasing the value by (-2)
public class a_backtrackArray {
    public static void changeArr(int arr[], int i, int val){
        //base case
        if(i == arr.length){
            printArr(arr);
            return;
        }

        //recursion work
        arr[i] = val;
        changeArr(arr, i+1, val+1);  //func call step
        arr[i] = arr[i] - 2;    //backtreking step
    }

    public static void printArr(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = new int[5];
        changeArr(arr, 0, 1);
        printArr(arr);
    }
}
