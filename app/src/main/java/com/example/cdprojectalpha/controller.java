package com.example.cdprojectalpha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;

public class controller extends AppCompatActivity {
    ImageButton go, back, left, right;
    TextView t;
    StringBuffer str = new StringBuffer();

    private void timecheck(){
        Date today = new Date();
        SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
        str.append(time.format(today));
    }

    private void scrollBottom(TextView textView) {
        int lineTop =  textView.getLayout().getLineTop(textView.getLineCount()) ;
        int scrollY = lineTop - textView.getHeight();
        if (scrollY > 0) {
            textView.scrollTo(0, scrollY);
        } else {
            textView.scrollTo(0, 0);
        }
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
        t.setMovementMethod(new ScrollingMovementMethod());

        if(option.connect == 1) {
            timecheck();
            str.append(" 연결 성공!\n");
            t.setText(str);

            go.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                        // 버튼을 눌렀을 때
                        timecheck();
                        str.append(" go\n");
                        t.setText(str);
                        scrollBottom(t);
                    }else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                        // 버튼에서 손을 떼었을 때
                        timecheck();
                        str.append(" go.stop\n");
                        t.setText(str);
                        scrollBottom(t);
                    }
                    return false;
                }
            });

            back.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                        // 버튼을 눌렀을 때
                        timecheck();
                        str.append(" back\n");
                        t.setText(str);
                        scrollBottom(t);
                    }else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                        // 버튼에서 손을 떼었을 때
                        timecheck();
                        str.append(" back.stop\n");
                        t.setText(str);
                        scrollBottom(t);
                    }
                    return false;
                }
            });

            left.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                        // 버튼을 눌렀을 때
                        timecheck();
                        str.append(" left\n");
                        t.setText(str);
                        scrollBottom(t);
                    }else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                        // 버튼에서 손을 떼었을 때
                        timecheck();
                        str.append(" left.stop\n");
                        t.setText(str);
                        scrollBottom(t);
                    }
                    return false;
                }
            });

            right.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                        // 버튼을 눌렀을 때
                        timecheck();
                        str.append(" right\n");
                        t.setText(str);
                        scrollBottom(t);
                    }else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                        // 버튼에서 손을 떼었을 때
                        timecheck();
                        str.append(" right.stop\n");
                        t.setText(str);
                        scrollBottom(t);
                    }
                    return false;
                }
            });
        }else{
            str.append("연결 실패\n네트워크 연결을 확인하세요.\n");
            t.setText(str);
        }
    }
}
