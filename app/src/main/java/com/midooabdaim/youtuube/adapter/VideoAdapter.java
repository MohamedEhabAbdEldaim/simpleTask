package com.midooabdaim.youtuube.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.midooabdaim.youtuube.R;
import com.midooabdaim.youtuube.data.local.room.DaoAccessChannel;
import com.midooabdaim.youtuube.data.local.room.channel;
import com.midooabdaim.youtuube.data.local.room.videoInfo;
import com.midooabdaim.youtuube.databinding.ItemChannelBinding;
import com.midooabdaim.youtuube.databinding.ItemVideoBinding;
import com.midooabdaim.youtuube.ui.activity.homeActivity.MainActivity;
import com.midooabdaim.youtuube.ui.activity.videoPlayingVideo.videoPlayActivity;
import com.midooabdaim.youtuube.ui.fragment.channelList.channelFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

import static com.midooabdaim.youtuube.data.local.room.roomManger.getInstance;


public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {

    private Context context;
    private Activity activity;
    private List<videoInfo> videoInfoList = new ArrayList<>();
    private channel channel;


    public VideoAdapter(Activity activity, List<videoInfo> videoInfoList, channel channel) {
        this.context = activity;
        this.activity = activity;
        this.videoInfoList = videoInfoList;
        this.channel = channel;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemVideoBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(context)
                        , R.layout.item_video, parent, false);
//        View view = LayoutInflater.from(context).inflate(R.layout.item_channel,
//                parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoAdapter.ViewHolder holder, int position) {
        setData(holder, position);
        setAction(holder, position);
    }

    private void setData(ViewHolder holder, int position) {
        holder.binding.itemVideoTxtVideoName.setText(videoInfoList.get(position).getVideoName());
    }

    private void setAction(ViewHolder holder, final int position) {
        holder.binding.itemVideoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity) activity;
                Gson g = new Gson();
                String jsonString = g.toJson(videoInfoList.get(position));
                Gson gg = new Gson();
                String jsonStringChannel = gg.toJson(channel);
                Intent intent = new Intent(mainActivity, videoPlayActivity.class);
                intent.putExtra("videoinfo", jsonString);
                intent.putExtra("channel", jsonStringChannel);
                mainActivity.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return videoInfoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemVideoBinding binding;

        public ViewHolder(ItemVideoBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
