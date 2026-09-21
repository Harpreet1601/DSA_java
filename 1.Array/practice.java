import java.util.*;
public class practice {
    public static String practice(String str){
        String result = "";

        for(int i=str.length()-1; i>=0; i--){
            result = result + str.charAt(i);
        }

        return result;
    }

     public static void main(String[] args) {
        
        String str = "hello";

        //practice(arr);
        System.out.print(practice(str));
        // boolean result = practice(str);
        // System.out.println(result);
      
    }
}