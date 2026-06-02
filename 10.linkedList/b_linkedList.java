public class b_linkedList{
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

     public static void addFirst(int data){
          Node newNode = new Node(data);

          if(head == null){
               head = tail = newNode;
               return;
          }
          newNode.next = head;
          head = newNode;
     }

     public static void addLast(int data){
          Node newNode = new Node(data);

          if(head == null){
               head = tail = newNode;
               return;
          }
          tail.next = newNode;
          tail = newNode;
     }

     public static void print(){
          if(head == null){
               System.out.println("ll is empty");
          }

          Node temp = head;
          while(temp != null){
               System.out.print(temp.data + "->");
               temp = temp.next;
          }
          System.out.println("null");
     }

     public static void addMiddle(int data,int idx){
          Node newNode = new Node(data);
          if(idx == 0){
               newNode.next = head;
               head = newNode;
               return;
          }

          Node temp = head;
          int i = 0;

          while(i < idx-1){
               temp = temp.next;
               i++;
          }

          newNode.next = temp.next;
          temp.next = newNode;
     }

     public static int removeFirst(){
          if(head == null){
               System.out.println("ll is empty");
               return -1;
          }
          if(head.next == null){
               int val = head.data;
               head = tail = null;
               return val;
          }

          int val = head.data;
          head = head.next;
          return val;
     }

     public static int removeLast(){
          if(head == null){
               System.out.println("ll is empty");
               return -1;
          }
          if(head.next == null){
               int val = head.data;
               head = tail = null;
               return val;
          }

          Node prev = head;
          while(prev.next.next != null){
               prev = prev.next;
          }
          int val = prev.next.data;
          prev.next = null;
          tail = prev;
          return val;
     }

     public static void reverse(){
          Node prev = null;
          Node curr = head = tail;
          Node next;

          while(curr != null){
               next = curr.next;
               curr.next = prev;
               prev = curr;
               curr = next;
          }
          head = prev;
     }

     public static void deleteNthFromEnd(int n){
          int size = 0;
          Node temp = head;
          while(temp != null){
               temp = temp.next;
               size++;
          }

          if(n == size){
               head = head.next;
               return;
          }

          int i = 1;
          int idxToFind = size-n;
          Node prev = head;

          while(i < idxToFind){
               prev = prev.next;
               i++;
          }
          prev.next = prev.next.next;
          return;
     }

     public Node findMid(Node head){
          Node slow = head;
          Node fast = head;

          while(fast != null && fast.next != null){
               slow = slow.next;
               fast = fast.next.next;
          }
          return slow;
     }

     public boolean palindrome(){
          if(head == null || head.next == null){
               return true;
          }

          Node midNode = findMid(head);

          Node prev = null;
          Node curr = midNode;
          Node next;

          while(curr != null){
               next = curr.next;
               curr.next = prev;
               prev = curr;
               curr = next;
          }

          Node right = prev;    //bcz prev is now the starting node of second half after reverse
          Node left = head;

          while(right != null){
               if(left.data != right.data){
                    return false;
               }
               left = left.next;
               right = right.next;
          }
          return false;
     }
//    public static void main(String[] args) {
//      b_linkedList ll = new b_linkedList();
//      ll.addFirst(2);
//      ll.addFirst(1);
//      ll.addLast(3);
//      ll.addMiddle(10,2);
//      //ll.addMiddle(4,4);

//      // //ll.removeFirst();
//      // //ll.removeLast();
//      // //ll.reverse();
//      ll.deleteNthFromEnd(2);
//      ll.print();
//    }
}