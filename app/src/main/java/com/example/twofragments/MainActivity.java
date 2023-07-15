package com.example.twofragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements SecondFragmentCallback, FirstFragmentCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void sendDataToSecondFragment(String data) {
        FragmentSecond fragmentSecond = (FragmentSecond) getSupportFragmentManager().findFragmentById(R.id.secondFragmentContainer);
        if (fragmentSecond != null) {
            fragmentSecond.displayData(data);
        }
    }

    @Override
    public void clearEditText() {
        FragmentFirst fragmentFirst = (FragmentFirst) getSupportFragmentManager().findFragmentById(R.id.firstFragmentContainer);
        if (fragmentFirst != null) {
            fragmentFirst.clearEditText();
        }
    }
}