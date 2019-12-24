package com.pullein.divider;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

/**
 * RecyclerView Item Decoration<br>
 * describe ：Activity 基类，主要实现Toolbar显示
 *
 * @author xugang
 * @date 2019/12/24
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected Toolbar mToolbar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        mToolbar = findViewById(R.id.toolbar);
        initToolbar(mToolbar);
        FrameLayout parentContainer = findViewById(R.id.parentContainer);
        LayoutInflater.from(this).inflate(getLayoutId(),parentContainer);
        initView(savedInstanceState);
    }

    protected void initToolbar(@StringRes int title){
        initToolbar(title,true);
    }

    protected void initToolbar(@StringRes int title,boolean hasBack){
        mToolbar.setTitle(title);
        if (hasBack){
            mToolbar.setNavigationIcon(android.R.drawable.ic_menu_close_clear_cancel);
            mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        }
    }

    protected void initToolbar(Toolbar toolbar){}

    protected abstract @LayoutRes int getLayoutId();

    protected abstract void initView(Bundle savedInstanceState);

    protected boolean onInterceptBack(){
        return false;
    }

    @Override
    public void onBackPressed() {
        if (onInterceptBack()){
            return;
        }
        super.onBackPressed();
    }
}
