package com.example.calculator;

import static android.view.View.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class StartMenuActivity extends AppCompatActivity {

    private Button startMenuButton;
    //private TextView calculatorTitle;
    //private ImageView calculatorLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_menu);

        startMenuButton = findViewById(R.id.start_button);
        //calculatorTitle = findViewById(R.id.calculator_title);
        //calculatorLogo = findViewById(R.id.calculator_logo);

        startMenuButton.setOnClickListener(v -> {
            Intent intent = new Intent(StartMenuActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
}