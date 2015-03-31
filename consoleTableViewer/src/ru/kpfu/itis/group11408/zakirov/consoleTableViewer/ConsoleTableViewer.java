package ru.kpfu.itis.group11408.zakirov.consoleTableViewer;

import java.util.Comparator;
import java.util.Formatter;

/**
 * Created by Anvar on 10.03.2015.
 */
public class ConsoleTableViewer <T> {
    private ModelProvider<T> modelProvider;
    private ViewProvider<T> viewProvider;

    public ConsoleTableViewer(ModelProvider<T> modelProvider, ViewProvider<T> viewProvider){
        this.modelProvider = modelProvider;
        this.viewProvider = viewProvider;
    }

    public void show(){
        T[] objects = modelProvider.getElements();

        System.out.println();
        System.out.println("Console Table Viewer:");
        System.out.println();

        String formatTemplate = "| %-15s ";
        String formatBorderTemplate = "+-----------------";
        String formatBorder = "+%n";
        String leftAlignFormat = "|%n";

        for (int i = 0; i < viewProvider.getColumnCount(); i++) {
            leftAlignFormat = formatTemplate + leftAlignFormat;
            formatBorder = formatBorderTemplate + formatBorder;
        }

        System.out.format(formatBorder);

        String[] labels = new String[viewProvider.getColumnCount()];
        for (int i = 0; i < labels.length; i++)
            labels[i] = viewProvider.getHeader(i);
        System.out.format(leftAlignFormat, labels);

        System.out.format(formatBorder);

        for (int i = 0; i < objects.length; i++) {
            for (int j = 0; j < labels.length; j++)
                labels[j] = viewProvider.getLabel(objects[i], j);

            System.out.format(leftAlignFormat, labels);
        }

        System.out.format(formatBorder);
    }

    public void setModelProvider(ModelProvider<T> modelProvider){
        this.modelProvider = modelProvider;
    }

    public void setViewProvider(ViewProvider<T> viewProvider){
        this.viewProvider = viewProvider;
    }
}
