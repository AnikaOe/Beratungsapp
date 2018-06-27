package com.project.anika.beratungsapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

public class FrageElegant extends AppCompatActivity {

    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frageelegant);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String idString = preferences.getString("SelectedElegant", "");
        if(idString!="")
        {
            int id = Integer.parseInt(idString);
            radioGroup = findViewById(R.id.RG_Auswahl);
            radioGroup.check(id);
        }
    }

    public void weiterButtonClick(View view) {
        //get result
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
        editor.putString("elegant",Integer.toString(result));
        editor.apply();

        //go to next
        Intent intent = new Intent(this, FrageExzentrisch.class);
        startActivity(intent);
    }
    public void onDestroy() {
        super.onDestroy();
        radioGroup = findViewById(R.id.RG_Auswahl);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("SelectedElegant",Integer.toString(radioGroup.getCheckedRadioButtonId()));
        editor.apply();
    }

}
