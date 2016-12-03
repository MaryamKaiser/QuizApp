package com.example.lab2.quizapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView userAns = (TextView) findViewById(R.id.userAns);
        TextView correctAns = (TextView) findViewById(R.id.corrAns);

        TextView score = (TextView) findViewById(R.id.score);
        Intent i = getIntent();
        String userAnswer = i.getStringExtra("userAns");
        String corrAns = i.getStringExtra("corrAns");
        String data = i.getStringExtra("data");

        userAns.setText(userAnswer);
        correctAns.setText(corrAns);
        score.setText(data);

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage("Do you want to take this quiz again?");
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                setResult(1);
                finish();

            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
            }
        });
        alert.show();
    }
}
