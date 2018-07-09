package com.example.leonardo.avanzado01.activities;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.leonardo.avanzado01.R;
import com.example.leonardo.avanzado01.fragments.HomeFragment;

public class NotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        FragmentManager fragmentManager = getSupportFragmentManager();

        Fragment fragment = new HomeFragment();
        fragmentManager.beginTransaction().replace(R.id.content, fragment).addToBackStack("tag").commit();


    }
}