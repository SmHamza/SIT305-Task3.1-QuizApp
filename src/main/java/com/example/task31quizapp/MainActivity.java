package com.example.task31quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public boolean check = false;
    public TextView textViewForName;
//    public TextView textForName;
    public String name;
    EditText textName;
    public void jumpClick(View view)
    {
        Intent intent = new Intent(this, questionsActivity.class);
        intent.putExtra("name", textName.getText().toString());
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textName = findViewById(R.id.textName);
        Intent intent = getIntent();
        check = intent.getBooleanExtra("checkName", false);
        name = intent.getStringExtra("username");
        if(check == true)
        {
            textName.setVisibility(View.GONE);
            textViewForName = findViewById(R.id.textViewName);
            textViewForName.setText("Welcome " + name);
            textViewForName.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            textViewForName.setTextSize(20);
        }
    }
}