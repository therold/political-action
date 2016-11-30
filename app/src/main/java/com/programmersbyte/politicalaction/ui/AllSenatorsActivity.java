package com.programmersbyte.politicalaction.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.programmersbyte.politicalaction.R;
import com.programmersbyte.politicalaction.adapters.LegislatorListAdapter;
import com.programmersbyte.politicalaction.models.Legislator;
import com.programmersbyte.politicalaction.services.SunlightService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class AllSenatorsActivity extends AppCompatActivity {
    public static final String TAG = AllSenatorsActivity.class.getSimpleName();
//    @Bind(R.id.senatorsListView) ListView mListView;
    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
    private LegislatorListAdapter mAdapter;
    public ArrayList<Legislator> mLegislators = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_senators);
        ButterKnife.bind(this);

        getSenators("senate");
    }

    private void getSenators(String chamber) {
        final SunlightService sunlightService = new SunlightService();
        sunlightService.findLegislators(chamber, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {
                mLegislators = sunlightService.processResults(response);
                AllSenatorsActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter = new LegislatorListAdapter(getApplicationContext(), mLegislators);
                        mRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager =
                                new LinearLayoutManager(AllSenatorsActivity.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);

//                        String[] legislatorNames = new String[mLegislators.size()];
//                        for(int i = 0; i < legislatorNames.length; i++) {
//                            legislatorNames[i] = mLegislators.get(i).getFirstName() + " " + mLegislators.get(i).getLastName() + " - " + mLegislators.get(i).getChamber();
//                        }
//                        ArrayAdapter adapter = new ArrayAdapter(AllSenatorsActivity.this, android.R.layout.simple_list_item_1, legislatorNames);
//                        mListView.setAdapter(adapter);
                    }
                });
            }
        });
    }
}
