package ru.kpfu.itis.group11408.zakirov.graph;

/**
 * Created by Anvar on 20.04.2015.
 */
public class Vedge<T> {
    private T value;

    public Vedge(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public boolean equals(Vedge vedge){
        return this.value.equals(vedge.value);
    }
}
