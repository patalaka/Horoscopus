package ua.com.myapps.horoscopus.core;

import java.util.ArrayList;
import java.util.List;

import ua.com.myapps.horoscopus.R;

/**
* Creating horoscope information
*/
public class HoroscopeLab {
    private static List<OneHoroscopeInfo> mAllHoroscopesConfig;

    private HoroscopeLab(){
        mAllHoroscopesConfig = new ArrayList<>();
        mAllHoroscopesConfig.add(new OneHoroscopeInfo(R.string.com, R.color.com_color, R.drawable.ic_com, R.drawable.bac_com, "com"));
        mAllHoroscopesConfig.add(new OneHoroscopeInfo(R.string.ero, R.color.ero_color, R.drawable.ic_ero, R.drawable.bac_erotic, "ero"));
        mAllHoroscopesConfig.add(new OneHoroscopeInfo(R.string.lov, R.color.love_color, R.drawable.ic_lov, R.drawable.bac_love, "lov"));
        mAllHoroscopesConfig.add(new OneHoroscopeInfo(R.string.bus, R.color.bus_color, R.drawable.ic_bus, R.drawable.bac_bus, "bus"));
        mAllHoroscopesConfig.add(new OneHoroscopeInfo(R.string.hea, R.color.hea_color, R.drawable.ic_hea, R.drawable.bac_hea, "hea"));
        mAllHoroscopesConfig.add(new OneHoroscopeInfo(R.string.cook, R.color.cook_color, R.drawable.ic_cook, R.drawable.bac_cook, "cook"));
        mAllHoroscopesConfig.add(new OneHoroscopeInfo(R.string.mob, R.color.mob_color, R.drawable.ic_mob, R.drawable.bac_mob, "mob"));
        mAllHoroscopesConfig.add(new OneHoroscopeInfo(R.string.anti, R.color.anti_color, R.drawable.ic_anti, R.drawable.bac_anti, "anti"));
    }

    //returning List<> horoscopes
    public static List<OneHoroscopeInfo> getAllHoroscopesInfo(){
        if(mAllHoroscopesConfig == null){
            new HoroscopeLab();
        }
        return mAllHoroscopesConfig;
    }



    //getter
    public class OneHoroscopeInfo{
        int mHoroscopeName, mHoroscopeColor, mHoroscopeIcon, mHoroscopeBackground;
        String mHoroscopeLink;

        public OneHoroscopeInfo(int mHoroscopeName, int mHoroscopeColor, int mHoroscopeImage, int mHoroscopeBackground, String mHoroscopeLink){
            this.mHoroscopeName = mHoroscopeName;
            this.mHoroscopeColor = mHoroscopeColor;
            this.mHoroscopeIcon = mHoroscopeImage;
            this.mHoroscopeBackground = mHoroscopeBackground;
            this.mHoroscopeLink = mHoroscopeLink;
        }

        public String getHoroscopeLink() {
            return mHoroscopeLink;
        }

        public int getHoroscopeName() {
            return mHoroscopeName;
        }

        public int getHoroscopeColor() {
            return mHoroscopeColor;
        }

        public int getHoroscopeIcon() {
            return mHoroscopeIcon;
        }

        public int getHoroscopeBackground() {
            return mHoroscopeBackground;
        }
    }
}
