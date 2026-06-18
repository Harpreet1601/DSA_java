//import java.util.ArrayList;

public class h_lowestCommonAncestor {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    // public static boolean getPath(Node root, int n, ArrayList<Integer> path){     //n represent the node to which we have to find the path
    //     if(root == null){
    //         return false;
    //     }
    //     path.add(root);

    //     if(root.data == n){
    //         return true;
    //     }

    //     boolean foundLeft = getPath(root.left, n, path);
    //     boolean foundRight = getPath(root.right, n, path);

    //     if(foundLeft || foundRight){
    //         return true;
    //     }

    //     path.remove(path.size()-1);
    //     return false;
    // }

    // public static Node lca(Node root, int n1, int n2){
    //     ArrayList<Node> path1 = new ArrayList<>();
    //     ArrayList<Node> path2 = new ArrayList<>();

    //     getPath(root,n1,path1);
    //     getPath(root,n2,path2);

    //     //last common ancestor
    //     for(int i=0; i<path1.size() && i<path2.size(); i++){
    //         if(path1.get(i) != path2.get(i)){
    //             break;
    //         }
    //     }

    //     //last common node became -> i-1
    //     Node lca = path1.get(i-1);
    //     return lca;
    // }

    public static Node lca(Node root, int n1, int n2){
        if(root == null || root.data == n1 || root.data == n2){
            return root;
        }

        Node leftlca = lca(root.left, n1, n2);
        Node rightlca = lca(root.right, n1, n2);

        //leftlca = valid but rightlca = null
        if(rightlca == null){
            return leftlca;
        }
        if(leftlca == null){
            return rightlca;
        }

        return root;

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
        System.out.println(lca(root, n1, n2).data);
    }
}
