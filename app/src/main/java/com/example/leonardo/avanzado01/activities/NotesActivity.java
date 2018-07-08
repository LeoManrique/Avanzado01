package com.example.leonardo.avanzado01.activities;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.leonardo.avanzado01.R;

public class NotesActivity extends AppCompatActivity {
    private TextView bienvenido;
    private SharedPreferences sharedPreferences;
    String nombre;
    String bienvenida;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        bienvenido = findViewById(R.id.bienvenido);
        nombre = sharedPreferences.getString("firstName", "");
        bienvenida = "Bienvenido "+nombre;
        bienvenido.setText(bienvenida);
    }
}