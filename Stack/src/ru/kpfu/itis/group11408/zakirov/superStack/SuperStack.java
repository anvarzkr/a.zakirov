package ru.kpfu.itis.group11408.zakirov.superStack;

import java.util.*;

/**
 * Created by Anvar on 23.03.2015.
 */
public class SuperStack<T>{
    private final int MAX_SIZE = 100;
    private T[] stack = (T[])new Object[MAX_SIZE];
    private int size = 0;

    public T pop(){
        if (size == 0)
            throw new EmptyStackException();
        T returned = this.stack[--size];
        this.stack[size] = null;
        return returned;
    }

    public T peek(){
        if (size == 0)
            throw new EmptyStackException();
        return this.stack[size - 1];
    }

    public void push(T obj){
        this.stack[size++] = obj;
    }

    public int size(){
        return this.size;
    }

    public boolean empty(){
        return (this.size == 0);
    }

    public int search(Object obj){
        for (int i = 0; i < this.size; i++)
            if (obj.hashCode() == this.stack[i].hashCode())
                return i;

        return -1;
    }

}
