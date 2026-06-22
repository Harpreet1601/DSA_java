public class d_invertBST {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }

    public static Node invert(Node root){
        if(root == null){
            return null;
        }

        Node leftInvert = invert(root.left);
        Node rightInvert = invert(root.right);

        root.left = rightInvert;
        root.left = leftInvert;

        return null;
    }
}
