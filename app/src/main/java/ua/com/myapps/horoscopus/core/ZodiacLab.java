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
        allZodiacs.add(new OneZodiacInfo("aries", R.string.aries, R.string.date_aries, R.string.status_aries, R.raw.big_aries, R.raw.ico_aries));
        allZodiacs.add(new OneZodiacInfo("taurus", R.string.taurus, R.string.date_taurus, R.string.status_taurus, R.raw.big_taurus, R.raw.ico_taurus));
        allZodiacs.add(new OneZodiacInfo("gemini", R.string.gemini, R.string.date_gemini, R.string.status_gemini, R.raw.big_gemini, R.raw.ico_gemini));
        allZodiacs.add(new OneZodiacInfo("cancer", R.string.cancer, R.string.date_cancer, R.string.status_cancer, R.raw.big_cancer, R.raw.ico_cancer));
        allZodiacs.add(new OneZodiacInfo("leo", R.string.leo, R.string.date_leo, R.string.status_leo, R.raw.big_leo, R.raw.ico_leo));
        allZodiacs.add(new OneZodiacInfo("virgo", R.string.virgo, R.string.date_virgo, R.string.status_virgo, R.raw.big_virgo, R.raw.ico_virgo));
        allZodiacs.add(new OneZodiacInfo("libra", R.string.libra, R.string.date_libra, R.string.status_libra, R.raw.big_libra, R.raw.ico_libra));
        allZodiacs.add(new OneZodiacInfo("scorpio", R.string.scorpio, R.string.date_scorpio, R.string.status_scorpio, R.raw.big_scorpio, R.raw.ico_scorpio));
        allZodiacs.add(new OneZodiacInfo("sagittarius", R.string.sagittarius, R.string.date_sagittarius, R.string.status_sagittarius, R.raw.big_sagittarius, R.raw.ico_sagittarius));
        allZodiacs.add(new OneZodiacInfo("capricorn", R.string.capricorn, R.string.date_capricorn, R.string.status_capricorn, R.raw.big_capricorn, R.raw.ico_capricorn));
        allZodiacs.add(new OneZodiacInfo("aquarius", R.string.aquarius, R.string.date_aquarius, R.string.status_aquarius, R.raw.big_aquarius, R.raw.ico_aquarius));
        allZodiacs.add(new OneZodiacInfo("pisces", R.string.pisces, R.string.date_pisces, R.string.status_pisces, R.raw.big_pisces, R.raw.ico_pisces));
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
