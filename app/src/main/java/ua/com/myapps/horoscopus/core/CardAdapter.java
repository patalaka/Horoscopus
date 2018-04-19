package ua.com.myapps.horoscopus.core;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
*Created cards for GridView
*/
public class CardAdapter extends BaseAdapter{
    private Context mContext;
    private List<HoroscopeLab.OneHoroscopeInfo> mAllCardsInfo;

    private float scale;
    private int padding_25dp;
    private int padding_10dp;

    public CardAdapter(Context context, List<HoroscopeLab.OneHoroscopeInfo> mAllCardsInfo){
        this.mContext = context;
        this.mAllCardsInfo = mAllCardsInfo;

        scale = mContext.getResources().getDisplayMetrics().density;
        padding_25dp = (int) (25 * scale + 0.5f);
        padding_10dp = (int) (10 * scale + 0.5f);
    }
    @Override
    public int getCount() {
        return mAllCardsInfo.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout linearLayout;
        ImageView imageView;
        TextView tv;

        linearLayout = new LinearLayout(mContext);
        linearLayout.setBackgroundColor(mContext.getResources().getColor(mAllCardsInfo.get(position).getHoroscopeColor()));
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout.setGravity(Gravity.CENTER);

        imageView = new ImageView(mContext);
        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB){ imageView.setLayerType(View.LAYER_TYPE_SOFTWARE, null); }
        imageView.setImageDrawable(mContext.getResources().getDrawable(mAllCardsInfo.get(position).getHoroscopeIcon()));
        imageView.setPadding(0,0,0,0);


        tv = new TextView(mContext);
        tv.setGravity(Gravity.CENTER);
        tv.setTextColor(Color.WHITE);
        tv.setPadding(padding_10dp,0,0,0);
        tv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        tv.setText(mAllCardsInfo.get(position).mHoroscopeName);


        //TextView LayoutParams options
        ViewGroup.LayoutParams lp = tv.getLayoutParams();
        if(mContext.getResources().getConfiguration().orientation == 2){lp.height = parent.getWidth()/4;}
        else {lp.height = parent.getWidth()/3;}


        linearLayout.addView(imageView, new ViewGroup.LayoutParams(padding_25dp, padding_25dp));
        linearLayout.addView(tv);
        return linearLayout;
    }
}
