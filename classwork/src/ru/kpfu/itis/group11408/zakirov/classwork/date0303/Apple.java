package ru.kpfu.itis.group11408.zakirov.classwork.date0303;

/**
 * Created by Anvar on 03.03.2015.
 */
public class Apple implements Colorable{
    public static void main(String[] args) {
        Colorable fruit= new Apple();
        fruit.printColor();
    }

    @Override
    public COLOR getColor() {
        return COLOR.RED;
    }


}


