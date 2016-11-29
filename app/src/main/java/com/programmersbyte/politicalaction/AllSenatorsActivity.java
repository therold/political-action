package com.programmersbyte.politicalaction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class AllSenatorsActivity extends AppCompatActivity {
    public static final String TAG = AllSenatorsActivity.class.getSimpleName();
    @Bind(R.id.senatorsListView) ListView mListView;

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
                        String[] legislatorNames = new String[mLegislators.size()];
                        for(int i = 0; i < legislatorNames.length; i++) {
                            legislatorNames[i] = mLegislators.get(i).getFirstName() + " " + mLegislators.get(i).getLastName() + " - " + mLegislators.get(i).getChamber();
                        }
                        ArrayAdapter adapter = new ArrayAdapter(AllSenatorsActivity.this, android.R.layout.simple_list_item_1, legislatorNames);
                        mListView.setAdapter(adapter);
                    }
                });
            }
        });
    }
}
