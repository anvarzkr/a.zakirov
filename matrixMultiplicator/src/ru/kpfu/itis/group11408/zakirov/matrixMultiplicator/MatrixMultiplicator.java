package ru.kpfu.itis.group11408.zakirov.matrixMultiplicator;

import java.util.Random;
import java.util.regex.Matcher;

/**
 * Created by Anvar on 25.04.2015.
 */
public class MatrixMultiplicator {
    private int[][] matrix1;
    private int[][] matrix2;
    private int[][] resultMatrix;
    public int threadFinished = 0;
    public int threadCount = 1;

    public static void main(String[] args) {
        Random random = new Random();
        int length = 250;
        int[][] matrix1 = new int[length][length];
        int[][] matrix2 = new int[length][length];
        for (int i = 0; i < length; i++){
            for (int j = 0; j < length; j++){
                matrix1[i][j] = random.nextInt(10);
                matrix2[i][j] = random.nextInt(10);
            }
        }

        startTest(matrix1, matrix2, 1);
        startTest(matrix1, matrix2, 2);
        startTest(matrix1, matrix2, 4);
    }

    public static void startTest(int[][] matrix1, int[][] matrix2, int threadCount){
        System.out.println("Starting test with " + matrix1.length + "x" + matrix1.length + " matrix length and " + threadCount + " thread(s)");
        long time = System.currentTimeMillis();
        MatrixMultiplicator matrixMultiplicator = new MatrixMultiplicator(matrix1, matrix2);
        matrixMultiplicator.calculate(1);
        while (matrixMultiplicator.threadFinished < matrixMultiplicator.threadCount){
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long timeEnd = System.currentTimeMillis();

        System.out.println(((double)(timeEnd - time) / 1000) + " sec.");
    }

    public MatrixMultiplicator(int[][] matrix1, int[][] matrix2) {
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
    }

    private class MatrixRunnable implements Runnable{
        private int from;
        private int to;

        public MatrixRunnable(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public void run() {
            for (int i = from; i < to; i++)
                for (int j = 0; j < matrix1.length; j++)
                    for (int k = 0; k < matrix1.length; k++)
                        resultMatrix[i][j] += matrix1[i][k] * matrix2[k][j];

            //System.out.println("finished: " + from + " -> " + to);
            threadFinished++;
            //System.out.println(threadCount + " | " + threadFinished);
        }
    }

    public int[][] calculate(int threadCount){
        this.threadCount = threadCount;
        threadFinished = 0;
        resultMatrix = new int[matrix1.length][matrix1.length];
        int rowsMultiplied = 0;
        for (int t = 1; t <= threadCount; t++){
            int rowCount = (t != threadCount) ? matrix1.length / threadCount : matrix1.length - rowsMultiplied;
            new Thread(new MatrixRunnable(rowsMultiplied, rowsMultiplied + rowCount)).start();
            rowsMultiplied += rowCount;
        }

        return resultMatrix;
    }
}
