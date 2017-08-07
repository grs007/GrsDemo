package com.grs.my.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.grs.my.R;
import com.grs.my.base.BaseActivityN;
import com.grs.my.home.homehome.HomeHomeFragment;
import com.grs.my.home.homemy.HomeMyFragment;
import com.zhy.autolayout.AutoLayoutRadioGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivityN {
    @BindView(R.id.main_vp)
    ViewPager mainVp;
    @BindView(R.id.title_back)
    TextView titleBack;
    @BindView(R.id.title_title)
    TextView titleTitle;
    @BindView(R.id.mian_rb1)
    RadioButton mianRb1;
    @BindView(R.id.mian_rb2)
    RadioButton mianRb2;
    @BindView(R.id.main_rg)
    AutoLayoutRadioGroup mainRg;

    private HomeHomeFragment autoTrackFragment;
    private HomeMyFragment homeMyFragment;
    private List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void init() {
        titleTitle.setText("首页");
        titleBack.setVisibility(View.GONE);
        autoTrackFragment = new HomeHomeFragment();
        homeMyFragment = new HomeMyFragment();
        fragments = new ArrayList<>();
        fragments.add(autoTrackFragment);
        fragments.add(homeMyFragment);
        mainVp.setOffscreenPageLimit(1); //预加载
        mainVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Override
            public Fragment getItem(int arg0) {
                return fragments.get(arg0);
            }
        });
    }

    @Override
    protected void initEvent() {
        mainVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    titleTitle.setText("首页");
                    mianRb1.setChecked(true);
                } else {
                    titleTitle.setText("我的");
                    mianRb2.setChecked(true);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mainRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.mian_rb1) {
                    mianRb1.setChecked(true);
                    mainVp.setCurrentItem(0, true);
                } else {
                    mianRb2.setChecked(true);
                    mainVp.setCurrentItem(1, true);
                }
            }
        });
    }
}
