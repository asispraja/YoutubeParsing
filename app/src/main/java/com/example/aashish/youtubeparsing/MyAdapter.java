package com.example.aashish.youtubeparsing;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.aashish.youtubeparsing.entities.Item;

import java.util.List;

/**
 * Created by Aashish on 23/05/2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context c;
    List<Item> list;
    public MyAdapter(MainActivity mainActivity, List<Item> mydata) {
    c=mainActivity;
    list=mydata;
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(c).inflate(R.layout.singleitem,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyAdapter.MyViewHolder holder, final int position) {
    holder.title.setText(list.get(position).getSnippet().getTitle());
    holder.date.setText(list.get(position).getSnippet().getPublishedAt());
    Glide.with(c).load(list.get(position).getSnippet().getThumbnails().getDefault().getUrl()).into(holder.imv);
    holder.view.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i = new Intent(c,PlayerActivity.class);
            i.putExtra("id",list.get(position).getSnippet().getResourceId().getVideoId());
            c.startActivity(i);
        }
    });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imv;
        TextView title,date;
        View view;
        public MyViewHolder(View itemView) {
            super(itemView);
            imv= itemView.findViewById(R.id.img);

            view = itemView;
            title = itemView.findViewById(R.id.title);
            date= itemView.findViewById(R.id.date);

        }
    }
}
