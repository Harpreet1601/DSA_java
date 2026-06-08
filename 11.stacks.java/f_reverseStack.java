import java.util.Stack;

public class f_reverseStack {

    public static void pushAtBottom(Stack<Integer> s, int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }

        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    public static void reverseStack(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }

        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        reverseStack(s);

        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}
// 1. Pop the top element.
// 2. Recursively reverse the remaining stack.
// 3. Insert the popped element at the bottom.

//pushAtBottom() only inserts ONE element at the bottom.
// pushAtBottom():
// - Stack cannot directly insert at the bottom.
// - Pop all elements until stack becomes empty.
// - Push the new element.
// - Push back all removed elements.
// - Recursion acts as temporary storage.

// reverseStack():
// - Pop one element and save it.
// - Reverse the smaller stack recursively.
// - Put the saved element at the bottom.

// Key Insight:
// To insert an element at the bottom:
// Remove everything -> Insert element -> Restore everything.

// Time Complexity: O(N²)
// Space Complexity: O(N)