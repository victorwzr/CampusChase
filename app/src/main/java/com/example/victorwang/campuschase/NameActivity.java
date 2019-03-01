package com.example.victorwang.campuschase;


import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name);
        Button button1 = (Button) findViewById(R.id.btn1);
        button1.setOnClickListener(help);
        Button button2 = (Button) findViewById(R.id.btn2);
        button2.setOnClickListener(go);
    }

    private View.OnClickListener help = new View.OnClickListener(){
        public void onClick(View v){
                new AlertDialog.Builder(NameActivity.this)
                .setTitle("Help")
                .setMessage("Start here by add your name")
                .setPositiveButton("Sure",null)
                .show();

        }
    };

    private View.OnClickListener go = new View.OnClickListener(){
        public void onClick(View v){
            Intent nameIntent = new Intent(NameActivity.this,MenuActivity.class);
            NameActivity.this.startActivity(nameIntent);
            NameActivity.this.finish();
        }
    };



}
