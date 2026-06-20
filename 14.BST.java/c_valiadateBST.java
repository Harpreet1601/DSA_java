public class c_valiadateBST {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }

    public static boolean validate(Node root, Node min, Node max){
        if(root == null){
            return true;
        }

        if(min != null && root.data <= min.data){
            return false;
        }
        else if(max != null && root.data >= max.data){
            return false;
        }

        return validate(root.left, min, root) && validate(root.right,root, max);
    }
}
