package ru.kpfu.itis.group11408.zakirov.bank;

/**
 * Created by Anvar on 05.05.2015.
 */
public class ATM {
    private long money;
    private Bank ownerBank;

    public ATM(Bank bank, long money){
        this.money = money;
        this.ownerBank = bank;
        this.ownerBank.addMoney(this.money);
    }

    public long getMoney(Client client) {
        if (!ownerBank.hasClient(client))
            return 0;
        return money;
    }

    public void putMoney(Client client, long amount) {
        if(client.getMoney() < amount || !ownerBank.hasClient(client) || ownerBank.getMoney() + amount < 0)
            return;
        this.money += amount;
        ownerBank.addMoney(amount);
        if (client.getMoney() + amount > 0) {
            client.setMoney(client.getMoney() + amount);
            System.out.println("Client " + client.getId() + " has " + client.getMoney() + "$ and " + (amount >= 0 ? "gets" : "puts") + " " + Math.abs(amount) + "$");
        }
    }

}
