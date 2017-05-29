package com.move2soft.android.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.move2soft.android.R;
import com.move2soft.android.activity.WardenFullinformation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by UV on 4/24/2017.
 */
public class AdapterWadens extends RecyclerView.Adapter<AdapterWadens.Wadens> {
    private Activity activity;
    private List<String> wardensList = new ArrayList<>();
    private LayoutInflater layoutInflater;
    private Context c;




    public AdapterWadens(Activity activity) {
        this.activity = activity;
        layoutInflater = LayoutInflater.from(activity);
        c = activity.getApplicationContext();
        for (int i = 0; i < 6; i++) {
            wardensList.add("");
        }
    }




    @Override
    public Wadens onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_warden_list, parent, false);

        return new Wadens(itemView);
    }

    @Override
    public void onBindViewHolder(Wadens holder, int position) {


        holder.iv_hostel_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent jump=new Intent(activity, WardenFullinformation.class);
                activity.startActivity(jump);
            }
        });
    }

    @Override
    public int getItemCount() {
        return wardensList.size();
    }

    class Wadens extends RecyclerView.ViewHolder {

ImageView iv_hostel_name;

        public Wadens(View itemView) {
            super(itemView);

            iv_hostel_name= (ImageView) itemView.findViewById(R.id.iv_hostel_name);
        }
    }
}
