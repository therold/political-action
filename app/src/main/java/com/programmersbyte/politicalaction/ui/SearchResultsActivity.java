package com.programmersbyte.politicalaction.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.programmersbyte.politicalaction.Congress;
import com.programmersbyte.politicalaction.R;
import com.programmersbyte.politicalaction.adapters.LegislatorListAdapter;
import com.programmersbyte.politicalaction.models.Legislator;
import com.programmersbyte.politicalaction.services.SunlightService;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class SearchResultsActivity extends AppCompatActivity {

    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
    private LegislatorListAdapter mAdapter;
    public ArrayList<Legislator> mLegislators = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        setTitle(getString(R.string.search_results_title, name));

        getLegislators(name);
    }

    private void getLegislators(String query) {
        final SunlightService sunlightService = new SunlightService();
        sunlightService.queryLegislators(query, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {
                mLegislators = sunlightService.processResults(response);
                SearchResultsActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter = new LegislatorListAdapter(getApplicationContext(), mLegislators);
                        mRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager =
                                new LinearLayoutManager(SearchResultsActivity.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);

                    }
                });
            }
        });
    }
}
