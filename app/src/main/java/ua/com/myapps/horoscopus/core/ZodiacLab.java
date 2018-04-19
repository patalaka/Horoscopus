package ua.com.myapps.horoscopus.core;

import java.util.ArrayList;
import java.util.List;

import ua.com.myapps.horoscopus.R;

/**
 * Creating zodiacs info in ZodiacChangeFragment
 */
public class ZodiacLab {
    private static List<OneZodiacInfo> allZodiacs = null;

    private ZodiacLab(){
        allZodiacs = new ArrayList<>();
        allZodiacs.add(new OneZodiacInfo("aries", R.string.aries, R.string.date_aries, R.string.status_aries, R.drawable.big_aries, R.drawable.ico_aries));
        allZodiacs.add(new OneZodiacInfo("taurus", R.string.taurus, R.string.date_taurus, R.string.status_taurus, R.drawable.big_taurus, R.drawable.ico_taurus));
        allZodiacs.add(new OneZodiacInfo("gemini", R.string.gemini, R.string.date_gemini, R.string.status_gemini, R.drawable.big_gemini, R.drawable.ico_gemini));
        allZodiacs.add(new OneZodiacInfo("cancer", R.string.cancer, R.string.date_cancer, R.string.status_cancer, R.drawable.big_cancer, R.drawable.ico_cancer));
        allZodiacs.add(new OneZodiacInfo("leo", R.string.leo, R.string.date_leo, R.string.status_leo, R.drawable.big_leo, R.drawable.ico_leo));
        allZodiacs.add(new OneZodiacInfo("virgo", R.string.virgo, R.string.date_virgo, R.string.status_virgo, R.drawable.big_virgo, R.drawable.ico_virgo));
        allZodiacs.add(new OneZodiacInfo("libra", R.string.libra, R.string.date_libra, R.string.status_libra, R.drawable.big_libra, R.drawable.ico_libra));
        allZodiacs.add(new OneZodiacInfo("scorpio", R.string.scorpio, R.string.date_scorpio, R.string.status_scorpio, R.drawable.big_scorpio, R.drawable.ico_scorpio));
        allZodiacs.add(new OneZodiacInfo("sagittarius", R.string.sagittarius, R.string.date_sagittarius, R.string.status_sagittarius, R.drawable.big_sagittarius, R.drawable.ico_sagittarius));
        allZodiacs.add(new OneZodiacInfo("capricorn", R.string.capricorn, R.string.date_capricorn, R.string.status_capricorn, R.drawable.big_capricorn, R.drawable.ico_capricorn));
        allZodiacs.add(new OneZodiacInfo("aquarius", R.string.aquarius, R.string.date_aquarius, R.string.status_aquarius, R.drawable.big_aquarius, R.drawable.ico_aquarius));
        allZodiacs.add(new OneZodiacInfo("pisces", R.string.pisces, R.string.date_pisces, R.string.status_pisces, R.drawable.big_pisces, R.drawable.ico_pisces));
    }

    //get list zodiac info
    public static List<OneZodiacInfo> getZodiacList(){
        if(allZodiacs == null){
            new ZodiacLab();
        }
        return allZodiacs;
    }



    public class OneZodiacInfo{
        private int mTitleZodiac, mDateZodiac, mStatusTextZodiac, mBigImageZodiac, mSmallImageZodiac;
        private String mLinkZodiac;

        protected OneZodiacInfo(String mLinkZodiac, int mTitleZodiac, int mDateZodiac, int mStatusTextZodiac, int mBigImageZodiac, int mSmallImageZodiac){
            this.mLinkZodiac = mLinkZodiac;
            this.mTitleZodiac = mTitleZodiac;
            this.mDateZodiac = mDateZodiac;
            this.mStatusTextZodiac = mStatusTextZodiac;
            this.mBigImageZodiac = mBigImageZodiac;
            this.mSmallImageZodiac = mSmallImageZodiac;
        }

        public int getTitleZodiac() {
            return mTitleZodiac;
        }

        public int getDateZodiac() {
            return mDateZodiac;
        }

        public int getStatusTextZodiac() {
            return mStatusTextZodiac;
        }

        public int getBigImageZodiac() {
            return mBigImageZodiac;
        }

        public int getSmallImageZodiac() {
            return mSmallImageZodiac;
        }

        public String getLinkZodiac() {
            return mLinkZodiac;
        }
    }
}
