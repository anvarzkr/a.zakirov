package ru.kpfu.itis.group11408.zakirov.classwork.date1402;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anvar on 14.02.2015.
 */
public class Solver {

    public static void main(String[] args) {
        new Solver().solve();
    }

    public void solve(){
        List<String> pairList = new ArrayList<String>();
        double[] a = new double[]{8.5, 9, 10, 11.5, 12, 14},
                b = new double[]{10, 11, 12, 13, 14, 15};
        int lastIndex = 0,
            cnt = Math.min(Math.min(a.length, b.length), 1);
        if (a.length != 0 && b.length != 0) pairList.add(a[lastIndex] + " - " + b[lastIndex]);

        for (int i = 1; i < Math.max(a.length, b.length); i++){
            if (b[lastIndex] <= a[i]){
                pairList.add(a[i] + " - " + b[i]);
                lastIndex = i;
                cnt++;
            }
        }
        System.out.println(cnt);
        for (String str : pairList)
            System.out.println(str);
    }
}
