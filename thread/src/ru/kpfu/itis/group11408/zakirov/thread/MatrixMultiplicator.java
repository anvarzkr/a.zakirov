package ru.kpfu.itis.group11408.zakirov.thread;

import java.util.Random;
import java.util.regex.Matcher;

/**
 * Created by Anvar on 25.04.2015.
 */
public class MatrixMultiplicator {
    public static void main(String[] args) {
        Random random = new Random();
        int[][] matrix1, matrix2;
        int length = 500;
        matrix1 = new int[length][length];
        matrix2 = new int[length][length];
        for (int i = 0; i < length; i++){
            for (int j = 0; j < length; j++){
                matrix1[i][j] = random.nextInt(10);
                matrix2[i][j] = random.nextInt(10);
            }
        }

        int[][] resultMatrix = MatrixMultiplicator.calculate(matrix1, matrix2, 1);

    }

    public static int[][] calculate(int[][] matrix1, int[][] matrix2, int threadCount){
        int[][] resultMatrix = new int[matrix1.length][matrix1.length];
        for (int t = 1; t <= threadCount; t++){
            int rowCount = (t != threadCount) ? matrix1.length / threadCount : matrix1.length % threadCount;
        }
        for (int i = 0; i < matrix1.length; i++)
            for (int j = 0; j < matrix1.length; j++)
                for (int k = 0; k < matrix1.length; k++)
                    resultMatrix[i][j] += matrix1[i][k] * matrix2[k][j];

        return resultMatrix;
    }
}
