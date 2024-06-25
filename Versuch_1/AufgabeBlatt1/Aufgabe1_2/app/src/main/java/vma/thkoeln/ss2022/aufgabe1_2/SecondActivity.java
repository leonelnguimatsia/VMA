package vma.thkoeln.ss2022.aufgabe1_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    Button switchButtonZurück;
    EditText switchButtonEditFeld;
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        switchButtonZurück = (Button) findViewById(R.id.buttonZurück);

        switchButtonEditFeld = (EditText)  findViewById(R.id.editFeld);

        switchButtonZurück.setOnClickListener(new SwitchButtonZurückListener());
    }

    public void onDestroy(){

        super.onDestroy();
        Toast.makeText(this,"Activity2: onDestroy()", Toast.LENGTH_LONG).show();
        Log.v("Aufgabe1_2","---> activity2: onDestroy() <---");
    }

    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        text = savedInstanceState.getString("Text");
        switchButtonEditFeld.setText(text);
        Toast.makeText(this,"Activity2: onSaveInstanceState()", Toast.LENGTH_LONG).show();
        Log.v("aufgabe1_2","---> activity2: onSaveInstanceState() <--- ");
    }
}

class SwitchButtonZurückListener implements View.OnClickListener{


    @Override
    public void onClick(View view) {

        Log.v("Aufgabe1_2","---> activity2: Click on ButonZurück<---");
        Intent myIntent = new Intent(view.getContext(), MainActivity.class);
        view.getContext().startActivity(myIntent);
    }
}