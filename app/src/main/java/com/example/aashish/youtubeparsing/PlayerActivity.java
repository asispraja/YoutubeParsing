package com.example.aashish.youtubeparsing;

/**
 * Created by Aashish on 24/05/2018.
 */

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class PlayerActivity extends YouTubeBaseActivity
{
    YouTubePlayerView player;
    String videoid;
    String api="AIzaSyD-H9m_mRggQpix_iFhmWc-QKDV2PERv_I";
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.playerlayout);
        player = findViewById(R.id.player);

        videoid= getIntent().getStringExtra("id");
        player.initialize(api, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo(videoid);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Toast.makeText(PlayerActivity.this, "Video Loading Failed", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
