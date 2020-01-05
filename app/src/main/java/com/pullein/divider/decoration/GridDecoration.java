package com.pullein.divider.decoration;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

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

    public GridDecoration(@ColorInt int horizontalDividerColorId, @ColorInt int verticalDividerColorId, int mHorizontalDividerWidth, int mVerticalDividerWidth) {
        this.mHorizontalDividerWidth = mHorizontalDividerWidth;
        this.mVerticalDividerWidth = mVerticalDividerWidth;
        this.mVerticalDividerDivider = new ColorDrawable(verticalDividerColorId);
        this.mHorizontalDividerDivider = new ColorDrawable(horizontalDividerColorId);
    }

    @Override
    public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        canvas.save();
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; ++i) {
            View child = parent.getChildAt(i);
            //绘制横向线
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            int hLeft = child.getLeft() - params.leftMargin;
            int hTop = child.getBottom() + params.bottomMargin;
            int hRight = child.getRight() + params.rightMargin + mVerticalDividerWidth;
            int nBottom = hTop + mHorizontalDividerWidth;
            mHorizontalDividerDivider.setBounds(hLeft, hTop, hRight, nBottom);
            mHorizontalDividerDivider.draw(canvas);
            //绘制纵向线
            int vLeft = child.getRight() + params.rightMargin;
            int vTop = child.getTop() - params.topMargin;
            int vRight = vLeft + mVerticalDividerWidth;
            int vBottom = child.getBottom() + params.bottomMargin + mHorizontalDividerWidth;
            mVerticalDividerDivider.setBounds(vLeft, vTop, vRight, vBottom);
            mVerticalDividerDivider.draw(canvas);
        }
        canvas.restore();
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        //计算偏移量
        if (parent.getAdapter() == null) {
            return;
        }
        int spanCount = getSpanCount(parent);
        int childCount = parent.getAdapter().getItemCount();
        int itemPosition = parent.getChildAdapterPosition(view);
        boolean isLastRaw = isLastRaw(parent, itemPosition, spanCount, childCount);
        boolean isLastColumn = isLastColumn(parent, itemPosition, spanCount, childCount);
        if (isLastColumn && isLastRaw) {
            // 如果是最后一行，最后一列则不需要绘制底部
            outRect.set(0, 0, 0, 0);
            return;
        }
        if (isLastRaw) {
            // 如果是最后一行，则不需要绘制底部
            outRect.set(0, 0, mVerticalDividerWidth, 0);
            return;
        }
        if (isLastColumn) {
            // 如果是最后一列，则不需要绘制右边
            outRect.set(0, 0, 0, mHorizontalDividerWidth);
            return;
        }
        outRect.set(0, 0, mVerticalDividerWidth, mHorizontalDividerWidth);
    }

    /**
     * 获取当前recycleView列数
     *
     * @param parent
     * @return
     */
    private int getSpanCount(RecyclerView parent) {
        // 列数
        int spanCount = -1;
        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {

            spanCount = ((GridLayoutManager) layoutManager).getSpanCount();
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            spanCount = ((StaggeredGridLayoutManager) layoutManager).getSpanCount();
        }
        return spanCount;
    }

    private boolean isLastColumn(RecyclerView parent, int itemPosition, int spanCount, int childCount) {
        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            // 如果是最后一列，则不需要绘制右边
            return (itemPosition + 1) % spanCount == 0;
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            int orientation = ((StaggeredGridLayoutManager) layoutManager).getOrientation();
            if (orientation == StaggeredGridLayoutManager.VERTICAL) {
                // 如果是最后一列，则不需要绘制右边
                return (itemPosition + 1) % spanCount == 0;
            } else {
                childCount = childCount - childCount % spanCount;
                // 如果是最后一列，则不需要绘制右边
                return itemPosition >= childCount;
            }
        }
        return false;
    }

    private boolean isLastRaw(RecyclerView parent, int itemPosition, int spanCount, int childCount) {
        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            //最后一行开始索引
            int lastRawStartIndex = childCount - childCount % spanCount;
            if (childCount % spanCount == 0) {
                lastRawStartIndex = childCount - spanCount;
            }
            // 最后一行不需要绘制底部需要绘制底部
            return itemPosition >= lastRawStartIndex;
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            int orientation = ((StaggeredGridLayoutManager) layoutManager).getOrientation();
            // StaggeredGridLayoutManager 且纵向滚动
            if (orientation == StaggeredGridLayoutManager.VERTICAL) {
                //最后一行开始索引
                int lastRawStartIndex = childCount - childCount % spanCount;
                if (childCount % spanCount == 0) {
                    lastRawStartIndex = childCount - spanCount;
                }
                // 如果是最后一行，则不需要绘制底部
                return itemPosition >= lastRawStartIndex;
            } else {
                // StaggeredGridLayoutManager 且横向滚动
                // 如果是最后一行，则不需要绘制底部
                return (itemPosition + 1) % spanCount == 0;
            }
        }
        return false;
    }
}
