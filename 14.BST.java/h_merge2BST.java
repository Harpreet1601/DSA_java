//Make inorder array of both tree
//sort them both
//now merge them
//sorted arr -> balanced bst
import java.util.*;
public class h_merge2BST {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static void getInorder(Node root, ArrayList<Integer> arr){
        if(root == null){
            return;
        }
        getInorder(root.left, arr);
        arr.add(root.data);
        getInorder(root.right, arr);
    }

    public static Node createBST(ArrayList<Integer> arr, int start, int end){
        if(start > end){
            return null;
        }

        int mid = (start+end)/2;
        Node root = new Node(arr.get(mid));
        createBST(arr, start, mid-1);
        createBST(arr, mid+1, end);

        return root;
    }

    public static Node mergeBST(Node root1, Node root2){
        //step1
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInorder(root1, arr1);

        //step2
        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder(root2, arr2);

        //step3 - merge
        int i=0,  j=0;
        ArrayList<Integer> finalArr = new ArrayList<>();
        while(i<arr1.size() && j<arr2.size()){
            if(arr1.get(i) <= arr2.get(j)){
                finalArr.add(arr1.get(i));
                i++;
            }else{
                finalArr.add(arr2.get(j));
                j++;
            }
        }  

        //these is used when size of array is not equal and 1 array has element left in it
        while(i<arr1.size()){
            finalArr.add(arr1.get(i));
                i++;
        }
        while(j<arr2.size()){
            finalArr.add(arr2.get(i));
                j++;
        }

        //step4
        return createBST(finalArr, 0, finalArr.size()-1);
    }
}
