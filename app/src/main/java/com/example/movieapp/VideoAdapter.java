package com.example.movieapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.Vieholder> {
    Context context;
    List<Video>videoList;

    public VideoAdapter(Context context, List<Video> videoList) {
        this.context = context;
        this.videoList = videoList;
    }

    @NonNull
    @Override
    public VideoAdapter.Vieholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.video_file,parent,false);

        return new Vieholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoAdapter.Vieholder holder, int position) {

      holder.itemView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              context.startActivity(new Intent(context, MediaPlayer.class).putExtra("VideoURl",videoList.get(holder.getBindingAdapterPosition()).getUrl()));

          }
      });

    }

    @Override
    public int getItemCount() {
        if(videoList==null) return 0;
        return videoList.size();
    }

    public class Vieholder extends RecyclerView.ViewHolder {
        ImageView video;
        public Vieholder(@NonNull View itemView) {
            super(itemView);

            video=itemView.findViewById(R.id.video);
        }
    }
}
