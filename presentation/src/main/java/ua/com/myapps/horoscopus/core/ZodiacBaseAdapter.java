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

import java.util.List;

import ua.com.myapps.horoscopus.item.ZodiacItem;

/**
 * Created by Max on 27.09.2015.
 */
public class ZodiacBaseAdapter extends BaseAdapter {
    private Context mContext;
    private List<ZodiacItem> zodiacItemList;

    private float scale;
    private int padding_50dp;

    public ZodiacBaseAdapter(Context context, List<ZodiacItem> list) {
        this.mContext = context;
        this.zodiacItemList = list;

        scale = mContext.getResources().getDisplayMetrics().density;
        padding_50dp = (int) (50 * scale + 0.5f);
    }

    @Override
    public int getCount() {
        return zodiacItemList.size();
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
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB)
            imageView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);

        imageView.setImageDrawable(mContext.getResources().getDrawable(zodiacItemList.get(position).getIconRes()));

        TextView textView = new TextView(mContext);
        textView.setText(zodiacItemList.get(position).getTitleRes());
        textView.setGravity(Gravity.CENTER);

        linLayout.addView(imageView, new ViewGroup.LayoutParams(padding_50dp, padding_50dp));
        linLayout.addView(textView);

        return linLayout;
    }
}
