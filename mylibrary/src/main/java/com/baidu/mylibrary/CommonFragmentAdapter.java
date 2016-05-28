package com.baidu.mylibrary;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Project: MyDemo
 * Author: wm
 * Data:   16-5-27
 */
public class CommonFragmentAdapter extends FragmentPagerAdapter{

    private List<Fragment> mFragments;

    public CommonFragmentAdapter(FragmentManager fm,List<Fragment> fragments) {
        super(fm);
        this.mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {

        int ret = 0;

        if (mFragments != null) {
            ret = mFragments.size();
        }
        return ret;
    }
}
