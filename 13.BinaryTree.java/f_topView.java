import java.util.*;
public class f_topView {
    // Node structure
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

     // info class to store node with horizontal distance
    static class info{
        Node node;
        int hd;

        info(Node node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topView(Node root){
        Queue<info> q = new LinkedList<>();   //queue for level order traversal
        HashMap<Integer, Node> map = new HashMap<>();

        int min = 0, max = 0;
        q.add(new info(root, 0));
        q.add(null);

        while(!q.isEmpty()){
            info curr = q.remove();
            if(curr == null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }
            else{
                if(!map.containsKey(curr.hd)){     //first time hd is occuring
                map.put(curr.hd, curr.node);
                }

                if(curr.node.left != null){
                    q.add(new info(curr.node.left, curr.hd-1));
                    min = Math.min(min, curr.hd-1);
                }

                if(curr.node.right != null){
                    q.add(new info(curr.node.right, curr.hd+1));
                    max = Math.max(max, curr.hd+1);
                }
            }
       }

        for(int i=min; i<=max; i++){
            System.out.print(map.get(i).data+ " ");
        }
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

        topView(root);
    }
}
/*
Top View of Binary Tree:

1. Perform BFS traversal.
2. Track horizontal distance (HD) of every node.
3. Root HD = 0
   Left -> HD-1
   Right -> HD+1
4. Store first node seen at each HD in HashMap.
5. Use queue to process nodes level by level.
6. Finally print nodes from smallest HD to largest HD.

Why BFS?
Because the first node reached at an HD is the topmost node.

Time: O(N log N)
Space: O(N)
*/