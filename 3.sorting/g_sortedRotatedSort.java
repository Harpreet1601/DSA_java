public class g_sortedRotatedSort {
    public static int search(int arr[], int tar, int si, int ei){
        //BAse case
        if(si > ei){
            return -1;
        }

        int mid = si + (ei-si)/2;
        // when target el on mid
        if(arr[mid] == tar){
            return mid;
        }

        //mid on line 1
        if(arr[si] <= arr[mid]){
            //case a: left side of line
            if(arr[si] <= tar && tar <= arr[mid]){
                return search(arr, tar, si, mid-1);
            }else{
            //case b: right side of line 1    
                return search(arr, tar, mid+1, ei);
            }
        }

        //mid on line 2
        else{
            //case c: right of line 2
            if(arr[mid] <= tar && tar <= arr[ei]){
                return search(arr, tar, mid+1, ei);
            } else{
                //case d: left of line 2
                return search(arr, tar, si, mid-1);
            }

        }
    }
    public static void main(String[] args) {
        int arr[] = {4,5,6,7,0,1,2};
        int target = 0;
        int tarIdx = search(arr, target, 0, arr.length-1);
        System.out.println(tarIdx);
    }
}
