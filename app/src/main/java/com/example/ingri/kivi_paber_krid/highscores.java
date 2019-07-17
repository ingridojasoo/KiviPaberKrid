package com.example.ingri.kivi_paber_krid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class highscores extends AppCompatActivity {

    TextView gamescore;
    TextView highscore;
    TextView view;
    EditText file;
    String scores;

    int lastscore;

    int best1, best2, best3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscores);

        file = findViewById(R.id.file);
        view = findViewById(R.id.info);
        highscore = findViewById(R.id.gamescore);

        gamescore = (TextView)findViewById(R.id.gamescore);

        SharedPreferences preferences = getSharedPreferences("PREFS",0 );
        lastscore = preferences.getInt("Computer", 0);
        best1 = preferences.getInt("Best1", 0);
        best2 = preferences.getInt("Best2", 0);
        best3 = preferences.getInt("Best3", 0);

        if (lastscore > best3){
            best3 = lastscore;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("Best3", best3);
            editor.apply();
        }
        if (lastscore > best2){
            int temp = best2;
            best2 = lastscore;
            best3 = temp;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("Best3", best3);
            editor.putInt("Best2", best2);
            editor.apply();
        }
        if (lastscore > best1){
            int temp = best1;
            best1 = lastscore;
            best2 = temp;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("Best2", best2);
            editor.putInt("Best1", best1);
            editor.apply();
        }

        gamescore.setText("Score is: "+ lastscore + "\n" +
            "Best 1: " + best1 + "\n"+
            "Best 2: "+ best2 +"\n"+
            "Best 3: " + best3 + "\n");

        scores = gamescore.getText().toString();
    }

    public void savemyscore (View view){
        SharedPreferences preferences = getSharedPreferences("PREFS", 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("score", scores);
        editor.apply();

        Intent savemyscore = new Intent(highscores.this, externalstorage.class);
        startActivity(savemyscore);
    }

    public void resumegame (View view){
        Intent resumegame = new Intent(highscores.this, game.class);
        startActivity(resumegame);

    }
}
