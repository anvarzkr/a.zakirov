package ru.kpfu.itis.group11408.zakirov.semestrWork2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by Anvar on 26.04.2015.
 */
public class Floyd {
    public static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int size = 5;
        Random random = new Random();
        int[][] W = new int[size][size];
        int[][] H = new int[size][size];
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                W[i][j] = (i == j) ? 0 : random.nextInt(5);
                if (W[i][j] == 0 && i != j)
                    W[i][j] = INF;
                H[i][j] = (W[i][j] == INF || W[i][j] == 0) ? 0 : (j + 1);
            }
        }

        print(W, H, false);

        for (int k = 0; k < size; k++){
            for (int i = 0; i < size; i++){
                for (int j = 0; j < size; j++){
                    if (W[i][k] < INF && W[k][j] < INF)
                        if (W[i][j] > W[i][k] + W[k][j]) {
                            W[i][j] = W[i][k] + W[k][j];
                            H[i][j] = H[i][k];
                        }
                }
            }
        }

        print(W, H, true);
    }

    private static void print(int[][] W, int[][] H, boolean printPath){
        System.out.println("W:");
        for (int[] r : W){
            for (int val : r)
                System.out.print(((val != INF) ? val : "*") + " ");
            System.out.println();
        }
        System.out.println("H:");
        for (int[] r : H){
            for (int val : r)
                System.out.print(val + " ");
            System.out.println();
        }
        if (!printPath)
            return;
        for (int i = 1; i <= W.length; i++){
            List list = getPath(H, 1, i);
            System.out.println();
            list.forEach(elem-> System.out.print(((list.indexOf(elem) == 0) ? "" : " -> ") + elem));
            System.out.println();
        }
    }

    private static List getPath(int[][] H, int from, int to){
        if (H[from - 1][to - 1] == 0)
            return new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        list.add(from);
        int i = from - 1, j = to - 1;
        while (H[i][j] != to){
            list.add(H[i][j]);
            i = H[i][j] - 1;
        }
        list.add(to);
        return list;
    }
}
