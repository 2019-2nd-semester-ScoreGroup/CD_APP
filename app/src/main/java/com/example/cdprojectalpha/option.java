package com.example.cdprojectalpha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class option extends AppCompatActivity {
    Button b, b2, b3;
    EditText ip, port;
    TextView v1, v2;
    String fip, fport, sip, sport;
    client c = new client();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);
        b = findViewById(R.id.button5);
        b2 = findViewById(R.id.button8);
        b3 = findViewById(R.id.button3);
        ip = findViewById(R.id.Sample1);
        port = findViewById(R.id.Sample2);
        v1 = findViewById(R.id.textView10);
        v2 = findViewById(R.id.textView11);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sip = ip.getText().toString();
                sport = port.getText().toString();
                fip = new String(" IP: " + sip);
                fport = new String(" PORT: " + sport);
                v1.setText(fip);
                v2.setText(fport);
                c.server_test(sip);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.connect == 1){
                    Toast.makeText(option.this, "연결 성공!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(option.this, "연결 실패", Toast.LENGTH_SHORT).show();
                }
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.connect = 1;
            }
        });
    }
}
