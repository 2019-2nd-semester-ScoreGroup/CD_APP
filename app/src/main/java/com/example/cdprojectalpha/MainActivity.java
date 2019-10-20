package com.example.cdprojectalpha;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static int connect = 0;
    Button b, b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);
        b = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
//                Intent in = new Intent(getApplicationContext(), controller.class);
//                startActivity(in);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(), option.class);
                startActivity(in);
            }
        });
    }

    void login()
    {
        final EditText id = new EditText(this);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("회원 로그인");
        builder.setView(id);
        builder.setMessage("아이디");
        builder.setPositiveButton("다음",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        if(id.getText().toString().equals("user")){
                            login_fin();
                        }
                        else
                            Toast.makeText(getApplicationContext(), "존재하지 않는 아이디입니다!",Toast.LENGTH_LONG).show();
                    }
                });
        builder.setNegativeButton("취소",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        builder.show();
    }

    void login_fin()
    {
        final EditText pass = new EditText(this);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("회원 로그인");
        builder.setMessage("비밀번호");
        builder.setView(pass);
        builder.setPositiveButton("로그인",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        if(pass.getText().toString().equals("1234567890"))
                            Toast.makeText(getApplicationContext(), "회원입니다!",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(getApplicationContext(), "회원이 아닙니다!",Toast.LENGTH_LONG).show();
                    }
                });
        builder.setNegativeButton("취소",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        builder.show();
    }
}
