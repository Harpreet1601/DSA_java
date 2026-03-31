public class a_linkedList {
    public static class node{
        int data;
        node next;

        public node(int data){
            this.data = data;
            this.next = null;
        }
    }

    //Here we declare variable for node with static -- means the variable belongs to class not to obj
    //static means only 1 head for entire class
    public static node head;
    public static node tail;
    public static int size;

    //Methods
    public void addFirst(int data){
        //step1 = create new node
        node newNode = new node(data);
        size++;

        if(head == null){
            head = tail = newNode;
            return;
        }
        //step2 = nae node ke next me assign krdo previous head ki value
        newNode.next = head;//link

        //step3 = head=newNode
        head = newNode;
    }

    public void addLast(int data){
        node newNode = new node(data);
        size++;

        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void print(){
        if(head == null){
            System.out.println("LL is empty");
        }

        node temp = head;
        while(temp != null){
            System.out.print(temp.data+ "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void addMiddle(int idx, int data){
        if(idx == 0){
            addFirst(data);
            return;
        }
        node newNode = new node(data);
        size++;

        node temp = head;
        int i = 0;

        while(i < idx-1){
            //update temp to reach next node
            temp = temp.next;
            i++;;
        }

        //i=idx-1;  is point pe temp hoga-> prev 
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int removeFirst(){
        if(size == 0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast(){
        if(size == 0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        //prev : i = size-2
        //loop to reach the prev index
        node prev = head;
        for(int i=0; i<size-2; i++){
            prev = prev.next;
        }

        int val = prev.next.data;  //tail.data
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    
    public int search(int key){
        node temp = head;
        int i=0;

        while(temp != null){
            if(temp.data == key){
                return i;
            }
            //update the temp to next adress 
            temp = temp.next;
            i++;
        }
        return -1;
    }

    public void reverse(){
        //variables in referense to head bcz LL always starts with head 
        //starting me head ka prev null hoga
        node prev = null;
        //head and tail at same idx when ll get reversed
        node curr = tail = head;
        node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        //update the head bcz at the end of every loop curr initialise again prev with head
        head = prev;
    }

    public void deleteNthFromEnd(int n) {
        //calculate size
        int size = 0;
        node temp = head;
        while(temp != null){
            temp = temp.next;
            size++;
        }

        if(n == size){
            head = head.next;  //remove first index
            return;
        }

        //size-n
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

    //PALINDROME
    public node findMid(node head){
        node slow = head;
        node fast = head;

        //loop to find mid
        while(fast != null && fast.next != null) {
            slow = slow.next; //+1
            fast = fast.next.next; //+2
        }
        return slow; //slow is my mid node here
    }

    public boolean palindrome(){
        if(head == null || head.next != null){
            return true;
        }
        //step1 - find mid
        node midNode = findMid(head);

        //step2 - reverse 2nd half
        node prev = null;
        node curr = midNode;
        node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        node right = prev; //right half head
        node left = head;

        //step3 - check 1st and 2nd half
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
        a_linkedList ll = new a_linkedList();
        ll.addFirst(2); 
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);
        ll.addMiddle(2,9);

        ll.print();
        //System.out.println(ll.size);
        //ll.removeFirst();
       // ll.print();

        //ll.removeLast();
        //ll.print();

        // System.out.println(ll.search(9));
        // ll.reverse();
        // ll.print();

        ll.deleteNthFromEnd(3);
        ll.print();
    }
}
