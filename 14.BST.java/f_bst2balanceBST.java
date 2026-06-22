//1.first find the inorder sequence of given tree using array list
//2.and then make BST from that array list

import java.util.ArrayList;

public class f_bst2balanceBST {
     static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }
    //to print the given tree
    public static void preorder(Node root){
            if(root == null){
                return;
            }
            System.out.print(root.data+ " ");
            preorder(root.left);
            preorder(root.right); 
    }

    public static void getInorder(Node root, ArrayList<Integer> inorder){
        if(root == null){
            return;
        }

        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }

    public static Node createBST(ArrayList<Integer> inorder, int start, int end){
        if(start > end){
            return null;
        }

        int mid = (start+end)/2;
        Node root = new Node(inorder.get(mid));
        createBST(inorder, start, mid-1);
        createBST(inorder, mid+1, end);

        return root;
    }

    public static Node balancedBSt(Node root){
        //inorder sq
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);

        //sorted inorder -> balanced BSt
        root = createBST(inorder, 0, inorder.size()-1);

        return root;
    }

}
