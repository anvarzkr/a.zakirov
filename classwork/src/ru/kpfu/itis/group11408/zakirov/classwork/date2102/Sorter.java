package ru.kpfu.itis.group11408.zakirov.classwork.date2102;

/**
 * Created by Anvar on 21.02.2015.
 */
public class Sorter {
    public static void main(String[] args) {

        int[] a = new int[]{5, 3, 8, 6, 4, 0, 3, -6, -2, 4, 15, -43, 34, -8};
        for (int val : a)
            System.out.print(val + " ");

        Sorter.bubbleSort(a);

        System.out.println();
        for (int val : a)
            System.out.print(val + " ");
    }

    public static int[] sort(int[] a){
        for (int i = 0; i < a.length; i++) {
            int mnPos = i;

            for (int j = i + 1; j < a.length; j++)
                if (a[j] < a[mnPos])
                    mnPos = j;

            if (mnPos != i) {
                int tmp = a[i];
                a[i] = a[mnPos];
                a[mnPos] = tmp;
            }
        }
        return a;
    }

    public static int[] bubbleSort(int[] a){
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a.length - 1; j++)
                if (a[j] > a[j + 1]){
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }

        return a;
    }
}
