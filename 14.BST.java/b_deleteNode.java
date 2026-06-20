public class b_deleteNode {
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

    public static Node delete(Node root, int val){
        if(root.data < val){
            root.right = delete(root.right, val);
        } 
        else if(root.data > val){
            root.left = delete(root.left, val);
        }
        else{  //(root.data == key) this is the case where we find the node to delete

            //case1 = leaf node
            if(root.left == null && root.right == null){
                return null;
            }

            //case2 = Have single child
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }

            //case3 = Have both child
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }

    public static Node findInorderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    public static void main(String args[]){
        int values[] = {8,5,3,1,4,6,10,11,14};
        Node root = null;

        for(int i=0; i<values.length; i++){
            root = insert(root, values[i]);
        }

        inorder(root);

        root = delete(root, 8);
        System.out.println();

        inorder(root);
    }
}

/*
BST Delete Node Approach:

1. delete(root, val):
   - If root == null → return null.
   - If val is smaller than root.data:
        Search in left subtree.
        Update connection: root.left = delete(root.left, val)
   - If val is greater than root.data:
        Search in right subtree.
        Update connection: root.right = delete(root.right, val)
   - If root.data == val → node found, perform deletion.

2. Deletion Cases:
   Case 1: Leaf node
        - No left and right child.
        - Return null to remove node.

   Case 2: Single child
        - If left is null → return right child.
        - If right is null → return left child.
        - Parent directly connects with child.

   Case 3: Two children
        - Find inorder successor (smallest node in right subtree).
        - Copy successor value into current node.
        - Delete duplicate successor from right subtree.

3. findInorderSuccessor(root):
   - Move left until left becomes null.
   - Leftmost node is the smallest value.
   - Return that node.

Main Function:
   - Create BST using insert().
   - Print inorder before deletion.
   - Call delete(root, value).
   - Store returned root because tree root/links may change.
   - Print inorder after deletion.

Important:
delete() returns the updated subtree root.
That is why we write:
root.left = delete(...)
root.right = delete(...)
to reconnect changed subtrees.

Time Complexity:
Average: O(log n)
Worst: O(n)
Space: O(height)
*/