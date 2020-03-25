package com.midooabdaim.youtuube.data.local.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DaoAccessChannel {
    @Insert
    void add(channel... nChannels);

    @Insert
    void addAll(List<channel> lists);

    @Update
    void update(channel... nChannels);

    @Delete
    void delete(channel... nChannels);

    @Query("select * from channel")
    List<channel> getAll();

    @Query("select * from channel where channelSubscrption=:sub")
    List<channel> getAllSub(boolean sub);

}
