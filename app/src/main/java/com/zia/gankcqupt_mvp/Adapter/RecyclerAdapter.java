package com.zia.gankcqupt_mvp.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zia.gankcqupt_mvp.Bean.Student;
import com.zia.gankcqupt_mvp.R;
import com.zia.gankcqupt_mvp.View.Activity.Page.DetailActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zia on 2017/5/19.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.Holder> {

    private RecyclerOnClickListener listener;
    private List<Student> list = new ArrayList<>();
    public static boolean ISFOUR = false;
    private Context context;

    public RecyclerAdapter(Context context){
        this.context = context;
    }

    public void reFresh(List<Student> list,boolean isfour){
        this.list = list;
        ISFOUR = isfour;
        notifyDataSetChanged();
    }

    public void setListener(RecyclerOnClickListener listener){
        this.listener = listener;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(final Holder holder, int position) {
        final Student student = list.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener != null)
                listener.onClick(student);
                Intent intent = new Intent(context,DetailActivity.class);
                intent.putExtra("student",student);
                intent.putExtra("isfour",ISFOUR);
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity)context,
                        new Pair(holder.imageView, DetailActivity.ELEMENT)
                );
                ActivityCompat.startActivity(context, intent, options.toBundle());
            }
        });
        holder.tv_year.setText(student.getYear());
        holder.tv_name.setText(student.getName());
        holder.tv_college.setText(student.getCollege());
        String url;
        if(ISFOUR){
            url = "http://172.22.80.212.cqupt.congm.in/PHOTO0906CET/"+student.getStudentId()+".jpg";
            //url = "http://139.199.176.72/cet/"+student.getStudentId()+".jpg";
        }else{
            url = "http://jwzx.cqupt.congm.in/showstuPic.php?xh=" + student.getStudentId();
            //url = "http://139.199.176.72/ykt/"+student.getStudentId()+".jpg";
        }
        Glide.with(context).load(url).error(R.mipmap.error_icon).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tv_name,tv_year,tv_college;

        public Holder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.image);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            tv_year = (TextView) itemView.findViewById(R.id.tv_year);
            tv_college = (TextView) itemView.findViewById(R.id.tv_college);
        }
    }
}
