package ru.kpfu.itis.group11408.zakirov.classwork.date2402;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Anvar on 24.02.2015.
 */
public class Launcher {
    public static void main(String[] args) {
        Student[] students = new Student[]{
                new Student(100, 1996, "Anvar"),
                new Student(77, 1995, "Leha"),
                new Student(99, 1996, "Danil"),
                new Student(88, 1997, "Maks"),
                null,
                new Student(1, 1, null)
        };

        insertionSort(students, StudentHelper.getGradeComparator());
        print(students, "sort by grade");

        insertionSort(students, StudentHelper.getYearComparator());
        print(students, "sort by year");
        insertionSort(students, StudentHelper.getNameComparator());
        print(students, "sort by name");
    }

    public static void print(Student[] students, String string){
        System.out.println();
        System.out.println(string);
        for (Student student : students)
            System.out.println(student);
        System.out.println();
    }

    public static Student[] insertionSort(Student[] students, Comparator<Student> comparator){
        for (int i = 0; i < students.length; i++)
            for (int j = 0; j < students.length - 1; j++)
                if (comparator.compare(students[j], students[j + 1]) >= 0){
                    Student temp_student = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp_student;
                }
        return students;
    }
}
