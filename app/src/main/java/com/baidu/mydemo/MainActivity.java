package com.baidu.mydemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioGroup;

import com.baidu.mydemo.fragments.DiscoveryFragment;
import com.baidu.mydemo.fragments.HomeFragment;
import com.baidu.mydemo.fragments.MessageFragment;
import com.baidu.mydemo.fragments.ReviewFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private List<Fragment> mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup group = (RadioGroup) findViewById(R.id.main_tab_bar);

        group.setOnCheckedChangeListener(this);
        mFragments = new ArrayList<>();

        // 当 activity 发生重复创建或者横竖屏切换，内部的Fragment
        // 会自动创建一遍

        FragmentManager manager = getSupportFragmentManager();
        if (savedInstanceState == null) {
            Fragment fragment = new HomeFragment();
            mFragments.add(fragment);

            fragment = new DiscoveryFragment();
            mFragments.add(fragment);

            fragment = new ReviewFragment();
            mFragments.add(fragment);

            fragment = new MessageFragment();
            mFragments.add(fragment);

            FragmentTransaction transaction =
                    manager.beginTransaction();
            int index = 0;
            for (Fragment f : mFragments) {
//                添加
                // 第三个参数 给Fragment 设置Tag
                transaction.add(R.id.fragment_container,f,"tag"+index);
                transaction.hide(f);
                index++;
            }

            // 第一个显示
            transaction.show(mFragments.get(0));
            transaction.commit();
        }else{
             //  不是第一次创建， Fragment 会自动由 Activity 创建好
            //  FragmentManager 的管理
            //  根据 add 时，设置的Tag 来查找 Fragment
            for (int i = 0; i <4; i++) {
                String tag = "tag" +i;
                Fragment f = manager.findFragmentByTag(tag);

                if (f != null) {
                    mFragments.add(f);
                }
            }
        }
    }

    //--------------------------------------------
    // Tab 切换
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        int index = 0;
        switch (checkedId) {
            case R.id.main_tab_home:
                index = 0;
                break;
            case R.id.main_tab_discovery:
                index = 1;
                break;
            case R.id.main_tab_review:
                index = 2;
                break;
            case R.id.main_tab_message:
                index = 3;
                break;
        }
        switchFragment(index);
    }
    private void switchFragment(int index){
        if (index>=0 && index < mFragments.size()) {
            int size = mFragments.size();

            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            for (int i = 0; i < size; i++) {

                Fragment f = mFragments.get(i);

                if(i== index){
                    // 显示
                    transaction.show(f);
                }else {
                    transaction.hide(f);
                }

            }
            transaction.commit();
        }
    }

}
