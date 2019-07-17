package com.example.ingri.kivi_paber_krid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.SharedPreferences;

public class menyy extends AppCompatActivity {

    private EditText kasutajanimi;
    Button play;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menyy);

        kasutajanimi = findViewById(R.id.kasutajanimi);
        play = findViewById(R.id.play);

    }

    public void playgame(View view) {
        sharedPreferences= getSharedPreferences("Save", 0);
        SharedPreferences.Editor editor =sharedPreferences.edit();
        editor.putString("Name", kasutajanimi.getText().toString());
        editor.apply();

        if (view.getId()==R.id.play){
            if (kasutajanimi.getText().length()==0){
                Toast.makeText(this, "Please enter name", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        Intent playgame = new Intent(menyy.this, game.class);
        startActivity(playgame);
    }
}
