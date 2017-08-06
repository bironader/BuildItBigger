package com.example.androidlib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    TextView jokeTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        jokeTxt = (TextView) findViewById(R.id.jokeTxt);
        jokeTxt.setText(getIntent().getStringExtra("joke"));
    }
}
