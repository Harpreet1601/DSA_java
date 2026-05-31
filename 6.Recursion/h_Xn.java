public class h_Xn {
    public static int xPowN(int x, int n){
        if(n == 0){
            return 1;
        }

        return x * xPowN(x,n-1);
    }

    //optimized
     public static int optimizedPow(int a, int n){
        if(n == 0){
            return 1;
        }

        int halfPower = optimizedPow(a, n/2);
        int halfPowerSq = halfPower*halfPower;

        //when n is odd
        if(n%2 != 0){
            halfPowerSq = a * halfPowerSq;
        }

        return halfPowerSq;
     }
    public static void main(String[] args) {
        int x = 2;
        int a = 3;
        int n = 10;
        System.out.println(xPowN(x,n));
        System.out.println(xPowN(a,n));
    }
}
