package com.superrookie.relaxcar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class NoticeViewPagerAdapter extends FragmentStatePagerAdapter {
    private List<NoticeFragment> mFragmentList;

    NoticeViewPagerAdapter(FragmentManager fm) {
        super(fm);
        mFragmentList = new ArrayList<>();
        mFragmentList.add(NoticeFragment.createInstance("동해물과백두산이마르고닳도록"));
        mFragmentList.add(NoticeFragment.createInstance("하느님이보우하사우리나라만세"));
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
}
