package com.example.yungui.weather.widgets;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.example.yungui.weather.R;

/**
 * Created by yungui on 2017/8/9.
 */

public class CustomPopupWindow {
    private Context mContext;
    private int Width;
    private int Height;



    private boolean IsFocusable=true;
    private boolean IsOutSideTouch  = true;
    private int ResLayoutId = -1;
    private View contentView;
    private PopupWindow popupWindow;
    private int AnimationStyle = -1;

    private boolean clipEnable = true;
    private boolean ignoreCheekPress = false;
    private int inputMode = -1;
    private PopupWindow.OnDismissListener dismissListener;
    private int softInputMode = -1;
    private boolean touchable = true;
    private View.OnTouchListener touchListener;


    //私有的构造方法
    private CustomPopupWindow(Context mContext) {
        this.mContext = mContext;
    }

    /**
     * 宽高的getsetter方法
     *
     */
    public int getWidth() {
        return Width;
    }

    public int getHeight() {
        return Height;
    }

    /**
     * customPopupWindow的showAsDropDown()方法，代理popupWindow 的方法
     */
    public CustomPopupWindow showAsDropDown(View anchor, int xOff, int yOff) {
        if (popupWindow != null) {
            popupWindow.showAsDropDown(anchor,xOff,yOff);
        }
        return this;
    }
    public CustomPopupWindow showAsDropDown(View anchor) {
        if (popupWindow != null) {
            popupWindow.showAsDropDown(anchor);
        }
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public CustomPopupWindow showAsDropDown(View anchor, int xOff, int yOff,int  gravity) {
        if (popupWindow != null) {
            popupWindow.showAsDropDown(anchor,xOff,yOff,gravity);
        }
        return this;
    }
    public CustomPopupWindow showAtLocation(View parent, int  gravity,int x, int y) {
        if (popupWindow != null) {
            popupWindow.showAtLocation(parent,gravity,x,y);
        }
        return this;
    }

    public void dismiss() {
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    /**
     * 增加属性
     */
    private void apply(PopupWindow popupWindow) {
        popupWindow.setClippingEnabled(clipEnable);
        if (ignoreCheekPress) {
            popupWindow.setIgnoreCheekPress();
        }
        if (inputMode != -1) {
            popupWindow.setInputMethodMode(inputMode);
        }
        if (softInputMode != -1) {
            popupWindow.setSoftInputMode(softInputMode);
        }
        if (dismissListener != null) {
            popupWindow.setOnDismissListener(dismissListener);
        }
        if (touchListener != null) {
            popupWindow.setTouchInterceptor(touchListener);
        }
        popupWindow.setTouchable(touchable);
    }
    private PopupWindow build() {
        if (contentView == null) {
            contentView = LayoutInflater.from(mContext).inflate(ResLayoutId, null);
        }
        if (Width != 0 || Height != 0) {
            popupWindow = new PopupWindow(contentView, Width, Height);

        } else {
            popupWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }

        //设置的动画
        if (AnimationStyle != -1) {
            popupWindow.setAnimationStyle(AnimationStyle);
        }

        //设置属性
        apply(popupWindow);
        //外界没有设置宽高，需要计算并设置宽高
        if (Width == 0 || Height == 0) {
            popupWindow.getContentView().measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
            Height = popupWindow.getContentView().getMeasuredHeight();
            Width = popupWindow.getContentView().getMeasuredWidth();
        }
        popupWindow.update();
        return popupWindow;
    }

    /**
     * 建造者
     */
    public static class PopupWindowBuilder {
        private CustomPopupWindow customPopupWindow;

        public PopupWindowBuilder(Context context) {
            customPopupWindow = new CustomPopupWindow(context);
        }

        public PopupWindowBuilder size(int width, int height) {
            customPopupWindow.Width = width;
            customPopupWindow.Height = height;
            return this;
        }

        public PopupWindowBuilder setFocusable(boolean focusable) {
            customPopupWindow.IsFocusable = focusable;
            return this;
        }

        public PopupWindowBuilder setView(int ResLayoutId) {
            customPopupWindow.ResLayoutId = ResLayoutId;
            customPopupWindow.contentView = null;
            return this;
        }
        public PopupWindowBuilder setView(View  contentView) {
            customPopupWindow.ResLayoutId = -1;
            customPopupWindow.contentView = contentView;
            return this;
        }

        public PopupWindowBuilder setOutSideTouchable(boolean outSideTouchable) {
            customPopupWindow.IsOutSideTouch = outSideTouchable;
            return this;
        }

        /**
         * 设置弹窗
         */
        public PopupWindowBuilder setAnimationStyle(int animationStyle) {
            customPopupWindow.AnimationStyle = animationStyle;
            return this;
        }
        public PopupWindowBuilder setClippingEnable(boolean enable){
            customPopupWindow.clipEnable =enable;
            return this;
        }


        public PopupWindowBuilder setIgnoreCheekPress(boolean ignoreCheekPress){
            customPopupWindow.ignoreCheekPress = ignoreCheekPress;
            return this;
        }

        public PopupWindowBuilder setInputMethodMode(int mode){
            customPopupWindow.inputMode = mode;
            return this;
        }

        public PopupWindowBuilder setTouchIntercepter(View.OnTouchListener touchIntercepter) {
            customPopupWindow.touchListener = touchIntercepter;
            return this;
        }

        public CustomPopupWindow create() {
            //构建popupWindow
            customPopupWindow.build();
            return customPopupWindow;
        }


    }



}
