package com.pullein.divider;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;

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
        recyclerView.addItemDecoration(new GridDecoration(Color.RED, Color.BLUE, 10, 20));
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.setAdapter(new GridAdapter(this));
    }

    public void show(View view) {
        ScaleAnimation animation = new ScaleAnimation(0,1,0,1, Animation.RELATIVE_TO_PARENT,0.5f,1,0.5f);
        animation.setDuration(100);
        animation.setFillAfter(true);
        animation.setRepeatCount(0);
        recyclerView.setAnimation(animation);
        recyclerView.setVisibility(View.VISIBLE);
    }

    public void hide(View view) {
        ScaleAnimation animation = new ScaleAnimation(1,0,1,0, Animation.RELATIVE_TO_PARENT,0.5f,1,0.5f);
        animation.setDuration(100);
        animation.setFillAfter(true);
        animation.setRepeatCount(0);
        recyclerView.setAnimation(animation);
        recyclerView.setVisibility(View.GONE);
    }
}
