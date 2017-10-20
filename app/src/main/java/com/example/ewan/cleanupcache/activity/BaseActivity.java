package com.example.ewan.cleanupcache.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ewan.cleanupcache.R;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.deleteActivity(this);
    }
}
