package ru.kpfu.itis.group11408.zakirov.superLinkedList;

/**
 * Created by Anvar on 14.03.2015.
 */
public class SuperLinkedItem<T> {
    private SuperLinkedItem<T> previous;
    private SuperLinkedItem<T> next;
    private T data;

    public SuperLinkedItem(T data, SuperLinkedItem<T> previous){

    }

    public SuperLinkedItem<T> getPrevious() {
        return previous;
    }

    public void setPrevious(SuperLinkedItem<T> previous) {
        this.previous = previous;
    }

    public SuperLinkedItem<T> getNext() {
        return next;
    }

    public void setNext(SuperLinkedItem<T> next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T item) {
        this.data = item;
    }
}
