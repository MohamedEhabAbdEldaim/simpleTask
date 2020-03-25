package com.midooabdaim.youtuube.data.local.room;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = channel.class,
        parentColumns = "channelName"
        , childColumns = "channel_Name"
        , onDelete = CASCADE))
public class videoInfo {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String videoName;
    private String videoUrl;
    private String channel_Name;

    public videoInfo() {
    }

    @Ignore
    public videoInfo(String videoName, String videoUrl, String channelName) {
        this.videoName = videoName;
        this.videoUrl = videoUrl;
        this.channel_Name = channelName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getChannel_Name() {
        return channel_Name;
    }

    public void setChannel_Name(String channelName) {
        this.channel_Name = channelName;
    }
}
