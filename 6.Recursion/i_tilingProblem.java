public class i_tilingProblem {
    public static int tiling(int n){
        if(n == 0 || n == 1){
            return 1;
        }

        //kaam
        //vertical choice
        int verticalTiles = tiling(n-1);

        //hoeizontal choice
        int horizontalTiles = tiling(n-2);

        int totalWays = verticalTiles + horizontalTiles;
        return totalWays;
    }
    public static void main(String[] args) {
        System.out.println(tiling(3));
    }
}
// n = width of the remaining board.
// tiling(n-1) means one vertical tile consumed one column of width.
// tiling(n-2) means two horizontal tiles consumed two columns of width.
// n is not the count of tiles placed; it is the width still left to cover.