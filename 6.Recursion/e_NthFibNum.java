//Finnding nth fibonacci number
public class e_NthFibNum {
    public static int nthFibNum(int n){
        if(n == 0 || n == 1){
            return n;
        }

        int nth = nthFibNum(n-1) + nthFibNum(n-2);
        return nth;
    }
    public static void main(String[] args) {
        int n = 6;
        System.out.println(nthFibNum(n));
    }
}
