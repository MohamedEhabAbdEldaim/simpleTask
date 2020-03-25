package com.midooabdaim.youtuube.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.midooabdaim.youtuube.R;
import com.midooabdaim.youtuube.databinding.FragmentLoadDataBinding;
import com.midooabdaim.youtuube.ui.activity.homeActivity.MainActivity;
import com.midooabdaim.youtuube.ui.activity.homeActivity.ViewModelHomeActivity;
import com.midooabdaim.youtuube.ui.fragment.channelList.ViewModelFragmentChannel;
import com.midooabdaim.youtuube.ui.fragment.channelList.channelFragment;

import static com.midooabdaim.youtuube.helper.MethodHelper.replaceFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoadDataToRoomFragment extends BaseFragment {
    private FragmentLoadDataBinding binding;
    private ViewModelHomeActivity viewModel;

    public LoadDataToRoomFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        intialFragment();
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_load_data, container, false);
        View view = binding.getRoot();
        viewModel = ViewModelProviders.of(getActivity()).get(ViewModelHomeActivity.class);
        binding.setLifecycleOwner(getActivity());
        viewModel.noDataChannel = new MutableLiveData<>();
        viewModel.noDataVideo = new MutableLiveData<>();
        viewModel.noDataChannel.setValue(false);
        viewModel.noDataVideo.setValue(false);
        viewModel.getNoDataChannel().observe(getActivity(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    viewModel.setDataChannel(getActivity());
                }
            }
        });

        viewModel.getNoDataVideo().observe(getActivity(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    viewModel.setDataVideo(getActivity());
                }
            }
        });


        initView();
        return view;
    }

    private void initView() {
        binding.fragmentLoadDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.getDataChannel(getActivity());
                viewModel.getDataVideo(getActivity());
                replaceFragment(getActivity().getSupportFragmentManager(), R.id.activity_home_frame_layout_id, new channelFragment());

            }
        });
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
