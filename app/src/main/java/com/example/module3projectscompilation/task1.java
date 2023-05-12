package com.example.module3projectscompilation;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class task1 extends AppCompatActivity {

    private static final String KEY_COUNT = "COUNT";
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task1);
        TextView a = (TextView) findViewById(R.id.textView);
        Button b = findViewById(R.id.button);
        b.setOnClickListener(listener);

        if (savedInstanceState != null) {
            int count = savedInstanceState.getInt(KEY_COUNT, 0);
            a.setText(count);
        }
    }
    View.OnClickListener listener = view -> {
        count++;
        TextView a = findViewById(R.id.textView);
        a.setText(String.valueOf(count));
    };

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COUNT, count);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        count = savedInstanceState.getInt(KEY_COUNT);
        TextView a = findViewById(R.id.textView);
        a.setText(String.valueOf(count));
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
