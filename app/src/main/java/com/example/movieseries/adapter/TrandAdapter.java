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
import com.example.movieseries.model.Result_trend;
import com.example.movieseries.model.TvResult;

import java.util.List;

public class TrandAdapter extends RecyclerView.Adapter<TrandAdapter.MyViewHolder> {

    Context context;
    private List<Result_trend> result_trends ;

    public TrandAdapter(Context context, List<Result_trend> result_trends) {
        this.context = context;
        this.result_trends = result_trends;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.trand_recyler_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        if (result_trends.get(position).getMediaType().equals("movie")){

            holder.title.setText(result_trends.get(position).getOriginalTitle());
            holder.date.setText(result_trends.get(position).getReleaseDate().replace("-","/"));
            holder.vote.setText(result_trends.get(position).getVoteCount().toString());
            Glide.with(context).load(Constant.IMAGE_URL+result_trends.get(position).getPosterPath()).into(holder.imageView);

        }
        else{
            holder.title.setText(result_trends.get(position).getName());
            holder.date.setText(result_trends.get(position).getFirstAirDate().replace("-","/"));
            holder.vote.setText(result_trends.get(position).getVoteCount().toString());
            Glide.with(context).load(Constant.IMAGE_URL+result_trends.get(position).getPosterPath()).into(holder.imageView);
        }
    }

    @Override
    public int getItemCount() {
        return result_trends.size();
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
