package com.example.victorwang.campuschase;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CreateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.create);
        Button buttonmd = (Button) findViewById(R.id.btn_md);
        buttonmd.setOnClickListener(md);
        Button buttonjts = (Button) findViewById(R.id.btn_jts);
        buttonjts.setOnClickListener(jts);
    }

    private View.OnClickListener jts = new View.OnClickListener(){
        public void onClick(View v){
            new AlertDialog.Builder(CreateActivity.this)
                    .setTitle("My team status")
                    .setMessage("Change here")
                    .setPositiveButton("Sure",null)
                    .show();

        }
    };
    private View.OnClickListener  md = new View.OnClickListener(){
        public void onClick(View v){
            Intent mdIntent = new Intent(CreateActivity.this,MapsActivity.class);
            CreateActivity.this.startActivity(mdIntent);
            CreateActivity.this.finish();
        }
    };
}
