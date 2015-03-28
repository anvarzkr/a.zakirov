package ru.kpfu.itis.group11408.zakirov.arrayHashMap;

import java.util.*;

/**
 * Created by Anvar on 28.03.2015.
 */
public class ArrayHashMap<K, V> implements Map<K, V>{
    private int size;
    LinkedList<Element>[] dictinary;

    public ArrayHashMap(int size){
        this.dictinary = new LinkedList[size];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override

    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        for (Element element: dictinary[getKeyIndex(key)])
            if (element.getKey() == key)
                return true;
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (Element element: dictinary[getKeyIndex(value)])
            if (element.getKey() == value)
                return true;
        return false;
    }

    @Override
    public V get(Object key) {
        for (Element element: dictinary[getKeyIndex(key)])
            if (element.getKey() == key)
                return null;//element.getKey();
        return null;
    }

    @Override
    public V put(K key, V value) {
        return null;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    public int getKeyIndex(Object o){
        return o.hashCode() % this.dictinary.length;
    }

    private class Element<K, V> implements Entry<K, V>{
        private K key;
        private V value;

        public Element(K key, V value){
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }

        @Override
        public V setValue(V value) {
            return (this.value = value);
        }
    }
}
