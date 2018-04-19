package ua.com.myapps.horoscopus;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
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

import ua.com.myapps.horoscopus.core.HoroscopeLab;
import ua.com.myapps.horoscopus.core.HoroscopeLab.OneHoroscopeInfo;
import ua.com.myapps.horoscopus.core.ZodiacLab;
import ua.com.myapps.horoscopus.core.ZodiacLab.OneZodiacInfo;
import ua.com.myapps.horoscopus.fragments.CardsFragment;
import ua.com.myapps.horoscopus.fragments.ContentHoroscopeFragment;

/**
 * This activity is showing info of horoscope
 * */


public class HoroscopeActivity extends ActionBarActivity {
    private List<OneZodiacInfo> mAllZodiacsInfo;
    private List<OneHoroscopeInfo> mAllHoroscopesInfo;
    private int mZodiacIndex, mHoroIndex;


    private HoroscopePageAdapter pageAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horoscope);
        //get zodiac info
        mAllZodiacsInfo = ZodiacLab.getZodiacList();
        //get horo info
        mAllHoroscopesInfo = HoroscopeLab.getAllHoroscopesInfo();

        Intent intent = getIntent();
        mZodiacIndex = intent.getIntExtra(CardsFragment.ZODIAC_ID, 0);
        mHoroIndex = intent.getIntExtra(CardsFragment.HOROSCOPE_ID, 0);

        showActionBar(mZodiacIndex);
        showContent(mHoroIndex);
    }


    private void showActionBar(int indexZodiac){
        LinearLayout actionBarLayout = (LinearLayout) getLayoutInflater().inflate(R.layout.actionbar_horoscope, null);
        //text actionBar
        TextView actionBarTextView = (TextView) actionBarLayout.findViewById(R.id.actionbar_titleView);
        actionBarTextView.setText(mAllZodiacsInfo.get(indexZodiac).getTitleZodiac());

        //image actionBar
        ActionBar.LayoutParams actionBarLayoutParams = new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, Gravity.LEFT);
        ImageView drawerImageView = (ImageView) actionBarLayout.findViewById(R.id.drawer_image);
        //control version
        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB){drawerImageView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);}
        drawerImageView.setImageDrawable(getResources().getDrawable(mAllZodiacsInfo.get(indexZodiac).getSmallImageZodiac()));


        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            actionBar.setCustomView(actionBarLayout, actionBarLayoutParams);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setElevation(0);
        }
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void showContent(int indexHoroscope){
        //FrameLayout frameLayoutTop = (FrameLayout)findViewById(R.id.frame_layout_horoscope_title);
        LinearLayout bacLayout = (LinearLayout) findViewById(R.id.horoscope_activity_ln);
        bacLayout.setBackgroundResource(mAllHoroscopesInfo.get(indexHoroscope).getHoroscopeBackground());
        //Title
        TextView titleHoroscope = (TextView) findViewById(R.id.horoscope_title);
        titleHoroscope.setText(mAllHoroscopesInfo.get(indexHoroscope).getHoroscopeName());

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
        if(KeyEvent.KEYCODE_BACK == keyCode){
            setResult(RESULT_CANCELED);
            finish();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }



    /**
     * FragmentAdapter
     * */
    public class HoroscopePageAdapter extends FragmentPagerAdapter {
        private int antiHoroscope = 6, cookHoroscope = 5, mobHoroscope = 7;

        public HoroscopePageAdapter(FragmentManager fm){
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            return ContentHoroscopeFragment.newInstance(position,mAllZodiacsInfo.get(mZodiacIndex).getLinkZodiac(), mAllHoroscopesInfo.get(mHoroIndex).getHoroscopeLink());
        }

        @Override
        public int getCount() {
            if(   mHoroIndex == antiHoroscope
               || mHoroIndex == cookHoroscope
               || mHoroIndex == mobHoroscope ){
                return 3;
            }else {
                return 5;
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            int dayName = 0;
            switch (position){
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
