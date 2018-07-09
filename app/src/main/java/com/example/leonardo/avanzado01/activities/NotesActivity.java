package com.example.leonardo.avanzado01.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.leonardo.avanzado01.R;
import com.example.leonardo.avanzado01.fragments.HomeFragment;

public class NotesActivity extends AppCompatActivity {
    private static final int REGISTER_FORM_REQUEST = 100;
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        FragmentManager fragmentManager = getSupportFragmentManager();
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        Fragment fragment = new HomeFragment();
        fragmentManager.beginTransaction().replace(R.id.content, fragment).addToBackStack("tag").commit();

        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        Toast.makeText(NotesActivity.this, "Home...", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_favorites:
                        Toast.makeText(NotesActivity.this, "Favorites...", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_archived:
                        Toast.makeText(NotesActivity.this, "Archived...", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_logout:
                        Toast.makeText(NotesActivity.this, "Logout...", Toast.LENGTH_SHORT).show();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        boolean success = editor
                                .putString("firstName", "")
                                .putBoolean("islogged", false)
                                .commit();
                        goLogin();
                        break;

                }
                return true;
            }
        });

    }

    public void goLogin(){
        startActivityForResult(new Intent(this, MainActivity.class), REGISTER_FORM_REQUEST);
        finish();
    }
}