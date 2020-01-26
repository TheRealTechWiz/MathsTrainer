package com.example.prathammathstrainer;

import android.os.CountDownTimer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView timerView;
    TextView probView;
    TextView scoreView;
    TextView resultView;
    Button button_0;
    Button button_1;
    Button button_2;
    Button button_3;
    Button resetButton;

    int i = 0;
    int j = 0;
    int fir;
    int sec;
    int butt;
    int onee;
    int two;
    int three;
    int four;
    int set;


    public void reset(View view){
        button_0.setEnabled(true);
        button_1.setEnabled(true);
        button_2.setEnabled(true);
        button_3.setEnabled(true);
        resultView.setText("");
        i = 0; j = 0;
        scoreView.setText("0/0");
        time();
        on();

    }

    public void time () {
        CountDownTimer countDownTimer = new CountDownTimer(30000+100, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timerView.setText(String.valueOf(millisUntilFinished/1000+"s"));
            }

            @Override
            public void onFinish() {
                timerView.setText("0s");
                button_0.setEnabled(false);
                button_1.setEnabled(false);
                button_2.setEnabled(false);
                button_3.setEnabled(false);
                resetButton.setVisibility(View.VISIBLE);
                //Toast.makeText(MainActivity.this, "Your score is "+String.valueOf(i)+"/"+String.valueOf(j), Toast.LENGTH_SHORT).show();
                resultView.setText("Your score is "+String.valueOf(i)+"/"+String.valueOf(j));
            }
        }.start();
    }
    public void view (View view){
        Button butto = (Button) view;
        int tapped =   Integer.parseInt(butto.getTag().toString());

        if (tapped == butt) {
            //Toast.makeText(getApplicationContext(), "Right!!", Toast.LENGTH_SHORT).show();
            resultView.setText("Right!!");
            i++; j++;
        }
        else {
            //Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
            resultView.setText("Wrong");
            j++;
        }
        on();
        scoreView.setText(String.valueOf(i)+"/"+String.valueOf(j));

    }

    public void on (){

        timerView =  findViewById(R.id.timerView);
        probView  =  findViewById(R.id.problView);
        scoreView =  findViewById(R.id.scoreView);
        resultView=  findViewById(R.id.resultView);
        button_0   = findViewById(R.id.button0);
        button_1   = findViewById(R.id.button1);
        button_2   = findViewById(R.id.button2);
        button_3   = findViewById(R.id.button3);
        resetButton   = findViewById(R.id.resetButton);
        resetButton.setVisibility(View.INVISIBLE);

        Random random = new Random();
        fir = random.nextInt(100);
        sec = random.nextInt(100);
        butt= random.nextInt(4);
        onee = random.nextInt(100);
        two = random.nextInt(100);
        three = random.nextInt(100);
        four = random.nextInt(100);
        set= fir+sec;

        probView.setText(String.valueOf(fir)+"+"+String.valueOf(sec));


        if (butt==0) button_0.setText(String.valueOf(set));
        else button_0.setText(String.valueOf(onee));

        if (butt==1) button_1.setText(String.valueOf(set));
        else button_1.setText(String.valueOf(two));

        if (butt==2) button_2.setText(String.valueOf(set));
        else button_2.setText(String.valueOf(three));

        if (butt==3) button_3.setText(String.valueOf(set));
        else button_3.setText(String.valueOf(four));

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        on();
        time();

    }
}