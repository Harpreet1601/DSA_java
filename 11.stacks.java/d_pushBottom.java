import java.util.*;
public class d_pushBottom {
    public static void pushAtBottom(Stack<Integer> s, int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }

        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        pushAtBottom(s, 4);
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
}
// "first it stores the top value that getting popped in the top variable, after that it calls the pushAtBottom function again..."
// "then again it move to pushAtBottom, then again top becomes 1 and now 1 get popped..."
// "when stack is empty, push 4 is called"
// "after that it continuously add first 1, then 2, then 3"