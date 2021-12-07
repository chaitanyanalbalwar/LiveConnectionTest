package com.app.liveconnectiontest.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.liveconnectiontest.R;
import com.app.liveconnectiontest.models.MovieModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GridviewListAdapter extends RecyclerView.Adapter<GridviewListAdapter.MyViewHolder> {

    Context context;
    ArrayList<MovieModel>movieList;


    public GridviewListAdapter(Context context, ArrayList<MovieModel> movieList) {
        this.context = context;
        this.movieList = movieList;
    }


    @NonNull
    @Override
    public GridviewListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridviewListAdapter.MyViewHolder holder, int position) {

        MovieModel movieModel=movieList.get(position);

        holder.txtName.setText(movieModel.getOriginal_title());
        Picasso.get().load("https://image.tmdb.org/t/p/w780/"+movieModel.getBackdrop_path()).into(holder.imgLogo);


    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtName;
        ImageView imgLogo;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtName=itemView.findViewById(R.id.txtName);
            imgLogo=itemView.findViewById(R.id.imgLogo);
        }
    }
}
