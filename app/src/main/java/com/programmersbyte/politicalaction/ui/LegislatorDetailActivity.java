package com.programmersbyte.politicalaction.ui;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.programmersbyte.politicalaction.R;
import com.programmersbyte.politicalaction.adapters.LegislatorPagerAdapter;
import com.programmersbyte.politicalaction.models.Legislator;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LegislatorDetailActivity extends AppCompatActivity {
    @Bind(R.id.viewPager) ViewPager mViewPager;
    private LegislatorPagerAdapter adapterViewPager;
    ArrayList<Legislator> mLegislators = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legislator_detail);
        ButterKnife.bind(this);

        mLegislators = Parcels.unwrap(getIntent().getParcelableExtra("legislators"));
        int startingPosition = getIntent().getIntExtra("position", 0);

        adapterViewPager = new LegislatorPagerAdapter(getSupportFragmentManager(), mLegislators);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}
