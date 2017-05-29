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
import com.move2soft.android.adapter.AdapterOnlineBech;
import com.move2soft.android.adapter.AdapterWadens;
import com.move2soft.android.utils.BaseActivity;

import butterknife.ButterKnife;

public class OnlineBech extends BaseActivity {

    ImageView iv_menu;
    RecyclerView rv_online_bech;

    AdapterOnlineBech adapterOnlineBech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_bech);
        ButterKnife.bind(this);
        bindToolbar();
        setTitle("Online Bech");
        showMenuOnly();
        showBack();

        iv_menu= (ImageView) findViewById(R.id.iv_menu);
        iv_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(OnlineBech.this,MainActivity.class);
                startActivity(j);
            }
        });

        rv_online_bech= (RecyclerView) findViewById(R.id.rv_online_bech);
        adapterOnlineBech = new AdapterOnlineBech(OnlineBech.this);
        RecyclerView.LayoutManager homelayoutmanager = new GridLayoutManager(OnlineBech.this, 1);
        rv_online_bech.setLayoutManager(homelayoutmanager);
        rv_online_bech.setItemAnimator(new DefaultItemAnimator());
        rv_online_bech.setAdapter(adapterOnlineBech);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
