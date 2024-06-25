package vma.thkoeln.ss2022.info.intentauswahl;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/*
Wenn ich das dritte Item auswähle gibt er mir eine auswahl an Apps welche ich benutzen kann.
 */

public class MainActivity extends AppCompatActivity {

    ListView myListView;
    Intent sendIntent;
    static final String ACTION_MYACTION ="vma.thkoeln.ss2022.android.intents.AUFG32";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myListView = findViewById(R.id.listview);
        String[]mobileArray = {"AUFG31","AUFG32","BLATT3"};
        final ArrayAdapter<String>adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,android.R.id.text1,mobileArray);
        myListView.setAdapter(adapter);

        sendIntent = new Intent();

        //myListView.setOnItemClickListener(new MyadapterView());

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                switch (position){

                    case 0:
                        sendIntent = new Intent("vma.thkoeln.ss2022.android.intents.AUFG31");
                        break;

                    case 1:
                        sendIntent = new Intent("vma.thkoeln.ss2022.android.intents.AUFG32");
                        break;

                    case 2:
                        sendIntent = new Intent("vma.thkoeln.ss2022.android.intents.BLATT3");
                        break;
                }

                if (sendIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(sendIntent);
                }

            }
        });
    }
}

