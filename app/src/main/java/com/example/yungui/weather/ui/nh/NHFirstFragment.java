package com.example.yungui.weather.ui.nh;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yungui.weather.R;
import com.example.yungui.weather.http.ApiFactory;
import com.example.yungui.weather.http.api.Api;
import com.example.yungui.weather.modle.nh.NH_DataBean;
import com.example.yungui.weather.modle.nh.NH_IDList;
import com.example.yungui.weather.ui.MainActivity;
import com.example.yungui.weather.ui.base.BaseFragment;
import com.sdsmdg.harjot.vectormaster.VectorMasterView;
import com.sdsmdg.harjot.vectormaster.models.ClipPathModel;
import com.sdsmdg.harjot.vectormaster.models.GroupModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class NHFirstFragment extends BaseFragment {
    private Toolbar toolbar;
    private VectorMasterView hourglassView;
    private int state;
    private float translationY,rotation;
    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;
    private RecyclerView recyclerView;

    private Subscription subscription;
    private List<String> idList = new ArrayList<>();
    private List<NH_DataBean> dataBeanList = new ArrayList<>();
    private int initLoadCount = 2;

    public NHFirstFragment() {

    }

    public static NHFirstFragment newInstance(int columnCount) {
        NHFirstFragment fragment = new NHFirstFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_nh_first;
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
        toolbar = findView(R.id.toolbar);
        ((MainActivity) getActivity()).initToolbar(toolbar);
        hourglassView = findView(R.id.hourglassView);
        animateHourglass();
    }

    @Override
    protected void lazyFetchData() {
        idList.clear();
        dataBeanList.clear();
        subscription = ApiFactory
                .getNhController()
                .getIDList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NH_IDList>() {
                    @Override
                    public void onCompleted() {
                        Log.e(TAG, "onCompleted: "+1 );

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: "+e.toString() );

                    }

                    @Override
                    public void onNext(NH_IDList nh_idList) {
                        idList = nh_idList.getData();
                        for (int i = 0; i < initLoadCount; i++) {
                            ApiFactory
                                    .getNhController()
                                    .getIDListItem(idList.get(i))
                                    .subscribeOn(Schedulers.io())
                                    .observeOn(AndroidSchedulers.mainThread())
                                    .subscribe(new Observer<NH_DataBean>() {
                                        @Override
                                        public void onCompleted() {
                                            Log.e(TAG, "onCompleted: "+2 );
                                            hourglassView.setVisibility(View.INVISIBLE);
                                        }

                                        @Override
                                        public void onError(Throwable e) {
                                            Log.e(TAG, "onError: "+e.toString() );

                                        }

                                        @Override
                                        public void onNext(NH_DataBean nh_dataBean) {
                                            Log.e(TAG, "onNext: "+nh_dataBean.equals(null) );
                                            dataBeanList.add(nh_dataBean);
                                            Log.e(TAG, "onNext:dataBeanList的个数L: "+dataBeanList.size());
                                        }
                                    });


                        }
                    }
                });


    }
    private void animateHourglass() {
        final GroupModel frame = hourglassView.getGroupModelByName("hourglass_frame");
        final GroupModel fillOutlines = hourglassView.getGroupModelByName("fill_outlines");
        final GroupModel fillOutlinesPivot = hourglassView.getGroupModelByName("fill_outlines_pivot");
        final GroupModel group_fill_path = hourglassView.getGroupModelByName("group_fill_path");

        ClipPathModel mask = hourglassView.getClipPathModelByName("mask_1");

         state = 0;
         translationY = -24;

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (state == 0) {	// Slide the clip-path down by changing translationY of parent group
                    translationY += 0.3f;
                    fillOutlinesPivot.setTranslateY(translationY);
                    group_fill_path.setTranslateY(-1 * translationY);
                    if (translationY >= -12) {
                        state = 1;
                    }
                } else if (state == 1) {	// Rotate the groups by 180 degress
                    rotation += 3f;
                    frame.setRotation(rotation);
                    fillOutlines.setRotation(rotation);
                    if (rotation == 180) {
                        state = 2;
                    }
                } else if (state == 2) {	// Slide the clip-path up by changing translationY of parent group
                    translationY -= 0.3f;
                    fillOutlinesPivot.setTranslateY(translationY);
                    group_fill_path.setTranslateY(-1 * translationY);
                    if (translationY <= -24) {
                        state = 3;
                    }
                } else if (state == 3) { 	// Rotate the groups by 180 degress
                    rotation += 3f;
                    frame.setRotation(rotation);
                    fillOutlines.setRotation(rotation);
                    if (rotation == 360) {
                        rotation = 0;
                        state = 0;
                    }
                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        hourglassView.update();		// Update the view from the UI thread
                    }
                });
            }
        }, 500, 1000 / 60);
    }


}
