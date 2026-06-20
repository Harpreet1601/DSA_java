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
    public static void main(String args[]){
        int values[] = {5,1,3,4,2,7};
        Node root = null;

        for(int i=0; i<values.length; i++){
            root = insert(root, values[i]);
        }

        // inorder(root);
        // System.out.println();

        if(search(root,1)){
            System.out.println("found");
        }
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