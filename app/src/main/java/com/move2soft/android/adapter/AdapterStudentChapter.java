package com.move2soft.android.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.move2soft.android.R;
import com.move2soft.android.activity.StudentChapterFullinformation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by UV on 4/24/2017.
 */
public class AdapterStudentChapter extends RecyclerView.Adapter<AdapterStudentChapter.StudChapter> {

    private List<String> studentchapterlist = new ArrayList<>();
    private LayoutInflater layoutInflater;
    private Context c;
    private Activity activity;




    public AdapterStudentChapter(Activity activity) {
        this.activity = activity;
        layoutInflater = LayoutInflater.from(activity);
        c = activity.getApplicationContext();
        for (int i = 0; i < 9; i++) {
            studentchapterlist.add("");
        }
    }



    @Override
    public StudChapter onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_student_chapter_list, parent, false);

        return new StudChapter(itemView);
    }

    @Override
    public void onBindViewHolder(StudChapter holder, int position) {


        holder.layout_student_chapter_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent stud=new Intent(activity, StudentChapterFullinformation.class);
                activity.startActivity(stud);
            }
        });
    }

    @Override
    public int getItemCount() {
        return studentchapterlist.size();
    }

    class StudChapter extends RecyclerView.ViewHolder {

        LinearLayout layout_student_chapter_cart;
        public StudChapter(View itemView) {
            super(itemView);
            layout_student_chapter_cart= (LinearLayout) itemView.findViewById(R.id.layout_student_chapter_cart);

        }
    }
}
