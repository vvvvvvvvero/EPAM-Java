package com.epam.rd.autotasks.matrices;
import java.util.Arrays;

public class TransposeMatrix {
    public static int[][] transpose(int[][] matrix) {
        int[][] returnTab = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < returnTab.length; i++)
        {
            for (int j = 0; j < returnTab[i].length; j++)
            {
                returnTab[i][j] = matrix[j][i];
            }
        }
        return returnTab;

    }

    public static void main(String[] args) {

        System.out.println("Test your code here!\n");

        // Get a result of your code

        int[][] matrix = {
                {1, 2},
                {7, -13} };

        int[][] result = transpose(matrix);
        System.out.println(Arrays.deepToString(result).replace("],", "]\n"));
    }

}
