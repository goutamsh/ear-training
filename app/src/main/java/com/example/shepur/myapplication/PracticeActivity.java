package com.example.shepur.myapplication;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class PracticeActivity extends AppCompatActivity implements View.OnClickListener {

    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);
        setClickListeners();
    }

    private void setClickListeners() {
        Button button = findViewById(R.id.saButton);
        button.setOnClickListener(this);

        button = findViewById(R.id.reKomalButton);
        button.setOnClickListener(this);

        button = findViewById(R.id.reButton);
        button.setOnClickListener(this);

        button = findViewById(R.id.gaKomalButton);
        button.setOnClickListener(this);

        button = findViewById(R.id.gaButton);
        button.setOnClickListener(this);

        button = findViewById(R.id.maButton);
        button.setOnClickListener(this);

        button = findViewById(R.id.maTivarButton);
        button.setOnClickListener(this);

        button = findViewById(R.id.paButton);
        button.setOnClickListener(this);

        button = findViewById(R.id.dhaKomalButton);
        button.setOnClickListener(this);

        button = findViewById(R.id.dhaButton);
        button.setOnClickListener(this);

        button = findViewById(R.id.niKomalButton);
        button.setOnClickListener(this);

        button = findViewById(R.id.niButton);
        button.setOnClickListener(this);

        button = findViewById(R.id.ssButton);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        int mediaId = MappingHelper.getMediaIdOfButton(v.getId());
         if(mp != null){
            mp.release();
        }
        mp = MediaPlayer.create(getApplicationContext(), mediaId);
        mp.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mp.release();
    }
}
