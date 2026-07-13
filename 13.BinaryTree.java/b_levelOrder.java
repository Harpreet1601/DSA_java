import java.util.*;
public class b_levelOrder {
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

        public static void levelOrder(Node root){
            if(root == null){
                return;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode == null){
                    System.err.println();
                    if((q.isEmpty())){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(currNode.data + " ");
                    if(currNode.left != null){
                        q.add(currNode.left);
                    }
                    if(currNode.right != null){
                        q.add(currNode.right);
                    }
                }
            }
        }
    }    
        public static void main(String[] args) {
            // int  nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
            // BinaryTree tree = new BinaryTree();
            // Node root = tree.buildPreorder(nodes);

            // tree.levelOrder(root);
        }
}


/*
Level Order Traversal Algorithm:
1. Use a Queue data structure to store nodes level by level.
2. Add root node into queue and add null as a level separator.
3. Remove nodes from queue one by one and print their data.
4. Add left and right children of current node into queue.
5. When null is found, move to the next line (next level).
6. Repeat until the queue becomes empty.
7. Traverses tree in Breadth First Search (BFS) order.
*/


