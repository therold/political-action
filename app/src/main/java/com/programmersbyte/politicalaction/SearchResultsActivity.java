package com.programmersbyte.politicalaction;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SearchResultsActivity extends AppCompatActivity {
    @Bind(R.id.textSearchName) TextView mTextSearchName;
    @Bind(R.id.textSearchError) TextView mTextSearchError;
    @Bind(R.id.searchListView) ListView mSearchListView;
    private String[] mSearchResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        setTitle(getString(R.string.search_results_title, name));

        mSearchResults = Congress.search(name);
        if(mSearchResults.length < 1) {
            mTextSearchError.setText(getString(R.string.search_no_results));
        } else {
            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, mSearchResults);
            mSearchListView.setAdapter(adapter);
        }
    }
}
