package com.move2soft.android.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.move2soft.android.R;
import com.move2soft.android.adapter.AdapterStudentChapter;
import com.move2soft.android.adapter.AdapterWadens;
import com.move2soft.android.utils.BaseActivity;

import butterknife.ButterKnife;

public class StudentChapters extends BaseActivity {

    ImageView iv_menu;
    RecyclerView rv_student_chapter_list;
    AdapterStudentChapter adapterStudentChapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_chapters);
        ButterKnife.bind(this);
        bindToolbar();
        setTitle("Student Chapters");
        showMenuOnly();
        showBack();

        iv_menu= (ImageView) findViewById(R.id.iv_menu);
        iv_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(StudentChapters.this,MainActivity.class);
                startActivity(j);
            }
        });

        rv_student_chapter_list= (RecyclerView) findViewById(R.id.rv_student_chapter_list);
        adapterStudentChapter = new AdapterStudentChapter(StudentChapters.this);
        RecyclerView.LayoutManager homelayoutmanager = new GridLayoutManager(StudentChapters.this, 1);
        rv_student_chapter_list.setLayoutManager(homelayoutmanager);
        rv_student_chapter_list.setItemAnimator(new DefaultItemAnimator());
        rv_student_chapter_list.setAdapter(adapterStudentChapter);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
