package ua.com.myapps.horoscopus.old.core;

import java.util.ArrayList;
import java.util.List;

import ua.com.myapps.horoscopus.R;
import ua.com.myapps.horoscopus.old.item.HoroscopeItem;
import ua.com.myapps.horoscopus.old.item.ZodiacItem;

/**
 * Creating horoscope information
 */
public class Mapper {
    private static List<HoroscopeItem> horoscopeItemList;
    private static List<ZodiacItem> zodiacItemList;

    private static void createHoroscopeList() {
        horoscopeItemList = new ArrayList<>();
        horoscopeItemList.add(new HoroscopeItem(R.string.com, R.drawable.ic_h_com, R.drawable.bg_com, "com"));
        horoscopeItemList.add(new HoroscopeItem(R.string.ero, R.drawable.ic_h_ero, R.drawable.bg_ero, "ero"));
        horoscopeItemList.add(new HoroscopeItem(R.string.lov, R.drawable.ic_h_lov, R.drawable.bg_love, "lov"));
        horoscopeItemList.add(new HoroscopeItem(R.string.bus, R.drawable.ic_h_bus, R.drawable.bg_bus, "bus"));
        horoscopeItemList.add(new HoroscopeItem(R.string.hea, R.drawable.ic_h_hea, R.drawable.bg_hea, "hea"));
        horoscopeItemList.add(new HoroscopeItem(R.string.cook, R.drawable.ic_h_cook, R.drawable.bg_cook, "cook"));
        horoscopeItemList.add(new HoroscopeItem(R.string.mob, R.drawable.ic_h_mob, R.drawable.bg_mobile, "mob"));
        horoscopeItemList.add(new HoroscopeItem(R.string.anti, R.drawable.ic_h_anti, R.drawable.bg_anti, "anti"));
    }

    private static void createZodiacList() {
        zodiacItemList = new ArrayList<>();
        zodiacItemList.add(new ZodiacItem(R.string.aries, R.drawable.ic_z_small_aries, R.drawable.ic_z_big_aries, R.string.date_aries, R.string.status_aries, "aries"));
        zodiacItemList.add(new ZodiacItem(R.string.taurus, R.drawable.ic_z_small_taurus, R.drawable.ic_z_big_taurus, R.string.date_taurus, R.string.status_taurus, "taurus"));
        zodiacItemList.add(new ZodiacItem(R.string.gemini, R.drawable.ic_z_small_gemini, R.drawable.ic_z_big_gemini, R.string.date_gemini, R.string.status_gemini, "gemini"));
        zodiacItemList.add(new ZodiacItem(R.string.cancer, R.drawable.ic_z_small_cancer, R.drawable.ic_z_big_cancer, R.string.date_cancer, R.string.status_cancer, "cancer"));
        zodiacItemList.add(new ZodiacItem(R.string.leo, R.drawable.ic_z_small_leo, R.drawable.ic_z_big_leo, R.string.date_leo, R.string.status_leo, "leo"));
        zodiacItemList.add(new ZodiacItem(R.string.virgo, R.drawable.ic_z_small_virgo, R.drawable.ic_z_big_virgo, R.string.date_virgo, R.string.status_virgo, "virgo"));
        zodiacItemList.add(new ZodiacItem(R.string.libra, R.drawable.ic_z_small_libra, R.drawable.ic_z_big_libra, R.string.date_libra, R.string.status_libra, "libra"));
        zodiacItemList.add(new ZodiacItem(R.string.scorpio, R.drawable.ic_z_small_scorpio, R.drawable.ic_z_big_scorpio, R.string.date_scorpio, R.string.status_scorpio, "scorpio"));
        zodiacItemList.add(new ZodiacItem(R.string.sagittarius, R.drawable.ic_z_small_sagittarius, R.drawable.ic_z_big_sagittarius, R.string.date_sagittarius, R.string.status_sagittarius, "sagittarius"));
        zodiacItemList.add(new ZodiacItem(R.string.capricorn, R.drawable.ic_z_small_capricorn, R.drawable.ic_z_big_capricorn, R.string.date_capricorn, R.string.status_capricorn, "capricorn"));
        zodiacItemList.add(new ZodiacItem(R.string.aquarius, R.drawable.ic_z_small_aquarius, R.drawable.ic_z_big_aquarius, R.string.date_aquarius, R.string.status_aquarius, "aquarius"));
        zodiacItemList.add(new ZodiacItem(R.string.pisces, R.drawable.ic_z_small_pisces, R.drawable.ic_z_big_pisces, R.string.date_pisces, R.string.status_pisces, "pisces"));
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
