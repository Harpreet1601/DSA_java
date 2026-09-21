public class k_toggleCase {
    public static String toggleCase(String str) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                result.append(Character.toLowerCase(ch));
            } 
            else if (ch >= 'a' && ch <= 'z') {
                result.append(Character.toUpperCase(ch));
            } 
            else {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        String str = "HeLLo";

        System.out.println(toggleCase(str));
    }
}
