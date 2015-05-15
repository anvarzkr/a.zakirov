package ru.kpfu.itis.group11408.zakirov.bank;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by Anvar on 12.05.2015.
 */
public class Launcher {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Random random = new Random();
        for (int i = 0; i < 10; i++)
            bank.addClient(new Client(i, Math.abs(random.nextInt(2000))));

        List<ATM> atms = new LinkedList<>();
        atms.add(new ATM(bank, Math.abs(random.nextInt(20000))));
        atms.add(new ATM(bank, Math.abs(random.nextInt(20000))));
        atms.add(new ATM(bank, Math.abs(random.nextInt(20000))));
        atms.add(new ATM(bank, Math.abs(random.nextInt(20000))));

        List<Client> clients = bank.getClients();

        for (int i = 0; i < 50; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    atms.get(random.nextInt(atms.size())).putMoney(clients.get(random.nextInt(clients.size())), random.nextInt(2000) - 1000);
                }
            }).start();
        }

    }
}
