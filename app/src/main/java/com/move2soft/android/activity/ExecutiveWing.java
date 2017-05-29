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
import com.move2soft.android.adapter.AdapterEw;
import com.move2soft.android.adapter.AdapterWadens;
import com.move2soft.android.utils.BaseActivity;

import butterknife.ButterKnife;

public class ExecutiveWing extends BaseActivity {

    ImageView iv_menu;
    RecyclerView rv_ew;
    AdapterEw adapterEw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_executive_wing);
        ButterKnife.bind(this);
        bindToolbar();
        setTitle("Executive Wing");
        showMenuOnly();
        showBack();

        rv_ew= (RecyclerView) findViewById(R.id.rv_ew);
        iv_menu= (ImageView) findViewById(R.id.iv_menu);
        iv_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(ExecutiveWing.this,MainActivity.class);
                startActivity(j);
            }
        });


        adapterEw = new AdapterEw(ExecutiveWing.this);
        RecyclerView.LayoutManager homelayoutmanager = new GridLayoutManager(ExecutiveWing.this, 1);
        rv_ew.setLayoutManager(homelayoutmanager);
        rv_ew.setItemAnimator(new DefaultItemAnimator());
        rv_ew.setAdapter(adapterEw);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
