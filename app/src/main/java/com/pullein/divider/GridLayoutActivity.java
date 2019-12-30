package com.pullein.divider;

import android.graphics.Color;
import android.os.Bundle;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pullein.divider.adapter.GridAdapter;
import com.pullein.divider.decoration.GridDecoration;

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
        recyclerView.addItemDecoration(new GridDecoration(Color.parseColor("#e9e9e9"), Color.parseColor("#e9e9e9"), 10, 10, true, true, true, false));
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.setAdapter(new GridAdapter(this));
    }
}
