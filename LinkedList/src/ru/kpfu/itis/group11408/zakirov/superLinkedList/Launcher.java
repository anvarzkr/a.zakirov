package ru.kpfu.itis.group11408.zakirov.superLinkedList;

import java.util.Iterator;

/**
 * Created by Anvar on 23.03.2015.
 */
public class Launcher {
    public static void main(String[] args) {
        SuperLinkedList<String> stringList = new SuperLinkedList<>();
        String anvarName = "Anvar";
        stringList.add(anvarName);
        stringList.add("have");
        stringList.add("done");
        stringList.add("this");
        stringList.add("task");
        stringList.add("!");

        Iterator<String> iterator = stringList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println();
        stringList.remove(0);
        stringList.add(0, "I");
        stringList.set(stringList.size(), "?");

        iterator = stringList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
