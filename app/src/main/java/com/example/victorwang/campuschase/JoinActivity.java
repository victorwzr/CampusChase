package com.example.victorwang.campuschase;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

public class JoinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.join);
        Button buttonJ = (Button) findViewById(R.id.btn_j);
        buttonJ.setOnClickListener(j);
    }

    private View.OnClickListener  j = new View.OnClickListener(){
        public void onClick(View v){
            Intent JIntent = new Intent(JoinActivity.this,MapsActivity.class);
            JoinActivity.this.startActivity(JIntent);
            JoinActivity.this.finish();
        }
    };
}
