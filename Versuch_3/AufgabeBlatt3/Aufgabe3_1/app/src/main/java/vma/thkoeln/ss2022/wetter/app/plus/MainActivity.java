package vma.thkoeln.ss2022.wetter.app.plus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView temperatur, textanzahlEingabe, textAnzahlRegen, textAnzahlWind, textAnzahlDurschnitt, textAusgabetemperatur;
    EditText eingabeTemperatur;
    CheckBox regenCheckbox, windCheckBox;
    Button bttn_Übernehmen, bttn_Reset;
    Toast meldung;
    int anzahlRegen = 0;
    int anzahlWind = 0;
    int anzahlEingabe = 0;
    double summeTemperatrur = 0.0;
    WetterAppDatabase wetterAppDatabase;
    WetterAppDao wetterAppDao;
    int initialize = 1;


    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){

        Toast toast = Toast.makeText(MainActivity.this,"test",Toast.LENGTH_LONG);
        toast.show();
        startActivity(new Intent(MainActivity.this, Meineliste.class));

        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Registrierung der oben gennanten Attributten

        temperatur = findViewById(R.id.textTemperatur);
        textAusgabetemperatur = findViewById(R.id.textAusgabe);
        textanzahlEingabe = findViewById(R.id.textGrad);
        textAnzahlWind = findViewById(R.id.textWind);
        textAnzahlRegen = findViewById(R.id.textRegen);
        textAnzahlDurschnitt = findViewById(R.id.textDurschnitt);
        eingabeTemperatur = findViewById(R.id.textEingabe);
        regenCheckbox = findViewById(R.id.checkBoxRegen);
        windCheckBox = findViewById(R.id.checkBoxWind);
        bttn_Übernehmen = findViewById(R.id.buttonÜbernehemen);
        bttn_Reset = findViewById(R.id.buttonReset);

        meldung = Toast.makeText(this,"Vorsicht vor Glätte!!",Toast.LENGTH_LONG);
        bttn_Übernehmen.setOnClickListener(new ButtonÜbernehmenListener());
        bttn_Reset.setOnClickListener((new ButtonResetListener()));

        wetterAppDatabase = Room.databaseBuilder(getApplicationContext(),WetterAppDatabase.class,"mein-wetterApp").allowMainThreadQueries().build();
        (new Thread(){public void run(){
            wetterAppDatabase.clearAllTables();
        }}).start();

        wetterAppDao = wetterAppDatabase.wetterAppDao();
    }

    public class ButtonÜbernehmenListener implements View.OnClickListener {


        @SuppressLint("SetTextI18n")
        @Override
        public void onClick(View view) {

            String isRegen = " " ,isWind = " ";

            if(regenCheckbox.isChecked()){

                isRegen = "Regen";

                anzahlRegen++;

            } else{

                isRegen = " Kein Regen";
            }

            if(windCheckBox.isChecked()){

                isWind = "Wind";

                anzahlWind++;

            } else{

                isWind = "Kein Wind";
            }

            textAusgabetemperatur.setText(eingabeTemperatur.getText()+" Grad "+ isRegen +", "+ isWind);

            double hilfsvarialbe = Double.valueOf(String.valueOf(eingabeTemperatur.getText()));

            if(hilfsvarialbe < 4.0) {

                meldung.show();
            }
            anzahlEingabe++;
            summeTemperatrur+= hilfsvarialbe;
            textAnzahlDurschnitt.setText("Temp Durschnitt.: "+ String.valueOf(summeTemperatrur/anzahlEingabe));
            textanzahlEingabe.setText("Gesamte eingabe: "+ String.valueOf(anzahlEingabe));
            textAnzahlRegen.setText("Anzahl Eingabe Regen:"+String.valueOf(anzahlRegen));
            textAnzahlWind.setText("Anzahl eingabe Wind:"+String.valueOf(anzahlWind));

            long time = System.currentTimeMillis();
            WetterApp wetterApp = new WetterApp(initialize,time,hilfsvarialbe,regenCheckbox.isChecked(),windCheckBox.isChecked());
            System.out.println("Bonjour a tous");
            wetterAppDao.insertAll(wetterApp);
            System.out.println("Affiche Size: "+wetterAppDao.getAll().size());
            initialize++;


        }
    }

    public class ButtonResetListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {

            anzahlRegen = 0;
            anzahlWind = 0;
            summeTemperatrur = 0.0;
            anzahlEingabe = 0;

            regenCheckbox.setChecked(false);
            windCheckBox.setChecked(false);

            textAusgabetemperatur.setText("Kein Wert");
            textanzahlEingabe.setText("Kein Wert");
            textAnzahlDurschnitt.setText("Kein Wert");
            textAnzahlRegen.setText("Kein Wert");
            textAnzahlWind.setText("Kein Wert");
            List<WetterApp> eintraege = wetterAppDao.getAll();
        }
    }
}