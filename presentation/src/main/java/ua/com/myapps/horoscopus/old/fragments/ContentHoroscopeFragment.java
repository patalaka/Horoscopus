package ua.com.myapps.horoscopus.old.fragments;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import ua.com.myapps.horoscopus.R;
import ua.com.myapps.horoscopus.old.databases.ContentDB;


/**
 * Showing the fragment content horoscope
 */
public class ContentHoroscopeFragment extends Fragment {
    //Error
    private LinearLayout mErrorLayout;
    private TextView mErrorText;
    private Button mErrorButton;

    //ProgressBar
    private LinearLayout mProgressBarLayout;

    //Content
    private ScrollView mContentScrollView;
    private TextView mContentTextDate, mContentText;

    //DB
    private ContentDB database;

    public static ContentHoroscopeFragment newInstance(int position, String linkZodiac, String linkHoroscope) {
        ContentHoroscopeFragment f = new ContentHoroscopeFragment();
        Bundle args = new Bundle();
        args.putInt("num", position);
        args.putString("zodiac_args", linkZodiac);
        args.putString("horoscope_args", linkHoroscope);
        f.setArguments(args);

        return f;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content_horoscope, container, false);

        mErrorLayout = (LinearLayout) view.findViewById(R.id.error_download_layout);
        mErrorText = (TextView) view.findViewById(R.id.error_download_tv);
        mErrorButton = (Button) view.findViewById(R.id.error_download_button);

        mProgressBarLayout = (LinearLayout) view.findViewById(R.id.progressBar_layout);

        mContentScrollView = (ScrollView) view.findViewById(R.id.content_layout);
        mContentTextDate = (TextView) view.findViewById(R.id.content_date);
        mContentText = (TextView) view.findViewById(R.id.content_textView);

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {
            mContentText.setTextIsSelectable(true);
        }

        database = new ContentDB(getActivity());
        refreshInformation();

