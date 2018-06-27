package com.project.anika.beratungsapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class Picturequiz extends AppCompatActivity {

    private ImageSwitcher sw;
    private Animation outleft;
    private Animation outright;
    private Animation inleft;
    private Animation inright;
    // Array of Image IDs to Show In ImageSwitcher
    int imageIds[] = {R.drawable.figurbetont2, R.drawable.nachhaltig2,  R.drawable.elegant2, R.drawable.casual2,  R.drawable.exzentrisch2, R.drawable.rockig2,R.drawable.romantisch2,R.drawable.sportlich2,R.drawable.figurbetont3,R.drawable.nachhaltig3,R.drawable.elegant3,R.drawable.casual3,R.drawable.exzentrisch3,R.drawable.rockig3,R.drawable.romantisch3,R.drawable.sportlich3};
    int count = imageIds.length;
    // to keep current Index of ImageID array
    int currentIndex = 0;
    private ImageView like;
    private ImageView dislike;

    int results[] = {0,0,0,0,0,0,0,0};


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picturequiz);

        //initialisiere ImageView
        sw =  findViewById(R.id.imgsw);
        sw.setFactory(new ViewSwitcher.ViewFactory() {
            public View makeView() {
                ImageView imgv = new ImageView(getApplicationContext());
                imgv.setScaleType(ImageView.ScaleType.CENTER_CROP);

                ViewGroup.LayoutParams params = new ImageSwitcher.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

                imgv.setLayoutParams(params);
                return imgv;
            }
        });
        sw.setOnTouchListener(new OnSwipeTouchListener(Picturequiz.this)
        {

            @Override
            public void onClick() {
            super.onClick();
            // your on click here
        }

            @Override
            public void onDoubleClick() {
            super.onDoubleClick();
            // your on onDoubleClick here
        }

            @Override
            public void onLongClick() {
            super.onLongClick();
            // your on onLongClick here
        }

            @Override
            public void onSwipeUp() {
            super.onSwipeUp();
            // your swipe up here
        }

            @Override
            public void onSwipeDown() {
            super.onSwipeDown();
            // your swipe down here.
        }

            @Override
            public void onSwipeLeft() {
            super.onSwipeLeft();
            dislikeButtonClick(sw);
        }

            @Override
            public void onSwipeRight() {
            super.onSwipeRight();
            likeButtonClick(sw);
        }
        });


        outleft = AnimationUtils.loadAnimation(this, R.anim.exit_to_right);
        outright = AnimationUtils.loadAnimation(this, R.anim.exit_to_left);
        inleft = AnimationUtils.loadAnimation(this, R.anim.enter_from_left);
        inright = AnimationUtils.loadAnimation(this, R.anim.enter_from_right);


        sw.setImageResource(imageIds[currentIndex]);

        //go to the Point where i was beforre
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String idString;

        for (int i = 0; i < imageIds.length; i++)
        {
            idString = preferences.getString(Integer.toString(imageIds[i]), "");
            if(idString=="1")
            {
                likeButtonClick(sw);
            }
            else if (idString=="0")
            {
                dislikeButtonClick(sw);
            }
        }
    }

    public void likeButtonClick(View view) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();

        sw.setOutAnimation(outleft);
        sw.setInAnimation(inleft);
        currentIndex++;
        //  Check If index reaches maximum then open next Quiz
        if (currentIndex >= count)

           // currentIndex = 0;
        {
            editor.putString(Integer.toString(imageIds[currentIndex-1]),"1");
            editor.apply();
            weiterButtonClick(findViewById(R.id.buttonLike));
        }
        else
        {
            sw.setImageResource(imageIds[currentIndex]);
            editor.putString(Integer.toString(imageIds[currentIndex-1]),"1");
            editor.apply();
        }

    }

    public void dislikeButtonClick(View view) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();

        sw.setOutAnimation(outright);
        sw.setInAnimation(inright);
        currentIndex++;
        //  Check If index reaches maximum then open next Quiz
        if (currentIndex >= count)
            //currentIndex = 0;
        {
            editor.putString(Integer.toString(imageIds[currentIndex-1]),"0");
            editor.apply();
            weiterButtonClick(findViewById(R.id.buttonDislike));
        }
        else
        {
            sw.setImageResource(imageIds[currentIndex]);
            editor.putString(Integer.toString(imageIds[currentIndex-1]),"0");
            editor.apply();
        }
        // sw.startAnimation(outright);


    }

    //gehe weiter zur nächsten Frage
    public void weiterButtonClick(View view) {

        for (int i = 0; i < 8; i++) //just go through half
        {
                 if (i == 0 )
                 {
                     results ("figurbetontPicture" , i);
                 }
                 else if (i == 1 )
                 {
                     results ("nachhaltigPicture" , i);
                 }
                 else if (i == 2 )
                 {
                     results ("elegantPicture" , i);
                 }
                 else if (i == 3 )
                 {
                     results ("casualPicture" , i);
                 }
                 else if (i == 4 )
                 {
                     results ("exzentrischPicture" , i);
                 }

                 else if (i == 5 )
                 {
                     results ("rockigPicture" , i);
                 }

                 else if (i == 6 )
                 {
                     results ("romantischPicture" , i);
                 }
                 else if (i == 7 )
                 {
                     results ("sportlichPicture" , i);
                 }

        }

        Intent intent = new Intent(this, Wordquiz.class);
        startActivity(intent);
    }

    public void results (String kategorie, int i)
    {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        int result;

        if (preferences.getString(Integer.toString(imageIds[i]), "") =="")
        {
            if (preferences.getString(Integer.toString(imageIds[i+8]), "") =="")
            {
                result =  0;
            }
            else
            {
                result = Integer.parseInt(preferences.getString(Integer.toString(imageIds[i+8]), ""));
            }
        }
        else if (preferences.getString(Integer.toString(imageIds[i+8]), "") =="")
        {
            if (preferences.getString(Integer.toString(imageIds[i]), "") =="")
            {
                result =  0;
            }
            else
            {
                result = Integer.parseInt(preferences.getString(Integer.toString(imageIds[i]), ""));
            }
        }
        else
        {
            result = Integer.parseInt(preferences.getString(Integer.toString(imageIds[i]), "")) + Integer.parseInt(preferences.getString(Integer.toString(imageIds[i+8]), ""));
        }
        editor.putString(kategorie, Integer.toString(result));
        editor.apply();
    }
}