public class k_friendsPairing {
    public static int pairFriends(int n){
        if(n == 1 || n == 2){
            return n;
        }
        //when pair single
        int fnm1 = pairFriends(n-1);

        //when make pair of 2
        int fnm2 = pairFriends(n-2);
        int pairWays = (n-1) * fnm2;

        //totalways to make pairs
        int totalWays = fnm1 + pairWays;
        return totalWays;
    }
    public static void main(String[] args) {
        System.out.println(pairFriends(3));
    }
}
