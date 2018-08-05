package com.sofialopes.android.jokedisplayandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeDisplayActivity extends AppCompatActivity {

    public static final String JOKE_EXTRA = "extra_joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);

        TextView jokeTv = findViewById(R.id.joke_tv);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra(JOKE_EXTRA)) {
            jokeTv.setText(intent.getStringExtra(JOKE_EXTRA));
        }
    }
}
