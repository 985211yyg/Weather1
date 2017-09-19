package com.example.yungui.weather.ui.nh.fragment;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.yungui.weather.R;
import com.example.yungui.weather.http.ApiFactory;
import com.example.yungui.weather.http.api.Api;
import com.example.yungui.weather.modle.nh.NH_DataBean;
import com.example.yungui.weather.modle.nh.NH_MovieList;
import com.example.yungui.weather.modle.nh.NH_ReadingList;
import com.example.yungui.weather.ui.MainActivity;
import com.example.yungui.weather.ui.base.BaseFragment;
import com.example.yungui.weather.ui.nh.NHDetailActivity;
import com.example.yungui.weather.ui.nh.adapter.NHMovieRecyclerViewAdapter;
import com.example.yungui.weather.ui.nh.adapter.NHReadRecyclerViewAdapter;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class NHMovieFragment extends BaseFragment {
    private Toolbar toolbar;
    private Subscription subscription;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private NHMovieRecyclerViewAdapter movieRecyclerViewAdapter;

    public NHMovieFragment() {
    }

    public static NHMovieFragment newInstance(String param1, String param2) {
        NHMovieFragment fragment = new NHMovieFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_nhmovie;
    }


    @Override
    protected void initView() {
        toolbar = findView(R.id.toolbar);
        toolbar.setTitle("影视");
        ((MainActivity) getActivity()).initToolbar(toolbar);

        recyclerView = findView(R.id.movie_recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        swipeRefreshLayout = findView(R.id.movie_refresh);
        swipeRefreshLayout.setRefreshing(true);

        movieRecyclerViewAdapter = new NHMovieRecyclerViewAdapter(R.layout.nh_item_movie, null);
        recyclerView.setAdapter(movieRecyclerViewAdapter);
        movieRecyclerViewAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(mContext, NHDetailActivity.class);
                intent.putExtra("tag", "movie");
                intent.putExtra("title", ((NH_MovieList.DataBean) adapter.getData().get(position)).getTitle());
                intent.putExtra("url", ((NH_MovieList.DataBean) adapter.getData().get(position)).getShare_url());
                intent.putExtra("img", ((NH_MovieList.DataBean) adapter.getData().get(position)).getImg_url());
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
                .getMovieList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NH_MovieList>() {
                    @Override
                    public void onCompleted() {
                        Log.e(TAG, "onCompleted: ");
                        swipeRefreshLayout.setRefreshing(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: ");

                    }

                    @Override
                    public void onNext(NH_MovieList nh_movieList) {
                        Log.e(TAG, "onNext: " + nh_movieList.getData().size());
                        if (movieRecyclerViewAdapter.getData() == null || movieRecyclerViewAdapter.getData().size() == 0) {
                            movieRecyclerViewAdapter.setNewData(nh_movieList.getData());
                            Log.e(TAG, "readRecyclerViewAdapter: ");
                        } else {
                            movieRecyclerViewAdapter.addData(movieRecyclerViewAdapter.getData().size(), nh_movieList.getData());
                        }
                        movieRecyclerViewAdapter.notifyDataSetChanged();
                    }
                });


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (subscription != null) {
            subscription.isUnsubscribed();
            subscription = null;
        }

    }

}
