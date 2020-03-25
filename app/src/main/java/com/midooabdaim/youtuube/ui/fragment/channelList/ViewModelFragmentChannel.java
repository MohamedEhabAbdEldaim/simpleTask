package com.midooabdaim.youtuube.ui.fragment.channelList;

import android.app.Activity;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.midooabdaim.youtuube.data.local.room.DaoAccessChannel;
import com.midooabdaim.youtuube.data.local.room.channel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

import static com.midooabdaim.youtuube.data.local.room.roomManger.destroyInstance;
import static com.midooabdaim.youtuube.data.local.room.roomManger.getInstance;

public class ViewModelFragmentChannel extends ViewModel {

    private MutableLiveData<List<channel>> mutableLiveData;
    private DaoAccessChannel dao;
    private List<channel> channelList;

    public MutableLiveData<List<channel>> getMutableLiveData() {
        if (mutableLiveData == null) {
            mutableLiveData = new MutableLiveData<List<channel>>();
        }
        return mutableLiveData;
    }

    public void getChannel(Activity activity, boolean b) {
        dao = getInstance(activity).daoAccessChannel();

        try {
            channelList = new ArrayList<>();
            if (b) {

                Executors.newSingleThreadExecutor().execute(new Runnable() {
                    @Override
                    public void run() {
                        channelList = dao.getAll();
                    }
                });
                mutableLiveData.setValue(channelList);
            } else {

                Executors.newSingleThreadExecutor().execute(new Runnable() {
                    @Override
                    public void run() {
                        channelList = dao.getAll();
                    }
                });
                mutableLiveData.postValue(channelList);
            }

        } catch (Exception e) {
        }
    }


}
