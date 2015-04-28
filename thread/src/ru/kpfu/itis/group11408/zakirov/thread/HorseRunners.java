package ru.kpfu.itis.group11408.zakirov.thread;

import java.util.Random;

/**
 * Created by Anvar on 25.04.2015.
 */
public class HorseRunners {
    public static void main(String[] args) {
        Random random = new Random();
        String[] horseNames = new String[]{
                "Horse1",
                "Horse2",
                "Horse3",
                "Horse4",
                "Horse5",
        };
        for (int i = 0; i < horseNames.length; i++){
            final int horseIndex = i;
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    int steps = 0;
                    while (steps < 100){
                        System.out.println(horseNames[horseIndex] + " прошла " + (steps += random.nextInt(5) + 1) + " шагов!");
                        try{
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Thread.yield();
                    }
                    System.out.println(horseNames[horseIndex] + " только что финишировала!");
                }
            });
            thread.start();

        }
    }
}
