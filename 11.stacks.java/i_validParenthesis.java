import java.util.*;
public class i_validParenthesis {
    public static boolean isValid(String str){
        Stack <Character> s = new Stack<>();

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            
            //opening condition
            if(ch == '(' || ch == '{' || ch == '['){
                s.push(ch);
            }else{
                //closing
                if(s.isEmpty()){   //it means no opening brackets is present
                    return false;
                }
                if((s.peek() == '(' && ch == ')')
                    || (s.peek() == '{' && ch == '}')
                    || (s.peek() == '[' && ch == ']')){
                        s.pop();
                }else{             
                    return false;   //when successfull pair is not form
                }
            }
        }
        if(s.isEmpty()){
            return true;
        }else{
            return false;    //when we still left no matching bracket at starting of the string
        }
    }
    public static void main(String[] args) {
        String str = "({})[]";
        System.out.println(isValid(str));
    }
}
