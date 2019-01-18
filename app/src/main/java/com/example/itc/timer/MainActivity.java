package com.example.itc.timer;

import android.os.CountDownTimer;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import static com.example.itc.timer.R.id.timerSeekBar;

public class MainActivity extends AppCompatActivity {
    SeekBar timerSeeBar;
    TextView timerTextView;
    Button counterButton;
    Boolean counterIsActive = false;
    CountDownTimer countDownTimer;

    public MainActivity() {
        countDownTimer = new CountDownTimer(timerSeeBar.getProgress() * 1000 + 100, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {

            }
        };
    }

    public void resertimer() {
        timerTextView.setText("0:30");
        timerSeeBar.setProgress(30);
        countDownTimer.cancel();
        counterButton.setText("Go!");
        timerSeeBar.setEnabled(true);
        counterIsActive = false;
    }



    public void updatetimer(int secondsleft) {
        int minutes = (int) secondsleft / 60;
        int seconds = secondsleft - minutes * 60;

        String secondString = Integer.toString(seconds);

        if (seconds <= 9) {
            secondString = "0" + secondString;
        }
        timerTextView.setText(Integer.toString(minutes) + ":" + secondString);
    }

    public void controlTimer(View view) {
        if (counterIsActive == false) {
            counterIsActive = true;
            timerSeeBar.setEnabled(false);
            counterButton.setText("Stop");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timerSeeBar = (SeekBar) findViewById(timerSeekBar);
        timerTextView = (TextView) findViewById(R.id.timerTextview);
        counterButton = (Button) findViewById(R.id.counterButtom);

        timerSeeBar.setMax(600);
        timerSeeBar.setProgress(30);

        timerSeeBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updatetimer(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
