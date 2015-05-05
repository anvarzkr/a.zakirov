package ru.kpfu.itis.group11408.zakirov.thread;

/**
 * Created by Anvar on 05.05.2015.
 */
public class SyncExample {

    private class Changer implements Runnable{
        private int diff;
        private String name;

        public Changer(int diff, String name) {
            super();
            this.diff = diff;
            this.name = name;
        }

        @Override
        public void run() {
            change(diff);
        }
    }

    private final int[] array = new int[3];
    private int currIndex = 0;

    public static void main(String[] args) {

    }

    public SyncExample(){
    }

    public void change(int diff){
        currIndex += diff;
        array[currIndex]++;
    }
}
