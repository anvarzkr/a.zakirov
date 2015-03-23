package ru.kpfu.itis.group11408.zakirov.consoleTableViewer;

import java.util.Comparator;

/**
 * Created by Anvar on 10.03.2015.
 */
public class Launcher {
    private static final int NOT_NULL = 99;

    public static void main(String[] args) {
        studentsTable();
        animalsTable();

    }

    public static void animalsTable(){
        Animal[] animals = new Animal[]{
                new Animal(5, 2001, "Tiger", "AAAARra"),
                new Animal(3, 2007, "Mouse", "Pipipi"),
                new Animal(10, 1998, "Fly", "Bzzzzzz"),
                new Animal(0, 2010, "Dog", "Davvvv"),
                new Animal(1, 2015, "Cat", "Meow"),
                new Animal(4, 1995, "Elephant", "WOooohOO"),
        };

        ModelProvider<Animal> modelProvider = new ModelProvider<Animal>() {
            @Override
            public Comparator<Animal> getComparator(Animal obj) {
                return AnimalHelper.getNameComparator();
            }

            @Override
            public Animal[] getElements() {
                return animals;
            }
        };

        ViewProvider<Animal> viewProvider = new ViewProvider<Animal>() {

            String[] labels = new String[]{
                    "Gunger",
                    "Year",
                    "Name",
                    "Roar"
            };

            @Override
            public int getColumnCount() {
                return labels.length;
            }

            @Override
            public String getLabel(Animal obj, int columnIndex) {
                String returnLabel = "";
                switch (columnIndex){
                    case 0:
                        returnLabel = "" + obj.hungry;
                        break;
                    case 1:
                        returnLabel = "" + obj.year;
                        break;
                    case 2:
                        returnLabel = "" + obj.name;
                        break;
                    case 3:
                        returnLabel = "" + obj.roar;
                        break;
                    default:
                        returnLabel = "Unknown value";
                }

                return returnLabel;
            }

            @Override
            public String getHeader(int columnIndex) {
                return labels[columnIndex];
            }
        };

        ConsoleTableViewer<Animal> consoleTableViewer = new ConsoleTableViewer<>(modelProvider, viewProvider);
        consoleTableViewer.show();
    }

    public static void studentsTable(){
        Student[] students = new Student[]{
                new Student(100, 1996, "Anvar"),
                new Student(77, 1995, "Leha"),
                new Student(99, 1996, "Danil"),
                new Student(88, 1997, "Maks"),
                new Student(1, 1, "Arthur")
        };

        ModelProvider<Student> modelProvider = new ModelProvider<Student>() {
            @Override
            public Comparator<Student> getComparator(Student obj) {
                return StudentHelper.getNameComparator();
            }

            @Override
            public Student[] getElements() {
                return students;
            }
        };

        ViewProvider<Student> viewProvider = new ViewProvider<Student>() {

            String[] labels = new String[]{
                    "Name",
                    "Year",
                    "Rating"
            };

            @Override
            public int getColumnCount() {
                return 3;
            }

            @Override
            public String getLabel(Student obj, int columnIndex) {
                String returnLabel = "";
                switch (columnIndex){
                    case 0:
                        returnLabel = obj.name;
                        break;
                    case 1:
                        returnLabel = "" + obj.year;
                        break;
                    case 2:
                        returnLabel = "" + obj.grade;
                        break;
                    default:
                        returnLabel = "Unknown value";
                }

                return returnLabel;
            }

            @Override
            public String getHeader(int columnIndex) {
                return labels[columnIndex];
            }
        };

        ConsoleTableViewer<Student> consoleTableViewer = new ConsoleTableViewer<>(modelProvider, viewProvider);
        consoleTableViewer.show();
    }
}
