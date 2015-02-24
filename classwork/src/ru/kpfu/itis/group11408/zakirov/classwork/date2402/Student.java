package ru.kpfu.itis.group11408.zakirov.classwork.date2402;

import java.util.Comparator;

/**
 * Created by Anvar on 24.02.2015.
 */
public class Student {
    public final int grade;
    public final int year;
    public final String name;

    public Student(int grade, int year, String name){
        this.grade = grade;
        this.year = year;
        this.name = name;
    }

    public String toString(){
        return this.grade + " " + this.year + " " + this.name  ;
    }

}
