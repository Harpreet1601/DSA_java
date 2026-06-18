//1.find subroot in main tree(root.data == subroot.data)
//2.check identical now
public class e_subtree {
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

        public static boolean isIdentical(Node node, Node subroot){
            if(node == null && subroot == null){     //last node of tree - when both points to null in last
                return true;
            }
            else if(node == null || subroot == null || node.data != subroot.data){    //this one refers to in between the tree - when one refers to
                return false;                                                         //refers to null and other to data
            }

            if(!isIdentical(node.left, subroot.left)){
                return false;
            }
            if(!isIdentical(node.right, subroot.right)){
                return false;
            }

            return true;
        }

        public static boolean subtree(Node root, Node subroot){
            if(root == null){
                return false;
            }

            if(root.data == subroot.data){
                if(isIdentical(root, subroot)){
                    return true;
                }
            }

            boolean leftAns = subtree(root.left, subroot);
            boolean rightAns = subtree(root.right, subroot);

            return leftAns || rightAns;
        }
    }    
    public static void main(String[] args) {
            // int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
            // int subRoot[] = {1,2,4};
            // BinaryTree tree = new BinaryTree();
            // Node root = tree.buildPreorder(nodes);
            // Node subroot = tree.buildPreorder(subRoot);

            // System.out.println(tree.subtree(root, subroot));    
    }
}


// 1. isSubtree(root, subRoot):
//    - Traverses the main tree and searches every node.
//    - At each node, check if the tree starting from this node
//      is exactly equal to subRoot.
//    - If found at any node, return true.

// 2. isSame(root, subRoot):
//    - Compares two trees.
//    - Both nodes null -> same tree.
//    - One null or values different -> not same.
//    - Recursively check left and right children.

// Thinking:
// - Searching a location in tree = traversal (isSubtree)
// - Checking complete structure = identical tree comparison (isSame)