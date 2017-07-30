package com.example.yungui.weather.widgets;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by yungui on 2017/7/13.
 */

public class MyItemDecoration extends RecyclerView.ItemDecoration {
    private Paint paint;
    private int dividerColor;
    private int dividerHeight;

    /**
     *  自定义分隔条
     * @param dividerColor   分隔条颜色
     * @param dividerHeight   分隔条高度
     */
    public MyItemDecoration(int dividerColor,int dividerHeight) {
        this.dividerColor = dividerColor;
        this.dividerHeight = dividerHeight;
        paint = new Paint();
        paint.setColor(dividerColor);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        //设置外部矩形的大小
        int itemPosition = parent.getChildAdapterPosition(view);
        //第一个item 不用设置分隔区域
        if (itemPosition != 0) {
            //设置狂宽度为10 的 矩形区域  在ondraw()中会将制定高度的divider绘制在该矩形区域
            outRect.set(0,0,0,10);
        }
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        //获取自子view的数量
        int index = parent.getChildCount();
        //遍历每个item  获取他们的位置信息，确定 分隔条 绘制位置
        for (int i = 0; i < index; i++) {
            //获取子view
            View child = parent.getChildAt(i);

            int itemIndex = parent.getChildAdapterPosition(child);
            //第一个itemview不用绘制
            if (itemIndex == 0) {
                continue;
            }
            //获取itemView的布局参数
            RecyclerView.LayoutParams childLayoutParams = (RecyclerView.LayoutParams) child.getLayoutParams();

            //确定divider左边位置，于itemview左边对齐,也就是recycleview的左边对齐，外边距开始
            int left = parent.getPaddingLeft();

            //上一个 child 的bottom + child 距离recycleview底部的距离 + child在数值方向上的移动距离 translateY
            int top = child.getBottom() + childLayoutParams.bottomMargin + Math.round(ViewCompat.getTranslationY(child));

            //divider 的右边位置,与itemView对齐
            int right = parent.getRight() - parent.getPaddingRight();

            //divider 的底部位置
            int bottom = top + dividerHeight;

            //绘制divider
            c.drawRect(left,top,right,bottom,paint);

        }
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
    }
}
