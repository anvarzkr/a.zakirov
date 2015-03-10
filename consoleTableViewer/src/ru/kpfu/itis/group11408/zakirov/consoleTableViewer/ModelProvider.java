package ru.kpfu.itis.group11408.zakirov.consoleTableViewer;

import java.util.Comparator;

/**
 * Created by Anvar on 10.03.2015.
 */
public interface ModelProvider <T> {

    public Comparator<T> getComparator(T obj);

    public T[] getElements();

}
