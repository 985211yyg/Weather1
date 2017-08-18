package com.example.yungui.weather.widgets;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**  根据获得的图片的大小重新绘制imageview
 * Created by yungui on 2017/6/30.
 */

public class RatioImageView extends android.support.v7.widget.AppCompatImageView {

    private int originalWidth;
    private int originalHeight;
    public RatioImageView(Context context) {
        this(context,null);
    }

    public RatioImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public RatioImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public void setOriginalSize(int originalWidth, int originalHeight) {
        this.originalHeight = originalHeight;
        this.originalWidth = originalWidth;
    }

    /**
     * 重新测量
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (originalWidth > 0 && originalHeight > 0) {
            //计算比例
            float ratio = (float) originalWidth / (float) originalHeight;
            //获取测量的宽高
            int width = MeasureSpec.getSize(widthMeasureSpec);
            int height = MeasureSpec.getSize(heightMeasureSpec);
            if (width > 0) {
                height = (int) (width / ratio);
            } else if (height > 0) {
                width = (int) (height / ratio);
            }
            setMeasuredDimension(width, height);
        } else {

            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }
}
