// Prof. Dr. Carsten Vogt
// Technische Hochschule Köln
// Fakultät für Informations-, Medien- und Elektrotechnik
// www.nt.th-koeln.de/vogt/

// Eine App mit zwei Activities, zwischen denen man hin- und herschalten kann.
// LogCat-Ausgaben zeigen dabei an, wann welche Zustandsübergangsmethoden (Callbacks) ausgeführt werden.
// Stand: 4.12.2015

// Video dazu: https://youtu.be/Zwswz3UmvOc

package de.thkoeln.cvogt.android.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

/* Diese zweite Aktivität muss ggf. per Hand im Manifest eingetragen werden.
   Sie wird dort automatisch eingetragen, wenn im Project-Unterfenster auf 'java'
   rechts-klickt und dann den Menus "New > Activity > ..." folgt. */

public class ActivitySeibt extends Activity {
        
    public void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seibt);
        
        final Button switchButton = (Button) findViewById(R.id.switchActivity);  // ab API-Level 26 ist der Type Cast des Rückgabewerts von findViewById() nicht mehr nötig

        final Button mainButton = (Button) findViewById(R.id.button_Seibt_Zu_Main);

        switchButton.setOnClickListener(new SwitchButtonListener2());

        mainButton.setOnClickListener( new SwitchButtonMainListener2());

        Toast.makeText(this,"ActivitySeibt: onCreate()", Toast.LENGTH_LONG).show();
        
        Log.v("Aufgabe1_1","      ---> ActivitySeibt: onCreate() <--- ");
        // Log.v("DEMO","Activity2: Intent.getComponent() = "+getIntent().getComponent());

    }

    public void onStart() {
        super.onStart();
        Log.v("Aufgabe1_1","      ---> ActivitySeibt: onStart() <--- ");
    }        

    public void onResume() {
        super.onResume();
        Log.v("Aufgabe1_1","      ---> ActivitySeibt: onResume() <--- ");
    }        

    public void onPause() {
        super.onPause();
        Log.v("Aufgabe1_1","      ---> ActivitySeibt: onPause() <--- ");
    }        

    public void onStop() {
        super.onStop();
        Log.v("Aufgabe1_1","      ---> ActivitySeibt: onStop() <--- ");
    }        

    public void onDestroy() {
        super.onDestroy();
        Log.v("Aufgabe1_1","      ---> ActivitySeibt: onDestroy() <--- ");
    }       

}

class SwitchButtonListener2 implements OnClickListener  {   // Listener des Buttons
        
        public void onClick(View v) {
        Log.v("Aufgabe1_1","      ---> ActivityNguimatsia: Click on Button Gehe zu Nguimatsia <--- ");
        Intent myIntent = new Intent(v.getContext(), ActivityNguimatsia.class); // Durch Übergabe dieses Intent-Objekts an startActivity():
        v.getContext().startActivity(myIntent);                          // Erzeugung und Aktivierung einer neuen Instanz der Klasse ActivityNguimatsia
        }
        
}

class SwitchButtonMainListener2 implements  OnClickListener{

    @Override
    public void onClick(View v) {

        Log.v("Aufgabe1_1","---> Activity0: Click on Button Ngui Zu Main <--- ");
        Intent myIntent = new Intent(v.getContext(), Activity0.class); // Durch Übergabe dieses Intent-Objekts an startActivity():
        myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        // Log.v("DEMO","Activity1: Intent.getComponent() = "+myIntent.getComponent());
        v.getContext().startActivity(myIntent);                             // Erzeugung und Aktivierung einer neuen Instanz der Klasse Activity0
    }
}
