package com.superrookie.relaxcar;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.superrookie.relaxcar.notification.NotificationController;
import com.viewpagerindicator.LinePageIndicator;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ViewPager mViewPager;

    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;

        mViewPager = findViewById(R.id.content_viewpager);
        mViewPager.setAdapter(new NoticeViewPagerAdapter(getSupportFragmentManager()));
        mViewPager.setPageTransformer(true, new ZoomOutPageTransformer());

        LinePageIndicator indicator = (LinePageIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(mViewPager);

        findViewById(R.id.btn_settings).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: btn_settings");
                NotificationController.getController(mContext).showNotification(
                        mContext, "RelaxCar", "Test NotificationText");
            }
        });
    }
}
