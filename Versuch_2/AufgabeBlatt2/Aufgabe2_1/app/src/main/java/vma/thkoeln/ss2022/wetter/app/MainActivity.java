package vma.thkoeln.ss2022.wetter.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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



    @Override
    public void onCreate(Bundle savedInstanceState) {
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
    }

    public class ButtonÜbernehmenListener implements View.OnClickListener {


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
        }
    }
}