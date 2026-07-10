public class b_linkedList{
   public static class Node{
     int data;
     Node next;
     Node prev;

     public Node(int data){
          this.data = data;
          this.next = null;
          this.prev = null;
     }
   }

   public static Node head;
   public static Node tail;
   
   public static void addFirst(int data){
     Node newNode = new Node(data);

     if(head == null){
          head = tail = newNode;
          return;
     }

      newNode.next = head;
      head.prev = newNode;
      head = newNode;
   }
   public static void main(String[] args) {
     //b_linkedList ll = new b_linkedList();
     // ll.addFirst(2);
     // ll.addFirst(1);
     // ll.addLast(3);
     // ll.addMiddle(10,2);
     //ll.addMiddle(4,4);

     //ll.removeFirst();
     //ll.removeLast();
     //ll.reverse();
     // ll.deleteNthFromEnd(2);
     // ll.print();
   }
}