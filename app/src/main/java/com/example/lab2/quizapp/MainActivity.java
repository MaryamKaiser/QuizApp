package com.example.lab2.quizapp;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Boolean ans1 = false;
    Boolean ans2 = false;
    Boolean ans3 = false;

    String ans1_c = "Java";
    String ans2_c = "Android Studio";
    String ans3_c = "C#";

    String ans1_u = "";
    String ans2_u = "";
    String ans3_u = "";

    int percentage ;
    int percentage1 ;
    int percentage2 ;
    int percentage3 ;

    private static final int Restart = 0;
    RadioGroup rg;
    RadioGroup rg2;
    RadioGroup rg3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        rg = (RadioGroup) findViewById(R.id.RDG_1);

        rg2 = (RadioGroup) findViewById(R.id.RDG_2);

        rg3 = (RadioGroup) findViewById(R.id.RDG_3);

        rg.clearCheck();
        rg2.clearCheck();
        rg3.clearCheck();

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ans1 = true;

                if (checkedId == R.id.btn1_1)
                {
                    RadioButton rd1_1 = (RadioButton) findViewById(R.id.btn1_1);
                    ans1_u = rd1_1.getText().toString();
                }
                else if (checkedId == R.id.btn2_1)
                {
                    RadioButton rd1_1 = (RadioButton) findViewById(R.id.btn2_1);
                    ans1_u = rd1_1.getText().toString();
                }
                else if (checkedId == R.id.btn3_1)
                {
                    RadioButton rd1_1 = (RadioButton) findViewById(R.id.btn3_1);
                    ans1_u = rd1_1.getText().toString();
                }
                if (ans1_u.equals(ans1_c))
                    percentage1 = 33;
                else
                    percentage1 = 0;
            }
        });

        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ans2= true;
                if (checkedId == R.id.btn1_2)
                {
                    RadioButton rd1_1 = (RadioButton) findViewById(R.id.btn1_2);
                    ans2_u = rd1_1.getText().toString();
                }
                else if (checkedId == R.id.btn2_2)
                {
                    RadioButton rd1_1 = (RadioButton) findViewById(R.id.btn2_2);
                    ans2_u = rd1_1.getText().toString();
                }
                else if (checkedId == R.id.btn3_2)
                {
                    RadioButton rd1_1 = (RadioButton) findViewById(R.id.btn3_2);
                    ans2_u = rd1_1.getText().toString();
                }
                if(ans2_u.equals(ans2_c))
                     percentage2 = 33;
                else
                    percentage2 = 0;
            }
        });

        rg3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ans3 = true;
                if (checkedId == R.id.btn1_3)
                {
                    RadioButton rd1_1 = (RadioButton) findViewById(R.id.btn1_3);
                    ans3_u = rd1_1.getText().toString();
                }
                else if (checkedId == R.id.btn2_3)
                {
                    RadioButton rd1_1 = (RadioButton) findViewById(R.id.btn2_3);
                    ans3_u = rd1_1.getText().toString();
                }
                else if (checkedId == R.id.btn3_3)
                {
                    RadioButton rd1_1 = (RadioButton) findViewById(R.id.btn3_3);
                    ans3_u = rd1_1.getText().toString();
                }
                if(ans3_u.equals(ans3_c))
                    percentage3 =  33;

                else
                    percentage3 = 0;
            }
        });

        Button btnSubmit = (Button) findViewById(R.id.submitAns);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String yourAnswer = ans1_u + " \n" + ans2_u + "\n" + ans3_u;
                String correctAns = ans1_c + "\n" + ans2_c + "\n" + ans3_c ;
                if (ans1 && ans2 && ans3)
                {
                    percentage = percentage1 + percentage2 + percentage3;
                    //Toast.makeText(MainActivity.this, "Submitted",Toast.LENGTH_SHORT).show();
                    //Toast.makeText(MainActivity.this, "Score = " + percentage,Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this, Main2Activity.class);
                    i.putExtra("data", String.valueOf(percentage));
                    i.putExtra("userAns", yourAnswer);
                    i.putExtra("corrAns", correctAns);
                    startActivityForResult(i,Restart);

                    //startActivity(i);

                }
                else{
                    String Message = "" ;
                    if (!ans1)
                    {
                        Message += "Q.1";
                        Toast.makeText(MainActivity.this, "Please Answer" + Message,Toast.LENGTH_SHORT).show();
                    }
                    else if (!ans2)
                    {
                        Message += "Q.2";
                        Toast.makeText(MainActivity.this, "Please Answer" + Message,Toast.LENGTH_SHORT).show();
                    }

                    else if(!ans3)
                    {
                        Message += "Q.3";
                        Toast.makeText(MainActivity.this, "Please Answer" + Message,Toast.LENGTH_SHORT).show();
                    }
                    //Toast.makeText(MainActivity.this, "Please Answer" + Message,Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    protected void onResume(){
        super.onResume();

    }

    protected void  onActivityResult (int RequestCode, int resultCOde, Intent data )
    {
        if(RequestCode == Restart && resultCOde == 1)
        {
            rg.clearCheck();
            rg2.clearCheck();
            rg3.clearCheck();
        }
    }
    public void submitAns(View view) {
       /* if (ans1 && ans2 && ans3)
        {
            percentage = percentage1 + percentage2 + percentage3;
            //Toast.makeText(MainActivity.this, "Submitted",Toast.LENGTH_SHORT).show();
            //Toast.makeText(MainActivity.this, "Score = " + percentage,Toast.LENGTH_SHORT).show();
            Intent i = new Intent(MainActivity.this, Main2Activity.class);
            i.putExtra("data", percentage);
            startActivity(i);
        }
        else{
            String Message = "" ;

            if (!ans1)
            {
                Message += "Q.1";
                Toast.makeText(MainActivity.this, "Please Answer" + Message,Toast.LENGTH_SHORT).show();
            }
            else if (!ans2)
            {
                Message += "Q.2";
                Toast.makeText(MainActivity.this, "Please Answer" + Message,Toast.LENGTH_SHORT).show();
            }

            else if(!ans3)
            {
                Message += "Q.3";
                Toast.makeText(MainActivity.this, "Please Answer" + Message,Toast.LENGTH_SHORT).show();
            }
            //Toast.makeText(MainActivity.this, "Please Answer" + Message,Toast.LENGTH_SHORT).show();
        }*/
    }

}
