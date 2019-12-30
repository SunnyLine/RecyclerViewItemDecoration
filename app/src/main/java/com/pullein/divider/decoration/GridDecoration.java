package com.pullein.divider.decoration;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * RecyclerView Item Decoration<br>
 * describe ：表格的分割线
 *
 * @author xugang
 * @date 2019/12/30
 */
public class GridDecoration extends RecyclerView.ItemDecoration {
    //横向分割线宽度
    private int mHorizontalDividerWidth;
    //纵向分割线宽度
    private int mVerticalDividerWidth;
    //填充横向分割线资源
    private Drawable mHorizontalDividerDivider;
    //填充纵向分割线资源
    private Drawable mVerticalDividerDivider;
    //是否显示第一个横向分割线
    private boolean isShowFirstHorizontalDivider = false;
    //是否显示第一个纵向分割线
    private boolean isShowFirstVerticalDivider = false;
    //是否显示最后一个横向分割线
    private boolean isShowLastHorizontalDivider = false;
    //是否显示最后一个纵向分割线
    private boolean isShowLastVerticalDivider = false;

    public GridDecoration(@ColorInt int horizontalDividerColorId, @ColorInt int verticalDividerColorId, int mHorizontalDividerWidth, int mVerticalDividerWidth, boolean isShowFirstHorizontalDivider, boolean isShowFirstVerticalDivider, boolean isShowLastHorizontalDivider, boolean isShowLastVerticalDivider) {
        this.mHorizontalDividerWidth = mHorizontalDividerWidth;
        this.mVerticalDividerWidth = mVerticalDividerWidth;
        this.isShowFirstHorizontalDivider = isShowFirstHorizontalDivider;
        this.isShowFirstVerticalDivider = isShowFirstVerticalDivider;
        this.isShowLastHorizontalDivider = isShowLastHorizontalDivider;
        this.isShowLastVerticalDivider = isShowLastVerticalDivider;
        this.mVerticalDividerDivider = new ColorDrawable(verticalDividerColorId);
        this.mHorizontalDividerDivider = new ColorDrawable(horizontalDividerColorId);
    }

    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDraw(c, parent, state);
        drawHorizontalDivider(c, parent, state);
        drawVerticalDivider(c, parent, state);
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        calcHorizontalOffsets(outRect, view, parent, state);
        calcVerticalOffsets(outRect, view, parent, state);
    }

    private void drawHorizontalDivider(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
    }

    private void drawVerticalDivider(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
    }

    private void calcHorizontalOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
    }

    private void calcVerticalOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
    }
}
