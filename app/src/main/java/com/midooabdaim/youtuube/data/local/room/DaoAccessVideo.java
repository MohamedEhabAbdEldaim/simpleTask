package com.midooabdaim.youtuube.data.local.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DaoAccessVideo {
    @Insert
    void add(videoInfo... nVideoInfo);

    @Insert
    void addAll(List<videoInfo> infoList);

    @Update
    void update(videoInfo... nVideoInfo);

    @Delete
    void delete(videoInfo... nVideoInfo);

    @Query("select * from videoInfo")
    List<videoInfo> getAll();

    @Query("select * from videoInfo where channel_Name=:channelName")
    List<videoInfo> getAll(String channelName);
}
