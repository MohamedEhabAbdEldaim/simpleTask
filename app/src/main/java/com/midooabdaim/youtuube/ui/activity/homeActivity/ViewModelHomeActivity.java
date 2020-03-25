package com.midooabdaim.youtuube.ui.activity.homeActivity;

import android.app.Activity;
import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.midooabdaim.youtuube.R;
import com.midooabdaim.youtuube.data.local.room.DaoAccessChannel;
import com.midooabdaim.youtuube.data.local.room.DaoAccessVideo;
import com.midooabdaim.youtuube.data.local.room.channel;
import com.midooabdaim.youtuube.data.local.room.videoInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

import static com.midooabdaim.youtuube.data.local.room.roomManger.getInstance;

public class ViewModelHomeActivity extends ViewModel {
    private DaoAccessChannel daoAccessChannel;
    private DaoAccessVideo daoAccessVideo;
    private List<channel> channelList;
    private List<videoInfo> infoList;
    public MutableLiveData<Boolean> noDataChannel;
    public MutableLiveData<Boolean> noDataVideo;

    public MutableLiveData<Boolean> getNoDataChannel() {
        if (noDataChannel == null) {
            noDataChannel = new MutableLiveData<Boolean>();
        }
        return noDataChannel;

    }

    public MutableLiveData<Boolean> getNoDataVideo() {
        if (noDataVideo == null) {
            noDataVideo = new MutableLiveData<Boolean>();
        }
        return noDataVideo;

    }

    public void getDataChannel(Context context) {
        try {
            channelList = new ArrayList<>();
            daoAccessChannel = getInstance(context).daoAccessChannel();
            Executors.newSingleThreadExecutor().execute(new Runnable() {
                @Override
                public void run() {
                    channelList = daoAccessChannel.getAll();
                }
            });
            if (channelList.size() == 0) {
                noDataChannel.postValue(true);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setDataChannel(Context context) {
        try {
            channelList = new ArrayList<>();
            daoAccessChannel = getInstance(context).daoAccessChannel();
            channel channelee = new channel("comdy", R.drawable.comdey, false);
            channelList.add(channelee);
            channel channels = new channel("oscar", R.drawable.oscar, false);
            channelList.add(channels);
            channel channele = new channel("ontime", R.drawable.ontime, false);
            channelList.add(channele);
            channel channel = new channel("الدحيح", R.drawable.dahih, false);
            channelList.add(channel);
            channel channe = new channel("football", R.drawable.footballstars, false);
            channelList.add(channe);

            Executors.newSingleThreadExecutor().execute(new Runnable() {
                @Override
                public void run() {
                    daoAccessChannel.addAll(channelList);

                }
            });


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getDataVideo(Context context) {
        try {
            infoList = new ArrayList<>();
            daoAccessVideo = getInstance(context).daoAccessVideo();
            Executors.newSingleThreadExecutor().execute(new Runnable() {
                @Override
                public void run() {
                    infoList = daoAccessVideo.getAll();
                }
            });
            if (infoList.size() == 0) {
                noDataVideo.postValue(true);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setDataVideo(Context context) {
        try {
            infoList = new ArrayList<>();
            daoAccessVideo = getInstance(context).daoAccessVideo();
            videoInfo videoInfo = new videoInfo("جائحة كورونا", "I0h3onMey-4", "الدحيح");
            infoList.add(videoInfo);
            videoInfo videoInfo1 = new videoInfo("أسوأ أم", "MhGIO7w3a9U", "الدحيح");
            infoList.add(videoInfo1);
            videoInfo videoInfo2 = new videoInfo("أشهر لوحة في العالم", "-X7dsuOPKtg", "الدحيح");
            infoList.add(videoInfo2);
            videoInfo videoInfo3 = new videoInfo("أشهر لوحة في العالم", "-X7dsuOPKtg", "الدحيح");
            infoList.add(videoInfo3);
            videoInfo videoInfo4 = new videoInfo("الشتاء قادم", "Jp_Y5P8Qpus", "الدحيح");
            infoList.add(videoInfo4);
            videoInfo videoInfo5 = new videoInfo("الظاهرة كريم بنزيمة", "wR9-qhoRfwE", "الدحيح");
            infoList.add(videoInfo5);
            videoInfo videoInfo6 = new videoInfo("ملخص مباراة برشلونة وريال مدريد", "5GjTSoYCvSo", "football");
            infoList.add(videoInfo6);
            videoInfo videoInfo7 = new videoInfo(" ملخص مباراة اتلتيكو مدريد وبرشلونة 3-2", "7iTUiVVjf1o", "football");
            infoList.add(videoInfo7);
            videoInfo videoInfo8 = new videoInfo("ملخص مباراة باريس سان جيرمان ومانشستر سيتي", "r5S46xP8fng", "football");
            infoList.add(videoInfo8);
            videoInfo videoInfo9 = new videoInfo("عادل عبد الرحمن لحسام عاشور: أنصحك بالاعتزال في النادي الأهلي", "pnsyTJ6QcYM", "ontime");
            infoList.add(videoInfo9);
            videoInfo videoInfo11 = new videoInfo("شريف إكرامي : لا يوجد لاعب في مصر يساوي 50 مليون جنيه", "WNZiPdzARN4", "ontime");
            infoList.add(videoInfo11);
            videoInfo videoInfo12 = new videoInfo("شريف إكرامي: أسلوب حياة صالح جمعة غريب ونصحته بترك الأهلي", "Ul-zDSzWiC8", "ontime");
            infoList.add(videoInfo12);
            videoInfo videoInfo13 = new videoInfo("صرريخ ضحك مع سيد بشرية لما دخل علي المعلم ابو العز", "8chY-Et7Y0s", "oscar");
            infoList.add(videoInfo13);
            videoInfo videoInfo14 = new videoInfo("صاحبك لما يكون متجوز واحدة بلدي ويعاكسوا بعض قدامك", "fNcnWCZxv2Y", "oscar");
            infoList.add(videoInfo14);
            videoInfo videoInfo15 = new videoInfo("بنت سالم بيه اتخطفت واطلب فيها 100 مليون جنية", "BMCx9Z8_ck8", "oscar");
            infoList.add(videoInfo15);
            videoInfo videoInfo16 = new videoInfo("لما التوبه تكون مش نصوحة مصطفي شعبان في دكتور أمراض نسا", "i_FpFGuRz_0", "comdy");
            infoList.add(videoInfo16);
            videoInfo videoInfo17 = new videoInfo("لما تخطفك مزة شمال#مصطفي شعبان_دكتور_أمراض_نسا", "TqkM2_K7AFI", "comdy");
            infoList.add(videoInfo17);
            videoInfo videoInfo18 = new videoInfo(" لما تقوم من النوم تلاقي نفسك مع مزة ومسروق منك هدومك الداخلية", "HbADK3Dp5Wg", "comdy");
            infoList.add(videoInfo18);
            videoInfo videoInfo19 = new videoInfo("لما تكون ساعة دخلتك وتقول يا مسهل", "wcdgZTIIP6A", "comdy");
            infoList.add(videoInfo19);
            Executors.newSingleThreadExecutor().execute(new Runnable() {
                @Override
                public void run() {
                    daoAccessVideo.addAll(infoList);
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
