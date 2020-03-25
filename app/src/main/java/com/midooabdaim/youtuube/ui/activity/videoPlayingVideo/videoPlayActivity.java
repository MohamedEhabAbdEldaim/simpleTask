package com.midooabdaim.youtuube.ui.activity.videoPlayingVideo;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.gson.Gson;
import com.midooabdaim.youtuube.R;
import com.midooabdaim.youtuube.data.local.room.channel;
import com.midooabdaim.youtuube.data.local.room.videoInfo;
import com.midooabdaim.youtuube.databinding.ActivityVideoPlayBinding;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.midooabdaim.youtuube.helper.youtubeConfig.getAPI_Key;


public class videoPlayActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
    ActivityVideoPlayBinding activityVideoPlayBinding;
    public channel channel;
    public videoInfo videoInfo;
    private viewModelForActivityPlay viewModelForActivityPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_play);
        activityVideoPlayBinding = DataBindingUtil.setContentView(this, R.layout.activity_video_play);
        // viewModelForActivityPlay=ViewModelProviders.of(this).get(viewModelForActivityPlay.class);
        getIntentValue();
        intialView();
    }

    private void getIntentValue() {
        try {
            Intent intent = getIntent();
            JSONObject request = new JSONObject(intent.getStringExtra("videoinfo"));
            Gson g = new Gson();
            videoInfo = g.fromJson(String.valueOf(request), videoInfo.class);
            JSONObject requests = new JSONObject(intent.getStringExtra("channel"));
            Gson gg = new Gson();
            channel = gg.fromJson(String.valueOf(requests), channel.class);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void intialView() {
        activityVideoPlayBinding.activityVideoPlayYpvId.initialize(getAPI_Key(), this);
        activityVideoPlayBinding.activityVideoPlayCivChannelImg.setImageResource(channel.getChannelIcon());
        activityVideoPlayBinding.activityVideoPlayTxtChannelName.setText(channel.getChannelName());
        activityVideoPlayBinding.activityVideoPlayTxtVideoName.setText(videoInfo.getVideoName());
        if (channel.isChannelSubscrption()) {
            activityVideoPlayBinding.activityVideoPlayBtnSub.setText(getString(R.string.btnsubscription));
        } else {
            activityVideoPlayBinding.activityVideoPlayBtnSub.setText(getString(R.string.btnunsubscription));
        }

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.loadVideo(videoInfo.getVideoUrl());
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
    }
}
