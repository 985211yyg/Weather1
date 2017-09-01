package com.example.yungui.weather.ui.nh.fragment;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.animation.BaseAnimation;
import com.example.yungui.weather.R;
import com.example.yungui.weather.ui.nh.PicShareActivity;
import com.example.yungui.weather.ui.nh.adapter.BottomSheetRecycleAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BottomSheetDialogFragment extends android.support.design.widget.BottomSheetDialogFragment {

    private static final String ARG_ITEM_COUNT = "item_count";
    private static final String ARG_LAYOUT_ID = "layout_id";
    public static final String TAG = "bottom_kids";
    public static final String ARG_CONTENT = "content";
    public static final int IMG = 1;
    public static final int TEXT=2;
    public static final int IMG_TEXT = 3;

    private Listener mListener;
    private int layoutID,itemcount,tag;
    private List<Integer> data = new ArrayList<>();
    private List<String> strings = new ArrayList<>();
    private BottomSheetRecycleAdapter bottomSheetRecycleAdapter;


    public static BottomSheetDialogFragment newInstance(int itemcount, int layout_id,int tag) {
        final BottomSheetDialogFragment fragment = new BottomSheetDialogFragment();
        final Bundle args = new Bundle();
        args.putInt(TAG,tag);
        args.putInt(ARG_ITEM_COUNT, itemcount);
        args.putInt(ARG_LAYOUT_ID, layout_id);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_item_list_dialog, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.list);
        layoutID = getArguments().getInt(ARG_LAYOUT_ID);
        itemcount = getArguments().getInt(ARG_ITEM_COUNT);
        tag = getArguments().getInt(TAG);
        switch (tag) {
            case IMG:
            case IMG_TEXT:
                //分享模式
                data = Arrays.asList(R.mipmap.wx, R.mipmap.qq, R.mipmap.friends, R.mipmap.google, R.mipmap.wb);
                bottomSheetRecycleAdapter = new BottomSheetRecycleAdapter(layoutID, data);
                break;
            case TEXT:
                //生成长图模式
                data.add(-1);
                bottomSheetRecycleAdapter = new BottomSheetRecycleAdapter(layoutID, data);
                break;
        }
        bottomSheetRecycleAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(bottomSheetRecycleAdapter);
        bottomSheetRecycleAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {


                switch (tag) {
                    case IMG:
                    case IMG_TEXT:
                        mListener.onItemClicked(position);
                        //分享模式
                        break;
                    case TEXT:
                        mListener.onItemClicked(-1);
                        dismiss();
                        break;
                }
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        final Fragment parent = getParentFragment();
        if (parent != null) {
            mListener = (Listener) parent;
        } else {
            mListener = (Listener) context;
        }
    }

    @Override
    public void onDetach() {
        mListener = null;
        super.onDetach();
    }

    public interface Listener {
        void onItemClicked(int tag);
    }

}
