package com.example.yungui.weather.ui.video;

import android.animation.Animator;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.yungui.weather.R;
import com.example.yungui.weather.ui.video.adapter.VideoSearchAdapter;
import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yungui on 2017/7/25.
 */

public class VideoSearchFragment extends DialogFragment {
    private RecyclerView recyclerView;
    private VideoSearchAdapter videoSearchAdapter;
    private FlexboxLayoutManager flexboxLayoutManager;
    private List<String> exampleKeys = Arrays.asList("脱口秀", "城会玩", "666", "笑cry", "漫威",
            "清新", "匠心", "VR", "心理学", "舞蹈", "品牌广告", "粉丝自制", "电影相关", "萝莉", "魔性"
            , "第一视角", "教程", "毕业设计", "奥斯卡", "燃", "冰与火之歌", "温情", "线下campaign", "公益");

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Window window = getDialog().getWindow();
        View view = inflater.inflate(R.layout.fragment_video_search, (ViewGroup) window.findViewById(android.R.id.content), false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        setData();

    }

    private void initView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        flexboxLayoutManager = new FlexboxLayoutManager();
        flexboxLayoutManager.setFlexDirection(FlexDirection.ROW);
        flexboxLayoutManager.setJustifyContent(JustifyContent.FLEX_START);
        flexboxLayoutManager.setFlexWrap(FlexWrap.WRAP);
        flexboxLayoutManager.setAlignItems(AlignItems.STRETCH);
        recyclerView.setLayoutManager(flexboxLayoutManager);
        videoSearchAdapter = new VideoSearchAdapter(R.layout.keys_example, exampleKeys);
        recyclerView.setAdapter(videoSearchAdapter);
        videoSearchAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                String key = (String) adapter.getData().get(position);
                Intent intent = new Intent(getActivity(), VideoDetailActivity.class);
                intent.putExtra("key",key);
                startActivity(intent);
                getDialog().dismiss();
            }
        });
    }

    private void setData() {

    }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        //设置dialog窗口的大小和动画
        getDialog().getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT);
        getDialog().getWindow().setWindowAnimations(R.style.myDialogFragmentAnim);
        super.onStart();
    }
}
