package com.programmersbyte.politicalaction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class AllSenatorsActivity extends AppCompatActivity {
    public static final String TAG = AllSenatorsActivity.class.getSimpleName();
    @Bind(R.id.senatorsListView) ListView mListView;
    String[] senators = Congress.getSenators();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_senators);
        ButterKnife.bind(this);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, senators);
        mListView.setAdapter(adapter);
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
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    String jsonData = response.body().string();
                    Log.v(TAG, jsonData);
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
