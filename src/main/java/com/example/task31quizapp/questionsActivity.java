package com.example.task31quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

public class questionsActivity extends AppCompatActivity {
    public int questionNum = 1;
    public int score = 0;
    public ProgressBar myProgressBar;
    public TextView progressTextView;
    public String name;
    public boolean answerBool1 = false;
    public boolean answerBool2 = false;
    public boolean answerBool3 = false;

    public void nextButton(View view)
    {
        myProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressTextView = (TextView) findViewById(R.id.progressText);
        Button b = (Button)view;
        String buttonText = b.getText().toString().toUpperCase();
        Button answer1 = (Button)findViewById(R.id.answerButton);
        Button answer2 = (Button)findViewById(R.id.answerbutton2);
        Button answer3 = (Button)findViewById(R.id.answerButton3);
        if (buttonText.equals("SUBMIT"))
        {
            b.setText("NEXT");
            ChangeColor();
            if(questionNum == 1){ answer1.setBackgroundColor(Color.GREEN);}
            if(questionNum == 2){ answer2.setBackgroundColor(Color.GREEN);}
            if(questionNum == 3){ answer3.setBackgroundColor(Color.GREEN);}
            if(questionNum == 4){ answer1.setBackgroundColor(Color.GREEN);}
            if(questionNum == 5){ answer3.setBackgroundColor(Color.GREEN);}
            if(questionNum == 1 && answerBool1 == true){ score = score + 1;}
            if(questionNum == 2 && answerBool2 == true){ score = score + 1;}
            if(questionNum == 3 && answerBool3 == true){ score = score + 1;}
            if(questionNum == 4 && answerBool1 == true){ score = score + 1;}
            if(questionNum == 5 && answerBool3 == true){ score = score + 1;}
        }
        else if (buttonText.equals("NEXT") && questionNum < 5)
        {
            questionNum = questionNum + 1;
            ChangeQuestions(questionNum);
            b.setText("SUBMIT");
            myProgressBar.setProgress(questionNum);
            progressTextView.setText( String.valueOf(questionNum)+ "/5");
            answer1.setBackgroundColor(Color.GRAY);
            answer2.setBackgroundColor(Color.GRAY);
            answer3.setBackgroundColor(Color.GRAY);
            answerBool1 = false; answerBool2 = false; answerBool3 = false;
        }
        else
        {
            Intent intent = getIntent();
            name = intent.getStringExtra("name");
            intent = new Intent(this, FinalActivity.class);
            intent.putExtra("username1", name);
            intent.putExtra("score", score);
            startActivity(intent);
        }
    }
    public void ChangeColor()
    {
        Button answer1 = (Button)findViewById(R.id.answerButton);
        Button answer2 = (Button)findViewById(R.id.answerbutton2);
        Button answer3 = (Button)findViewById(R.id.answerButton3);
        if(questionNum == 1)
        {
            if(answerBool1 == true) { answer1.setBackgroundColor(Color.RED); }
            if(answerBool2 == true) { answer2.setBackgroundColor(Color.RED); }
            if(answerBool3 == true) { answer3.setBackgroundColor(Color.RED); }
        }
        else{
            if(answerBool1 == true) { answer1.setBackgroundColor(Color.RED); }
            if(answerBool2 == true) { answer2.setBackgroundColor(Color.RED); }
            if(answerBool3 == true) { answer3.setBackgroundColor(Color.RED); }
        }

    }
    public void ChangeQuestions(int value)
    {
        TextView view = (TextView)findViewById(R.id.textViewQuestions);
        Button answer1 = (Button)findViewById(R.id.answerButton);
        Button answer2 = (Button)findViewById(R.id.answerbutton2);
        Button answer3 = (Button)findViewById(R.id.answerButton3);
        if (value == 2)
        {
            view.setText("A __________ provides simple feedback about an operation in a small popup");
            answer1.setText("Button");
            answer2.setText("Toast");
            answer3.setText("Check Box");
        }
        else if (value == 3)
        {
            view.setText("Activities have 4 possible LifeCycle states: Foreground, Partially Hidden, FullyHidden and");
            answer1.setText("Empty");
            answer2.setText("Not Visible");
            answer3.setText("Destroyed");
            }
        else if (value == 4)
        {
            view.setText("Which lifeCycle callback is called when an activity is visible and will start interacting with the user");
            answer1.setText("onResume");
            answer2.setText("onStart");
            answer3.setText("onPause");
            }
        else if (value == 5)
        {
            view.setText("_________ are messages which allow Android components to request functionality from other components of the Android system");
            answer1.setText("startActivity");
            answer2.setText("onClick");
            answer3.setText("Intent");
        }
    }

    public void answerBtn(View view)
    {
        answerBool1 = true;
    }
    public void answerBtn2(View view)
    {
        answerBool2 = true;
    }
    public void answerBtn3(View view)
    {
        answerBool3 = true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        TextView view = (TextView)findViewById(R.id.textViewQuestions);
        view.setText("A __________ is a special view that can contain other views called children");

        Button answer1 = (Button)findViewById(R.id.answerButton);
        Button answer2 = (Button)findViewById(R.id.answerbutton2);
        Button answer3 = (Button)findViewById(R.id.answerButton3);
        answer1.setText("ViewGroup");
        answer2.setText("View");
        answer3.setText("TextView");
        answer1.setBackgroundColor(Color.GRAY);
        answer2.setBackgroundColor(Color.GRAY);
        answer3.setBackgroundColor(Color.GRAY);
    }
}