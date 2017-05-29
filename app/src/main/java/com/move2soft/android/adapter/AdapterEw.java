package com.move2soft.android.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.move2soft.android.R;
import com.move2soft.android.activity.EwFullinformation;
import com.move2soft.android.activity.WardenFullinformation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by UV on 4/24/2017.
 */
public class AdapterEw extends RecyclerView.Adapter<AdapterEw.Ew> {

    private Activity activity;
    private List<String> ewlist = new ArrayList<>();
    private LayoutInflater layoutInflater;
    private Context c;

    public AdapterEw(Activity activity) {
        this.activity = activity;
        layoutInflater = LayoutInflater.from(activity);
        c = activity.getApplicationContext();
        for (int i = 0; i < 10; i++) {
            ewlist.add("");
        }
    }

    @Override
    public Ew onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_ew_list, parent, false);

        return new Ew(itemView);
    }

    @Override
    public void onBindViewHolder(Ew holder, int position) {
        holder.layout_ex_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent jump=new Intent(activity, EwFullinformation.class);
                activity.startActivity(jump);
            }
        });
    }

    @Override
    public int getItemCount() {
        return ewlist.size();
    }

    class Ew extends RecyclerView.ViewHolder {

        LinearLayout layout_ex_list;

        public Ew(View itemView) {
            super(itemView);
            layout_ex_list = (LinearLayout) itemView.findViewById(R.id.layout_ex_list);

        }
    }
}
