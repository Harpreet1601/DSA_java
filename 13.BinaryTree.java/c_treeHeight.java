public class c_treeHeight {
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
        
        public static int height(Node root){
            if(root == null){
                return 0;
            }

            int lH = height(root.left);
            int rH = height(root.right);
            return Math.max(lH, rH)+1;
        }

        public static int count(Node root){
            if(root == null){
                return 0;
            }

            int lCount = count(root.left);
            int rCount = count(root.right);

            return lCount + rCount + 1;
        }

        public static int nodeSum(Node root){
            if(root == null){
                return 0;
            }

            int leftSum = nodeSum(root.left);
            int rightSum = nodeSum(root.right);

            return leftSum + rightSum + root.data;
        }
    }    
    public static void main(String[] args) {
            // int  nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
            // BinaryTree tree = new BinaryTree();
            // Node root = tree.buildPreorder(nodes);

            // //System.out.println(tree.height(root));
            // //System.out.println(tree.count(root));
            // System.out.println(tree.nodeSum(root));
    }
}
