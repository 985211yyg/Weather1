package com.example.yungui.weather.ui.welfare;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.yungui.weather.R;
import com.example.yungui.weather.ui.base.BaseFragment;
import com.example.yungui.weather.widgets.DragPhotoView;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends BaseFragment implements DragPhotoView.OnExitListener{

    private static final String URL = "url";
    private static final String POS = "position";
    private static final String TAG = "PlaceholderFragment";

    private DragPhotoView dragPhotoView;
    private RelativeLayout picContainer;
    private boolean isAttached = false;

    public PlaceholderFragment() {
    }

    public static PlaceholderFragment newInstance(String url, int position) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putString(URL, url);
        args.putInt(POS, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_pic_detail;
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
        dragPhotoView = findView(R.id.pic_imageView);
        dragPhotoView.setExitListener(this);
        picContainer = findView(R.id.pic_container);
        fillPhoto();

    }

    private void fillPhoto() {
        if (getArguments().get(URL) != null) {
            Glide.with(getActivity())
                    .load(getArguments().get(URL))
                    .error(R.drawable.broken_image)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(dragPhotoView);
        }
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        isAttached = true;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        isAttached = false;
    }


    @Override
    protected void lazyFetchData() {

    }

    @Override
    public void onExit(DragPhotoView dragPhotoView, float translateX, float translateY, float W, float Y) {
        Log.e(TAG, "onExit: "+translateX );
        //透明度 0~255
//        picContainer.setAlpha(Math.abs(translateY));
//        if (translateY > 50) {
//            getActivity().finish();
//        }
    }

}
