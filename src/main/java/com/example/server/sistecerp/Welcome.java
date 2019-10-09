package com.example.server.sistecerp;

import android.content.Intent;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Welcome extends AppCompatActivity {
    private static int Splash_Time_Out=2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent home=new Intent(Welcome.this,Login.class);
                finish();
                startActivity(home);

            }
        },Splash_Time_Out);


    }
}
