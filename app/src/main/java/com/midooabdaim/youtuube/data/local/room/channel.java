package com.midooabdaim.youtuube.data.local.room;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;


@Entity
public class channel {


    @PrimaryKey
    @NonNull
    private String channelName;
    private int channelIcon;
    private boolean channelSubscrption;

    public channel() {
    }

    @Ignore
    public channel(String channelName, int channelIcon, boolean channelSubscrption) {
        this.channelName = channelName;
        this.channelIcon = channelIcon;
        this.channelSubscrption = channelSubscrption;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public int getChannelIcon() {
        return channelIcon;
    }

    public void setChannelIcon(int channelIcon) {
        this.channelIcon = channelIcon;
    }

    public boolean isChannelSubscrption() {
        return channelSubscrption;
    }

    public void setChannelSubscrption(boolean channelSubscrption) {
        this.channelSubscrption = channelSubscrption;
    }
}
