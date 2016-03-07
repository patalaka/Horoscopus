package ua.com.myapps.horoscopus.fragments;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.larvalabs.svgandroid.SVG;
import com.larvalabs.svgandroid.SVGParser;

import java.util.List;

import ua.com.myapps.horoscopus.AllZodiacsActivity;
import ua.com.myapps.horoscopus.R;
import ua.com.myapps.horoscopus.core.ZodiacLab;
import ua.com.myapps.horoscopus.core.ZodiacLab.OneZodiacInfo;

/**
* ZodiacChangeFragment
*/
public class ZodiacChangeFragment extends Fragment{
    private int mPositionZodiac;
    private ImageView mImageZodiac;
    private TextView mTitleZodiac, mDateZodiac, mStatusTextZodiac;
    private SharedPreferences mSp;
    private List<OneZodiacInfo> allZodiacs;
    private Intent mIntent;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        allZodiacs = ZodiacLab.getZodiacList();
        mSp = PreferenceManager.getDefaultSharedPreferences(getActivity());
        mPositionZodiac = Integer.valueOf(mSp.getString("listHoroscopes", "0"));

        mIntent = new Intent();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_change_zodiac, container, false);

        mImageZodiac = (ImageView) view.findViewById(R.id.image_zodiac);
        mTitleZodiac = (TextView) view.findViewById(R.id.title_zodiac);
        mDateZodiac  = (TextView) view.findViewById(R.id.date_zodiac);
        mStatusTextZodiac = (TextView) view.findViewById(R.id.text_status_zodiac);

        //set text info
        setInformationZodiac(allZodiacs.get(mPositionZodiac));

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AllZodiacsActivity.class);
                startActivityForResult(intent, 1);
                getActivity().overridePendingTransition(R.anim.abc_grow_fade_in_from_bottom,R.anim.abc_shrink_fade_out_from_bottom);
            }
        });
        return view;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        for(OneZodiacInfo h : allZodiacs){
            if(h.getLinkZodiac().equals(data.getStringExtra("zodiac_result"))){
                setInformationZodiac(h);

                //Auto load horoscope
                if(!mSp.getBoolean("on_off_autoHoroscope", false)){
                    SharedPreferences.Editor editor = mSp.edit();
                    editor.putString("listHoroscopes", String.valueOf(mPositionZodiac));
                    editor.apply();
                }
                break;
            }
        }
    }


    //set info in UI and putExtra(ZODIAC)
    private void setInformationZodiac(OneZodiacInfo zodiac){
        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB){mImageZodiac.setLayerType(View.LAYER_TYPE_SOFTWARE, null);}
        SVG svgBigImage = SVGParser.getSVGFromResource(getResources(), zodiac.getBigImageZodiac());
        mImageZodiac.setImageDrawable(svgBigImage.createPictureDrawable());


        mTitleZodiac.setText(zodiac.getTitleZodiac());
        mDateZodiac.setText(zodiac.getDateZodiac());
        mStatusTextZodiac.setText(zodiac.getStatusTextZodiac());

        //getPosition zodiac in listZodiacs
        mPositionZodiac = allZodiacs.indexOf(zodiac);
        mIntent.putExtra("position_zodiac", mPositionZodiac);
        getActivity().setIntent(mIntent);
    }

}
