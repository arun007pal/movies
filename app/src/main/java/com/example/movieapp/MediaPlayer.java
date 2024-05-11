package com.example.movieapp;

import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.media3.common.MediaItem;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.ui.PlayerView;

import java.util.List;

public class MediaPlayer extends AppCompatActivity {

    ExoPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_media_player);


        PlayerView playerView = findViewById(R.id.exoplayer);

       player = new ExoPlayer.Builder(this).build();
     playerView.setPlayer(player);


        MediaItem firstItem = MediaItem.fromUri(Uri.parse(getIntent().getStringExtra("VideoURl")));
        String VideoURl = getIntent().getStringExtra("VideoURl");
        assert VideoURl != null;

        player.setMediaItem(firstItem);

        player.prepare();
        player.play();


    }

    @Override
    protected void onStart() {
        super.onStart();
        player.setPlayWhenReady(true);

    }

    @Override
    protected void onStop() {
        super.onStop();
        player.setPlayWhenReady(true);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        player.release();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();


    }
}