        return view;
    }

    public void refreshInformation() {
        new DownloadParser().execute();
    }

    class DownloadParser extends AsyncTask<Void, Void, String[]> {
        private String zodiac;
        private String horoscope;
        private int indexHoroscope;

        private String[] resultText;


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //show ProgressBar
            setVisibilityLayout(mProgressBarLayout, true);
            setVisibilityLayout(mContentScrollView, false);
            setVisibilityLayout(mErrorLayout, false);
        }

        @Override
        protected String[] doInBackground(Void... params) {
            Bundle getArgs = getArguments();
            indexHoroscope = getArgs.getInt("num");
            zodiac = getArgs.getString("zodiac_args");
            horoscope = getArgs.getString("horoscope_args");

            SQLiteDatabase db = database.getWritableDatabase();


            if (indexHoroscope <= 2) {
                Cursor c = db.query(zodiac, null, "date = ? and day_name = ?", new String[]{getDate(indexHoroscope), "day"}, null, null, null);

                if (c.moveToFirst()) {
                    int getDate = c.getColumnIndex("date");
                    int getHoroscope = c.getColumnIndex(horoscope);

                    if (c.getString(getHoroscope) != null) {
                        resultText = new String[]{c.getString(getDate), c.getString(getHoroscope), "DB"};
                    } else {
                        resultText = openConnect(database, indexHoroscope, zodiac, horoscope);
                    }

                } else {
                    resultText = openConnect(database, indexHoroscope, zodiac, horoscope);
                    //0rows
                }
                c.close();
            } else if (indexHoroscope == 3) {
                resultText = openConnect(database, indexHoroscope, zodiac, horoscope);
            } else if (indexHoroscope == 4) {
                resultText = openConnect(database, indexHoroscope, zodiac, horoscope);
            }

            database.close();
            return resultText;
        }

        @Override
        protected void onPostExecute(String[] result) {
            super.onPostExecute(result);
            try {
                //InternetConnectError
                if (result[0].equals("InternetConnectError") || result[0].equals("{\"success\":0,\"message\":\"No horoscope found!\"}")) {
                    setVisibilityLayout(mProgressBarLayout, false);
                    setVisibilityLayout(mContentScrollView, false);
                    setVisibilityLayout(mErrorLayout, true);

                    if (result[0].equals("InternetConnectError")) {
                        mErrorText.setText(R.string.error_internet);
                    } else {
                        mErrorText.setText(R.string.error_server);
                    }
                    mErrorButton.setText(R.string.refresh);
                    mErrorButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            refreshInformation();
                        }
                    });
                }

                //Normal connection
                else {
                    if (result[2].equals("DB")) {
                    }
                    if (!result[0].equals("")) {
                        mContentTextDate.setText(getDateTitleContent(indexHoroscope, result[0]));
                    }
                    mContentText.setText(result[1]);

                    setVisibilityLayout(mProgressBarLayout, false);
                    setVisibilityLayout(mContentScrollView, true);
                }
            } catch (NullPointerException e) {
                //nullPointerException
            } catch (ArrayIndexOutOfBoundsException e) {
                //arrayIndexOutOfBoundsException
                setVisibilityLayout(mProgressBarLayout, false);
                setVisibilityLayout(mContentScrollView, false);
                setVisibilityLayout(mErrorLayout, true);

                mErrorText.setText(R.string.error_server);
                mErrorButton.setText(R.string.refresh);
                mErrorButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        refreshInformation();
                    }
                });
            }

        }


        //connect to internet
        private String[] openConnect(ContentDB database, int indexHoroscope, String zodiac, String horoscope) {
            String resultJson;
            String[] result = new String[0];

            try {
                URL url = new URL(getLink(indexHoroscope, zodiac, horoscope));

                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();


                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }
                resultJson = buffer.toString();


                //JSON
                JSONObject dataJsonObject = new JSONObject(resultJson);
                JSONArray horoscopesJSON = dataJsonObject.getJSONArray("horoscope");
                JSONObject horoscopeInfo = horoscopesJSON.getJSONObject(0);

                String hr = horoscopeInfo.getString(horoscope).replaceFirst("\\n", "");

                //add text in DB
                database.setItemDB(
                        horoscopeInfo.getString("date"),
                        horoscopeInfo.getString("day_name"),
                        zodiac,
                        horoscope,
                        hr
                );


                result = new String[]{horoscopeInfo.getString("date"), hr, "INTERNET"};
            } catch (IOException e) {
                result = new String[]{"InternetConnectError"};
            } catch (Exception e) {
                e.printStackTrace();
            }

            return result;
        }

        //return date on three days
        private String getDate(int indexHoroscope) {
            String date = "";
            Calendar calendar = new GregorianCalendar();
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            sdf.setTimeZone(calendar.getTimeZone());

            switch (indexHoroscope) {
                case 0:
                    //Downloading day - 1
                    calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), (calendar.get(Calendar.DAY_OF_MONTH) - 1));
                    date = sdf.format(calendar.getTime());
                    break;
                case 1:
                    date = sdf.format(calendar.getTime());
                    break;
                case 2:
                    //Downloading day + 1
                    calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), (calendar.get(Calendar.DAY_OF_MONTH) + 1));
                    date = sdf.format(calendar.getTime());
                    break;
            }
            return date;
        }

        //generate link to urlConnection
        //this method is uses getDate()
        private String getLink(int indexHoroscope, String zodiac, String horoscope) {
            String linkResult = "";
            String date = getDate(indexHoroscope);


            switch (indexHoroscope) {
                case 0:
                    //Downloading day - 1
                    linkResult = "http://myapps.com.ua/horoscopus_generate/get_one_horoscope.php?" + "zodiac=" + zodiac + "&date=" + date + "&day_name=day" + "&horoscope=" + horoscope;
                    break;
                case 1:
                    linkResult = "http://myapps.com.ua/horoscopus_generate/get_one_horoscope.php?" + "zodiac=" + zodiac + "&date=" + date + "&day_name=day" + "&horoscope=" + horoscope;
                    break;
                case 2:
                    //Downloading day + 1
                    linkResult = "http://myapps.com.ua/horoscopus_generate/get_one_horoscope.php?" + "zodiac=" + zodiac + "&date=" + date + "&day_name=day" + "&horoscope=" + horoscope;
                    break;
                case 3:
                    linkResult = "http://myapps.com.ua/horoscopus_generate/get_one_horoscope.php?" + "zodiac=" + zodiac + "&id=6&day_name=week" + "&horoscope=" + horoscope;
                    break;
                case 4:
                    linkResult = "http://myapps.com.ua/horoscopus_generate/get_one_horoscope.php?" + "zodiac=" + zodiac + "&id=8&day_name=year" + "&horoscope=" + horoscope;
                    break;
            }

            return linkResult;
        }

        //generate text to context date
        private String getDateTitleContent(int indexHoroscope, String dayName) {
            String dateResult = "";
            Calendar calendar = new GregorianCalendar();
            SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd MMMM");
            sdf.setTimeZone(calendar.getTimeZone());

            switch (indexHoroscope) {
                case 0:
                    //Downloading day - 1
                    calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), (calendar.get(Calendar.DAY_OF_MONTH) - 1));
                    dateResult = sdf.format(calendar.getTime());
                    break;
                case 1:
                    dateResult = sdf.format(calendar.getTime());
                    break;
                case 2:
                    //Downloading day + 1
                    calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), (calendar.get(Calendar.DAY_OF_MONTH) + 1));
                    dateResult = sdf.format(calendar.getTime());
                    break;
                case 3:
                    dateResult = dayName;
                    break;
                case 4:
                    dateResult = dayName;
                    break;

            }

            if (dateResult == null) {
                dateResult = "";
                return dateResult;
            } else {
                return dateResult.substring(0, 1).toUpperCase() + dateResult.substring(1);
            }
        }

        //set visibility to layouts
        private void setVisibilityLayout(View layout, boolean visibility) {
            if (visibility) {
                if (layout.getVisibility() == View.INVISIBLE) {
                    layout.setVisibility(View.VISIBLE);
                }
            } else {
                if (layout.getVisibility() == View.VISIBLE) {
                    layout.setVisibility(View.INVISIBLE);
                }
            }
        }

    }

}
