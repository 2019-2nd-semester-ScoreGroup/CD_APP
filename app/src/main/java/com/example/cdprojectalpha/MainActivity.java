package com.example.cdprojectalpha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button b, b2;
    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);
        b = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        t = findViewById(R.id.textView14);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                t.setText("시작");
                Intent in = new Intent(getApplicationContext(), controller.class);
                startActivity(in);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                t.setText("옵션");
                Intent in = new Intent(getApplicationContext(), option.class);
                startActivity(in);
            }
        });
    }
}
