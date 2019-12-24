package com.pullein.divider;

import android.os.Bundle;

/**
 * RecyclerView Item Decoration<br>
 * describe ：Recycle实现表格布局，行列间距
 *
 * @author xugang
 * @date 2019/12/24
 */
public class GridLayoutActivity extends BaseActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_grid_layout;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        initToolbar(R.string.gridlayout);
    }
}