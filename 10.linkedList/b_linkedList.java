public class b_linkedList{
   public static class node{
        int data;
        node next;

        public node(int data){
            this.data = data;
            this.next = null;
        }
   }

   public static node head;
   public static node tail;

   //Methods
   public void addFirst(int data){
     node newNode = new node(data);

     if(head == null){
          head = tail = newNode;
          return;
     }
     newNode.next = head;
     head = newNode;
     }

     //addlast
     public void addLast(int data){
          node newNode = new node(data);
          if(head == null){
               head = tail = head;
               return;
          }
          tail.next = newNode;
          tail = newNode;
     }

     public void print(){
          if(head == null){
               System.out.println("LL is empty");
               return;
          }
          
          node temp = head;
          while(temp != null){
               System.out.print(temp.data + "->");
               temp = temp.next;
          }
          System.out.println("null");
     }

     public void addMiddle(int idx, int data){
          node newNode = new node(data);
          node temp = head;
          int i = 0;

          while(i < idx-1){
               temp = temp.next;
               i++;
          }

          newNode.next = temp.next;
          temp.next = newNode;
     }

     public int removeFirst(){
          //int val = head.data;
          head = head.next;
          return head.data;
     }

     public int removeLast(){
          if(head == null){
               System.out.println("LL is empty");
               return Integer.MIN_VALUE;
          }else if(head.next == null){
               head = tail = null;
               return -1;
          }

          node temp = head;
          while(temp.next.next != null){
               temp = temp.next;
          }

          //int val = temp.next.data;
          temp.next = null;
          tail = temp;
          return  temp.next.data;
     }

     public int search(int key){
          node temp = head;
          int i=0;

          while(temp != null){
               if(temp.data == key){
                    return i;
               }
               temp = temp.next;
               i++;
          }
          return -1;
     }

     public void reverse(){
          node prev = null;
          node curr = head = tail;
          node next;

          while(curr != null){
               next = curr.next;
               curr.next = prev;
               prev = curr;
               curr = next;
          }

          head = prev;
     }

     public void deleteNthFromEnd(int n){
          int size = 0;
          node temp = head;
          while(temp != null){
               temp = temp.next;
               size++;
          }

          if(size == n){
               head = head.next;
               return;
          }

          int i=1;
          int idxToFind = size-n;
          node prev = head;
          while(i < idxToFind){
               prev = prev.next;
               i++;
          }
          prev.next = prev.next.next;
          return;
     }

     public node findMid(node head){
          node slow = head;
          node fast = head;

          while(fast.next != null && fast.next.next != null){
               slow = slow.next;
               fast = fast.next.next;
          }
          return slow;
     }

     public boolean palindrome(){
          if(head == null || head.next != null){
               return true;
          }

          node midNode = findMid(head);

          node prev = null;
          node curr = midNode;
          node next;

          while(curr != null){
               next = curr.next;
               curr.next = head;
               prev = curr;
               curr = next;
          }

          node right = prev;
          node left = head;

          while(right != null){
               if(left.data != right.data){
                    return false;
               }
               left = left.next;
               right = right.next;
          }
          return true;
     }
   public static void main(String[] args) {
     b_linkedList ll = new b_linkedList();
     ll.addFirst(2);
     ll.addFirst(1);
     ll.addLast(3);
     ll.addLast(4);
     ll.addMiddle(2,10);
     ll.print();

     //ll.removeFirst();
     //ll.removeLast();
     //ll.deleteNthFromEnd(2);
     ll.print();
   }
}