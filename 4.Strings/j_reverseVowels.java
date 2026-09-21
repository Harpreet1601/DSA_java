public class j_reverseVowels {
    public static boolean isVowels(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public static String reverseVowels(String str){
        char arr[] = str.toCharArray();

        int left = 0;
        int right = arr.length-1;

        while(left < right){
            while(left < right && !isVowels(arr[left])){
            left++;
            }

            while(left < right && !isVowels(arr[right])){
                right--;
            }

            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        return new String(arr);
    }

    public static void main(String[] args) {
        String str = "hello";
        System.out.println(reverseVowels(str));
    }
}
