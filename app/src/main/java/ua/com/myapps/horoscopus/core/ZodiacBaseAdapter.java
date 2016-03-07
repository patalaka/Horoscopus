package ua.com.myapps.horoscopus.core;

import android.content.Context;
import android.os.Build;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.larvalabs.svgandroid.SVG;
import com.larvalabs.svgandroid.SVGParser;

import java.util.List;

import ua.com.myapps.horoscopus.R;

/**
 * Created by Max on 27.09.2015.
 */
public class ZodiacBaseAdapter extends BaseAdapter {
    private Context mContext;
    private List<ZodiacLab.OneZodiacInfo> mZodiacList;

    private float scale;
    private int padding_50dp;

    public ZodiacBaseAdapter(Context context, List<ZodiacLab.OneZodiacInfo> list){
        this.mContext = context;
        this.mZodiacList = list;

        scale = mContext.getResources().getDisplayMetrics().density;
        padding_50dp = (int) (50 * scale + 0.5f);
    }

    @Override
    public int getCount() {
        return mZodiacList.size();
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
        LinearLayout linLayout = new LinearLayout(mContext);
        linLayout.setOrientation(LinearLayout.VERTICAL);
        linLayout.setGravity(Gravity.CENTER);

        ImageView imageView = new ImageView(mContext);
        SVG zodiacSVG = SVGParser.getSVGFromResource(mContext.getResources(), mZodiacList.get(position).getSmallImageZodiac());
        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB){imageView.setLayerType(View.LAYER_TYPE_SOFTWARE, null); }
        imageView.setImageDrawable(zodiacSVG.createPictureDrawable());


        TextView textView = new TextView(mContext);
        textView.setText(mZodiacList.get(position).getTitleZodiac());
        textView.setGravity(Gravity.CENTER);

        linLayout.addView(imageView, new ViewGroup.LayoutParams(padding_50dp, padding_50dp));
        linLayout.addView(textView);

        return linLayout;
    }
}
