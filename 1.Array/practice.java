import java.util.*;
public class practice{
     static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static void inorder(Node root, ArrayList<Integer> arr){
        if(root == null){
            return;
        }

        inorder(root.left, arr);
        arr.add(root.data);
        inorder(root.right, arr);
    }

    public static Node create(ArrayList<Integer> arr, int start, int end){
        if(start > end){
            return null;
        }

        int mid = (start+end)/2;

        Node root = new Node(arr.get(mid));
        root.left = create(arr, start, mid-1);
        root.right = create(arr, mid+1, end);

        return root;
    }

    public static Node merge(Node root1, Node root2){
        ArrayList<Integer> arr1 = new ArrayList<>();
        inorder(root1, arr1);

        ArrayList<Integer> arr2 = new ArrayList<>();
        inorder(root2, arr2);

        int i=0, j=0;
        ArrayList<Integer> arr = new ArrayList<>();
        while(i < arr1.size() && j < arr2.size()){
            if(arr1.get(i) <= arr2.get(j)){
                arr.add(arr1.get(i));
                i++;
            }else{
                arr.add(arr2.get(j));
                j++;
            }
        }

        while(i<arr1.size()){
            arr.add(arr1.get(i));
            i++;
        }

        while(j<arr2.size()){
            arr.add(arr2.get(j));
            j++;
        }

        return create(arr, 0, arr.size()-1);
    }
    public static void main(String[] args) {
        
    }
}