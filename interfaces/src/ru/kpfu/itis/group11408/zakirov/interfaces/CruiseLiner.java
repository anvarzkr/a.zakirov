package ru.kpfu.itis.group11408.zakirov.interfaces;

/**
 * Created by Anvar on 14.02.2015.
 */
public class CruiseLiner extends Ship implements MilitaryTypeProvider {
    @Override
    public MilitaryType getMilitaryType() {
        return MilitaryType.PEACEFUL;
    }
}
