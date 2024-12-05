package com.example.latihandesember;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnLogin, btnSignUp;
    ImageView ivFacebook,ivGoogle, ivInstagram;
    TextView txtHello;

    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btnLogin);
        btnSignUp = findViewById(R.id.btnSignUp);

        ivFacebook = findViewById(R.id.ivFacebook);
        ivGoogle = findViewById(R.id.ivGoogle);
        ivInstagram = findViewById(R.id.ivInstagram);

        txtHello = findViewById(R.id.txtHello);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(MainActivity.this, Login.class);
                startActivity(login);
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signUp = new Intent(MainActivity.this, SignUp.class);
                startActivity(signUp);
            }
        });

        ivFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com"));
                startActivity(browserIntent);

            }
        });

        ivGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
                startActivity(browserIntent);

            }
        });

        ivInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com"));
                startActivity(browserIntent);

            }
        });

        String text = "How Your Day?";
        Handler handler = new Handler(Looper.getMainLooper());
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (index <= text.length()) {
                    txtHello.setText(text.substring(0, index));
                    index++;
                    handler.postDelayed(this, 200);
                } else {
                    index = 0;
                    handler.postDelayed(this, 2000);
                }
            }
        };

        handler.post(runnable);

    }
}