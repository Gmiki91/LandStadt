package com.example.landstadt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class SecondActivity extends Activity {
    private TextView text;
    private Button goback;
    private Button countDownButton;
    private char[] abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private int abcIndex = 0;
    private int delay = 500;
    private Handler timerHandler = new Handler();
    private Runnable timerRunnable = new Runnable() {
        @Override
        public void run() {
            text.setText(String.valueOf(abc[abcIndex]));
            timerHandler.postDelayed(this, delay);
            if (abcIndex == abc.length - 1) {
                abcIndex = 0;
            } else {
                abcIndex++;
            }
            text.setVisibility(View.INVISIBLE);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        text = findViewById(R.id.countDown);
        text.setText(String.valueOf(abc[abcIndex]));
        goback = findViewById(R.id.gobackButton);
        countDownButton = findViewById(R.id.countDownButton);


        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = getIntent();
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });


        countDownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (countDownButton.getText().equals("Start")) {
                    timerHandler.postDelayed(timerRunnable, 0);
                    countDownButton.setText("Stop");
                } else {
                    timerHandler.removeCallbacks(timerRunnable);
                    text.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(SecondActivity.this, GameActivity.class);
                    char letter = abcIndex == 0 ? 'z' : abc[abcIndex - 1];
                    intent.putExtra("letter", letter);
                    startActivity(intent);
                }
            }
        });

    }
}
