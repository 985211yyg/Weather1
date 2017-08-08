package com.example.yungui.weather.widgets;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import uk.co.senab.photoview.PhotoView;

/**
 * Created by yungui on 2017/7/1.
 */

public class DragPhotoView extends PhotoView {

    private Paint mPaint;

    private int mHeight;
    private int mWidth;

    //手指的触摸坐标
    private float mDownX;
    private float mDownY;

    //移动的坐标
    private float mTranslateX;
    private float mTranslateY;




    //缩放尺寸
    private float mScale = 1.0f;
    private float mMidScale = 0.75f;
    private float mMinScale = 0.5f;

    public static final float DEFAULT_MAX_SCALE = 3.0f;
    public static final float DEFAULT_MID_SCALE = 1.75f;
    public static final float DEFAULT_MIN_SCALE = 1.0f;

    //透明度
    private int mAlpha;
    //最大的竖直方向的移动距离
    private final static int MAX_TRANSLATE_Y = 400;

    //定义一个时间
    private final static long DURATION = 300;

    private boolean canFinish = false;
    private boolean isAnimate = false;

    //相关的时间
    private boolean isTouchEvent = false;

    //相关的事件回调借口接口
    //点击事件
    private OnTapListener tapListener;
    //退出事件
    private OnExitListener exitListener;

    public static final String TAG = DragPhotoView.class.getSimpleName();

    public DragPhotoView(Context context) {
        this(context, null);
    }

    public DragPhotoView(Context context, AttributeSet attr) {
        this(context, attr, 0);
    }

    public DragPhotoView(Context context, AttributeSet attr, int defStyle) {
        super(context, attr, defStyle);
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
    }

    //根据给出的数据实时重绘
    @Override
    protected void onDraw(Canvas canvas) {
        mPaint.setAlpha(mAlpha);
        //绘制背景
        canvas.drawRect(0, 0, mWidth, mHeight, mPaint);
        //设置画布的  去除水平方向的移动
        canvas.translate(0, mTranslateY);
        //设置缩放,中心缩放
//        canvas.scale(mScale, mScale, mWidth / 2, mHeight / 2);
        super.onDraw(canvas);
    }

    /**
     * 如果大小发生改变时候的回调
     *
     * @param w
     * @param h
     * @param oldw
     * @param oldh
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
       //重置改变后的尺寸
        mWidth = w;
        mHeight = h;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        //只有当没有缩放的时候能拖动
//        if (getScale() == DEFAULT_MIN_SCALE) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    onActionDown(event);
                    //改变标记，表示开始触摸
                    canFinish = true;
                    break;

                case MotionEvent.ACTION_MOVE:
                    //上下滑动
                    if (Math.abs(mTranslateX) <= Math.abs(mTranslateY) && event.getPointerCount() == 1) {
                        onActionMove(event);
                        isTouchEvent = true;
                        //传出滑动的参数
                        exitListener.onExit(this, mTranslateX, mTranslateY, mWidth, mHeight);
                    } else {
                        //左右滑动
                        isTouchEvent = false;
                        return super.dispatchTouchEvent(event);
                    }


                    break;

                case MotionEvent.ACTION_UP:
                    if (event.getPointerCount() == 1) {
                        onActionUp(event);
                        isTouchEvent = false;
                        postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                if (mTranslateX == 0 && mTranslateY == 0 && canFinish) {
                                    if (tapListener != null) {
                                        tapListener.onTap(DragPhotoView.this);
                                    }
                                }
                                canFinish = false;
                            }
                        }, 300);
                    }
            }
//        }

        return super.dispatchTouchEvent(event);
    }

    /**
     * ===========================================================
     * 获取手放下时的坐标
     *
     * @param event
     */
    private void onActionDown(MotionEvent event) {
        //获取点击的坐标
        mDownY = event.getY();
        mDownX = event.getX();

    }

    //处理移动事件,缩放，透明度
    private void onActionMove(MotionEvent event) {
        float moveY = event.getY();
        float moveX = event.getX();
        //计算手指滑动的距离
        mTranslateX = moveX - mDownX;
        mTranslateY = moveY - mDownY;
//        Log.e(TAG, "onActionMove: dy==========" + mTranslateY + "\n" + "dx======" + mTranslateX);
        //根据滑动距离与最大滑动距离的比例来确定缩放比例
        float percent = Math.abs(mTranslateY / MAX_TRANSLATE_Y);
        //计算透明度
        mAlpha = (int) (255 * (1 - percent));
        //控制透明的值
        if (mAlpha > 255) {
            mAlpha = 255;
        } else if (mAlpha < 0) {
            mAlpha = 0;
        }
        //通知重绘
        invalidate();
    }

    private void onActionUp(MotionEvent event) {
        //如果没有超过最大的移动距离，绘制动画
        performAnimation();

    }

    private void performAnimation() {
        //缩放动画
        getScaleAnimation().start();
        //位移动画
        getTranslateXAnimation().start();
        getTranslateYAnimation().start();
        //透明度改变动画
        getAlphaAnimation().start();
    }

    private ValueAnimator getAlphaAnimation() {
        ValueAnimator animator = ValueAnimator.ofInt(mAlpha, 255);
        animator.setDuration(DURATION);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mAlpha = (int) animation.getAnimatedValue();
            }
        });
        return animator;
    }

    private ValueAnimator getTranslateYAnimation() {
        ValueAnimator animator = ValueAnimator.ofFloat(mTranslateY, 0);
        animator.setDuration(DURATION);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //监听赢的距离来控值缩放比例，是的动画平滑
                mTranslateY = (float) animation.getAnimatedValue();
            }
        });
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                finishAnimationCallBack();
            }
        });
        return animator;
    }

    private ValueAnimator getTranslateXAnimation() {
        ValueAnimator animator = ValueAnimator.ofFloat(mTranslateX, 0);
        animator.setDuration(DURATION);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mTranslateX = (float) animation.getAnimatedValue();
                invalidate();
            }
        });
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                finishAnimationCallBack();
            }
        });

        return animator;
    }

    private ValueAnimator getScaleAnimation() {
        ValueAnimator animator = ValueAnimator.ofFloat(mScale, 1);
        animator.setDuration(DURATION);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mScale = (float) animation.getAnimatedValue();
            }
        });
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                isAnimate = false;
                animator.removeAllUpdateListeners();

            }

            @Override
            public void onAnimationStart(Animator animation) {
                isAnimate = true;
            }

        });
        return animator;
    }

    public float getMinScale() {
        return mMinScale;
    }

    public void setMinScale(float mMinScale) {
        this.mMinScale = mMinScale;
    }

    public void setExitListener(OnExitListener exitListener) {
        this.exitListener = exitListener;
    }

    public void setTapListener(OnTapListener tapListener) {
        this.tapListener = tapListener;
    }

    //完成动画的返回原来的位置
    public void finishAnimationCallBack() {
        mTranslateY = 0;
        mTranslateX = 0;
    }

    public interface OnTapListener {
        void onTap(DragPhotoView dragPhotoView);
    }

    public interface OnExitListener {
        void onExit(DragPhotoView dragPhotoView, float translateX, float translateY, float W, float Y);
    }

}
