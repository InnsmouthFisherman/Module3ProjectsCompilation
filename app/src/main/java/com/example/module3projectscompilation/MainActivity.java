package com.example.module3projectscompilation;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1 = findViewById(R.id.task1);
        b1.setOnClickListener(listener);
        Button b2 = findViewById(R.id.task2);
        b2.setOnClickListener(listener);
        Button b3 = findViewById(R.id.task3);
        b3.setOnClickListener(listener);
        Button b4 = findViewById(R.id.task4);
        b4.setOnClickListener(listener);
        Button b5 = findViewById(R.id.task5);
        b5.setOnClickListener(listener);
    }
    @SuppressLint("NonConstantResourceId")
    View.OnClickListener listener = view -> {
        switch(view.getId()) {
            case R.id.task1:
                startActivity(new Intent(MainActivity.this, task1.class));
            case R.id.task2:
                startActivity(new Intent(MainActivity.this, task2.class));
            case R.id.task3:
                startActivity(new Intent(MainActivity.this, task3.class));
        }
    };
}