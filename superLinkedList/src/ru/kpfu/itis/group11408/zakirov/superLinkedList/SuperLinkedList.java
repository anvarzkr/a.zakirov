package ru.kpfu.itis.group11408.zakirov.superLinkedList;

import java.util.*;

/**
 * Created by Anvar on 14.03.2015.
 */
public class SuperLinkedList<T> implements List<T>{
    private int size = 0;
    private SuperLinkedItem first;
    private SuperLinkedItem last;

    public SuperLinkedItem getFirst() {
        return first;
    }

    public void setFirst(SuperLinkedItem first) {
        this.first = first;
    }

    public SuperLinkedItem getLast() {
        return last;
    }

    public void setLast(SuperLinkedItem last) {
        this.last = last;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return (this.size == 0) ? true : false;
    }

    @Override
    public boolean contains(Object o) {
        /// КОСТЫЛЬ

        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            SuperLinkedItem<T> current;

            @Override
            public boolean hasNext() {
                return (first == null) ? false : true;
            }

            @Override
            public T next() {
                //return first.getNext().getData();
                return null;
            }
        };
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        if (this.last == null){
            //this.first = new SuperLinkedItem();
            //this.last = new SuperLinkedItem();
        }else{

        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

}
