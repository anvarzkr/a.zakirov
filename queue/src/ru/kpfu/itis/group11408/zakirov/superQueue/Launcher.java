package ru.kpfu.itis.group11408.zakirov.superQueue;

/**
 * Created by Anvar on 24.03.2015.
 */
public class Launcher {
    public static void main(String[] args) {
        SuperQueue<String> superQueue = new SuperQueue<>();
        superQueue.add("Anvar");
        superQueue.add("have");
        superQueue.add("maked");
        superQueue.add("his");
        superQueue.add("own");
        superQueue.add("Queue");
        superQueue.add("and");
        superQueue.add("printed");
        superQueue.add("this");
        superQueue.add("using");
        superQueue.add("his");
        superQueue.add("superQueue");

        while(superQueue.peek() != null){
            String str = superQueue.poll();
            System.out.println(str);
        }
    }
}
