//find min distance btn nodes
//Distance = (lca->n1 + lca->n2)path
public class i_minDistance {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    public static Node findLCA(Node root, int n1, int n2) {

        if(root == null) {
            return null;
        }

        if(root.data == n1 || root.data == n2) {
            return root;
        }

        Node leftlca = findLCA(root.left, n1, n2);
        Node rightlca = findLCA(root.right, n1, n2);


        if(rightlca == null){
            return leftlca;
        }
        if(leftlca == null){
            return rightlca;
        }

        return root;
    }

    public static int lcaDist(Node root, int n){
        if(root == null){
            return -1;
        }

        if(root.data == n){
            return 0;
        }

        int leftDist = lcaDist(root.left, n);
        int rightDist = lcaDist(root.right, n);

        if(leftDist == -1 && rightDist == -1){
            return -1;
        }else if(leftDist == -1){
            return rightDist+1;
        }else{
            return leftDist+1;
        }
    }

    public static int distance(Node root, int n1, int n2){
        Node lca = findLCA(root, n1, n2);

        int dist1 = lcaDist(lca,n1);
        int dist2 = lcaDist(lca,n2);

        return dist1 + dist2;
    }
    public static void main(String[] args) {

        /*
                1
              /   \
             2     3
              \   / \
               4 5   6

            Top View: 2 1 3 6
        */

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.right = new Node(4);

        root.right.left = new Node(5);
        root.right.right = new Node(6);

        int n1=5, n2=6;
        System.out.println(distance(root, n1, n2));
    }
}
