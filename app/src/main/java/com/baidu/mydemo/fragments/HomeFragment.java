package com.baidu.mydemo.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baidu.mydemo.R;
import com.baidu.mydemo.fragments.home.ImageFragment;
import com.baidu.mydemo.fragments.home.QuanFragment;
import com.baidu.mydemo.fragments.home.RecommendFragment;
import com.baidu.mydemo.fragments.home.VedioFragment;
import com.baidu.mydemo.fragments.home.EssayFragment;
import com.baidu.mylibrary.CommonFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements TabLayout.OnTabSelectedListener {

    private TabLayout mTabLayout;

    private ViewPager mPager;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        mTabLayout = (TabLayout) view.findViewById(R.id.home_tab_bar);

        mPager = (ViewPager) view.findViewById(R.id.home_pager);

        List<Fragment> subFragments = new ArrayList<>();

        subFragments.add(new RecommendFragment());
        subFragments.add(new VedioFragment());
        subFragments.add(new ImageFragment());
        subFragments.add(new EssayFragment());
        subFragments.add(new QuanFragment());

        CommonFragmentAdapter adapter =
                new CommonFragmentAdapter(getChildFragmentManager(),subFragments);

        mPager.setAdapter(adapter);

        mTabLayout.setOnTabSelectedListener(this);

        // TabLayout 处理
        mTabLayout.addTab(mTabLayout.newTab().setText("推荐"));
        mTabLayout.addTab(mTabLayout.newTab().setText("视频"));
        mTabLayout.addTab(mTabLayout.newTab().setText("图片"));
        mTabLayout.addTab(mTabLayout.newTab().setText("段子"));
        mTabLayout.addTab(mTabLayout.newTab().setText("圈子"));


        TabLayout.TabLayoutOnPageChangeListener listener =
                     new TabLayout.TabLayoutOnPageChangeListener(mTabLayout);
        mPager.addOnPageChangeListener(listener);

        return view;
    }


    @Override
    public void onTabSelected(TabLayout.Tab tab) {

        mPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
