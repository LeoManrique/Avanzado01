package com.example.leonardo.avanzado01.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.leonardo.avanzado01.R;
import com.example.leonardo.avanzado01.repositories.UserRepository;
import com.example.leonardo.avanzado01.classes.User;
import com.orm.SugarRecord;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final int REGISTER_FORM_REQUEST = 100;
    private SharedPreferences sharedPreferences;
    String username, password;
    User usuario;
    List<User> lista;
    EditText editU, editP;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // init SharedPreferences
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        // islogged remember
        if(sharedPreferences.getBoolean("islogged", false)){
            // Go to Dashboard
            goDashboard();
        }

        setContentView(R.layout.activity_main);
        editU = findViewById(R.id.usr);
        editP = findViewById(R.id.psw);
        img = findViewById(R.id.img_nota);
        // Método de apoyo para ver los usuarios registrados en Toast
        img.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                List<User> list = SugarRecord.listAll(User.class);
                String users = "";
                for (int i = 0; i < list.size(); i++) {
                    User user = list.get(i);
                    users+= user.toString()+"\n";
                }
                Toast.makeText(MainActivity.this, users, Toast.LENGTH_LONG).show();
                return true;
            }
        });
    }

    public void validateLogin(View view){
        if (editU.getText().toString().isEmpty() || editP.getText().toString().isEmpty()){
            Toast.makeText(this, "Llenar todos los campos", Toast.LENGTH_SHORT).show();
        } else {
            username = editU.getText().toString();
            password = editP.getText().toString();
            lista = UserRepository.listLogin(username, password);
            if (lista.size() > 0 ){
                Long id = lista.get(0).getId();
                String fullName = lista.get(0).getFullname();
                String firstName = "";
                if (fullName.indexOf(' ') != -1){
                    firstName = fullName.substring(0, fullName.indexOf(' '));
                } else {
                    firstName = fullName;
                }
                SharedPreferences.Editor editor = sharedPreferences.edit();
                boolean success = editor
                        .putString("firstName", firstName)
                        .putBoolean("islogged", true)
                        .commit();

                goDashboard();
            } else {
                Toast.makeText(this, "Combinación de usuario clave no válida", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void callRegisterForm(View view){
        startActivityForResult(new Intent(this, RegisterActivity.class), REGISTER_FORM_REQUEST);
    }
    public void goDashboard(){
        startActivityForResult(new Intent(this, NotesActivity.class), REGISTER_FORM_REQUEST);
        finish();

    }
}
