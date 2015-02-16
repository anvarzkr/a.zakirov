package ru.kpfu.itis.group11408.zakirov.interfaces;

/**
 * Created by Anvar on 14.02.2015.
 */
public class Launcher {
    public static void main(String[] args) {
        MilitaryTypeProvider warShip = new Flattop(),
                peaceShip = new CruiseLiner(),
                warPlane = new WarPlane(),
                peacePlane = new Boing();

        printType("Flattop's military type is ", warShip.getMilitaryType());
        printType("Cruise Liner's military type is ", peaceShip.getMilitaryType());
        printType("War Plane's military type is ", warPlane.getMilitaryType());
        printType("Boing's military type is ", peacePlane.getMilitaryType());
    }

    public static void printType(String str, MilitaryTypeProvider.MilitaryType type){
        String out;
        switch (type){
            case MILITARY:
                out = "Military";
                break;
            case PEACEFUL:
                out = "Peaceful";
                break;
            default:
                out = "Unknown";
                break;
        }
        System.out.println(str + " " + out);
    }
}
