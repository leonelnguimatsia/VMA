package de.thkoeln.cvogt.android.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Activity0 extends Activity {

   // Button buttonNguimatsia;
    //Button buttonSeibt;
    //private Object ActivityNguimatsia;
   //private Object ActivitySeibt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_0);

       final Button buttonNguimatsia = (Button) findViewById(R.id.button_Nguimatsia);
       final Button buttonSeibt = (Button) findViewById(R.id.button_Seibt);

        buttonNguimatsia.setOnClickListener(new SwitchButtonNguimatsiaListener());
        buttonSeibt.setOnClickListener(new SwitchButtonSeibtListener());

        Toast.makeText(this,"Activity0: onCreate()",Toast.LENGTH_LONG).show();
        Log.v("Aufgabe1_1","      ---> Activity0: onCreate() <--- ");
    }

    public void onStart() {
        super.onStart();
        Log.v("Aufgabe1_1","      ---> Activity0: onStart() <--- ");
    }

    public void onResume() {
        super.onResume();
        Log.v("Aufgabe1_1","      ---> Activity0: onResume() <--- ");
    }

    public void onPause() {
        super.onPause();
        Log.v("Aufgabe1_1","      ---> Activity0: onPause() <--- ");
    }

    public void onStop() {
        super.onStop();
        Log.v("Aufgabe1_1","      ---> Activity0: onStop() <--- ");
    }

    public void onDestroy() {
        super.onDestroy();
        Log.v("Aufgabe1_1","      ---> Activity0: onDestroy() <--- ");
    }

}

class SwitchButtonNguimatsiaListener implements View.OnClickListener{

    @Override
    public void onClick(View v) {

        Log.v("Aufgabe1_1","      ---> Activity0 : Click on Button_Nguimatsia <--- ");
        Intent myIntent = new Intent(v.getContext(), ActivityNguimatsia.class); // Durch Übergabe dieses Intent-Objekts an startActivity():
        v.getContext().startActivity(myIntent);                          // Erzeugung und Aktivierung einer neuen Instanz der Klasse ActivityNguimatsia
    }
}

class SwitchButtonSeibtListener implements View.OnClickListener {

    @Override
    public void onClick(View v) {

        Log.v("Aufgabe1_1","      ---> Activity0 : Click on Button_Seibt <--- ");
        Intent myIntent = new Intent(v.getContext(), ActivitySeibt.class); // Durch Übergabe dieses Intent-Objekts an startActivity():
        v.getContext().startActivity(myIntent);                          // Erzeugung und Aktivierung einer neuen Instanz der Klasse ActivitySeibt

    }
}