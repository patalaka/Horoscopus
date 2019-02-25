package ua.com.myapps.horoscopus.old;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import ua.com.myapps.horoscopus.R;
import ua.com.myapps.horoscopus.old.core.Mapper;
import ua.com.myapps.horoscopus.old.fragments.CardsFragment;
import ua.com.myapps.horoscopus.old.fragments.ContentHoroscopeFragment;
import ua.com.myapps.horoscopus.old.item.HoroscopeItem;
import ua.com.myapps.horoscopus.old.item.ZodiacItem;

/**
 * This activity is showing info of horoscope
 */

public class HoroscopeActivity extends AppCompatActivity {
    private List<ZodiacItem> zodiacItemList;
    private List<HoroscopeItem> horoscopeItemList;
    private int mZodiacIndex, mHoroIndex;

    private HoroscopePageAdapter pageAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.old_activity_horoscope);
        //get zodiac info
        zodiacItemList = Mapper.getZodiacList();
        //get horo info
        horoscopeItemList = Mapper.getHoroscopeItemList();

        Intent intent = getIntent();
        mZodiacIndex = intent.getIntExtra(CardsFragment.ZODIAC_ID, 0);
        mHoroIndex = intent.getIntExtra(CardsFragment.HOROSCOPE_ID, 0);

        showActionBar(mZodiacIndex);
        showContent(mHoroIndex);
    }


    private void showActionBar(int indexZodiac) {
        LinearLayout actionBarLayout = (LinearLayout) getLayoutInflater().inflate(R.layout.actionbar_horoscope, null);
        //text actionBar
        TextView actionBarTextView = (TextView) actionBarLayout.findViewById(R.id.actionbar_titleView);
        actionBarTextView.setText(zodiacItemList.get(indexZodiac).getTitleRes());

        //image actionBar
        ActionBar.LayoutParams actionBarLayoutParams = new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, Gravity.LEFT);
        ImageView drawerImageView = (ImageView) actionBarLayout.findViewById(R.id.drawer_image);
        //control version
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {
            drawerImageView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }
        drawerImageView.setImageDrawable(getResources().getDrawable(zodiacItemList.get(indexZodiac).getIconRes()));


        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            actionBar.setCustomView(actionBarLayout, actionBarLayoutParams);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setElevation(0);
        }
    }

    private Drawable convertImageToRepeatDrawable(int resId) {
        Bitmap bmp = BitmapFactory.decodeResource(getResources(), resId);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bmp);
        bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        return bitmapDrawable;
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void showContent(int indexHoroscope) {
        HoroscopeItem item = horoscopeItemList.get(indexHoroscope);
        LinearLayout bacLayout = (LinearLayout) findViewById(R.id.horoscope_activity_ln);
        bacLayout.setBackgroundDrawable(convertImageToRepeatDrawable(item.getResBackground()));
        //Title
        TextView titleHoroscope = (TextView) findViewById(R.id.horoscope_title);
        titleHoroscope.setText(horoscopeItemList.get(indexHoroscope).getResName());

        //ViewPager
        pageAdapter = new HoroscopePageAdapter(getSupportFragmentManager());
        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(pageAdapter);
        viewPager.setCurrentItem(1);
    }

    //MENU
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_horoscope, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            //back Button
            case android.R.id.home:
                setResult(RESULT_CANCELED);
                finish();
                return true;
            case R.id.refreshHoroscope:
                pageAdapter.notifyDataSetChanged();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //back Button
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (KeyEvent.KEYCODE_BACK == keyCode) {
            setResult(RESULT_CANCELED);
            finish();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    /**
     * FragmentAdapter
     */
    public class HoroscopePageAdapter extends FragmentPagerAdapter {
        private int antiHoroscope = 6, cookHoroscope = 5, mobHoroscope = 7;

        public HoroscopePageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return ContentHoroscopeFragment.newInstance(position, zodiacItemList.get(mZodiacIndex).getTag(), horoscopeItemList.get(mHoroIndex).getTag());
        }

        @Override
        public int getCount() {
            if (mHoroIndex == antiHoroscope
                    || mHoroIndex == cookHoroscope
                    || mHoroIndex == mobHoroscope) {
                return 3;
            } else {
                return 5;
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            int dayName = 0;
            switch (position) {
                case 0:
                    dayName = R.string.yesterday;
                    break;
                case 1:
                    dayName = R.string.today;
                    break;
                case 2:
                    dayName = R.string.tomorrow;
                    break;
                case 3:
                    dayName = R.string.week;
                    break;
                case 4:
                    dayName = R.string.year;
                    break;
            }
            return getResources().getString(dayName);
        }

        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }
    }
}
