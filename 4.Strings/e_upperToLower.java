//convert the first letter to uppercase of every word

public class e_upperToLower {
    public static String toUpperCase(String str) {
        StringBuilder result = new StringBuilder();

        char ch = Character.toUpperCase(str.charAt(0));
      result.append(ch);

      for(int i=0; i<str.length(); i++){
        if(str.charAt(i) == ' ' && i < str.length()-1){
          result.append(str.charAt(i));
          
          result.append(Character.toUpperCase(str.charAt(i)));
        
        }
        // else{
        //   result.append(str.charAt(i));
        // }
      }

      return result.toString();
    }
    public static void main(String[] args) {
        String str = "HI, i am harpreet";
        System.out.println(toUpperCase(str));
    }
}
