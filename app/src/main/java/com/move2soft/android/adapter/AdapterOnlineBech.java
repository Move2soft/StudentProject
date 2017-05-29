package com.move2soft.android.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.move2soft.android.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by UV on 4/25/2017.
 */
public class AdapterOnlineBech extends RecyclerView.Adapter<AdapterOnlineBech.Onlinebech> {

    private Activity activity;
    private List<String> onlinebechproductlist = new ArrayList<>();
    private LayoutInflater layoutInflater;
    private Context c;
    AlertDialog alertDialog;


    public AdapterOnlineBech(Activity activity) {
        this.activity = activity;
        layoutInflater = LayoutInflater.from(activity);
        c = activity.getApplicationContext();
        for (int i = 0; i < 10; i++) {
            onlinebechproductlist.add("");
        }
    }


    @Override
    public Onlinebech onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_online_bech, parent, false);

        return new Onlinebech(itemView);
    }

    @Override
    public void onBindViewHolder(Onlinebech holder, int position) {

        holder.layout_product_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                productdetails();
            }
        });

    }

    @Override
    public int getItemCount() {
        return onlinebechproductlist.size();
    }

    class Onlinebech extends RecyclerView.ViewHolder {

  LinearLayout layout_product_card;
        public Onlinebech(View itemView) {
            super(itemView);
            layout_product_card= (LinearLayout) itemView.findViewById(R.id.layout_product_card);

        }
    }

    public void productdetails() {

        LayoutInflater li = LayoutInflater.from(activity);

        View confirmDialog = li.inflate(R.layout.dialog_product_details, null);





        android.support.v7.app.AlertDialog.Builder alert = new android.support.v7.app.AlertDialog.Builder(activity);

        alert.setView(confirmDialog);

        alertDialog = alert.create();

        alertDialog.show();

        alertDialog.setCanceledOnTouchOutside(false);


    }
}
