package ru.kpfu.itis.group11408.zakirov.binTreeMap;

import java.util.Arrays;

/**
 * Created by Anvar on 04.04.2015.
 */
public class Launcher {
    public static void main(String[] args) {
        binTreeMap<String, String> binTreeMap = new binTreeMap<>();
        binTreeMap.put("anvar", "csgo");
        binTreeMap.put("diana", "dota2");
        binTreeMap.put("sasha", "rak");


        String[] strings = new String[]{
                binTreeMap.get("sasha"),
                binTreeMap.get("diana"),
                binTreeMap.get("anvar")
        };
        Arrays.sort(strings);
        for (String str: strings)
            System.out.println(str);
    }
}
