package com.programmersbyte.politicalaction.ui;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.programmersbyte.politicalaction.R;
import com.programmersbyte.politicalaction.adapters.LegislatorListAdapter;
import com.programmersbyte.politicalaction.models.Legislator;
import com.programmersbyte.politicalaction.services.SunlightService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class LegislatorListActivity extends AppCompatActivity {
    public static final String TAG = LegislatorListActivity.class.getSimpleName();
    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
    private LegislatorListAdapter mAdapter;
    public ArrayList<Legislator> mLegislators = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legislator_list);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String chamber = intent.getStringExtra("chamber");
        this.setTitle(chamber);
        getLegislatorsByChamber(chamber);
    }

    private void getLegislatorsByChamber(String chamber) {
        final SunlightService sunlightService = new SunlightService();
        sunlightService.findLegislators(chamber, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {
                mLegislators = sunlightService.processResults(response);
                Collections.sort(mLegislators, Legislator.LegislatorNameComparator);
                LegislatorListActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                    mAdapter = new LegislatorListAdapter(getApplicationContext(), mLegislators);
                    mRecyclerView.setAdapter(mAdapter);
                    RecyclerView.LayoutManager layoutManager =
                            new LinearLayoutManager(LegislatorListActivity.this);
                    mRecyclerView.setLayoutManager(layoutManager);
                    mRecyclerView.setHasFixedSize(true);

                    }
                });
            }
        });
    }
}
