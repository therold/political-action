package com.programmersbyte.politicalaction.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.programmersbyte.politicalaction.models.Legislator;
import com.programmersbyte.politicalaction.ui.LegislatorDetailFragment;

import java.util.ArrayList;

public class LegislatorPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Legislator> mLegislators;

    public LegislatorPagerAdapter(FragmentManager fm, ArrayList<Legislator> legislators) {
        super(fm);
        mLegislators = legislators;
    }

    @Override
    public Fragment getItem(int position) {
        return LegislatorDetailFragment.newInstance(mLegislators.get(position));
    }

    @Override
    public int getCount() {
        return mLegislators.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mLegislators.get(position).getFullName();
    }

}
