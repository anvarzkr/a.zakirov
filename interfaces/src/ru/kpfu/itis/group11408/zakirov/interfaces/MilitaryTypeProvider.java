package ru.kpfu.itis.group11408.zakirov.interfaces;

/**
 * Created by Anvar on 14.02.2015.
 */
public interface MilitaryTypeProvider {
    public enum MilitaryType{
        PEACEFUL,
        MILITARY
    };

    public MilitaryType getMilitaryType();
}
