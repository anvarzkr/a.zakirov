package ru.kpfu.itis.group11408.zakirov.superQueue;

import java.util.*;

/**
 * Created by Anvar on 24.03.2015.
 */
public class SuperQueue <T>{
    private final int MAX_SIZE = 100;
    private T[] queue = (T[])new Object[MAX_SIZE];
    private int size = 0;

    public T remove(){
        if (this.size == 0)
            throw new NoSuchElementException("Cant remove head element if queue if empty!");

        T returned = this.queue[0];

        for (int i = 0; i < this.size - 1; i++)
            this.queue[i] = this.queue[i + 1];

        this.size--;

        return returned;
    }

    public T poll(){
        if (this.size == 0)
            return null;

        T returned = this.queue[0];

        for (int i = 0; i < this.size - 1; i++)
            this.queue[i] = this.queue[i + 1];

        this.size--;

        return returned;
    }

    public T peek(){
        return (this.size == 0) ? null : this.queue[0];
    }

    public T element(){
        if (this.size == 0)
            throw new NoSuchElementException("Cant return the head element if queue if empty!");
        return this.queue[0];
    }

    public void add(T obj){
        if (size >= MAX_SIZE)
            throw new IllegalStateException("Cant push an element when queue is full!");
        this.queue[size++] = obj;
    }

    public void offer(T obj){
        add(obj);
    }

    public int search(Object obj){
        for (int i = 0; i < this.size; i++)
            if (obj.hashCode() == this.queue[i].hashCode())
                return i;

        return -1;
    }
}
