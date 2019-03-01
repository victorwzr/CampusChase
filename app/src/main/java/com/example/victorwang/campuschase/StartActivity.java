package com.example.victorwang.campuschase;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class StartActivity extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGHT = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
        new Handler().postDelayed(new Runnable(){

            @Override
            public void run() {
                Intent mainIntent = new Intent(StartActivity.this,NameActivity.class);
                    StartActivity.this.startActivity(mainIntent);
                    StartActivity.this.finish();
            }

        }, SPLASH_DISPLAY_LENGHT);
    }
}
