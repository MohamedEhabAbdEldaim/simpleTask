package com.midooabdaim.youtuube.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.midooabdaim.youtuube.R;
import com.midooabdaim.youtuube.data.local.room.DaoAccessChannel;
import com.midooabdaim.youtuube.data.local.room.channel;
import com.midooabdaim.youtuube.databinding.ItemChannelBinding;
import com.midooabdaim.youtuube.ui.activity.homeActivity.MainActivity;
import com.midooabdaim.youtuube.ui.fragment.channelList.channelFragment;
import com.midooabdaim.youtuube.ui.fragment.videoList.videoChannelListFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

import static com.midooabdaim.youtuube.data.local.room.roomManger.getInstance;
import static com.midooabdaim.youtuube.helper.MethodHelper.replaceFragment;


public class ChannelsAdapter extends RecyclerView.Adapter<ChannelsAdapter.ViewHolder> {
    private final DaoAccessChannel dao;
    private Context context;
    private Activity activity;
    private List<channel> channelList = new ArrayList<>();
    private channelFragment fragment;

    public ChannelsAdapter(Activity activity, List<channel> channelList, channelFragment fragment) {
        this.context = activity;
        this.activity = activity;
        this.channelList = channelList;
        this.fragment = fragment;
        dao = getInstance(activity).daoAccessChannel();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemChannelBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(context)
                        , R.layout.item_channel, parent, false);
//        View view = LayoutInflater.from(context).inflate(R.layout.item_channel,
//                parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ChannelsAdapter.ViewHolder holder, int position) {
        setData(holder, position);
        setAction(holder, position);
    }

    private void setData(ViewHolder holder, int position) {
        holder.binding.itemChannelImgIcon.setImageResource(channelList.get(position).getChannelIcon());
        holder.binding.itemChannelTxtChannelName.setText(channelList.get(position).getChannelName());
        if (channelList.get(position).isChannelSubscrption()) {
            holder.binding.itemChannelBtnSub.setText(activity.getString(R.string.btnsubscription));
        } else {
            holder.binding.itemChannelBtnSub.setText(activity.getString(R.string.btnunsubscription));
        }

    }

    private void setAction(ViewHolder holder, final int position) {
        holder.binding.itemChannelBtnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Executors.newSingleThreadExecutor().execute(new Runnable() {
                        @Override
                        public void run() {
                            channel channel = new channel();
                            channel.setChannelIcon(channelList.get(position).getChannelIcon());
                            channel.setChannelName(channelList.get(position).getChannelName());
                            channel.setChannelSubscrption(!(channelList.get(position).isChannelSubscrption()));
                            dao.update(channel);
                            fragment.recycle();
                        }
                    });

                } catch (Exception e) {
                }
            }
        });


        holder.binding.itemChannelView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity) activity;
                videoChannelListFragment fragment = new videoChannelListFragment();
                fragment.channel = channelList.get(position);
                replaceFragment(mainActivity.getSupportFragmentManager(), R.id.activity_home_frame_layout_id, fragment);

            }
        });

    }

    @Override
    public int getItemCount() {
        return channelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemChannelBinding binding;

        public ViewHolder(ItemChannelBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
