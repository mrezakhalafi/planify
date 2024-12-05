package com.example.latihandesember;

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

public class SignUp extends AppCompatActivity {

    TextView nameValidation, phoneValidation, emailValidation, passwordValidation;
    EditText txtName, txtPhone, txtEmail, txtPassword;
    Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtName = findViewById(R.id.txtName);
        txtPhone = findViewById(R.id.txtPhone);
        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);

        nameValidation = findViewById(R.id.nameValidation);
        phoneValidation = findViewById(R.id.phoneValidation);
        emailValidation = findViewById(R.id.emailValidation);
        passwordValidation = findViewById(R.id.passwordValidation);

        btnSignUp = findViewById(R.id.btnSignUp);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = txtName.getText().toString();
                String phone = txtPhone.getText().toString();
                String email = txtEmail.getText().toString();
                String password = txtPassword.getText().toString();

                if (name.isEmpty() || phone.isEmpty() || email.isEmpty() || password.isEmpty()){

                    Toast.makeText(SignUp.this, "Please check the fields.", Toast.LENGTH_LONG).show();

                    nameValidation.setVisibility(View.VISIBLE);
                    phoneValidation.setVisibility(View.VISIBLE);
                    emailValidation.setVisibility(View.VISIBLE);
                    passwordValidation.setVisibility(View.VISIBLE);

                }

            }
        });
    }
}