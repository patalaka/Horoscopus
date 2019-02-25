package ua.com.myapps.horoscopus.old.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;


public class ContentDB extends SQLiteOpenHelper {
    private ContentValues cv;
    private String[] horoZod = {"aquarius", "aries", "cancer", "capricorn", "gemini", "leo", "libra", "pisces", "sagittarius", "scorpio", "taurus", "virgo"};

    public ContentDB(Context context) {
        super(context, "horoscope_db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        ContentValues contentValues = new ContentValues();

        for (int i = 0; i < horoZod.length; i++) {
            db.execSQL("create table " + horoZod[i] + " (" +
                    "_id integer primary key autoincrement," +
                    "date," +
                    "date_load," +
                    "day_name," +
                    "com," +
                    "ero," +
                    "anti," +
                    "bus," +
                    "hea," +
                    "cook," +
                    "lov," +
                    "mob" +
                    ");"
            );

            for (int m = 0; m <= 2; m++) {
                //generate lines
                contentValues.put("date", "");
                contentValues.put("date_load", "");


                if (m == 0) contentValues.put("day_name", "week");
                else if (m == 1) contentValues.put("day_name", "month");
                else if (m == 2) contentValues.put("day_name", "year");

                contentValues.put("com", "");
                contentValues.put("ero", "");
                contentValues.put("anti", "");
                contentValues.put("bus", "");
                contentValues.put("hea", "");
                contentValues.put("cook", "");
                contentValues.put("lov", "");
                contentValues.put("mob", "");

                db.insert(horoZod[i], null, contentValues);
            }
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public void setItemDB(String date, String day_name, String zodiac, String horoscopeName, String horoscopeContent) {
        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        simpleDateFormat.setTimeZone(calendar.getTimeZone());
        String timeLoad = simpleDateFormat.format(calendar.getTime());

        SQLiteDatabase db = this.getWritableDatabase();

        switch (day_name) {
            case "day":
                List<String> dateList = new ArrayList<>();
                Cursor cursor = db.query(zodiac, new String[]{"date"}, "day_name = ?", new String[]{"day"}, null, null, null);

                if (cursor.moveToFirst()) {
                    int getDate = cursor.getColumnIndex("date");
                    do {
                        dateList.add(cursor.getString(getDate));
                    }
                    while (cursor.moveToNext());
                } else {
                    //0rows
                }

                boolean dateResult = getDateResult(date, dateList);
                /*update item*/
                if (dateResult) {
                    cv = new ContentValues();
                    cv.clear();
                    cv.put(horoscopeName, horoscopeContent);

                    db.update(zodiac, cv, "date = ?", new String[]{date});
                }
                /*add item*/
                else {
                    cv = new ContentValues();
                    cv.clear();
                    cv.put("date", date);
                    cv.put("date_load", timeLoad);
                    cv.put("day_name", "day");
                    cv.put(horoscopeName, horoscopeContent);

                    db.insert(zodiac, null, cv);
                }

                cursor.close();
                break;
            case "week":
                break;
            case "month":
                break;
            case "year":
                break;

        }

        this.close();
    }

    private boolean getDateResult(String date, List<String> dateList) {
        for (String h : dateList) {
            if (h.equals(date)) {
                return true;
            }
        }
        return false;
    }
}

