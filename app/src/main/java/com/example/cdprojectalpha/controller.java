package com.example.cdprojectalpha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class controller extends AppCompatActivity {
    ImageButton go, back, left, right;
    TextView t, t2;
    private int Gea = 0, Neu = 0, Dri = 1, Rev = 2; // 중립, 전진, 후진 기어
    private int LW = 0, RW = 0; // 왼쪽 바퀴, 오른쪽 바퀴 상태

    public void Wheel_state(int L, int R){
        LW = L;
        RW = R;
    }

    public void Gear(int sta){
        Gea = sta;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_controller);

        go = findViewById(R.id.imageButton2);
        back = findViewById(R.id.imageButton);
        left = findViewById(R.id.imageButton3);
        right = findViewById(R.id.imageButton4);
        t = findViewById(R.id.textView9);
        t2 = findViewById(R.id.textView6);

        if(option.connect == 1) {
            t2.setText("EventLog(Network: ON)");

            go.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                        // 버튼을 눌렀을 때
                        t.setText("LF|RF");
                        Gear(Dri);
                    }else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                        // 버튼에서 손을 떼었을 때
                        t.setText("LN|RN");
                        Gear(Neu);
                    }
                    return false;
                }
            });

            back.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                        // 버튼을 눌렀을 때
                        t.setText("LB|RB");
                        Gear(Rev);
                    }else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                        // 버튼에서 손을 떼었을 때
                        t.setText("LN|RN");
                        Gear(Neu);
                    }
                    return false;
                }
            });

            left.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                        // 버튼을 눌렀을 때
                        if(Gea == Dri)
                            t.setText("LN|RF");
                        else if(Gea == Rev)
                            t.setText("LN|RB");
                        else
                            t.setText("Gear N");
                    }else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                        // 버튼에서 손을 떼었을 때
                        if(Gea == Dri)
                            t.setText("LF|RF");
                        else if(Gea == Rev)
                            t.setText("LB|RB");
                        else
                            t.setText("Gear N");
                    }
                    return false;
                }
            });

            right.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                        // 버튼을 눌렀을 때
                        if(Gea == Dri)
                            t.setText("LF|RN");
                        else if(Gea == Rev)
                            t.setText("LB|RN");
                        else
                            t.setText("Gear N");
                    }else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                        // 버튼에서 손을 떼었을 때
                        if(Gea == Dri)
                            t.setText("LF|RF");
                        else if(Gea == Rev)
                            t.setText("LB|RB");
                        else
                            t.setText("Gear N");
                    }
                    return false;
                }
            });
        }else{
            t2.setText("EventLog(Network: OFF)");
        }
    }
}
