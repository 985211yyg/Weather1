package com.example.yungui.weather.ui.wxmm;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yungui.weather.R;
import com.example.yungui.weather.http.api.Api;
import com.example.yungui.weather.ui.base.BaseFragment;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class BannerFragment extends BaseFragment {
    private String url,desc;
    private TextView textView;
    private ImageView imageView;
    private Subscription subscription;
    private ProgressBar progressBar;

    public static BannerFragment newInstance(String bannerUrl,String bannerDesc) {
        BannerFragment fragment = new BannerFragment();
        Bundle data = new Bundle();
        data.putString("url", bannerUrl);
        data.putString("desc", bannerDesc);
        fragment.setArguments(data);
        return fragment;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_banner;
    }

    @Override
    protected int getMenuID() {
        return 0;
    }

    @Override
    protected void onMenuItemClick(int id) {

    }

    @Override
    protected void initView() {
        url = getArguments().getString("url");
        desc = getArguments().getString("desc");
        imageView = findView(R.id.banner_imageView);
        textView = findView(R.id.banner_desc);
        progressBar = findView(R.id.progress);
    }

    @Override
    protected void lazyFetchData() {
        Glide.with(getActivity())
                .load(url)
                .error(R.drawable.broken_image)
                .into(imageView);
        progressBar.setVisibility(View.GONE);
        textView.setText(desc);


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
