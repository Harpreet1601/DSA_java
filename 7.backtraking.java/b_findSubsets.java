//find and print all subsets of a string
//to find subsets it has choice on every level to add make a subset or not
//total subsets = 2power(n);
public class b_findSubsets {
    public static void subsets(String str, String ans, int i){
        //base
        if(i == str.length()){
            System.out.println(ans);
            return;
        }

        //recursion
        //yes choice
        subsets(str, ans+str.charAt(i), i+1);

        //No choice
        subsets(str, ans, i+1);
    }
    public static void main(String[] args) {
       String str = "abc"; 
       subsets(str, " ", 0);
    }
}

// Immutable objects (like String): the function call stack handles the "backtracking" because each call gets its own value.

// Mutable objects (like arrays, StringBuilder, lists): you usually need an explicit undo step after the recursive call
// because all calls share the same object.

// This distinction—between immutable and mutable data—is the key reason why your subset code doesn't need a separate 
// backtracking statement even though it is using a backtracking-style recursive search.