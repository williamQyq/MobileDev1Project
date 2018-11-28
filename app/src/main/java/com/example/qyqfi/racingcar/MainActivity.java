package com.example.qyqfi.racingcar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private ImageButton playButton;
    private ImageButton highScoreButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
    }

    public void openGameActivity(){
        Intent intent = new Intent(this,  GameView.class);
        startActivity(intent);
    }

    public void openHighScoreActivity() {
        Intent intent = new Intent(this, HighscoreMain.class);
        startActivity(intent);
    }
}
