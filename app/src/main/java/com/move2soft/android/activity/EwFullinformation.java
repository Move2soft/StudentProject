package com.move2soft.android.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.move2soft.android.R;
import com.move2soft.android.utils.BaseActivity;

public class EwFullinformation extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ew_fullinformation);
        bindToolbar();
        setTitle("SGS");
        showEmptyOnly();
        showBack();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
