//In each iteration every node is considerd as root node for its childrens 
//So, in last if any node does not have any further (left,right) node it became null and we return to its level
public class a_preorder {
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

        public static void preorder(Node root){
            if(root == null){
                return;
            }
            System.out.print(root.data+ " ");
            preorder(root.left);
            preorder(root.right); 
        }

        public static void inorder(Node root){
            if(root == null){
                return;
            }

            inorder(root.left);
            System.err.print(root.data + " ");
            inorder(root.right);
        }

        public static void postorder(Node root){
            if(root == null){
                return;
            }

            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }

        
    }
    public static void main(String[] args) {
        // int  nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        // BinaryTree tree = new BinaryTree();
        // Node root = tree.buildPreorder(nodes);
        
        // tree.preorder(root);
        // tree.inorder(root);
        // tree.postorder(root);
    }
}

// tree
// object of BinaryTree class
// used to call methods
// does not store binary tree

// root
// first node of actual binary tree
// stores reference/address of node 1
// through links, it can reach every node

// Why not store every node?
// Because nodes already store connections: