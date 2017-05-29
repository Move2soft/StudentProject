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
import com.move2soft.android.adapter.AdapterWadens;
import com.move2soft.android.utils.BaseActivity;

import butterknife.ButterKnife;

public class Wardens extends BaseActivity {


    AdapterWadens adapterWadens;
    ImageView iv_menu;
    RecyclerView rv_wardens_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wardens);
        ButterKnife.bind(this);
        bindToolbar();
        setTitle("Wardens");
        showMenuOnly();
        showBack();

        iv_menu= (ImageView) findViewById(R.id.iv_menu);
        iv_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(Wardens.this,MainActivity.class);
                startActivity(j);
            }
        });

        rv_wardens_list= (RecyclerView) findViewById(R.id.rv_wardens_list);
        adapterWadens = new AdapterWadens(Wardens.this);
        RecyclerView.LayoutManager homelayoutmanager = new GridLayoutManager(Wardens.this, 1);
        rv_wardens_list.setLayoutManager(homelayoutmanager);
        rv_wardens_list.setItemAnimator(new DefaultItemAnimator());
        rv_wardens_list.setAdapter(adapterWadens);

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
