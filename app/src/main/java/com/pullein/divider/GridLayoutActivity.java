package com.pullein.divider;

import android.os.Bundle;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pullein.divider.adapter.GridAdapter;

/**
 * RecyclerView Item Decoration<br>
 * describe ：Recycle实现表格布局，行列间距
 *
 * @author xugang
 * @date 2019/12/24
 */
public class GridLayoutActivity extends BaseActivity {

    private RecyclerView recyclerView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_grid_layout;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        initToolbar(R.string.gridlayout);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        recyclerView.setAdapter(new GridAdapter(this));
    }
}
