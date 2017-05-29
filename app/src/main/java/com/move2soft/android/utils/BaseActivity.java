package com.move2soft.android.utils;

import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.move2soft.android.R;


/**
 * Created by root on 21/4/16.
 */
public class BaseActivity extends AppCompatActivity {

    AsyncProgressDialog ad;
    private Toast toast;
    public Toolbar toolbar;
    TextView tv_title;
    ImageView ivDrawer,iv_menu;


    public void bindToolbar() {
        ivDrawer = (ImageView) findViewById(R.id.ivDrawer);
        tv_title = (TextView) findViewById(R.id.tv_title);
        iv_menu= (ImageView) findViewById(R.id.iv_menu);

    }

    public void setTitle(String titlea) {
        tv_title.setText(titlea + "");
    }

    public void showBack() {
        ivDrawer.setImageResource(R.drawable.ic_back);
        ivDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    public void showEmptyOnly() {
        iv_menu.setVisibility(View.GONE);

    }

    public void showMenuOnly() {
        iv_menu.setImageResource(R.drawable.ic_home);

    }

    public void showMenuOnly1() {
        iv_menu.setImageResource(R.drawable.ic_settings);

    }

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        toast = Toast.makeText(getActivity(), "", Toast.LENGTH_LONG);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }


    public void showToast(final String text, final int duration) {
        runOnUiThread(new Runnable() {

            @Override
            public void run() {
                toast.setText(text);
                toast.setDuration(duration);
                toast.show();
            }
        });
    }

    public void showToast(final int text, final int duration) {

        runOnUiThread(new Runnable() {

            @Override
            public void run() {
                toast.setText(getResources().getString(text));
                toast.setDuration(duration);
                toast.show();
            }
        });

    }

    public void showProgress(String msg) {

        try {
            if (ad != null && ad.isShowing()) {
                return;
            }

            ad = AsyncProgressDialog.getInstant(getActivity());
            ad.show(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public BaseActivity getActivity() {
        return this;
    }

    public void dismissProgress() {
        try {
            if (ad != null) {
                ad.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void hideKeyBoard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(
                INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }


}
