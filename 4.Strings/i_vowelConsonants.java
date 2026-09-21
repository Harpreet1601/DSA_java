public class i_vowelConsonants {
    public static String practice(String str){
      int vowels = 0;
      int consonants = 0;

      for(int i=0; i<str.length(); i++){
        char  ch = str.charAt(i);

        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
          vowels++;
        }else{
          consonants++;
        }
      }

      if(vowels > 2){
        String result = " ";

        for(int i=str.length()-1; i>=0; i--){
          result = result + str.charAt(i);
        }

        return result;
      }else{
        return String.valueOf(consonants);
      }
    }

     public static void main(String[] args) {
        String str = "education";
        

        
        System.out.print(practice(str));
        // boolean result = practice(str);
        // System.out.println(result);
      
    }
}