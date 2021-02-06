package com.test.deadlock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Deadlock job = new Deadlock();
        Thread pavel = new Thread(job,"Павел");
        Thread victor = new Thread(job, "Виктор");
        pavel.start();
        victor.start();
    }
}