package com.programmersbyte.politicalaction;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SearchResultsActivity extends AppCompatActivity {
    private String[] mSearchResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        mSearchResults = Congress.search(name);

    }
}
