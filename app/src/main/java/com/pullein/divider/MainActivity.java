package com.pullein.divider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        initToolbar(R.string.app_name,false);
    }

    public void openGridLayoutActivity(View view){
        startActivity(new Intent(this,GridLayoutActivity.class));
    }
}
