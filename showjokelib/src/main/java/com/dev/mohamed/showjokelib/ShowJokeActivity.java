package com.dev.mohamed.showjokelib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowJokeActivity extends AppCompatActivity {

    TextView tvJoke;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_joke);

        String joke=getIntent().getStringExtra("joke");

        tvJoke=findViewById(R.id.tv_joke);
        tvJoke.setText(joke);
    }
}
