package com.midooabdaim.youtuube.ui.fragment.videoList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.midooabdaim.youtuube.R;
import com.midooabdaim.youtuube.adapter.ChannelsAdapter;
import com.midooabdaim.youtuube.adapter.VideoAdapter;
import com.midooabdaim.youtuube.data.local.room.channel;
import com.midooabdaim.youtuube.data.local.room.videoInfo;
import com.midooabdaim.youtuube.databinding.FragmentVideoListBinding;
import com.midooabdaim.youtuube.ui.fragment.BaseFragment;
import com.midooabdaim.youtuube.ui.fragment.channelList.ViewModelFragmentChannel;
import com.midooabdaim.youtuube.ui.fragment.channelList.channelFragment;

import java.util.ArrayList;
import java.util.List;

import static com.midooabdaim.youtuube.data.local.room.roomManger.getInstance;

/**
 * A simple {@link Fragment} subclass.
 */
public class videoChannelListFragment extends BaseFragment {

    private FragmentVideoListBinding binding;
    private LinearLayoutManager linearLayoutManager;
    private ViewModelVideoList viewModelVideoList;
    public channel channel;
    private VideoAdapter videoAdapter;
    private List<videoInfo> infoList;

    public videoChannelListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        intialFragment();

        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_video_list, container, false);
        View view = binding.getRoot();
        viewModelVideoList = ViewModelProviders.of(getActivity()).get(ViewModelVideoList.class);
        binding.setLifecycleOwner(getActivity());
        initRecyclerView();
        viewModelVideoList.getMutableLiveData().observe(getActivity(), new Observer<List<videoInfo>>() {
            @Override
            public void onChanged(List<videoInfo> videoInfos) {
                praperRecycler(videoInfos);

            }
        });
        //return inflater.inflate(R.layout.fragment_video_list, container, false);
        return view;
    }

    private void initRecyclerView() {
        linearLayoutManager = new LinearLayoutManager(getActivity());
        binding.fragmentVideoRcVideo.setLayoutManager(linearLayoutManager);
        // testedData();
        viewModelVideoList.getVideo(getActivity(), channel.getChannelName());
    }

 /*   private void testedData() {
        infoList = new ArrayList<>();

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
        channel channels = new channel("oscar", R.drawable.oscar, false);
        videoAdapter = new VideoAdapter(getActivity(), infoList,channels);
        binding.fragmentVideoRcVideo.setAdapter(videoAdapter);
    }*/

    private void praperRecycler(List<videoInfo> videoInfos) {
        videoAdapter = new VideoAdapter(getActivity(), videoInfos, channel);
        binding.fragmentVideoRcVideo.setAdapter(videoAdapter);
        videoAdapter.notifyDataSetChanged();
    }


    @Override
    public void onStart() {
        intialFragment();
        super.onStart();
    }

    @Override
    public void BackPressed() {
        super.BackPressed();
    }

}
