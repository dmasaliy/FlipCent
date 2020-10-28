package com.game.flipcent;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

@SuppressLint("UseCompatLoadingForDrawables")
public class MainActivity extends AppCompatActivity {

    Random random = new Random();

    Button flip;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        flip = findViewById(R.id.flip);
        imageView = findViewById(R.id.imageView);

        flip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flip.setEnabled(false);
                flip.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        flip.setEnabled(true);
                    }
                }, 2000);
                fliper();
            }
        });
    }


    public void fliper(){
        int flipNumber = (int) (Math.random() * 2 + 1);

        switch (flipNumber){
            case 1:
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.one));
                Toast.makeText(this, "Tails", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.two));
                Toast.makeText(this, "Eagle", Toast.LENGTH_SHORT).show();
                break;

        }
    }
}