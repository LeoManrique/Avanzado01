package com.example.leonardo.avanzado01.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.leonardo.avanzado01.R;
import com.example.leonardo.avanzado01.repositories.UserRepository;

public class RegisterActivity extends AppCompatActivity {

    private EditText fullnameInput;
    private EditText userInput;
    private EditText passwordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fullnameInput = (EditText)findViewById(R.id.fullname_input);
        userInput = (EditText)findViewById(R.id.user_input);
        passwordInput = (EditText)findViewById(R.id.password_input);
    }

    public void callRegister(View view){
        String fullname = fullnameInput.getText().toString();
        String username = userInput.getText().toString();
        String password = passwordInput.getText().toString();

        if(fullname.isEmpty() || username.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "You must complete these fields", Toast.LENGTH_SHORT).show();
            return;
        }

        UserRepository.create(fullname, username, password);

        finish();

    }
}