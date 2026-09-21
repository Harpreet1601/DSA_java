public class h_anagram {
    public static boolean practice(String str1, String str2){
      if(str1.length() != str2.length()){
        return false;
      }

      int freq[] = new int[26];

      for(int i=0; i<str1.length(); i++){
        char ch = str1.charAt(i);
        freq[ch - 'a']++;
      }

      for(int i=0; i<str2.length(); i++){
        char ch = str2.charAt(i);
        freq[ch - 'a']--;
      }

      for(int i=0; i<freq.length; i++){
        if(freq[i] != 0){
          return false;
        }
      }

      return true;
    }

     public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";

        
       // System.out.print(practice(str));
        boolean result = practice(str1, str2);
        System.out.println(result);
      
    }
}