package com.example.latihandesember;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {

    TextView emailValidation, passwordValidation, cheatCode, tvForgotPassword;
    EditText txtEmail, txtPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);
        cheatCode = findViewById(R.id.cheatCode);
        tvForgotPassword = findViewById(R.id.tvForgotPassword);

        emailValidation = findViewById(R.id.emailValidation);
        passwordValidation = findViewById(R.id.passwordValidation);

        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = txtEmail.getText().toString();
                String password = txtPassword.getText().toString();

                if (email.isEmpty() || password.isEmpty()){

                    Toast.makeText(Login.this, "Please check the fields.", Toast.LENGTH_LONG).show();

                    emailValidation.setVisibility(View.VISIBLE);
                    passwordValidation.setVisibility(View.VISIBLE);

                }else if(email.equals("mrezakhalafi") && password .equals("1S2d3T4e5L")){

                    Toast.makeText(Login.this, "Welcome, Reza.", Toast.LENGTH_LONG).show();

                    Intent login = new Intent(Login.this, MainApps.class);
                    startActivity(login);
                }else{

                    Toast.makeText(Login.this, "Invalid credentials.", Toast.LENGTH_LONG).show();

                }

            }
        });

        cheatCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtEmail.setText("mrezakhalafi");
                txtPassword.setText("1S2d3T4e5L");

            }
        });

        tvForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent forgotPassword = new Intent(Login.this, Forgot.class);
                startActivity(forgotPassword);
            }
        });
    }
}