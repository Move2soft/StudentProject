package com.move2soft.android.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.move2soft.android.R;
import com.move2soft.android.utils.BaseActivity;

public class StudentChapterFullinformation extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_chapter_fullinformation);
        bindToolbar();
        setTitle("Chintan Pratishthan");
        showEmptyOnly();
        showBack();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
