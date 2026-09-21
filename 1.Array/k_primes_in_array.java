public class k_primes_in_array {
     public static boolean prime(int num){
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
        public static void main(String[] args) {
            int arr[] = {3,5,10,11,50,17,20};

            //for each loop in java
            for(int num : arr){
                if(prime(num)){
                    System.out.println(num);
                }
            }
        }
}




//print prime btn numbers
// public class practice {
//     public static boolean practice(int n){
//       if(n < 2){
//         return false;
//       }

//       for(int i=2; i<n; i++){
//         if(n%i == 0){
//             return false;
//         }
//     }
//         return true;
//     }

//     public static void primes(int start, int end){
//         for(int i=start; i<=end; i++){
//             if(practice(i)){
//                 System.out.println(i + " ");
//             }
//         }
//     }

//      public static void main(String[] args) {
//         int start = 0;
//         int end = 20;
        

//         primes(start, end);
//         //System.out.print(practice(n));
//         // boolean result = practice(str);
//         // System.out.println(result);
      
//     }
// }