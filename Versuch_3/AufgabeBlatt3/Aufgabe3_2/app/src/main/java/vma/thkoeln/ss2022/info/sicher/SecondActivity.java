package vma.thkoeln.ss2022.info.sicher;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    Button switchButtonZurück;
    EditText switchButtonEditfeld;
    String text;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor myedit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        switchButtonZurück = (Button) findViewById(R.id.buttonZurück);
        switchButtonEditfeld = findViewById(R.id.editFeld);
        switchButtonZurück.setOnClickListener(new SwitchButtonZurückListener());
        sharedPreferences = getSharedPreferences("MysharedPref",MODE_PRIVATE);
        myedit = sharedPreferences.edit();
        text = sharedPreferences.getString("text","");

        if(savedInstanceState != null)
            text = savedInstanceState.getString("Text");
        switchButtonEditfeld.setText(text);

    }

    public void onDestroy() {
        super.onDestroy();
        myedit.putString("text",String.valueOf(switchButtonEditfeld.getText()));
        myedit.commit();
        Toast.makeText(this,"Activity2: onDestroy()", Toast.LENGTH_LONG).show();
        Log.v("DEMO","      ---> Activity2: onDestroy() <--- ");
    }

    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("Text",text);
        //text = savedInstanceState.getString("Text");
        myedit.putString("text",String.valueOf(switchButtonEditfeld.getText()));
        myedit.commit();
        Toast.makeText(this,"Activity2: onSaveInstanceState()", Toast.LENGTH_LONG).show();
        Log.v("DEMO","---> Activity2 onSaveInstanceState() <--- ");
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