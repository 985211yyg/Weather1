package com.example.yungui.weather.ui.nh.fragment;


import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.yungui.weather.R;
import com.example.yungui.weather.http.ApiFactory;
import com.example.yungui.weather.modle.nh.NH_MusicList;
import com.example.yungui.weather.ui.MainActivity;
import com.example.yungui.weather.ui.base.BaseFragment;
import com.example.yungui.weather.ui.nh.NHDetailActivity;
import com.example.yungui.weather.ui.nh.adapter.NHMusicRecyclerViewAdapter;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NHMusicFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NHMusicFragment extends BaseFragment {
    private Toolbar toolbar;
    private Subscription subscription;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;

    private NHMusicRecyclerViewAdapter musicRecyclerViewAdapter;

    public NHMusicFragment() {
    }


    public static NHMusicFragment newInstance(String param1, String param2) {
        NHMusicFragment fragment = new NHMusicFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int getLayoutID() {
        return R.layout.fragment_nhmusic;
    }


    @Override
    protected void initView() {
        toolbar = findView(R.id.toolbar);
        toolbar.setTitle("音乐");
        ((MainActivity) getActivity()).initToolbar(toolbar);

        recyclerView = findView(R.id.music_recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        swipeRefreshLayout = findView(R.id.music_refresh);
        swipeRefreshLayout.setRefreshing(true);

        musicRecyclerViewAdapter = new NHMusicRecyclerViewAdapter(R.layout.nh_item_music, null);
        recyclerView.setAdapter(musicRecyclerViewAdapter);
        musicRecyclerViewAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(mContext, NHDetailActivity.class);
                intent.putExtra("tag", "music");
                intent.putExtra("title", ((NH_MusicList.DataBean) adapter.getData().get(position)).getTitle());
                intent.putExtra("url", ((NH_MusicList.DataBean) adapter.getData().get(position)).getShare_url());
                intent.putExtra("img", ((NH_MusicList.DataBean) adapter.getData().get(position)).getImg_url());
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(getActivity(),
                        view.findViewById(R.id.img), "shareImg").toBundle());
            }
        });
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(false);
            }
        });

    }

    @Override
    protected void lazyFetchData() {
        subscription = ApiFactory
                .getNhController()
                .getMusicList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NH_MusicList>() {
                    @Override
                    public void onCompleted() {
                        Log.e(TAG, "onCompleted: " );
                        swipeRefreshLayout.setRefreshing(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: " );

                    }

                    @Override
                    public void onNext(NH_MusicList nh_musicList) {
                        Log.e(TAG, "onNext: "+nh_musicList.getData().size());
                        if (musicRecyclerViewAdapter.getData() == null || musicRecyclerViewAdapter.getData().size() == 0) {
                            musicRecyclerViewAdapter.setNewData(nh_musicList.getData());
                            Log.e(TAG, "readRecyclerViewAdapter: " );
                        } else {
                            musicRecyclerViewAdapter.addData(musicRecyclerViewAdapter.getData().size(),nh_musicList.getData());
                        }
                        musicRecyclerViewAdapter.notifyDataSetChanged();
                    }
                });

    }


}
