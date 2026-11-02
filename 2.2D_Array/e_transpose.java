public class e_transpose {
    public static int[][] transpose(int matrix[][]) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] result = new int[col][row];

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                result[j][i] = matrix[i][j];
            }
        }

        return result;
    }
    public static void main(String[] args) {
         int matrix[][] = {{1,2,3},
                          {5,6,8},
                          {9,10,11}};

         int[][] answer = transpose(matrix);

        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[i].length; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }
}
