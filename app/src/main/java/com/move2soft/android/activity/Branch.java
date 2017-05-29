package com.move2soft.android.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.move2soft.android.R;
import com.move2soft.android.utils.BaseActivity;

import butterknife.ButterKnife;

public class Branch extends BaseActivity {

    ImageView iv_menu;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch);
        ButterKnife.bind(this);
        bindToolbar();
        setTitle("Branch");
        showMenuOnly();
        showBack();


        iv_menu= (ImageView) findViewById(R.id.iv_menu);
        iv_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(Branch.this,MainActivity.class);
                startActivity(j);
            }
        });

        submit= (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent ji=new Intent(Branch.this,BranchTab.class);
               startActivity(ji);
            }
        });

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
