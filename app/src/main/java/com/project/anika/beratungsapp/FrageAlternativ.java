package com.project.anika.beratungsapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

public class FrageAlternativ extends AppCompatActivity {

    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragealternativ);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String idString = preferences.getString("SelectedAlternativ", "");
        if(idString!="")
        {
            int id = Integer.parseInt(idString);
            radioGroup = findViewById(R.id.RG_Auswahl);
            radioGroup.check(id);
        }

    }

    public void weiterButtonClick(View view) {

        //get Result
        int id;
        int result = 0;

        radioGroup = findViewById(R.id.RG_Auswahl);
        id = radioGroup.getCheckedRadioButtonId();

        switch (id)
        {
            case R.id.radioButton1:
                result =  2;
                break;
            case R.id.radioButton2:
                result =  1;
                break;
            case R.id.radioButton3:
                result =  0;
                break;
            case R.id.radioButton4:
                result =  -1;
                break;
            case R.id.radioButton5:
                result =  -2;
                break;
        }

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("nachhaltig",Integer.toString(result));
        editor.apply();

        //gehe zur nächsten Frage
        Intent intent = new Intent(this, FrageCasual.class);
        startActivity(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        radioGroup = findViewById(R.id.RG_Auswahl);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("SelectedAlternativ",Integer.toString(radioGroup.getCheckedRadioButtonId()));
        editor.apply();
    }

}
