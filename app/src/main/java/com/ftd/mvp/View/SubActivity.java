package com.ftd.mvp.View;

import android.content.Context;
import android.os.Bundle;

import com.ftd.mvp.R;

public class SubActivity extends BaseActivity {

    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mContext = this;

    }




}
