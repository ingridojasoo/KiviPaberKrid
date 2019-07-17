package com.example.ingri.kivi_paber_krid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class game extends AppCompatActivity implements View.OnClickListener {

    ImageView input, output;
    Button rock, paper, scissors, highscores;
    TextView gamescore, playerName;
    int []images = new int[]{
            R.mipmap.rock,
            R.mipmap.paper,
            R.mipmap.scissors
    };
    int userinput = 0;
    int your_score, computer_score =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        input = (ImageView)findViewById(R.id.input);
        output = (ImageView)findViewById(R.id.output);
        rock = (Button)findViewById(R.id.rock);
        paper = (Button)findViewById(R.id.paper);
        scissors = (Button)findViewById(R.id.scissors);
        highscores = (Button)findViewById(R.id.highscores);
        gamescore = (TextView)findViewById(R.id.gamescore);

        rock.setOnClickListener(this);
        paper.setOnClickListener(this);
        scissors.setOnClickListener(this);

        playerName = (TextView) findViewById(R.id.playerName);
        SharedPreferences nimi = getSharedPreferences("Save", 0);
        String name = nimi.getString("Name", "Error");
        playerName.setText(name);

        highscores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("PREFS",0);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putInt("Computer", your_score);
                editor.apply();

                Intent highscores = new Intent(getApplicationContext(), highscores.class);
                startActivity(highscores);
                finish();
            }
        });
    }

    public void onClick(View v){
        int id = v.getId();
        switch (id){
            case R.id.rock:
                userinput=1;
                input.setBackgroundResource(R.mipmap.rock);
                setOutput();
                break;

            case R.id.paper:
                userinput=2;
                input.setBackgroundResource(R.mipmap.paper);
                setOutput();
                break;

            case R.id.scissors:
                userinput=3;
                input.setBackgroundResource(R.mipmap.scissors);
                setOutput();
                break;
        }
    }
    private void setOutput(){
        int ImageId = (int) (Math.random() * images.length);
        output.setBackgroundResource(images[ImageId]);
        checkresult(ImageId);
    }
    private void checkresult(int ImageId){
        if (userinput ==1 && ImageId ==0){
            showresult(2);
        }
        else if (userinput ==1 && ImageId==1){
            showresult(0);
        }
        else if (userinput ==1 && ImageId==2){
            showresult(1);
            your_score++;
        }
        else if (userinput ==2 && ImageId==0){
            showresult(1);
            your_score++;
        }
        else if (userinput ==2 && ImageId==1){
            showresult(2);
        }
        else if (userinput ==2 && ImageId==2){
            showresult(0);
        }
        else if (userinput ==3 && ImageId==0){
            showresult(0);
        }
        else if (userinput ==3 && ImageId==1){
            showresult(1);
            your_score++;
        }
        else if (userinput ==3 && ImageId==2){
            showresult(2);
        }
    }
    private void showresult (int result){
        if(result == 0){
            Toast.makeText(getApplicationContext(),"You lose!", Toast.LENGTH_SHORT).show();
            computer_score++;
        }
        else if (result ==1){
            Toast.makeText(getApplicationContext(),"You win! :)", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(getApplicationContext(),"DRAW", Toast.LENGTH_SHORT).show();
    }
}
