// Detect Cycle
// Find Cycle Start
// Find Previous Node
// previous.next = null
public class d_removeCycle {
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

    public static void removeCycle(){
        //detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

             if(slow == fast){
                cycle = true;
                break;
            }
        }
        if(cycle == false){
            return;
        }
       
        //find node from where cycle was start
        // fast reaches the cycle start, and prev stays one step behind fast. Therefore, when fast reaches the cycle start, 
        // prev is at the last node of the cycle, which is exactly the node whose next must be set to null
         slow = head;

        //"Currently, prev is not pointing to any node."
         Node prev = null;
         while(slow != fast){
            //if prev exists only inside the loop. then After the loop ends, Java won't know what prev is, and you cannot use to remove cycle
            prev = fast;
            slow = slow.next;
            fast = fast.next;
         }
        //remove cycle
        prev.next = null;
    }
}
