package ru.kpfu.itis.group11408.zakirov.bank;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anvar on 05.05.2015.
 */
public class Bank {
    private long money;
    private List<Client> clients;

    public Bank(){
        clients = new ArrayList<>();
    }

    public void addMoney(long amount){
        this.money += amount;
    }

    public void removeMoney(long amount){
        this.money -= amount;
    }

    public long getMoney() {
        return money;
    }

    public void addClient(Client client){
        synchronized (client) {
            clients.add(client);
        }
    }

    public void removeClient(Client client){
        synchronized (client) {
            clients.remove(client);
        }
    }

    public List<Client> getClients() {
        return clients;
    }

    public boolean hasClient(Client client){
        synchronized (client) {
            return clients.contains(client);
        }
    }
}
