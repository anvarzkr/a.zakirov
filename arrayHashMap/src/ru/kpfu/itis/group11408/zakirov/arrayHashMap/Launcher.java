package ru.kpfu.itis.group11408.zakirov.arrayHashMap;

/**
 * Created by Anvar on 31.03.2015.
 */
public class Launcher {
    public static void main(String[] args) {
        ArrayHashMap<Integer, String> arrayHashMap = new ArrayHashMap<>(10);
        System.out.println();
        arrayHashMap.put(0, "Zero");
        arrayHashMap.put(1, "One");
        arrayHashMap.put(2, "Two");
        arrayHashMap.put(3, "Three");
        arrayHashMap.put(4, "Four");
        arrayHashMap.put(5, "Five");
        System.out.println("0 :" + arrayHashMap.get(0));
        System.out.println("1 :" + arrayHashMap.get(1));
        System.out.println("2 :" + arrayHashMap.get(2));
        System.out.println("3 :" + arrayHashMap.get(3));
        System.out.println("4 :" + arrayHashMap.get(4));
        System.out.println("5 :" + arrayHashMap.get(5));
        System.out.println();
    }
}
