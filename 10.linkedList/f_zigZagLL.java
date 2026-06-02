import java.util.LinkedList;
public class f_zigZagLL {
     public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;

    public void zigZag(){
        //step1 - find mid
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        //step2 - reverse 2nd half
        Node curr = mid.next;
        mid.next = null;     //here we need to break the connection bcz further we have merge them alernatively
        Node prev = null;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev;
        Node nextL, nextR;   //these are the nodes prev to left and right head

        //step3 - Alternate merge
        while(left != null && right != null){
            nextL = left.next;
            nextR = right.next;

            left.next = right;
            right.next = nextL;
            //update the head to next node
            left = nextL;
            right = nextR;
        }
    }
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
    }
}
