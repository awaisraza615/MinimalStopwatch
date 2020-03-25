package com.arenterprise.minimalstopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class StopWatchActivity extends AppCompatActivity {

    Button btnstart,btnstop;
    ImageView icanchor;
    Animation roundingalone;
    Chronometer timerhere;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);

        btnstart=findViewById(R.id.btnstart);
        btnstop=findViewById(R.id.btnstop);
        icanchor=findViewById(R.id.icanchor);
        timerhere=findViewById(R.id.timerhere);

        //create optional animation
        btnstop.setAlpha(0);


        //load animation
        roundingalone = AnimationUtils.loadAnimation(this,R.anim.roundinganim);

        //import fonts

        Typeface MLight = Typeface.createFromAsset(getAssets(), "fonts/MLight.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");
        Typeface MRegular = Typeface.createFromAsset(getAssets(), "fonts/MRegular.ttf");

        //customize font
        btnstart.setTypeface(MMedium);
        btnstop.setTypeface(MMedium);
        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //passing animation
                icanchor.startAnimation(roundingalone);
                btnstop.animate().alpha(1).translationY(-88).setDuration(300).start();
                btnstart.animate().alpha(0).setDuration(300).start();
                //start timer
                timerhere.setBase(SystemClock.elapsedRealtime());
                timerhere.start();
            }
        });
        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                timerhere.stop();
            }
        });
    }
}