package ua.com.myapps.horoscopus.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.List;

import ua.com.myapps.horoscopus.HoroscopeActivity;
import ua.com.myapps.horoscopus.MainActivity;
import ua.com.myapps.horoscopus.core.CardAdapter;
import ua.com.myapps.horoscopus.core.HoroscopeLab;


public class CardsFragment extends Fragment {
    public static final String ZODIAC_ID = "zodiac_id";
    public static final String HOROSCOPE_ID = "horoscope_id";
    private List<HoroscopeLab.OneHoroscopeInfo> mAllCardsInfo;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        //data for cards
        mAllCardsInfo = HoroscopeLab.getAllHoroscopesInfo();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        GridView gridView = new GridView(getActivity());
        gridView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        gridView.setNumColumns(GridView.AUTO_FIT);
        gridView.setVerticalScrollBarEnabled(false);
        gridView.setHorizontalScrollBarEnabled(false);
        gridView.setClipToPadding(false);
        gridView.setPadding(2, 0, 2, 3);
        gridView.setVerticalSpacing(3);
        gridView.setHorizontalSpacing(3);
        gridView.setDrawSelectorOnTop(true);
       // gridView.setSelector(getResources().getDrawable(R.drawable.item_selected));

        //Adapter
        gridView.setAdapter(new CardAdapter(getActivity(), mAllCardsInfo));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //get position zodiac
                Intent getI = getActivity().getIntent();
                Integer getPositionZodiac = getI.getIntExtra("position_zodiac", 0);

                //set parameters
                Intent intent = new Intent(getActivity(), HoroscopeActivity.class);
                intent.putExtra(ZODIAC_ID, getPositionZodiac);
                intent.putExtra(HOROSCOPE_ID, position);
                startActivityForResult(intent, 2);
            }
        });
        return gridView;
    }
}
