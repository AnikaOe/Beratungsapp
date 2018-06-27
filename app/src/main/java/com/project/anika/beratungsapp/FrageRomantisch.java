package com.project.anika.beratungsapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

public class FrageRomantisch extends AppCompatActivity {

    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frage_romantisch);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String idString = preferences.getString("SelectedRomantisch", "");
        if(idString!="")
        {
            int id = Integer.parseInt(idString);
            radioGroup = findViewById(R.id.RG_Auswahl);
            radioGroup.check(id);
        }
    }

    //gehe weiter zur nächsten Frage
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
        editor.putString("romantisch",Integer.toString(result));
        editor.apply();

        //go to next
        Intent intent = new Intent(this, FrageSportlich.class);
        startActivity(intent);
    }

    public void onDestroy() {
        super.onDestroy();
        radioGroup = findViewById(R.id.RG_Auswahl);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("SelectedRomantisch",Integer.toString(radioGroup.getCheckedRadioButtonId()));
        editor.apply();
    }
}
