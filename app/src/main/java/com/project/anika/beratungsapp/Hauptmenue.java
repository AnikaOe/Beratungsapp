package com.project.anika.beratungsapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Hauptmenue extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hauptmenue);

        initialisiereResult();


    }

    private void initialisiereResult() {
        int nachhaltig = 0;
        int casual = 0;
        int elegant = 0;
        int exzentrisch = 0;
        int figurbetont = 0;
        int rockig = 0;
        int romantisch = 0;
        int sportlich = 0;
        int indicator = 0;

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();

        if(preferences.getString("nachhaltigResult", "")!="")
        {
            nachhaltig = Integer.parseInt(preferences.getString("nachhaltigResult", ""));
            indicator = 1;
        }
        if(preferences.getString("casualResult", "")!="")
        {
            casual = Integer.parseInt(preferences.getString("casualResult", ""));
            indicator = 1;
        }
        if(preferences.getString("elegantResult", "")!="")
        {
            elegant = Integer.parseInt(preferences.getString("elegantResult", ""));
            indicator = 1;
        }
        if(preferences.getString("exzentrischResult", "")!="")
        {
            exzentrisch = Integer.parseInt(preferences.getString("exzentrischResult", ""));
            indicator = 1;
        }
        if(preferences.getString("figurbetontResult", "")!="")
        {
            figurbetont = Integer.parseInt(preferences.getString("figurbetontResult", ""));
            indicator = 1;
        }
        if(preferences.getString("romantischResult", "")!="")
        {
            romantisch = Integer.parseInt(preferences.getString("romantischResult", ""));
            indicator = 1;
        }
        if(preferences.getString("rockigResult", "")!="")
        {
            rockig = Integer.parseInt(preferences.getString("rockigResult", ""));
            indicator = 1;
        }
        if(preferences.getString("sportlichResult", "")!="")
        {
            sportlich = Integer.parseInt(preferences.getString("sportlichResult", ""));
            indicator = 1;
        }

        PreferenceManager.getDefaultSharedPreferences(getBaseContext()).
                edit().clear().apply();


        if(indicator==1)
        {
            TextView zurAuswertung = findViewById(R.id.textViewZurAuswertung);
            zurAuswertung.setVisibility(View.VISIBLE);
        }

        editor.putString("nachhaltigResult", Integer.toString(nachhaltig));
        editor.putString("casualResultn", Integer.toString(casual));
        editor.putString("elegantResult", Integer.toString(elegant));
        editor.putString("exzentrischResult", Integer.toString(exzentrisch));
        editor.putString("figurbetontResult", Integer.toString(figurbetont));
        editor.putString("romantischResult", Integer.toString(romantisch));
        editor.putString("rockigResult", Integer.toString(rockig));
        editor.putString("sportlichResult", Integer.toString(sportlich));
        editor.apply();

    }

    public void startAuswertung (View view)
    {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("resultIndicator","ja");
        editor.apply();
        Intent intent = new Intent(this,Quiz.class);
        startActivity(intent);

    }

    //startet Fashionquiz
    public void openFashionquiz(View view) {
        Intent intent = new Intent(this, Sortieren.class);
        startActivity(intent);
    }

    //Öffnet Facebook (für SocialMedia Button Hauptmenue)
    public void openFacebook(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/wundercurves.de/"));
        startActivity(browserIntent);
    }

    public void openYoutube(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCRTMy2P9OmJA_EB7lPYnQzw"));
        startActivity(browserIntent);
    }

    public void openPinterest(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.pinterest.com/wundercurves_de/"));
        startActivity(browserIntent);
    }

    public void openInstagram(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/wundercurves.de/"));
        startActivity(browserIntent);
    }


}
