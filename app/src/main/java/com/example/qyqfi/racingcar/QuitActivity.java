package com.example.qyqfi.racingcar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuitActivity extends AppCompatActivity {

    private TextView score_tv;
    private ImageButton playButton;
    private ImageButton highScoreButton;
    DatabaseHelper myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        myDB = new DatabaseHelper(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quit);

        playButton = (ImageButton) findViewById(R.id.playBtn);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGameActivity();
            }
        });

        highScoreButton = (ImageButton) findViewById(R.id.showScoreBtn);
        highScoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHighScoreActivity();
            }
        });

        //set text to Score TextView
        score_tv = (TextView) findViewById(R.id.score_textView);
        score_tv.setText("Score: "+getIntent().getStringExtra("SCORE"));

        AddData(getIntent().getStringExtra("SCORE"));
    }

    public void openGameActivity(){
        Intent intent = new Intent(this, GameView.class);
        finish();
        startActivity(intent);
    }

    public void openHighScoreActivity() {
        Intent intent = new Intent(this, HighscoreView.class);
        startActivity(intent);
    }

    public void AddData(String newEntry) {

        boolean insertData = myDB.addData(newEntry);

        if(insertData==true){
            Toast.makeText(this, "Data Successfully Inserted!", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Something went wrong :(.", Toast.LENGTH_LONG).show();
        }
    }
}
