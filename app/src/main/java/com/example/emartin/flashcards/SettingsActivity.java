package com.example.emartin.flashcards;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

//sound
//game length (time vs number of flashcards vs points gotten)
//danger: reset user stats

//notification: practice reminder
//game: motivational messages
public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.empty_space);

        //getSupportFragmentManager()
        //getFragmentManager()
        /*
        fragment = new SettingsFragment();
        fm
                .beginTransaction()
                .replace(R.id.empty_space, fragment)
                .commit();
                */
    }

}
