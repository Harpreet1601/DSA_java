import java.util.*;
public class a_buildBst {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }

    public static Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }

        if(root.data > val){
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+ " ");
        inorder(root.right);
    }

    public static boolean search(Node root, int key){
        if(root == null){
            return false;
        }

        if(root.data == key){
            return true;
        }

        if(root.data > key){
            return search(root.left, key);
        }else{
            return search(root.right, key);
        }
    }

    public static void printInRange(Node root, int k1, int k2){
        if(root == null){
            return;
        }

        if(root.data >= k1 && root.data <= k2){
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        }

        else if(root.data < k1){
            printInRange(root.right, k1, k2);
        }else{
            printInRange(root.left, k1, k2);
        }
    }

    public static void printPath(ArrayList<Integer> path){
        for(int i=0; i<path.size(); i++){
            System.out.print(path.get(i) + "->");
        }
        System.out.println("NULL");
    }
    public static void printRoot2Leaf(Node root, ArrayList<Integer> path){
        if(root == null){
            return;
        }

        path.add(root.data);
        if(root.left == null && root.right == null){
            printPath(path);
        }

        printRoot2Leaf(root.left, path);
        printRoot2Leaf(root.right, path);
        path.remove(path.size()-1);
    }
    public static void main(String args[]){
        int values[] = {5,1,3,4,2,7};
        Node root = null;

        for(int i=0; i<values.length; i++){
            root = insert(root, values[i]);
        }

        // inorder(root);
        // System.out.println();

        // if(search(root,1)){
        //     System.out.println("found");
        // }

        //printInRange(root, 3, 7);

        printRoot2Leaf(root, new ArrayList<>());
    }
}
// insert():
// Goes down recursively to find empty position.
// Creates a node there.
// Returns that node.
// Parent connects it using root.left = or root.right =.

// for loop:
// Inserts all array elements one by one.
// It is not traversal.

// inorder():
// Traverses the final BST and prints values.

// In a normal binary tree, we do something like newNode.left = buildTree(). Why here we pass root.left?
// Because in BST insertion, we do not know where the new node should go.
// The function needs to start from the current node and search for the correct empty position.

// Currently:

//    5
//   /
// null

// So:

// insert(null,3)

// Now the function says:

// if(root == null)

// Create:

//3