//find size of largest BST in binary tree
public class g_largestBST {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }

    static class info{
        boolean isBST;
        int size;
        int min;
        int max;

        public info(boolean isBST, int size, int min, int max){
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public static int maxBST =0;

    public static info largestBST(Node root){
        if(root == null){
            return new info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        info leftInfo = largestBST(root.left);
        info rightInfo = largestBST(root.right);
        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, (Math.max(leftInfo.max, rightInfo.max)));

        if(root.data <= leftInfo.max || root.data >= rightInfo.min){
            return new info(false, size, min, max);
        }

        if(leftInfo.isBST && rightInfo.isBST){
            maxBST = Math.max(maxBST, size);
            return new info(true,size, min, max);
        }

        return new info(false, size, min, max);

    }
}
