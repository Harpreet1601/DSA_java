//Diameter = No. of nodes in the longest path between 2 nodes
//case1 = diameter pass through root node  (T.C = O(n2))
//case2 = diameter exists in subtree

public class d_diameter {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree{
        static int idx = -1;
        public static Node buildPreorder(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildPreorder(nodes);
            newNode.right = buildPreorder(nodes);

            return newNode;
        }

        //T.C = O(n2)
        // public static int height(Node root){
        //     if(root == null){
        //         return 0;
        //     }

        //     int lH = height(root.left);
        //     int rH = height(root.right);
        //     return Math.max(lH, rH)+1;
        // }

        // public static int diameter(Node root){
        //     if(root == null){
        //         return 0;
        //     }

        //     int leftDiam = diameter(root.left);
        //     int leftHeight = height(root.left);

        //     int rightDiam = diameter(root.right);
        //     int rightHeight = height(root.right);

        //     int selfDiam = leftHeight + rightHeight + 1;

        //     return Math.max(selfDiam, Math.max(leftDiam, rightDiam));
        // }

        //T.C = O(n)  -- Optimised way
        //int diameter[] = new int[1];
        // public int diameterOfBinaryTree(TreeNode root) {
        //     height(root);
        //     return diameter[0];
        // }

        // public int height(TreeNode root){
        //     if(root == null){
        //         return 0;
        //     }

        //     int leftHeight = height(root.left);
        //     int rightHeight = height(root.right);

        //     int currDiameter = leftHeight + rightHeight;
        //     diameter[0] = Math.max(diameter[0], currDiameter);

        //     return Math.max(leftHeight, rightHeight) + 1;
        // }

    }
    public static void main(String[] args) {
            // int  nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
            // BinaryTree tree = new BinaryTree();
            // Node root = tree.buildPreorder(nodes);

            // System.out.println(tree.diameter(root));
        }    
}
