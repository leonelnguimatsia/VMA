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

public class ActivityNguimatsia extends Activity {



        
    /* onCreate() wird bei der Erzeugung der Activity ausgeführt. */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);  // Android Doku: "Derived classes must call through to the super class's implementation of this method. If they do not, an exception will be thrown."
        setContentView(R.layout.activity_nguimatsia);  // zeigt Layout auf dem Display an
        setTitle(R.string.activity1_title);  // setzt den Titel der Activity (kann alternativ durch ein Attribut in der Manifest-Datei geschehen)
        // setTitle("@string/activity1_title");  // alternative Form des Parameters

        final Button switchButton = (Button) findViewById(R.id.switchActivity);  // ab API-Level 26 ist der Type Cast des Rückgabewerts von findViewById() nicht mehr nötig

        final Button mainButton = (Button) findViewById(R.id.button_Ngui_Zu_Main);

        switchButton.setOnClickListener(new SwitchButtonListener());

        mainButton.setOnClickListener( new SwitchButtonMainListener());

        
        Toast.makeText(this,"ActivityNguimatsia: onCreate()", Toast.LENGTH_LONG).show(); // Kontrollausgabe durch 'Toast', Parameter 'this' bezieht sich auf die Activity]

        Log.v("Aufgabe1_1","---> ActivityNguimatsia: onCreate() <--- "); // Kontrollausgabe im LogCat

    }
    
    public void onStart() {
        super.onStart();
        Log.v("Aufgabe1_1","---> ActivityNguimatsia: onStart() <--- ");
    }        

    public void onResume() {
        super.onResume();
        Log.v("Aufgabe1_1","---> ActivityNguimatsia: onResume() <--- ");
    }        

    public void onPause() {
        super.onPause();
        Log.v("Aufgabe1_1","---> ActivityNguimatsia: onPause() <--- ");
    }        

    public void onStop() {
        super.onStop();
        Log.v("Aufgabe1_1","---> ActivityNguimatsia: onStop() <--- ");
    }        

    public void onDestroy() {
        super.onDestroy();
        Log.v("Aufgabe1_1","---> ActivityNguimatsia: onDestroy() <--- ");
    }

}

class SwitchButtonListener implements OnClickListener  {   // Listener des Buttons

        public void onClick(View v) {
                Log.v("Aufgabe1_1","---> ActivitySeibt: Click on Button Gehe zu Seibt <--- ");
                Intent myIntent = new Intent(v.getContext(), ActivitySeibt.class); // Durch Übergabe dieses Intent-Objekts an startActivity():
                // Log.v("DEMO","Activity1: Intent.getComponent() = "+myIntent.getComponent());
                v.getContext().startActivity(myIntent);                             // Erzeugung und Aktivierung einer neuen Instanz der Klasse ActivitySeibt
        }
}

class SwitchButtonMainListener implements  OnClickListener{

    @Override
    public void onClick(View v) {

        Log.v("Aufgabe1_1","---> Activity0: Click on Button Ngui Zu Main <--- ");
        Intent myIntent = new Intent(v.getContext(), Activity0.class); // Durch Übergabe dieses Intent-Objekts an startActivity():
        myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        // Log.v("DEMO","Activity1: Intent.getComponent() = "+myIntent.getComponent());
        v.getContext().startActivity(myIntent);                             // Erzeugung und Aktivierung einer neuen Instanz der Klasse Activity0
    }
}
