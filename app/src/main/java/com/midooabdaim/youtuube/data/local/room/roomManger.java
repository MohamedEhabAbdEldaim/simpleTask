package com.midooabdaim.youtuube.data.local.room;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {channel.class, videoInfo.class}, version = 1, exportSchema = false)
public abstract class roomManger extends RoomDatabase {
    private static roomManger roomManger;

    public abstract DaoAccessChannel daoAccessChannel();

    public abstract DaoAccessVideo daoAccessVideo();

    public static synchronized roomManger getInstance(Context context) {
        if (roomManger == null) {
            roomManger = Room.databaseBuilder(context.getApplicationContext()
                    , roomManger.class, "DataBaseName")
                    .fallbackToDestructiveMigration()
                    // .allowMainThreadQueries()
                    .build();
        }
        return roomManger;
    }

    public static void destroyInstance() {
        roomManger = null;
    }
}
