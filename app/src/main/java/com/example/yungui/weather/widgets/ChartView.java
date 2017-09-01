package com.example.yungui.weather.widgets;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import com.example.yungui.weather.R;
import com.example.yungui.weather.utils.SizeUtils;

import java.util.List;



public class ChartView extends View {

    private Paint paint;
    private PathMeasure mPathMeasureMax;
    private PathMeasure mPathMeasureMin;

    private float mAnimatorValue;
    private Path mDstMax;
    private Path mDstMin;


    private float mLengthMax;
    private float mLengthMin;

    private List<Integer> minTemp;
    private List<Integer> maxTemp;

    private int minValue = 0;
    private int maxValue = 0;

    Path minPath;
    Path maxPath;

    public ChartView(Context context) {
        this(context, null);
    }

    public ChartView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ChartView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
        paint.setColor(context.getResources().getColor(R.color.white));
        paint.setAntiAlias(true);
        paint.setStrokeWidth(3);
        paint.setTextSize(SizeUtils.sp2px(context, 12));

        mPathMeasureMax = new PathMeasure();
        mPathMeasureMin = new PathMeasure();
        mDstMax = new Path();
        mDstMin = new Path();
        minPath = new Path();
        maxPath = new Path();
    }

    @Override
    protected void onDraw(final Canvas canvas) {
        float width = getWidth();
        float height = getHeight();
        /**
         * 把视图进行等分
         */
        //计算高度的单位长度
        final int heightScale = (int) (height / (maxValue - minValue));
        //计算宽度的单位长度
        final int widthScale = (int) (width / (2 * minTemp.size()));

        Rect rect = new Rect();

        for (int i = 0; i < minTemp.size(); i++) {
            paint.setStyle(Paint.Style.FILL);
            if (i == 0) {
                //最大温度与最小温度的差值计算出最先温度的y坐标
                minPath.moveTo((2 * i + 1) * widthScale, (maxValue - minTemp.get(i)) * heightScale);
            } else {
                //跨国i个宽度单位，连线下一个温度最低值
                minPath.lineTo((2 * i + 1) * widthScale, (maxValue - minTemp.get(i)) * heightScale);
            }

            final String valueStr = String.valueOf(minTemp.get(i)) + "℃";
            paint.getTextBounds(valueStr, 0, valueStr.length(), rect);
            final float textHeight = rect.height();
            final float textWidth = rect.width();
            canvas.drawCircle((2 * i + 1) * widthScale,
                    (maxValue - minTemp.get(i)) * heightScale, 5, paint);
            canvas.drawText(valueStr, (2 * i + 1) * widthScale - textWidth / 2,
                    (maxValue - minTemp.get(i)) * heightScale + textHeight + 20, paint);
        }

        for (int i = 0; i < maxTemp.size(); i++) {
            if (i == 0) {
                maxPath.moveTo((2 * i + 1) * widthScale, (maxValue - maxTemp.get(i)) * heightScale);
            } else {
                maxPath.lineTo((2 * i + 1) * widthScale, (maxValue - maxTemp.get(i)) * heightScale);
            }
            final String valueStr = String.valueOf(maxTemp.get(i)) + "℃";
            paint.getTextBounds(valueStr, 0, valueStr.length(), rect);
            final float textHeight = rect.height();
            final float textWidth = rect.width();
            canvas.drawCircle((2 * i + 1) * widthScale, (maxValue - maxTemp.get(i)) * heightScale, 5, paint);
            canvas.drawText(valueStr, (2 * i + 1) * widthScale - textWidth / 2, (maxValue - maxTemp.get(i)) * heightScale - textHeight - 5, paint);
        }

        paint.setStyle(Paint.Style.STROKE);
        mPathMeasureMax.setPath(maxPath, false);
        mPathMeasureMin.setPath(minPath, false);

        mLengthMax = mPathMeasureMax.getLength();
        mLengthMin = mPathMeasureMin.getLength();
        super.onDraw(canvas);
        mDstMax.reset();
        mDstMin.reset();
        mDstMax.lineTo(0, 0);
        mDstMin.lineTo(0, 0);
        float stopMax = mLengthMax * mAnimatorValue;
        mPathMeasureMax.getSegment(0, stopMax, mDstMax, true);
        canvas.drawPath(mDstMax, paint);
        float stopMin = mLengthMin * mAnimatorValue;
        mPathMeasureMin.getSegment(0, stopMin, mDstMin, true);
        canvas.drawPath(mDstMin, paint);
    }

    public void setData(List<Integer> minTemp, List<Integer> maxTemp) {
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        minValue = minTemp.get(0);
        maxValue = maxTemp.get(0);
        for (int i : minTemp) {
            //获取最小值
            if (i < minValue) {
                minValue = i;
            }
        }
        for (int n : maxTemp) {
            //获取最大值
            if (n > maxValue) {
                maxValue = n;
            }
        }
        minValue = minValue - 3;
        maxValue = maxValue + 3;

        final ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 1);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                mAnimatorValue = (float) valueAnimator.getAnimatedValue();
                invalidate();
            }
        });
        valueAnimator.setDuration((minTemp.size() + 1) * 200);
        valueAnimator.setRepeatCount(0);
        valueAnimator.start();
    }
}
