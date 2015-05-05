package ru.kpfu.itis.group11408.zakirov.thread;

/**
 * Created by Anvar on 05.05.2015.
 */
public class DeadLock {

    private final int[] a1 = new int[0];
    private final int[] a2 = new int[0];

    class DeadLockMaker implements Runnable{

        @Override
        public void run() {
            while(true) {
                someMethod1();
                someMethod2();
            }
        }
    }

    public void someMethod1(){
        synchronized (a1){
            try{
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (a2){
                System.out.println("Завершил первый метод");
            }
        }
    }

    public void someMethod2(){
        synchronized (a2){
            try{
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (a1){
                System.out.println("Завершил второй метод");
            }
        }
    }

    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();
        for (int i = 0; i < 10; i++){
            new Thread(deadLock.new DeadLockMaker()).start();
        }
    }
}
