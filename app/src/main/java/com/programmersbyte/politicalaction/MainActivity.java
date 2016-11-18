package com.programmersbyte.politicalaction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.textAllCongressmenLink) TextView mAllCongressmenLink;
    @Bind(R.id.textAllSenatorsLink) TextView mAllSenatorsLink;
    @Bind(R.id.textSearchCongressLink) TextView mSearchCongressLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    public void onClick(View view) {
        if(view == mAllCongressmenLink) {
            // Go to Activity
        } else if(view == mAllSenatorsLink) {
            // Go to Activity
        } else if(view == mSearchCongressLink) {
            // Go to Activity
        }
    }
}
