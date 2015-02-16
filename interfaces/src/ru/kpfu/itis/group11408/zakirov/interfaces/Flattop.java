package ru.kpfu.itis.group11408.zakirov.interfaces;

/**
 * Created by Anvar on 14.02.2015.
 */
public class Flattop extends Ship implements MilitaryTypeProvider{

    public MilitaryType getMilitaryType(){
        return MilitaryType.MILITARY;
    }

}
