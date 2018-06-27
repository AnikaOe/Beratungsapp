package com.project.anika.beratungsapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Quiz extends AppCompatActivity {

    private int nachhaltig;
    private int casual;
    private int elegant;
    private int exzentrisch;
    private int figurbetont;
    private int rockig;
    private int romantisch;
    private int sportlich;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        if (preferences.getString("resultIndicator","")=="ja")
        {
            findResult();
        }
        else
        {
            calculateResult();
            writeResult();
        }
        //Das zeigt dir die einzelnen Punkte pro Kategorie
        //displayResult();
        compareResults();

    }

    private void findResult()
    {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        nachhaltig = Integer.parseInt(preferences.getString("nachhaltigResult", ""));
        casual = Integer.parseInt( preferences.getString("casualResultn", ""));
        elegant = Integer.parseInt(preferences.getString("elegantResult", ""));
        exzentrisch = Integer.parseInt(preferences.getString("exzentrischResult", ""));
        figurbetont = Integer.parseInt(preferences.getString("figurbetontResult", ""));
        romantisch = Integer.parseInt(preferences.getString("romantischResult", ""));
        rockig = Integer.parseInt(preferences.getString("rockigResult", ""));
        sportlich = Integer.parseInt(preferences.getString("sportlichResult", ""));
    }

    private void calculateResult()
          {
              SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

              //für nachhaltig

              if(preferences.getString("nachhaltig","")!="")
              {
                  nachhaltig=nachhaltig + Integer.parseInt(preferences.getString("nachhaltig",""));
              }
              if(preferences.getString("nachhaltigWord","")!="")
              {
                  nachhaltig=nachhaltig + Integer.parseInt(preferences.getString("nachhaltigWord",""));
              }
              if(preferences.getString("nachhaltigPicture","")!="")
              {
                  nachhaltig=nachhaltig + Integer.parseInt(preferences.getString("nachhaltigPicture",""));
              }
              if(preferences.getString("nachhaltigSortieren","")!="")
              {
                  nachhaltig=nachhaltig + Integer.parseInt(preferences.getString("nachhaltigSortieren",""));
              }

              //für Casual

              if(preferences.getString("casual","")!="")
              {
                  casual=casual + Integer.parseInt(preferences.getString("casual",""));
              }
              if(preferences.getString("casualWord","")!="")
              {
                  casual=casual + Integer.parseInt(preferences.getString("casualWord",""));
              }
              if(preferences.getString("casualPicture","")!="")
              {
                  casual=casual + Integer.parseInt(preferences.getString("casualPicture",""));
              }
              if(preferences.getString("casualSortieren","")!="")
              {
                  casual=casual + Integer.parseInt(preferences.getString("casualSortieren",""));
              }

              //Elegant
              if(preferences.getString("elegant","")!="")
              {
                  elegant=elegant + Integer.parseInt(preferences.getString("elegant",""));
              }
              if(preferences.getString("elegantWord","")!="")
              {
                  elegant=elegant + Integer.parseInt(preferences.getString("elegantWord",""));
              }
              if(preferences.getString("elegantPicture","")!="")
              {
                  elegant=elegant + Integer.parseInt(preferences.getString("elegantPicture",""));
              }
              if(preferences.getString("elegantSortieren","")!="")
              {
                  elegant=elegant + Integer.parseInt(preferences.getString("elegantSortieren",""));
              }

              //Exzentrisch
              if(preferences.getString("exzentrisch","")!="")
              {
                  exzentrisch=exzentrisch + Integer.parseInt(preferences.getString("exzentrisch",""));
              }
              if(preferences.getString("exzentrischWord","")!="")
              {
                  exzentrisch=exzentrisch + Integer.parseInt(preferences.getString("exzentrischWord",""));
              }
              if(preferences.getString("exzentrischPicture","")!="")
              {
                  exzentrisch=exzentrisch + Integer.parseInt(preferences.getString("exzentrischPicture",""));
              }
              if(preferences.getString("exzentrischSortieren","")!="")
              {
                  exzentrisch=exzentrisch + Integer.parseInt(preferences.getString("exzentrischSortieren",""));
              }

              //Figurbetont
              if(preferences.getString("figurbetont","")!="")
              {
                  figurbetont=figurbetont + Integer.parseInt(preferences.getString("figurbetont",""));
              }
              if(preferences.getString("figurbetontWord","")!="")
              {
                  figurbetont=figurbetont + Integer.parseInt(preferences.getString("figurbetontWord",""));
              }
              if(preferences.getString("figurbetontPicture","")!="")
              {
                  figurbetont=figurbetont + Integer.parseInt(preferences.getString("figurbetontPicture",""));
              }
              if(preferences.getString("figurbetontSortieren","")!="")
              {
                  figurbetont=figurbetont + Integer.parseInt(preferences.getString("figurbetontSortieren",""));
              }

              //rockig
              if(preferences.getString("rockig","")!="")
              {
                  rockig=rockig + Integer.parseInt(preferences.getString("rockig",""));
              }
              if(preferences.getString("rockigWord","")!="")
              {
                  rockig=rockig + Integer.parseInt(preferences.getString("rockigWord",""));
              }
              if(preferences.getString("rockigPicture","")!="")
              {
                  rockig=rockig + Integer.parseInt(preferences.getString("rockigPicture",""));
              }
              if(preferences.getString("rockigSortieren","")!="")
              {
                  rockig=rockig + Integer.parseInt(preferences.getString("rockigSortieren",""));
              }

              //Romantisch
              if(preferences.getString("romantisch","")!="")
              {
                  romantisch=romantisch + Integer.parseInt(preferences.getString("romantisch",""));
              }
              if(preferences.getString("romantischWord","")!="")
              {
                  romantisch=romantisch + Integer.parseInt(preferences.getString("romantischWord",""));
              }
              if(preferences.getString("romantischPicture","")!="")
              {
                  romantisch=romantisch + Integer.parseInt(preferences.getString("romantischPicture",""));
              }
              if(preferences.getString("romantischSortieren","")!="")
              {
                  romantisch=romantisch + Integer.parseInt(preferences.getString("romantischSortieren",""));
              }

              //Sportlich
              if(preferences.getString("sportlich","")!="")
              {
                  sportlich=sportlich + Integer.parseInt(preferences.getString("sportlich",""));
              }
              if(preferences.getString("sportlichWord","")!="")
              {
                  sportlich=sportlich + Integer.parseInt(preferences.getString("sportlichWord",""));
              }
              if(preferences.getString("sportlichPicture","")!="")
              {
                  sportlich=sportlich + Integer.parseInt(preferences.getString("sportlichPicture",""));
              }
              if(preferences.getString("sportlichSortieren","")!="")
              {
                  sportlich=sportlich + Integer.parseInt(preferences.getString("sportlichSortieren",""));
              }

          }

          public void displayResult() {

            String text = "Nachhaltig: " + nachhaltig + "\n" +
                    "Casual: " + casual + "\n" +
                    "Elegant: " + elegant+ "\n" +
                    "Exzentrisch: " + exzentrisch + "\n" +
                    "Figurbetont" + figurbetont + "\n" +
                    "Rockig: " + rockig + "\n" +
                    "Romantisch: " + romantisch + "\n" +
                    "Sportlich: " + sportlich + "\n";

            //TextView auswertungsView = findViewById(R.id.debug);
            //auswertungsView.setText(text);
          }

          private void compareResults() {
              if (nachhaltig > 0 || casual > 0 || elegant > 0 || exzentrisch > 0 || figurbetont > 0 || rockig > 0 || romantisch > 0 || sportlich > 0) {
                  int maxValue = 0;
                  int Ergebnisse[] = {nachhaltig, casual, elegant, exzentrisch, figurbetont, rockig, romantisch, sportlich};
                  String Auswertungen[] = {getString(R.string.AuswertungNachhaltig), getString(R.string.AuswertungCasual), getString(R.string.AuswertungElegant), getString(R.string.AuswertungExzentrisch), getString(R.string.AuswertungFigurbetont), getString(R.string.AuswertungRockig), getString(R.string.AuswertungRomantisch), getString(R.string.AuswertungSportlich)};
                  String Headlines[] = {getString(R.string.HeadlineNachhaltig), getString(R.string.HeadlineCasual), getString(R.string.HeadlineElegant), getString(R.string.HeadlineExzentrisch), getString(R.string.HeadlineFigurbetont), getString(R.string.HeadlineRockig), getString(R.string.HeadlineRomantisch), getString(R.string.HeadlineSportlich)};
                  int Pictureids [] = {R.drawable.nachhaltig1,R.drawable.casual1,R.drawable.elegant1,R.drawable.exzentrisch1,R.drawable.figurbetont1,R.drawable.rockig1,R.drawable.romantisch1,R.drawable.sportlich1};
                  int maxIndex = -1;
                  int first;
                  int second;
                  for (int i = 0; i < Ergebnisse.length; i++) {
                      if (Ergebnisse[i] > maxValue) {
                          maxValue = Ergebnisse[i];
                          maxIndex = i;
                      }
                  }

                  first = maxIndex;
                  Ergebnisse[first] = 0;
                  maxIndex = -1;
                  maxValue = 0;

                  ((TextView) findViewById(R.id.textViewHeadline1)).setText("Du bist der " + Headlines[first] +"!");
                  ((TextView) findViewById(R.id.textViewAuswertung1)).setText(Auswertungen[first]);
                  ((ImageView) findViewById(R.id.imageViewAuswertung1)).setImageResource(Pictureids[first]);

                  if (Ergebnisse[0] > 0 || Ergebnisse[1] > 0 || Ergebnisse[2] > 0 || Ergebnisse[3] > 0 || Ergebnisse[4] > 0 || Ergebnisse[5] > 0 || Ergebnisse[6] > 0 || Ergebnisse[7] > 0) {
                      for (int i = 0; i < Ergebnisse.length; i++) {
                          if (Ergebnisse[i] > maxValue) {
                              maxValue = Ergebnisse[i];
                              maxIndex = i;
                          }
                      }
                      second = maxIndex;
                      Ergebnisse[second] = 0;

                      ((TextView) findViewById(R.id.textViewHeadline2)).setText("Auch der " + Headlines[second] + " passt zu dir!");
                      ((TextView) findViewById(R.id.textViewAuswertung2)).setText(Auswertungen[second]);
                      ((ImageView) findViewById(R.id.imageViewAuswertung2)).setImageResource(Pictureids[second]);
                  }
                  else
                  {
                      ((TextView) findViewById(R.id.textViewHeadline2)).setText("");
                      ((TextView) findViewById(R.id.textViewAuswertung2)).setText("");
                      ((ImageView) findViewById(R.id.imageViewAuswertung2)).setVisibility(View.INVISIBLE);
                  }

              }
              else
              {
                  ((TextView) findViewById(R.id.textViewHeadline1)).setText("");
                  ((TextView) findViewById(R.id.textViewAuswertung1)).setText("Beantworte die Fragen im Quiz, um dein Style-Ergebnis zu bekommen.");
                  ((TextView) findViewById(R.id.textViewHeadline2)).setText("");
                  ((TextView) findViewById(R.id.textViewAuswertung2)).setText("");
                  ((ImageView) findViewById(R.id.imageViewAuswertung1)).setVisibility(View.INVISIBLE);
                  ((ImageView) findViewById(R.id.imageViewAuswertung2)).setVisibility(View.INVISIBLE);
              }
          }

          private void writeResult()
          {
              SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
              SharedPreferences.Editor editor = preferences.edit();
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

          public void goToHauptmenue (View view)
          {
              //gehe zum Hauptmenue
              Intent intent = new Intent(this, Hauptmenue.class);
              startActivity(intent);
          }

      }
