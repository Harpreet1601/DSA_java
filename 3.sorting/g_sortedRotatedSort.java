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


// class Solution {
//     public int search(int[] nums, int target) {
//         int left = 0;
//         int right = nums.length - 1;

//         while (left <= right) {

//             int mid = left + (right - left) / 2;

//             if (nums[mid] == target) {
//                 return mid;
//             }

//             // Left half is sorted
//             if (nums[left] <= nums[mid]) {

//                 if (target >= nums[left] && target < nums[mid]) {
//                     right = mid - 1;
//                 } else {
//                     left = mid + 1;
//                 }

//             }
//             // Right half is sorted
//             else {

//                 if (target > nums[mid] && target <= nums[right]) {
//                     left = mid + 1;
//                 } else {
//                     right = mid - 1;
//                 }
//             }
//         }

//         return -1;
//     }
// }


// At every iteration, one half of the array is always sorted.
// First find mid.
// If nums[mid] == target, return mid immediately.
// Determine which half is sorted:
// nums[si] <= nums[mid] → Left half is sorted.
// Otherwise → Right half is sorted.
// Case 1: Left Half Sorted

// if(nums[si] <= nums[mid])

// Check if target lies inside the sorted left range:

// target >= nums[si] && target < nums[mid]

// True:
// ei = mid - 1
// (Target must be in left half)

// False:
// si = mid + 1
// (Target must be in right half)

// Case 2: Right Half Sorted

// else

// Check if target lies inside the sorted right range:

// target > nums[mid] && target <= nums[ei]

// True:
// si = mid + 1
// (Target must be in right half)

// False:
// ei = mid - 1
// (Target must be in left half)

// Important Notes:
// We use mid - 1 and mid + 1 because mid has already been checked.
// ei = mid - 1 does NOT mean mid becomes mid - 1.
// It only shrinks the search range.
// si = mid + 1 does NOT mean mid becomes mid + 1.
// It only shrinks the search range.
// After updating si or ei, a NEW mid is calculated in the next iteration.
// Nested if-else blocks never return the answer.
// Their job is only to move si and ei.

// The ONLY place that returns the answer is:

// if(nums[mid] == target)
// return mid;

// Mental Model:

// Step 1: Find which side is sorted.
// Step 2: Check whether target lies in that sorted side.
// Step 3: Keep that side, discard the other side.
// Step 4: Repeat until target is found.