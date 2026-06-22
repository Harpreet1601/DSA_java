public class e_sortedArr2BalancedBST {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }
    public static void preorder(Node root){
            if(root == null){
                return;
            }
            System.out.print(root.data+ " ");
            preorder(root.left);
            preorder(root.right); 
    }

    public static Node balancedBST(int arr[], int start, int end){
        if(start > end){
            return null;
        }
        
        int mid = (start+end)/2;

        Node root = new Node(arr[mid]);
        root.left = balancedBST(arr, start, mid-1);
        root.right = balancedBST(arr, mid+1, end);

        return root;
    }

    public static void main(String[] args) {
        int arr[] = {3,5,6,8,10,11,12};
        Node root = balancedBST(arr, 0, arr.length-1);

        preorder(root);
    }
}
