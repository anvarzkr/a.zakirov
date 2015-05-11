package ru.kpfu.itis.group11408.zakirov.bank;

/**
 * Created by Anvar on 05.05.2015.
 */
public class Client {
    private int id;
    private long money;

    public Client(int id, long money){
        this.id = id;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public boolean equals(Object obj){
        return this.hashCode() == obj.hashCode();
    }

    public int hashCode(){
        return id;
    }
}
