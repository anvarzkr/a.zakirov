package ru.kpfu.itis.group11408.zakirov.semestrWork2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by Anvar on 26.04.2015.
 */
public class Floyd {
    private static int INF = Integer.MAX_VALUE;
    private int[][] W;
    private int[][] H;

    public static void main(String[] args) {
        int size = 5;
        Random random = new Random();
        int[][] W = new int[size][size];
        int[][] H = new int[size][size];
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                W[i][j] = (i == j) ? 0 : random.nextInt(5) + 1;
                if (W[i][j] == 0 && i != j)
                    W[i][j] = INF;
                H[i][j] = (W[i][j] == INF || W[i][j] == 0) ? 0 : (j + 1);
            }
        }

        Floyd floyd = new Floyd(W, H);

        System.out.println("Ishodnye matrici smejnosti i istorii:");
        floyd.print(false);
        long time = System.currentTimeMillis();
        floyd.run();
        long timeAlg = System.currentTimeMillis() - time;
        System.out.println();
        System.out.println("Konechnie matrici rasstoyanij i putey:");
        floyd.print(true);

        System.out.println(((double)timeAlg / 1000) + " seconds.");
    }

    public Floyd(int[][] W, int[][] H){
        this.W = W;
        this.H = H;
    }

    private void print(boolean printPath){
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
        System.out.println();
        for (int i = 1; i <= W.length; i++)
            for (int j = 1; j <= W.length; j++){
                List<Integer> list = this.getPath(i, j);
                if (list.size() == 0)
                    continue;
                list.forEach(elem -> System.out.print(((list.indexOf(elem) == 0) ? "" : " -> ") + elem));
                System.out.println();
            }
    }

    private List<Integer> getPath(int from, int to){
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

    public void run(){
        for (int k = 0; k < W.length; k++){
            for (int i = 0; i < W.length; i++){
                for (int j = 0; j < W.length; j++){
                    if (W[i][k] < INF && W[k][j] < INF)
                        if (W[i][j] > W[i][k] + W[k][j]) {
                            W[i][j] = W[i][k] + W[k][j];
                            H[i][j] = H[i][k];
                        }
                }
            }
        }
    }
}
