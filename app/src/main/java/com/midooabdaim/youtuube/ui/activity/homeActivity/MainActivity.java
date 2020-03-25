package com.midooabdaim.youtuube.ui.activity.homeActivity;

import android.os.Bundle;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.midooabdaim.youtuube.R;
import com.midooabdaim.youtuube.ui.activity.BaseActivity;
import com.midooabdaim.youtuube.ui.fragment.LoadDataToRoomFragment;
import com.midooabdaim.youtuube.ui.fragment.channelList.channelFragment;

import static com.midooabdaim.youtuube.data.local.room.roomManger.getInstance;
import static com.midooabdaim.youtuube.helper.MethodHelper.replaceFragment;

public class MainActivity extends BaseActivity {

    private ViewModelHomeActivity modelHomeActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        modelHomeActivity = ViewModelProviders.of(this).get(ViewModelHomeActivity.class);
        modelHomeActivity.noDataChannel = new MutableLiveData<>();
        modelHomeActivity.noDataVideo = new MutableLiveData<>();
        modelHomeActivity.noDataChannel.setValue(false);
        modelHomeActivity.noDataVideo.setValue(false);

        modelHomeActivity.getDataChannel(this);
        modelHomeActivity.getDataVideo(this);

        modelHomeActivity.getNoDataChannel().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    modelHomeActivity.setDataChannel(MainActivity.this);
                }
            }
        });

        modelHomeActivity.getNoDataVideo().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    modelHomeActivity.setDataVideo(MainActivity.this);
                }
            }
        });

//        replaceFragment(getSupportFragmentManager(), R.id.activity_home_frame_layout_id, new LoadDataToRoomFragment());
        replaceFragment(getSupportFragmentManager(), R.id.activity_home_frame_layout_id, new channelFragment());

    }


}
