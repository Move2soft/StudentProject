package com.move2soft.android.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.move2soft.android.R;
import com.move2soft.android.adapter.NavigationDrawerAdapter;
import com.move2soft.android.adapter.SpinnerAdapter;
import com.move2soft.android.model.Spinner;
import com.move2soft.android.utils.BaseActivity;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {
    @Bind(R.id.drawer_layout)
    DrawerLayout drawer_layout;
    @Bind(R.id.ivDrawer)
    ImageView ivDrawer;
    @Bind(R.id.drawerListView)
    ListView drawerListView;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private View listHeaderView;
    private TextView tvMobileNo;
    private PopupWindow pw;

    ImageView iv_menu;

    LinearLayout layout_ex_wing,layout_stud_chap,layout_online_bech,layout_baranch,layout_wardens;
    Animation animFadein;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        bindToolbar();
        showMenuOnly1();
        initDrawer();
        bind();
    }

    public void bind(){
        layout_ex_wing= (LinearLayout) findViewById(R.id.layout_ex_wing);
        layout_ex_wing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent exw=new Intent(MainActivity.this,ExecutiveWing.class);
                startActivity(exw);

            }
        });

        iv_menu= (ImageView) findViewById(R.id.iv_menu);
        iv_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menuiconclick();
            }
        });

        animFadein = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
        layout_ex_wing.startAnimation(animFadein);


        layout_stud_chap= (LinearLayout) findViewById(R.id.layout_stud_chap);
        layout_stud_chap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent st=new Intent(MainActivity.this,StudentChapters.class);
                startActivity(st);
            }
        });

        animFadein = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
        layout_stud_chap.startAnimation(animFadein);


        layout_online_bech= (LinearLayout) findViewById(R.id.layout_online_bech);
        layout_online_bech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent onlineB=new Intent(MainActivity.this,OnlineBech.class);
                startActivity(onlineB);
            }
        });

        animFadein = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
        layout_online_bech.startAnimation(animFadein);

        layout_baranch= (LinearLayout) findViewById(R.id.layout_baranch);
        layout_baranch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent branch=new Intent(MainActivity.this,Branch.class);
                startActivity(branch);
            }
        });

        animFadein = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
        layout_baranch.startAnimation(animFadein);


        layout_wardens= (LinearLayout) findViewById(R.id.layout_wardens);
        layout_wardens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent w=new Intent(MainActivity.this,Wardens.class);
                startActivity(w);
            }
        });

        animFadein = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
        layout_wardens.startAnimation(animFadein);
    }

    public void initDrawer() {
        LayoutInflater inflater = getLayoutInflater();
        listHeaderView = inflater.inflate(R.layout.nav_header, null, false);


        drawerListView.addHeaderView(listHeaderView);
        drawerListView.setAdapter(new NavigationDrawerAdapter(this));
        ivDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer_layout.openDrawer(Gravity.LEFT);
            }
        });
        actionBarDrawerToggle = new ActionBarDrawerToggle(MainActivity.this, drawer_layout, R.string.drawer_open, R.string.drawer_close) {

            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };

        drawerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectItemFragment(position);
            }
        });
    }

    private void selectItemFragment(int position) {

        switch (position) {
            case 1:
                Intent i=new Intent(MainActivity.this,Branch.class);
                startActivity(i);
                break;
            case 2:
                Intent ii=new Intent(MainActivity.this,ExecutiveWing.class);
                startActivity(ii);
                break;
            case 3:
                Intent iii=new Intent(MainActivity.this,Wardens.class);
                startActivity(iii);
                break;
            case 4:
                Intent iv=new Intent(MainActivity.this,StudentChapters.class);
                startActivity(iv);
                break;
            case 5:
                Intent vi=new Intent(MainActivity.this,OnlineBech.class);
                startActivity(vi);
                break;
            case 6:
                Intent ll = new Intent("android.intent.action.SEND");
                ll.setType("text/plain");
                ll.putExtra("android.intent.extra.SUBJECT", "Student project");
                ll.putExtra("android.intent.extra.TEXT", "Download Now To Get information and guideline to Colleage.\n\nDownload From :\nplay.google.com/store/apps/details?id=" + MainActivity.this.getPackageName());
                MainActivity.this.startActivity(Intent.createChooser(ll, "Share via"));
            case 7:
                try {
                    MainActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + MainActivity.this.getPackageName())));

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                break;
            case 8:
                Toast.makeText(MainActivity.this, "About Us", Toast.LENGTH_SHORT).show();
                break;


        }


        drawerListView.setItemChecked(position, true);

//        drawerLayout.closeDrawer(drawerListView);
    }

    private void menuiconclick() {
        LayoutInflater inflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //get the pop-up window i.e.  drop-down layout
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.filter_dialog_dealerlist, (ViewGroup) findViewById(R.id.PopUpView));

        //get the view to which drop-down layout is to be anchored
        pw = new PopupWindow(layout, 325, ViewGroup.LayoutParams.WRAP_CONTENT, true);


        //Pop-up window background cannot be null if we want the pop-up to listen touch events outside its window
        pw.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        pw.setElevation(10);
        pw.setTouchable(true);

        //let pop-up be informed about touch events outside its window. This  should be done before setting the content of pop-up
        pw.setOutsideTouchable(false);
        pw.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        pw.setContentView(layout);

        //anchor the drop-down to bottom-left corner of 'layout1'
        pw.showAsDropDown(iv_menu);

        //populate the drop-down list
        final ListView list = (ListView) layout.findViewById(R.id.dropDownList_dealer);
        final ArrayList<Spinner> data = new ArrayList<>();
        data.add(new Spinner("0", "About Us"));
        data.add(new Spinner("1", "Share"));
        data.add(new Spinner("2", "Rate Us"));
        SpinnerAdapter adapter = new SpinnerAdapter(this);
        adapter.addAll(data);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                pw.dismiss();
                if (position == 0) {
                    Toast.makeText(MainActivity.this, "About Us", Toast.LENGTH_SHORT).show();

                } else if (position == 1) {

                    Intent i = new Intent("android.intent.action.SEND");
                    i.setType("text/plain");
                    i.putExtra("android.intent.extra.SUBJECT", "Vaishnava Guide");
                    i.putExtra("android.intent.extra.TEXT", "Download Vaishnava Guide Now To Get information and guideline to follow vaishnavism.\n\nDownload From :\nplay.google.com/store/apps/details?id=" + MainActivity.this.getPackageName());
                    MainActivity.this.startActivity(Intent.createChooser(i, "Share via"));
                } else if (position == 2) {
                    try {
                        MainActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + MainActivity.this.getPackageName())));

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
