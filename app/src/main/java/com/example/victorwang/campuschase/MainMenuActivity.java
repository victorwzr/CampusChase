package com.example.victorwang.campuschase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
        Button buttonmmmp = (Button) findViewById(R.id.btn_mmm);
        buttonmmmp.setOnClickListener(mmmp);
        Button buttonmmmt = (Button) findViewById(R.id.btn_mmmt);
        buttonmmmt.setOnClickListener(mmmt);
        Button buttonmmhc = (Button) findViewById(R.id.btn_mmhc);
        buttonmmhc.setOnClickListener(mmhc);
        Button buttonmmh = (Button) findViewById(R.id.btn_mmh);
        buttonmmh.setOnClickListener(mmh);
        Button buttonmma = (Button) findViewById(R.id.btn_mma);
        buttonmma.setOnClickListener(mma);
    }
    private View.OnClickListener  mmmp = new View.OnClickListener(){
        public void onClick(View v){
            Intent mdIntent = new Intent(MainMenuActivity.this,MapsActivity.class);
            MainMenuActivity.this.startActivity(mdIntent);

        }
    };
    private View.OnClickListener  mmmt = new View.OnClickListener(){
        public void onClick(View v){
            Intent mdIntent = new Intent(MainMenuActivity.this,MyTeamActivity.class);
            MainMenuActivity.this.startActivity(mdIntent);

        }
    };
    private View.OnClickListener  mmhc = new View.OnClickListener(){
        public void onClick(View v){
            Intent mdIntent = new Intent(MainMenuActivity.this,HintActivity.class);
            MainMenuActivity.this.startActivity(mdIntent);

        }
    };
    private View.OnClickListener  mmh = new View.OnClickListener(){
        public void onClick(View v){
            Intent mdIntent = new Intent(MainMenuActivity.this,HelpActivity.class);
            MainMenuActivity.this.startActivity(mdIntent);

        }
    };
    private View.OnClickListener  mma = new View.OnClickListener(){
        public void onClick(View v){
            Intent mdIntent = new Intent(MainMenuActivity.this,AboutActivity.class);
            MainMenuActivity.this.startActivity(mdIntent);

        }
    };

}
