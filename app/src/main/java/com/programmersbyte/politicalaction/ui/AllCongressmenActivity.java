package com.programmersbyte.politicalaction.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.programmersbyte.politicalaction.Congress;
import com.programmersbyte.politicalaction.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AllCongressmenActivity extends AppCompatActivity {
    @Bind(R.id.congressmenListView) ListView mListView;
    String[] congressmen = Congress.getCongressmen();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_congressmen);
        ButterKnife.bind(this);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, congressmen);
        mListView.setAdapter(adapter);
    }
}
