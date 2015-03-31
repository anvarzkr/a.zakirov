package ru.kpfu.itis.group11408.zakirov.arrayHashMap;

import java.util.*;
import java.util.function.BiConsumer;

/**
 * Created by Anvar on 28.03.2015.
 */
public class ArrayHashMap<K, V> implements Map<K, V>{
    private int size;
    LinkedList<Element>[] dictionary;

    public ArrayHashMap(int size){
        this.dictionary = new LinkedList[size];
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
        for (Element element: dictionary[getKeyIndex(key)])
            if (element.getKey() == key)
                return true;
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (int i = 0; i < dictionary.length; i++)
            for (Element element: dictionary[i])
                if (element.getValue() == value)
                    return true;
        return false;
    }

    @Override
    public V get(Object key) {
        for (Element element: dictionary[getKeyIndex(key)])
            if (element.getKey() == key)
                return (V) element.getValue();
        return null;
    }

    @Override
    public V put(K key, V value) {
        dictionary[getKeyIndex(key)].add(new Element(key, value));
        this.size++;
        return value;
    }

    @Override
    public V remove(Object key) {
        if (this.containsKey(key))
            if (dictionary[getKeyIndex(key)].remove(get(key))) {
                this.size--;
                return get(key);
            }

        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        m.forEach((k, v) -> this.put(k, v));
    }

    @Override
    public void clear() {
        for (int i = 0; i < dictionary.length; i++)
            dictionary[i].clear();
    }

    @Override
    public Set<K> keySet() {
        Set<K> set = new HashSet<>();
        for (int i = 0; i < dictionary.length; i++)
            dictionary[i].forEach((el) -> set.add((K)el.getKey()));
        return set;
    }

    @Override
    public Collection<V> values() {
        Collection<V> collection = new ArrayList<>();
        for (int i = 0; i < dictionary.length; i++)
            dictionary[i].forEach((el) -> collection.add((V)el.getValue()));
        return collection;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = new HashSet<>();
        for (int i = 0; i < dictionary.length; i++)
            dictionary[i].forEach((el) -> set.add(new Element<>((K) el.getKey(), (V) el.getValue())));
        return set;
    }

    public int getKeyIndex(Object o){
        return o.hashCode() % this.dictionary.length;
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
