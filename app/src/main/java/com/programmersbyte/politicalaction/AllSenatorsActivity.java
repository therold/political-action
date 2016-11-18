package com.programmersbyte.politicalaction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AllSenatorsActivity extends AppCompatActivity {
    @Bind(R.id.senatorsListView) ListView mListView;
    String[] senators = Congress.getSenators();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_senators);
        ButterKnife.bind(this);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, senators);
        mListView.setAdapter(adapter);
    }
}
