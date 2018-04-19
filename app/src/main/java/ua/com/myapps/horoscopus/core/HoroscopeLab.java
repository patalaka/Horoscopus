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
        mAllHoroscopesConfig.add(new OneHoroscopeInfo(R.string.com, R.drawable.ic_com, R.drawable.bg_com, "com"));
        mAllHoroscopesConfig.add(new OneHoroscopeInfo(R.string.ero, R.drawable.ic_ero, R.drawable.bg_ero, "ero"));
        mAllHoroscopesConfig.add(new OneHoroscopeInfo(R.string.lov,  R.drawable.ic_lov, R.drawable.bg_love, "lov"));
        mAllHoroscopesConfig.add(new OneHoroscopeInfo(R.string.bus,  R.drawable.ic_bus, R.drawable.bg_bus, "bus"));
        mAllHoroscopesConfig.add(new OneHoroscopeInfo(R.string.hea,  R.drawable.ic_hea, R.drawable.bg_hea, "hea"));
        mAllHoroscopesConfig.add(new OneHoroscopeInfo(R.string.cook, R.drawable.ic_cook, R.drawable.bg_cook, "cook"));
        mAllHoroscopesConfig.add(new OneHoroscopeInfo(R.string.mob, R.drawable.ic_mob, R.drawable.bg_mobile, "mob"));
        mAllHoroscopesConfig.add(new OneHoroscopeInfo(R.string.anti,  R.drawable.ic_anti, R.drawable.bg_anti, "anti"));
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
        int mHoroscopeName, mHoroscopeIcon, mHoroscopeBackground;
        String mHoroscopeLink;

        public OneHoroscopeInfo(int mHoroscopeName,  int mHoroscopeImage, int mHoroscopeBackground, String mHoroscopeLink){
            this.mHoroscopeName = mHoroscopeName;
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

        public int getHoroscopeIcon() {
            return mHoroscopeIcon;
        }

        public int getHoroscopeBackground() {
            return mHoroscopeBackground;
        }
    }
}
