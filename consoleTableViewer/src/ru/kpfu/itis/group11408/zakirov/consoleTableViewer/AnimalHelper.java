package ru.kpfu.itis.group11408.zakirov.consoleTableViewer;

import java.util.Comparator;

/**
 * Created by Anvar on 10.03.2015.
 */
public class AnimalHelper {
    private static final int NOT_NULL = 99;

    public static Comparator<Animal> getNameComparator(){
        return new Comparator<Animal>() {
            @Override
            public int compare(Animal o1, Animal o2) {
                return (o1.name.equals(o2.name)) ? 0 : ((o1.name.compareTo(o2.name) > 0 ) ? 1 : -1);
            }
        };
    }

    /*public static int checkForNull(String o1, String o2){
        if (o1 == null && o2 == null)
            return 0;
        else if (o1 == null)
            return 1;
        else if (o2 == null)
            return -1;

        return NOT_NULL;
    }

    public static int checkForNull(String o1, String o2){
        if (o1 == null && o2 == null)
            return 0;
        else if (o1 == null)
            return 1;
        else if (o2 == null)
            return -1;

        return NOT_NULL;
    }*/
}
