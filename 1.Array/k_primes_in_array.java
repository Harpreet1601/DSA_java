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
