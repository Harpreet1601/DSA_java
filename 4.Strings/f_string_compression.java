public class f_string_compression {
    public static String compression(String str) {
        String newStr = " ";

        for(int i=0; i<str.length(); i++){
            Integer count = 1;   //here use integer object bcz in last we have to convert it into string
            while(str.charAt(i) == str.charAt(i+1) && i<str.length()-1){
                count++;
                i++;
            }
            newStr += str.charAt(i);
            if(count > 1){
                newStr += count.toString();
            }
        }
        return newStr;
    }
    public static void main(String[] args) {
        String str = "aaabbcccdd";
        System.out.println(compression(str));
    }
}
