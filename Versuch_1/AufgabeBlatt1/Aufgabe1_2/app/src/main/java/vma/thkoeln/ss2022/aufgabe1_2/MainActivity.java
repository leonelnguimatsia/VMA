package vma.thkoeln.ss2022.aufgabe1_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

      Button switchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchButton = (Button) findViewById(R.id.buttonGehe_Zu);

        switchButton.setOnClickListener(new SwitchButtonListener());

    }

    public void onDestroy(){

        super.onDestroy();
        Toast.makeText(this,"Activity1: onDestroy()", Toast.LENGTH_LONG).show();
        Log.v("Aufgabe1_2","---> activity1: onDestroy() <---");
    }
}

class SwitchButtonListener implements View.OnClickListener{


    @Override
    public void onClick(View view) {

        Log.v("Aufgabe1_2","---> activity1: Click on ButonGehe_Zu<---");
        Intent myIntent = new Intent(view.getContext(), SecondActivity.class);
        view.getContext().startActivity(myIntent);
    }
}
