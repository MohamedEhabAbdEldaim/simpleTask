package com.midooabdaim.youtuube.ui.fragment.videoList;

import android.app.Activity;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.midooabdaim.youtuube.data.local.room.DaoAccessVideo;
import com.midooabdaim.youtuube.data.local.room.videoInfo;

import java.util.List;
import java.util.concurrent.Executors;

import static com.midooabdaim.youtuube.data.local.room.roomManger.getInstance;

public class ViewModelVideoList extends ViewModel {
    private MutableLiveData<List<videoInfo>> mutableLiveData;
    private DaoAccessVideo daoAccessVideo;

    public MutableLiveData<List<videoInfo>> getMutableLiveData() {
        if (mutableLiveData == null) {
            mutableLiveData = new MutableLiveData<List<videoInfo>>();
        }
        return mutableLiveData;
    }

    public void getVideo(Activity activity, final String channel) {
        daoAccessVideo = getInstance(activity).daoAccessVideo();
        try {
            Executors.newSingleThreadExecutor().execute(new Runnable() {
                @Override
                public void run() {
                    mutableLiveData.setValue(daoAccessVideo.getAll(channel));
                }
            });

        } catch (Exception e) {
        }
    }

}
