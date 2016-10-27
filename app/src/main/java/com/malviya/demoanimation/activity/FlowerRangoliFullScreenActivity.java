package com.malviya.demoanimation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.malviya.demoanimation.R;
import com.malviya.demoanimation.adapter.FullScreenImageAdapter;
import com.malviya.demoanimation.animation.DepthPageTransformer;
import com.malviya.demoanimation.image_data_store.DataFlowerRangoli;


/**
 * Created by Prafulla on 10/26/2016.
 */

public class FlowerRangoliFullScreenActivity extends AppCompatActivity {

    //private Utils utils;
    FullScreenImageAdapter adapter;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen_view);
        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setPageTransformer(true, new DepthPageTransformer());
        Intent i = getIntent();
        int position = i.getIntExtra("position", 0);
        adapter = new FullScreenImageAdapter(FlowerRangoliFullScreenActivity.this, DataFlowerRangoli.getData());
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(position);
    }
}
