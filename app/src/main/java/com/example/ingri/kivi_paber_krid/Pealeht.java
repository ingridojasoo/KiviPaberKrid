package com.example.ingri.kivi_paber_krid;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Pealeht extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGHT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pealeht);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainAct = new Intent(Pealeht.this, menyy.class);
                Pealeht.this.startActivity(mainAct);
                Pealeht.this.finish();
            }
        }, SPLASH_DISPLAY_LENGHT);
    }
}
