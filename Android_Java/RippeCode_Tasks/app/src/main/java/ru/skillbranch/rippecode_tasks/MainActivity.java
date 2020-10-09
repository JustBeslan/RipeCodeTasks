package ru.skillbranch.rippecode_tasks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startTask1(View view) {
        Intent intentTask1 = new Intent(this, Task1.class);
        startActivity(intentTask1);
    }

    public void startTask2(View view) {
        Intent intentTask2 = new Intent(this, Task2.class);
        startActivity(intentTask2);
    }
}