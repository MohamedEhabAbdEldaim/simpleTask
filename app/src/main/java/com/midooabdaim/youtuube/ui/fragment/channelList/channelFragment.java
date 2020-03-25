package com.midooabdaim.youtuube.ui.fragment.channelList;

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
import com.midooabdaim.youtuube.data.local.room.channel;
import com.midooabdaim.youtuube.databinding.FragmentChannelBinding;
import com.midooabdaim.youtuube.ui.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import static com.midooabdaim.youtuube.data.local.room.roomManger.getInstance;

/**
 * A simple {@link Fragment} subclass.
 */
public class channelFragment extends BaseFragment {
    private FragmentChannelBinding binding;
    private LinearLayoutManager linearLayoutManager;
    private ViewModelFragmentChannel viewModelFragmentChannel;
    private ChannelsAdapter channelAdapter;
    private List<channel> channelList;

    public channelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        intialFragment();
        //  return inflater.inflate(R.layout.fragment_channel, container, false);
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_channel, container, false);
        View view = binding.getRoot();
        viewModelFragmentChannel = ViewModelProviders.of(getActivity()).get(ViewModelFragmentChannel.class);
        binding.setLifecycleOwner(getActivity());
        initRecyclerView();

        viewModelFragmentChannel.getMutableLiveData().observe(getActivity(), new Observer<List<channel>>() {
            @Override
            public void onChanged(List<channel> channels) {
                praperRecycler(channels);
            }
        });

        return view;
    }

    private void initRecyclerView() {
        linearLayoutManager = new LinearLayoutManager(getActivity());
        binding.fragmentChannelRvChannel.setLayoutManager(linearLayoutManager);
        //testedData();
        viewModelFragmentChannel.getChannel(getActivity(), true);

    }

   /* private void testedData() {
        channelList = new ArrayList<>();
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
        channelAdapter = new ChannelsAdapter(getActivity(), channelList, channelFragment.this);
        binding.fragmentChannelRvChannel.setAdapter(channelAdapter);
    }*/

    public void recycle() {
        viewModelFragmentChannel.getChannel(getActivity(), false);
    }


    private void praperRecycler(List<channel> channels) {
        channelAdapter = new ChannelsAdapter(getActivity(), channels, channelFragment.this);
        binding.fragmentChannelRvChannel.setAdapter(channelAdapter);
        channelAdapter.notifyDataSetChanged();
    }

    @Override
    public void onStart() {
        intialFragment();
        super.onStart();
    }

    @Override
    public void BackPressed() {
        getActivity().finish();
    }

}
