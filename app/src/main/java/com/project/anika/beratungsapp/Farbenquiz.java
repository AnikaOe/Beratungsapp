package com.project.anika.beratungsapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Farbenquiz extends AppCompatActivity {

    private int Farben[] ={R.id.imageViewBlau,R.id.imageViewGelb,R.id.imageViewGruen,R.id.imageViewPink,R.id.imageViewLila,R.id.imageViewRot,R.id.imageViewBraun,R.id.imageViewSchwarz,R.id.imageViewWeiss};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farbenquiz);

        //setzte für alle Views ein Tag, dass nicht ausgewählt
        findViewById(R.id.imageViewWeiss).setTag(1);
        findViewById(R.id.imageViewSchwarz).setTag(1);
        findViewById(R.id.imageViewBraun).setTag(1);
        findViewById(R.id.imageViewRot).setTag(1);
        findViewById(R.id.imageViewLila).setTag(1);
        findViewById(R.id.imageViewPink).setTag(1);
        findViewById(R.id.imageViewGruen).setTag(1);
        findViewById(R.id.imageViewGelb).setTag(1);
        findViewById(R.id.imageViewBlau).setTag(1);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String idString;

        for (int i = 0; i < Farben.length; i++)
        {
            idString = preferences.getString(Integer.toString(Farben[i]), "");
            if(idString!=""&&idString=="0")
            {
                colorClick(findViewById(Farben[i]));
            }
        }
    }

    public void colorClick (View view) {
        if ((Integer)view.getTag()==1)
        {
            view.setTag(0);
            view.setBackgroundResource(R.drawable.textviewborder);
        }
        else if ((Integer)view.getTag()==0)
        {
            view.setTag(1);
            view.setBackgroundResource(R.drawable.textviewnoborder);
        }
    }


        //gehe weiter zur nächsten Frage
        public void weiterButtonClick(View view) {

            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("resultIndicator","nein");
            editor.apply();

            Intent intent = new Intent(this, Quiz.class);
            startActivity(intent);
    }

    public void onDestroy() {
        super.onDestroy();

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();

        for (int i = 0; i < Farben.length; i++)
        {
            editor.putString(Integer.toString(Farben[i]),Integer.toString((Integer)findViewById(Farben[i]).getTag()));
        }

        editor.apply();
    }
}
