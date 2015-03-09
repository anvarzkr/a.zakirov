package ru.kpfu.itis.group11408.zakirov.sorting;

public class MergeSorter {

    public static int[] sort(int[] arr){
        if (arr.length < 2)
            return arr;

        int[] _arrL = new int[arr.length / 2];
        int[] _arrR = new int[arr.length - (arr.length / 2)];

        System.arraycopy(arr, 0, _arrL, 0, _arrL.length);
        System.arraycopy(arr, _arrL.length, _arrR, 0, _arrR.length);

        return merge(sort(_arrL), sort(_arrR));
    }

    private static int[] merge(int[] arr1, int[] arr2){
        int[] merged = new int[arr1.length + arr2.length];

        for (int i = 0, k1 = 0, k2 = 0; i < arr1.length + arr2.length; i++){
            if (k1 < arr1.length)
                if (k2 >= arr2.length || arr1[k1] < arr2[k2])
                    merged[i] = arr1[k1++];
            else
                merged[i] = arr2[k2++];
        }

        return merged;
    }
}
