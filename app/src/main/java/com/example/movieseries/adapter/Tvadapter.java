package com.example.movieseries.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movieseries.R;
import com.example.movieseries.helper.Constant;
import com.example.movieseries.model.Result;
import com.example.movieseries.model.TvResult;

import java.util.List;

public class Tvadapter extends RecyclerView.Adapter<Tvadapter.MyViewHolder> {

    Context context;
    private List<TvResult> tvModels ;

    public Tvadapter(Context context, List<TvResult> tvModels) {
        this.context = context;
        this.tvModels = tvModels;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyler_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.title.setText(tvModels.get(position).getName());
        holder.date.setText(tvModels.get(position).getFirstAirDate().replace("-","/"));
        holder.vote.setText(tvModels.get(position).getVoteCount().toString());
        Glide.with(context).load(Constant.IMAGE_URL+tvModels.get(position).getPosterPath()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return tvModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView vote,title,date;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imag);
            vote=itemView.findViewById(R.id.voteTV);
            title=itemView.findViewById(R.id.title);
            date=itemView.findViewById(R.id.relDate);
        }
    }
}
