package com.bmiasn.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.airbnb.lottie.LottieAnimationView;
import com.example.bmi.R;

public class bmisplash extends AppCompatActivity {
LottieAnimationView lotiview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmisplash);
        //lottie animation code here below

 lotiview=(LottieAnimationView)findViewById(R.id.animationshow);
        lotiview.setAnimation(R.raw.anmija);
        lotiview.playAnimation();

        // for screen hold for limit time this below code needed
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent ihome=new Intent(bmisplash.this,MainActivity.class);
                startActivity(ihome);
                finish();
            }
        },3800);
    }
}