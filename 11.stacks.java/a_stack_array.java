public class a_stack_array {
    int arr[];
    int top;
    int max_size;

    a_stack_array(int size){
        max_size = size;
        arr = new int[size];
        top = -1;
        }

    //Method creation
    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == max_size-1;
    }

    public void push(int data){
        if(isFull()){      //isFull()
            System.out.println("stack overflow");
        }else{
            arr[++top] = data;   //arr.add(data);
            System.out.println("Element added : " + data);
        }
    }

    public int pop(){  //Here we do not insert value in pop bcz we already know that it delete the top element
        if(isEmpty()){      //isEmpty()
            System.out.println("Stack underflow");
            return -1;
        }else{
            return arr[top];
        } 
    }

    public int peek(){
        if(!isEmpty()){
            return arr[top];
        }
        System.out.println("stack is empty");
        return -1;
    }

    public void display(){
        if(isEmpty()){
            System.out.println("stack is empty");
        }else{
            for(int i=top; i>=0; i--){
                System.out.println(arr[i]);
            }
        }
    }
    public static void main(String[] args) {
        a_stack_array s = new a_stack_array(3);
        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println("top element :" + s.peek());
        s.display();

    }
}