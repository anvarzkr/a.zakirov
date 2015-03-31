package ru.kpfu.itis.group11408.zakirov.superLinkedList;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

/**
 * Created by Anvar on 14.03.2015.
 */
public class SuperLinkedList<T> implements List<T>{

    private SuperLinkedItem<T> first = null;
    private SuperLinkedItem<T> last = null;

    @Override
    public int size() {

        int size = 0;

        if (first == null) {
            return 0;
        }

        for (SuperLinkedItem<T> iter = first; iter != null; iter = iter.getNext(), size++);

        return size;

    }

    @Override
    public boolean isEmpty() {
        return (first == null);
    }

    @Override
    public boolean contains(Object o) {
        SuperLinkedItem<T> el = first;
        while (el != null) {
            if (o == null || el.getData() == null) {
                if (o == el.getData()) {
                    return true;
                }
            } else if (o.equals(el.getData())) {
                return true;
            }
            el = el.getNext();
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return new Iterator(){
            private SuperLinkedItem<T> node = new SuperLinkedItem<T>(null, first);
            private SuperLinkedItem<T> previous = null;

            public T o() {
                if (node == null) {
                    throw new NoSuchElementException();
                }
                return node.getData();
            }

            public T next() {
                if (node == null || node.getNext() == null) {
                    throw new NoSuchElementException();
                }
                previous = node;
                node = node.getNext();
                return node.getData();
            }

            public boolean hasNext() {
                return node != null && node.getNext() != null;
            }
        };
    }

    @Override
    public Object[] toArray() {
        Object[] objects = new Object[this.size()];

        int i = 0;
        for (SuperLinkedItem<T> iter = first; iter != null; iter = iter.getNext(), i++)
            objects[i] = iter.getData();

        return objects;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T o) {

        if (first == null) {
            first = new SuperLinkedItem<T>(o);
            last = first;
        }else{
            SuperLinkedItem<T> newLast = new SuperLinkedItem<T>(o);
            last.setNext(newLast);
            last = newLast;
        }

        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (SuperLinkedItem<T> iter = first; iter != null; iter = iter.getNext())
            if (iter.getData() == o)
                return true;

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        Iterator iterator = c.iterator();
        int amount = 0;

        while(iterator.hasNext()){
            Object obj = iterator.next();

            for (SuperLinkedItem<T> iter = first; iter != null; iter = iter.getNext())
                if (obj == iter.getData())
                    amount++;
        }

        return (amount == c.size()) ? true : false;
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
    public boolean addAll(Collection c) {
        Iterator<T> iterator = c.iterator();

        while(iterator.hasNext()){
            T obj = iterator.next();

            this.add(obj);
        }

        return true;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        Iterator<T> iterator = c.iterator();

        while(iterator.hasNext()){
            T obj = iterator.next();

            this.add(obj);
        }

        return true;
    }

    @Override
    public void add(int index, T o) {
        if (index == size()) {
            add(o);
        }
        SuperLinkedItem<T> elem;

        if (index == 0) {
            elem = first;
        } else {
            elem = getSuperLinkedItem(index - 1);
        }

        SuperLinkedItem<T> afterNext = elem.getNext();
        SuperLinkedItem<T> newNext = new SuperLinkedItem<T>(o, afterNext);

        elem.setNext(newNext);

        if (elem == last) {
            last = newNext;
        }

    }

    @Override
    public void clear() {

        first = null;
        last = null;

    }

    @Override
    public int indexOf(Object o) {

        SuperLinkedItem<T> el = first;
        
        int k = -1;

        while (el != null) {
            k++;
            if (o == null || el.getData() == null) {
                if (el.getData() == o) {
                    return k;
                }
            } else if (o.equals(el.getData())) {
                return k;
            }
            el = el.getNext();
        }
        return k;
    }

    @Override
    public int lastIndexOf(Object o) {
        SuperLinkedItem<T> el = first;
        int k = -1;
        int n = -1;
        while (el != null) {
            k++;
            if (o == null || el.getData() == null) {
                if (el.getData() == o) {
                    n = k;
                }
            } else if (o.equals(el.getData())) {
                n = k;
            }
            el = el.getNext();
        }
        return n;
    }

    @Override
    public T set(int index, T element) {
        SuperLinkedItem<T> el = getSuperLinkedItem(index - 1);
        T t = el.getData();
        el.setData(element);
        return t;
    }

    @Override
    public T remove(int index) {

        if (first == null) {
            throw new IndexOutOfBoundsException("Unable to delete element from empty list");
        }

        if (index == 0) {

            first = first.getNext();

            if (first == null) {
                last = null;
            }

            return null;

        }

        SuperLinkedItem<T> previousSuperLinkedItem = getSuperLinkedItem(index - 1);
        SuperLinkedItem<T> elemForDelete = previousSuperLinkedItem.getNext();

        if (elemForDelete == null) {
            throw new IndexOutOfBoundsException("Deleting element that doesn't exist");
        }

        previousSuperLinkedItem.setNext(elemForDelete.getNext());

        return null;
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
        Iterator<T> iterator = this.iterator();
        SuperLinkedList<T> returnList = new SuperLinkedList<>();

        int i = 0;
        while(iterator.hasNext()){
            if (i > toIndex)
                break;

            T obj = iterator.next();

            if (i >= fromIndex)
                returnList.add(obj);

            i++;
        }
        return returnList;
    }

    @Override
    public T get(int index) {
        return getSuperLinkedItem(index).getData();
    }

    public T getFirst() {

        if (first == null) {
            throw new NoSuchElementException();
        }

        return first.getData();

    }

    public T getLast() {

        if (last == null) {
            throw new NoSuchElementException();
        }

        return last.getData();

    }

    @Override
    public String toString() {

        SuperLinkedItem<T> el = first;
        String st = "";
        while (el != null) {
            System.out.print(el.getData() + " ");
            el = el.getNext();
        }
        System.out.println();
        return st;

    }

    private SuperLinkedItem<T> getSuperLinkedItem(int index) {

        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Unable to get element by specified index" + index);
        }

        SuperLinkedItem<T> elem = first;

        for (int i = 0; i < index; i++, elem = elem.getNext());

        return elem;

    }

}