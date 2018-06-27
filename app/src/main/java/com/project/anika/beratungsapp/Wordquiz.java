package com.project.anika.beratungsapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Wordquiz extends AppCompatActivity {

    private int wordids[]={R.id.textViewWord1,R.id.textViewWord2,R.id.textViewWord3,R.id.textViewWord4,
            R.id.textViewWord5,R.id.textViewWord6,R.id.textViewWord7,R.id.textViewWord8,R.id.textViewWord9,
            R.id.textViewWord10,R.id.textViewWord11,R.id.textViewWord12,R.id.textViewWord13,R.id.textViewWord14,
            R.id.textViewWord15,R.id.textViewWord16,R.id.textViewWord17,R.id.textViewWord18,R.id.textViewWord19,
            R.id.textViewWord20,R.id.textViewWord21};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wordquiz);

        //Inital Tag
        findViewById(R.id.textViewWord1).setTag(1);
        findViewById(R.id.textViewWord2).setTag(1);
        findViewById(R.id.textViewWord3).setTag(1);
        findViewById(R.id.textViewWord4).setTag(1);
        findViewById(R.id.textViewWord5).setTag(1);
        findViewById(R.id.textViewWord6).setTag(1);
        findViewById(R.id.textViewWord7).setTag(1);
        findViewById(R.id.textViewWord8).setTag(1);
        findViewById(R.id.textViewWord9).setTag(1);
        findViewById(R.id.textViewWord10).setTag(1);
        findViewById(R.id.textViewWord11).setTag(1);
        findViewById(R.id.textViewWord12).setTag(1);
        findViewById(R.id.textViewWord13).setTag(1);
        findViewById(R.id.textViewWord14).setTag(1);
        findViewById(R.id.textViewWord15).setTag(1);
        findViewById(R.id.textViewWord16).setTag(1);
        findViewById(R.id.textViewWord17).setTag(1);
        findViewById(R.id.textViewWord18).setTag(1);
        findViewById(R.id.textViewWord19).setTag(1);
        findViewById(R.id.textViewWord20).setTag(1);
        findViewById(R.id.textViewWord21).setTag(1);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String idString;

        for (int i = 0; i < wordids.length; i++)
        {
            idString = preferences.getString(Integer.toString(wordids[i]), "");
            if(idString=="0")
            {
                onClickWord(findViewById(wordids[i]));
            }
        }

    }

    //gehe weiter zur nächsten Frage
    public void weiterButtonClick(View view) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        String idString;
        int points[] = {0,0,0,0,0,0,0,0};
        //for result
        for (int i = 0; i < wordids.length; i++) {
            idString = Integer.toString((Integer) findViewById(wordids[i]).getTag());
            if (idString == "0") {
                switch (i) {
                    case 0:
                        points[0] = points[0]+1;
                        break;
                    case 1:
                        points[0] = points[0]+1;
                        break;
                    case 2:
                        points[0] = points[0]+1;
                        points[6] = points[6]+1;
                        break;
                    case 3:
                        points[0] = points[0]+1;
                        points[2] = points[2]+1;
                        break;
                    case 4:
                        points[1] = points[1]+1;
                        points[6] = points[6]+1;
                        break;
                    case 5:
                        points[1] = points[1]+1;
                        break;
                    case 6:
                        points[1] = points[1]+1;
                        points[3] = points[3]+1;
                        points[4] = points[4]+1;
                        break;
                    case 7:
                        points[1] = points[1]+1;
                        points[2] = points[2]+1;
                        break;
                    case 8:
                        points[2] = points[2]+1;
                        break;
                    case 9:
                        points[2] = points[2]+1;
                        break;
                    case 10:
                        points[3] = points[3]+1;
                        points[7] = points[7]+1;
                        break;
                    case 11:
                        points[3] = points[3]+1;
                        break;
                    case 12:
                        points[3] = points[3]+1;
                        points[7] = points[7]+1;
                        break;
                    case 13:
                        points[4] = points[4]+1;
                        points[7] = points[7]+1;
                        break;
                    case 14:
                        points[4] = points[4]+1;
                        points[5] = points[5]+1;
                        break;
                    case 15:
                        points[4] = points[4]+1;
                        break;
                    case 16:
                        points[5] = points[5]+1;
                        break;
                    case 17:
                        points[5] = points[5]+1;
                        break;
                    case 18:
                        points[6] = points[6]+1;
                        points[7] = points[7]+1;
                        break;
                    case 19:
                        points[6] = points[6]+1;
                        break;
                    case 20:
                        points[5] = points[5]+1;
                        break;
                }
            }
        }

        //schreibe Ergebnis
        editor.putString("exzentrischWord",Integer.toString(points[0]));
        editor.putString("romantischWord",Integer.toString(points[1]));
        editor.putString("rockigWord",Integer.toString(points[2]));
        editor.putString("casualWord",Integer.toString(points[3]));
        editor.putString("elegantWord",Integer.toString(points[4]));
        editor.putString("figurbetontWord",Integer.toString(points[5]));
        editor.putString("nachhaltigWord",Integer.toString(points[6]));
        editor.putString("sportlichWord",Integer.toString(points[7]));
        editor.apply();

        //Gehe zu Ergebnis
        editor.putString("resultIndicator","nein");
        editor.apply();

        Intent intent = new Intent(this, Quiz.class);
        startActivity(intent);
    }

    public void onClickWord (View view) {
            if ((Integer)view.getTag()==1)
            {
                view.setTag(0);
                view.setBackgroundResource(R.drawable.textviewwordsselected);
            }
            else if ((Integer)view.getTag()==0)
            {
                view.setTag(1);
                view.setBackgroundResource(R.drawable.textviewwords);
            }
    }

    public void onDestroy() {
        super.onDestroy();

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();

        for (int i = 0; i < wordids.length; i++)
        {
            editor.putString(Integer.toString(wordids[i]),Integer.toString((Integer)findViewById(wordids[i]).getTag()));
        }

        editor.apply();
    }
}
