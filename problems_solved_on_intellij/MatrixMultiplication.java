package problems_solved_on_intellij;

import java.util.Arrays;

public class MatrixMultiplication {
    public static void main() {
        int[][] mat1 = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int[][] mat2 = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        System.out.println(Arrays.deepToString(matMultiplication(mat1, mat2)));
    }
    private static int[][] matMultiplication(int[][] mat1, int[][] mat2){
        int rowsA = mat1.length;
        int colsA = mat1[0].length;
        int rowsB = mat2.length;
        int colsB = mat2[0].length;

        int[][] resultMatrix = new int[rowsA][rowsB];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    resultMatrix[i][j] += mat1[i][k] * mat2[k][j];
                }
            }
        }
        return resultMatrix;
    }
}
