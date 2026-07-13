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
Top View of Binary Tree Approach:

Idea:
- View tree from top, so for every vertical line (Horizontal Distance)
  we only store the first node we encounter.

Data Structures:
1. Queue<info>
   - Used for level order traversal (BFS).
   - Stores node + its horizontal distance (HD).

2. HashMap<Integer, Node>
   - Stores first node at every HD.
   - Key = HD
   - Value = Node

Algorithm:
1. Start BFS traversal from root with HD = 0.
2. Use null marker to separate levels (optional for level order).
3. For every node:
   - If current HD is not present in map:
       store node (because it is the topmost node).
   - If HD already exists:
       ignore node.

4. For left child:
      HD = current HD - 1

5. For right child:
      HD = current HD + 1

6. Track minimum and maximum HD:
   - min = leftmost vertical line
   - max = rightmost vertical line

7. Finally print nodes from min HD to max HD.

Why BFS?
Because BFS visits upper levels first, so the first node
found at an HD is always visible from the top.

Example:
        1
       / \
      2   3
       \
        4

HD:
2 -> -1
1 ->  0
3 ->  1
4 ->  0 (ignored)

Answer:
2 1 3

Time Complexity: O(N)
Space Complexity: O(N)
*/

// Info = a packet containing (Node, Horizontal Distance).

// new Info(node, hd) creates that packet.

// curr.node gives the actual tree node.

// curr.hd gives its horizontal distance.

// map.containsKey(curr.hd) checks whether that horizontal distance has already been seen.

// new Info(curr.node.left, curr.hd-1) adds the left child with its updated horizontal distance.

// Once you think of Info as a packet carrying two values together, the entire Top View code becomes much easier to visualize.