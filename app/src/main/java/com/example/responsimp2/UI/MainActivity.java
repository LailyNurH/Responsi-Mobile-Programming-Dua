package com.example.responsimp2.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.responsimp2.R;
import com.example.responsimp2.SharedPref.SharedPrefManager;

public class MainActivity extends AppCompatActivity {
    Button btnlogin;
    EditText etemail,etpassword;
    private SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPrefManager = new SharedPrefManager(this);

        etemail = findViewById(R.id.etemail);
        etpassword = findViewById(R.id.etpassword);
        btnlogin = findViewById(R.id.btnlogin);
        login();
    }

    private void login() {
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = etemail.getText().toString();
                final String password = etpassword.getText().toString();


                if (username.isEmpty() || password.isEmpty()) {

                    Toast.makeText(MainActivity.this, "username dan password salah :)", Toast.LENGTH_SHORT).show();
                } else {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            String spUsername = sharedPrefManager.getUsername();
                            String spPassword = sharedPrefManager.getPassword();

                            Log.d("username", "user" + username);
                            Log.d("password", "pass" + password);

                            if (username.equals(spUsername) && password.equals(spPassword)) {
                                Intent i = new Intent(MainActivity.this, HomeActivity.class);
                                sharedPrefManager.saveIsLogin(true);
                                finishAffinity();
                                startActivity(i);
                            } else {
                                Toast.makeText(MainActivity.this, "username dan password salah :)", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }, 3000);
                }
            }
        });
    }
}