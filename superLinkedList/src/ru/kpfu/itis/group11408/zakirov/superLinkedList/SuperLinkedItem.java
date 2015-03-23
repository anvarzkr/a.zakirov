package ru.kpfu.itis.group11408.zakirov.superLinkedList;

/**
 * Created by Anvar on 14.03.2015.
 */
public class SuperLinkedItem<T> {
    private T data;
    private SuperLinkedItem next = null;

    public SuperLinkedItem(T obj) {
        this.data = obj;
    }

    public SuperLinkedItem(T obj, SuperLinkedItem next) {
        this.data = obj;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data){
        this.data = data;
    }

    public void setNext(SuperLinkedItem next) {
        this.next = next;
    }

    public SuperLinkedItem getNext() {
        return next;
    }
}
