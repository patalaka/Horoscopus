package ua.com.myapps.horoscopus.old;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.List;

import ua.com.myapps.horoscopus.R;
import ua.com.myapps.horoscopus.old.core.Mapper;
import ua.com.myapps.horoscopus.old.core.ZodiacBaseAdapter;
import ua.com.myapps.horoscopus.old.item.ZodiacItem;

/**
 * Showing Zodiac list
 */
public class AllZodiacsActivity extends AppCompatActivity {
    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.old_activity_all_zodiacs);
        final List<ZodiacItem> allZodiacsInfo = Mapper.getZodiacList();

        GridView gridView = (GridView) findViewById(R.id.all_zodiacs_gridView);
        ZodiacBaseAdapter zodiacsAdapter = new ZodiacBaseAdapter(getApplicationContext(), allZodiacsInfo);
        gridView.setAdapter(zodiacsAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                mIntent = new Intent();
                mIntent.putExtra("zodiac_result", allZodiacsInfo.get(position).getTag());
                setResult(RESULT_OK, mIntent);
                finish();
                overridePendingTransition(0, R.anim.abc_popup_exit);
            }
        });


        //Toolbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setLogo(R.mipmap.ic_logo);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setElevation(0);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (KeyEvent.KEYCODE_BACK == keyCode) {
            setResult(RESULT_CANCELED, new Intent());
            finish();
            overridePendingTransition(0, R.anim.abc_shrink_fade_out_from_bottom);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
