package ru.kpfu.itis.group11408.zakirov.classwork.date0303;

/**
 * Created by Anvar on 03.03.2015.
 */
public interface Colorable {
    public enum COLOR {
        RED,
        GREEN,
        YELLOW
    };

    public COLOR getColor();

    default public void printColor(){
        String color = "";
        switch (this.getColor()){
            case RED:
                color = "red";
                break;
            case GREEN:
                color = "green";
                break;
            default:
                color = "undefined";
        }
        System.out.println(color);
    }
}
