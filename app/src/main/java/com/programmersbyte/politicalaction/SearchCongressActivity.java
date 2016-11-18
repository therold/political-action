package com.programmersbyte.politicalaction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SearchCongressActivity extends AppCompatActivity {
    @Bind(R.id.editSearchCongress) EditText mEditSearchCongress;
    @Bind(R.id.buttonSubmitSearch) Button mButtonSubmitSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_congress);
        ButterKnife.bind(this);
    }
}
