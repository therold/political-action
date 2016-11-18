package com.programmersbyte.politicalaction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.textAllCongressmenLink) TextView mAllCongressmenLink;
    @Bind(R.id.textAllSenatorsLink) TextView mAllSenatorsLink;
    @Bind(R.id.textSearchCongressLink) TextView mSearchCongressLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
}
