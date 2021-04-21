package com.example.task31quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FinalActivity extends AppCompatActivity {

    public String name;
    public int score;
    TextView finalTextView;
    TextView scoreText;
    public void TakeQuiz(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("checkName", true);
        intent.putExtra("username", name);
        startActivity(intent);
    }
    public void Finish(View view)
    {
        this.finishAffinity();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        finalTextView = findViewById(R.id.FinalTextView);
        scoreText = findViewById(R.id.scoreText);

        Intent intent = getIntent();

        name = intent.getStringExtra("username1");
        finalTextView.setText("Congratulations " + name);

        score = intent.getIntExtra("score", 0);
        scoreText.setText(score + "/5");

    }
}