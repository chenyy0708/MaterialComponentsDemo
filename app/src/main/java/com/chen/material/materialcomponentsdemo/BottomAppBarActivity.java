package com.chen.material.materialcomponentsdemo;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

public class BottomAppBarActivity extends AppCompatActivity {

    private BottomAppBar bottomAppBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_app_bar);
        bottomAppBar = findViewById(R.id.bar);
        // 切换FAB对齐方式，附带平滑动画
        findViewById(R.id.bt_left).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomAppBar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_CENTER);
            }
        });
        findViewById(R.id.bt_right).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomAppBar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_END);
            }
        });
        // 设置菜单布局
        bottomAppBar.replaceMenu(R.menu.menu_main_nav);

        // 有两种方式设置菜单按钮点击事件
        //1.直接设置点击事件
        bottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(bottomAppBar, "菜单", Snackbar.LENGTH_SHORT).show();
            }
        });
        //2.设置actionbar，监听onOptionsItemSelected方法android.R.id.home按钮也可以监听菜单按钮
//        setSupportActionBar(bottomAppBar);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Snackbar.make(bottomAppBar, "菜单", Snackbar.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
