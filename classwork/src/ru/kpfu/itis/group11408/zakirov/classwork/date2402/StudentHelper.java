package ru.kpfu.itis.group11408.zakirov.classwork.date2402;

import java.util.Comparator;

/**
 * Created by Anvar on 24.02.2015.
 */
public class StudentHelper {

    private static final int NOT_NULL = 99;
    public static Comparator<Student> getGradeComparator(){
        return new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int nullCheck = checkForNull(o1, o2);
                if (nullCheck != NOT_NULL)
                    return nullCheck;

                return (o1.grade == o2.grade) ? 0 : ((o1.grade > o2.grade) ? 1 : -1);
            }
        };
    }

    public static Comparator<Student> getYearComparator(){
        return new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int nullCheck = checkForNull(o1, o2);
                if (nullCheck != NOT_NULL)
                    return nullCheck;

                return (o1.year == o2.year) ? 0 : ((o1.year > o2.year) ? 1 : -1);
            }
        };
    }

    public static Comparator<Student> getNameComparator(){
        return new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int nullCheck = checkForNull(o1, o2);
                if (nullCheck != NOT_NULL)
                    return nullCheck;

                nullCheck = checkForNull(o1.name, o2.name);
                if (nullCheck != NOT_NULL)
                    return nullCheck;

                return (o1.name.equals(o2.name)) ? 0 : ((o1.name.compareTo(o2.name) > 0 ) ? 1 : -1);
            }
        };
    }

    public static int checkForNull(Student o1, Student o2){
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
    }

}
