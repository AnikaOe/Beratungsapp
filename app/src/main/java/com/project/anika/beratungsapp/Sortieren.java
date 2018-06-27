package com.project.anika.beratungsapp;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Sortieren extends AppCompatActivity {

    private int count = 1;
    private  ImageView nummer;
    private int id;
    private int[] numberIds = {R.drawable.icon1, R.drawable.icon2, R.drawable.icon3, R.drawable.icon4, R.drawable.icon5, R.drawable.icon6, R.drawable.icon7, R.drawable.icon8};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sortieren);

        //set Tags for all Views
        findViewById(R.id.numberSportlich).setTag(10);
        findViewById(R.id.numberRockig).setTag(10);
        findViewById(R.id.numberRomantisch).setTag(10);
        findViewById(R.id.numberFigurbetont).setTag(10);
        findViewById(R.id.numberExzentrisch).setTag(10);
        findViewById(R.id.numberElegant).setTag(10);
        findViewById(R.id.numberCasual).setTag(10);
        findViewById(R.id.numberNachhaltig).setTag(10);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        if(preferences.getString("count", "")!=""){
        count = Integer.parseInt(preferences.getString("count", ""));}
        String idString;
        int id;

            for (int i = 1; i <= count && i <= 8; ++i)
            {
                idString = preferences.getString("Number"+i, "");
                if(idString!="" && idString!="0")
                {
                    id  = Integer.parseInt(idString);
                    nummer = findViewById(id);
                    nummer.setImageResource(numberIds[i-1]);
                    nummer.setTag(i);
                    nummer.setVisibility(View.VISIBLE);
                }
            }

     /*   Toast.makeText(this, preferences.getString("debug",""),
                Toast.LENGTH_LONG).show();*/


    }

    public void setNumber(View view) {

        //nur wenn noch nicht alle 8 Zahlen gesetzt sind
        if (count<=8) {

            //setze die Nummer die ich Brauche
            id = numberIds[count-1];

            //lege Nummer auf View
            if (view == findViewById(R.id.imageViewNachhaltig) && findViewById(R.id.numberNachhaltig).getVisibility() != View.VISIBLE) {
                nummer = findViewById(R.id.numberNachhaltig);
                nummer.setImageResource(id);
                nummer.setTag(count);
                nummer.setVisibility(View.VISIBLE);
                count++;

            } else if (view == findViewById(R.id.imageViewCasual) && findViewById(R.id.numberCasual).getVisibility() != View.VISIBLE) {
                nummer = findViewById(R.id.numberCasual);
                nummer.setImageResource(id);
                nummer.setTag(count);
                nummer.setVisibility(View.VISIBLE);
                count++;
            }
            else if (view == findViewById(R.id.imageViewElegant) && findViewById(R.id.numberElegant).getVisibility() != View.VISIBLE) {
                nummer = findViewById(R.id.numberElegant);
                nummer.setImageResource(id);
                nummer.setTag(count);
                nummer.setVisibility(View.VISIBLE);
                count++;
            }
            else if (view == findViewById(R.id.imageViewExzentrisch) && findViewById(R.id.numberExzentrisch).getVisibility() != View.VISIBLE) {
                nummer = findViewById(R.id.numberExzentrisch);
                nummer.setImageResource(id);
                nummer.setTag(count);
                nummer.setVisibility(View.VISIBLE);
                count++;
            }
            else if (view == findViewById(R.id.imageViewFigurbetont) && findViewById(R.id.numberFigurbetont).getVisibility() != View.VISIBLE) {
                nummer = findViewById(R.id.numberFigurbetont);
                nummer.setImageResource(id);
                nummer.setTag(count);
                nummer.setVisibility(View.VISIBLE);
                count++;
            }
            else if (view == findViewById(R.id.imageViewRomantisch) && findViewById(R.id.numberRomantisch).getVisibility() != View.VISIBLE) {
                nummer = findViewById(R.id.numberRomantisch);
                nummer.setImageResource(id);
                nummer.setTag(count);
                nummer.setVisibility(View.VISIBLE);
                count++;
            }
            else if (view == findViewById(R.id.imageViewRockig) && findViewById(R.id.numberRockig).getVisibility() != View.VISIBLE) {
                nummer = findViewById(R.id.numberRockig);
                nummer.setImageResource(id);
                nummer.setTag(count);
                nummer.setVisibility(View.VISIBLE);
                count++;
            }
            else if (view == findViewById(R.id.imageViewSportlich) && findViewById(R.id.numberSportlich).getVisibility() != View.VISIBLE) {
                nummer = findViewById(R.id.numberSportlich);
                nummer.setImageResource(id);
                nummer.setTag(count);
                nummer.setVisibility(View.VISIBLE);
                count++;
            }
        }
    }

    public void undoButton (View view) {

        // Nur wenn schon mindestens eine Zahl gesetzt ist
        if (count > 1) {
            //setze die Nummer die ich Brauche
            id = numberIds[count - 2];

            if ((Integer) findViewById(R.id.numberNachhaltig).getTag() == count-1) {
                findViewById(R.id.numberNachhaltig).setVisibility(View.INVISIBLE);
                findViewById(R.id.numberNachhaltig).setTag(10);
                count--;
            } else if ((Integer) findViewById(R.id.numberCasual).getTag() == count-1) {
                findViewById(R.id.numberCasual).setVisibility(View.INVISIBLE);
                findViewById(R.id.numberCasual).setTag(10);
                count--;
            } else if ((Integer) findViewById(R.id.numberElegant).getTag() == count-1) {
                findViewById(R.id.numberElegant).setVisibility(View.INVISIBLE);
                findViewById(R.id.numberElegant).setTag(10);
                count--;
            } else if ((Integer) findViewById(R.id.numberExzentrisch).getTag() == count-1) {
                findViewById(R.id.numberExzentrisch).setVisibility(View.INVISIBLE);
                findViewById(R.id.numberExzentrisch).setTag(10);
                count--;
            } else if ((Integer) findViewById(R.id.numberFigurbetont).getTag() == count-1) {
                findViewById(R.id.numberFigurbetont).setVisibility(View.INVISIBLE);
                findViewById(R.id.numberFigurbetont).setTag(10);
                count--;
            } else if ((Integer) findViewById(R.id.numberRomantisch).getTag() == count-1) {
                findViewById(R.id.numberRomantisch).setVisibility(View.INVISIBLE);
                findViewById(R.id.numberRomantisch).setTag(10);
                count--;
            } else if ((Integer) findViewById(R.id.numberRockig).getTag() == count-1) {
                findViewById(R.id.numberRockig).setVisibility(View.INVISIBLE);
                findViewById(R.id.numberRockig).setTag(10);
                count--;
            } else if ((Integer) findViewById(R.id.numberSportlich).getTag() == count-1) {
                findViewById(R.id.numberSportlich).setVisibility(View.INVISIBLE);
                findViewById(R.id.numberSportlich).setTag(10);
                count--;
            }
        }
    }

    public void restartButtonClick (View view)
    {
        findViewById(R.id.numberSportlich).setVisibility(View.INVISIBLE);
        findViewById(R.id.numberRockig).setVisibility(View.INVISIBLE);
        findViewById(R.id.numberRomantisch).setVisibility(View.INVISIBLE);
        findViewById(R.id.numberFigurbetont).setVisibility(View.INVISIBLE);
        findViewById(R.id.numberExzentrisch).setVisibility(View.INVISIBLE);
        findViewById(R.id.numberElegant).setVisibility(View.INVISIBLE);
        findViewById(R.id.numberCasual).setVisibility(View.INVISIBLE);
        findViewById(R.id.numberNachhaltig).setVisibility(View.INVISIBLE);
        findViewById(R.id.numberSportlich).setTag(10);
        findViewById(R.id.numberRockig).setTag(10);
        findViewById(R.id.numberRomantisch).setTag(10);
        findViewById(R.id.numberFigurbetont).setTag(10);
        findViewById(R.id.numberExzentrisch).setTag(10);
        findViewById(R.id.numberElegant).setTag(10);
        findViewById(R.id.numberCasual).setTag(10);
        findViewById(R.id.numberNachhaltig).setTag(10);
        count = 1;
    }

    public void weiterButtonClick (View view) {
      // Intent intent = new Intent(this, FrageAlternativ.class);
      //  startActivity(intent);
        //speichere Ergebnisse
        clearResults();
        for (int i = 1; i <= count || i < 5; ++i)
        {
            if ((Integer) findViewById(R.id.numberNachhaltig).getTag() == i) {
                results ("nachhaltigSortieren",i);
            } else if ((Integer) findViewById(R.id.numberCasual).getTag() == i) {
                results ("casualSortieren",i);
            } else if ((Integer) findViewById(R.id.numberElegant).getTag() == i) {
                results ("elegantSortieren",i);
            } else if ((Integer) findViewById(R.id.numberExzentrisch).getTag() == i) {
                results ("exzentrischSortieren",i);
            } else if ((Integer) findViewById(R.id.numberFigurbetont).getTag() == i) {
                results ("figurbetontSortieren",i);
            } else if ((Integer) findViewById(R.id.numberRomantisch).getTag() == i) {
                results ("romantischSortieren",i);
            } else if ((Integer) findViewById(R.id.numberRockig).getTag() == i) {
                results ("rockigSortieren",i);
            } else if ((Integer) findViewById(R.id.numberSportlich).getTag() == i) {
                results ("sportlichSortieren",i);
            }
        }
        //gehe zur nächsten
        Intent intent = new Intent(this, FrageAlternativ.class);
        startActivity(intent);
    }

    private void clearResults() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("nachhaltigSortieren", "0");
        editor.putString("casualSortieren", "0");
        editor.putString("elegantSortieren", "0");
        editor.putString("exzentrischSortieren", "0");
        editor.putString("figurbetontSortieren", "0");
        editor.putString("romantischSortieren", "0");
        editor.putString("rockigSortieren", "0");
        editor.putString("sportlichSortieren", "0");
        editor.apply();

    }

    public void results (String kategorie, int i)
    {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();

        int result = 0;

        //add to result
        if (i == 1)
        {
            result = 3;
        }
        else if (i == 2)
        {
            result = 2;
        }
        else if (i == 3 || i == 4)
        {
            result =  1;
        }

        editor.putString(kategorie, Integer.toString(result));
        editor.apply();

    }


    public void onDestroy() {
        super.onDestroy();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        String message;

        for (int i = 1; i <= count; ++i)
        {
            if ((Integer) findViewById(R.id.numberNachhaltig).getTag() == i) {
                message = Integer.toString(R.id.numberNachhaltig);
                editor.putString("Number"+i, message);
            } else if ((Integer) findViewById(R.id.numberCasual).getTag() == i) {
                message = Integer.toString(R.id.numberCasual);
                editor.putString("Number"+i, message);
            } else if ((Integer) findViewById(R.id.numberElegant).getTag() == i) {
                message = Integer.toString(R.id.numberElegant);
                editor.putString("Number"+i, message);
            } else if ((Integer) findViewById(R.id.numberExzentrisch).getTag() == i) {
                message = Integer.toString(R.id.numberExzentrisch);
                editor.putString("Number"+i, message);
            } else if ((Integer) findViewById(R.id.numberFigurbetont).getTag() == i) {
                message = Integer.toString(R.id.numberFigurbetont);
                editor.putString("Number"+i, message);
            } else if ((Integer) findViewById(R.id.numberRomantisch).getTag() == i) {
                message = Integer.toString(R.id.numberRomantisch);
                editor.putString("Number"+i, message);
            } else if ((Integer) findViewById(R.id.numberRockig).getTag() == i) {
                message = Integer.toString(R.id.numberRockig);
                editor.putString("Number"+i, message);
            } else if ((Integer) findViewById(R.id.numberSportlich).getTag() == i) {
                message = Integer.toString(R.id.numberSportlich);
                editor.putString("Number"+i, message);
            }
            editor.apply();
        }
        editor.putString("count", Integer.toString(count));
        editor.apply();
    }
}
