package ru.kpfu.itis.group11408.zakirov.consoleTableViewer;

/**
 * Created by Anvar on 10.03.2015.
 */
public interface ViewProvider <T> {

    public int getColumnCount();

    public String getLabel(T obj, int columnIndex);

    public String getHeader(int columnIndex);

}
