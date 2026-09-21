import java.util.HashMap;

public class g_charFreq {
    public static void frequency(String str){
      HashMap<Character, Integer> map = new HashMap<>();

      for(int i=0; i<str.length(); i++){
        char ch = str.charAt(i);

        if(map.containsKey(ch)){
            int count = map.get(ch);
            map.put(ch, count+1);
        }else{
          map.put(ch,1);
        }
      }

      for(char ch : map.keySet()){
        System.out.println(ch + " = " + map.get(ch));
      }
    }
  
    public static void main(String[] args) {
      String str = "hello";

        frequency(str);
      
    }
}
