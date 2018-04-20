package ua.com.myapps.horoscopus.core;

import java.util.ArrayList;
import java.util.List;

import ua.com.myapps.horoscopus.R;
import ua.com.myapps.horoscopus.item.HoroscopeItem;
import ua.com.myapps.horoscopus.item.ZodiacItem;

/**
 * Creating horoscope information
 */
public class Mapper {
    private static List<HoroscopeItem> horoscopeItemList;
    private static List<ZodiacItem> zodiacItemList;

    private static void createHoroscopeList() {
        horoscopeItemList = new ArrayList<>();
        horoscopeItemList.add(new HoroscopeItem(R.string.com, R.drawable.ic_com, R.drawable.bg_com, "com"));
        horoscopeItemList.add(new HoroscopeItem(R.string.ero, R.drawable.ic_ero, R.drawable.bg_ero, "ero"));
        horoscopeItemList.add(new HoroscopeItem(R.string.lov, R.drawable.ic_lov, R.drawable.bg_love, "lov"));
        horoscopeItemList.add(new HoroscopeItem(R.string.bus, R.drawable.ic_bus, R.drawable.bg_bus, "bus"));
        horoscopeItemList.add(new HoroscopeItem(R.string.hea, R.drawable.ic_hea, R.drawable.bg_hea, "hea"));
        horoscopeItemList.add(new HoroscopeItem(R.string.cook, R.drawable.ic_cook, R.drawable.bg_cook, "cook"));
        horoscopeItemList.add(new HoroscopeItem(R.string.mob, R.drawable.ic_mob, R.drawable.bg_mobile, "mob"));
        horoscopeItemList.add(new HoroscopeItem(R.string.anti, R.drawable.ic_anti, R.drawable.bg_anti, "anti"));
    }

    private static void createZodiacList() {
        zodiacItemList = new ArrayList<>();
        zodiacItemList.add(new ZodiacItem(R.string.aries, R.drawable.ic_aries, R.drawable.ic_aries_big, R.string.date_aries, R.string.status_aries, "aries"));
        zodiacItemList.add(new ZodiacItem(R.string.taurus, R.drawable.ic_taurus, R.drawable.ic_taurus_big, R.string.date_taurus, R.string.status_taurus, "taurus"));
        zodiacItemList.add(new ZodiacItem(R.string.gemini, R.drawable.ic_gemini, R.drawable.ic_gemini_big, R.string.date_gemini, R.string.status_gemini, "gemini"));
        zodiacItemList.add(new ZodiacItem(R.string.cancer, R.drawable.ic_cancer, R.drawable.ic_cancer_big, R.string.date_cancer, R.string.status_cancer, "cancer"));
        zodiacItemList.add(new ZodiacItem(R.string.leo, R.drawable.ic_leo, R.drawable.ic_leo_big, R.string.date_leo, R.string.status_leo, "leo"));
        zodiacItemList.add(new ZodiacItem(R.string.virgo, R.drawable.ic_virgo, R.drawable.ic_virgo_big, R.string.date_virgo, R.string.status_virgo, "virgo"));
        zodiacItemList.add(new ZodiacItem(R.string.libra, R.drawable.ic_libra, R.drawable.ic_libra_big, R.string.date_libra, R.string.status_libra, "libra"));
        zodiacItemList.add(new ZodiacItem(R.string.scorpio, R.drawable.ic_scorpio, R.drawable.ic_scorpio_big, R.string.date_scorpio, R.string.status_scorpio, "scorpio"));
        zodiacItemList.add(new ZodiacItem(R.string.sagittarius, R.drawable.ic_sagittarius, R.drawable.ic_sagittarius_big, R.string.date_sagittarius, R.string.status_sagittarius, "sagittarius"));
        zodiacItemList.add(new ZodiacItem(R.string.capricorn, R.drawable.ic_capricorn, R.drawable.ic_capricorn_big, R.string.date_capricorn, R.string.status_capricorn, "capricorn"));
        zodiacItemList.add(new ZodiacItem(R.string.aquarius, R.drawable.ic_aquarius, R.drawable.ic_aquarius_big, R.string.date_aquarius, R.string.status_aquarius, "aquarius"));
        zodiacItemList.add(new ZodiacItem(R.string.pisces, R.drawable.ic_pisces, R.drawable.ic_pisces_big, R.string.date_pisces, R.string.status_pisces, "pisces"));
    }

    public static List<HoroscopeItem> getHoroscopeItemList() {
        if (horoscopeItemList == null)
            createHoroscopeList();

        return horoscopeItemList;
    }

    public static List<ZodiacItem> getZodiacList() {
        if (zodiacItemList == null)
            createZodiacList();

        return zodiacItemList;
    }
}
