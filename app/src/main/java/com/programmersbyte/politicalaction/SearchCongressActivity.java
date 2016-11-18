package com.programmersbyte.politicalaction;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SearchCongressActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.editSearchCongress) EditText mEditSearchCongress;
    @Bind(R.id.buttonSubmitSearch) Button mButtonSubmitSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_congress);
        ButterKnife.bind(this);

        mButtonSubmitSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == mButtonSubmitSearch) {
            String name = mEditSearchCongress.getText().toString().trim();
            if(name.equals("")) {
                mEditSearchCongress.setError("Field Required!");
            } else {
                Intent intent = new Intent(SearchCongressActivity.this, SearchResultsActivity.class);
                intent.putExtra("name", name);
                startActivity(intent);
            }
        }
    }
}
