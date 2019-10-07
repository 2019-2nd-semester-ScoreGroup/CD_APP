package com.example.cdprojectalpha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class option extends AppCompatActivity {
    public static client c = new client();
    public static int connect = 0;
    int iport;
    Button b1, b2, b3;
    EditText ip, port;
    TextView v1, v2;
    String fip, fport, sip, sport;

    public void set_text(TextView v1, TextView v2, String i){
        v1.setText(fip);
        v2.setText(fport);
        iport = Integer.parseInt(i);
    }

    public void set_string(String s1, String s2){
        fip = " IP: " + s1;
        fport = " PORT: " + s2;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);
        b1 = findViewById(R.id.Bipport);
        b2 = findViewById(R.id.button8);
        b3 = findViewById(R.id.button3);
        ip = findViewById(R.id.Sample1);
        port = findViewById(R.id.Sample2);
        v1 = findViewById(R.id.textView10);
        v2 = findViewById(R.id.textView11);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sip = ip.getText().toString();
                sport = port.getText().toString();

                if(sip.equals("") && sport.equals("")){
                    sip = "127.0.0.1";
                    sport = "12142";
                    set_string(sip, sport);
                    set_text(v1, v2, sport);
                }else if(sip.equals("") || sport.equals(""))
                    Toast.makeText(getApplicationContext(), "잘못된 입력입니다!", Toast.LENGTH_LONG).show();
                else {
                    set_string(sip, sport);
                    set_text(v1, v2, sport);
                }

                c.set_connect(sip, iport);
                c.start();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(connect == 1)
                    Toast.makeText(option.this, "연결 성공!", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(option.this, "연결 실패", Toast.LENGTH_SHORT).show();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connect = 1;
            }
        });
    }
}
