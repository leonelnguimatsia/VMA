package vma.thkoeln.ss2022.wetter.app.plus;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

public class Zeigealleregentage extends AppCompatActivity {

    List<WetterApp> wetterAppList;
    ListView listViewRegentage;
    WetterAppDatabase wetterAppDatabase;
    WetterAppDao wetterAppDao;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zeigealleregentage);
        setTitle("Zeigt alle Werte der Regentage");
        listViewRegentage = findViewById(R.id.liste_zeigealleregentage);
        wetterAppDatabase = Room.databaseBuilder(getApplicationContext(),WetterAppDatabase.class,"mein-wetterApp").allowMainThreadQueries().build();
        wetterAppDao = wetterAppDatabase.wetterAppDao();
        wetterAppList = wetterAppDao.loadAllByRegen(true);

        // SharedPreferences sharedPreferences = getSharedPreferences("MysharedPref",MODE_PRIVATE);
        // String s1 = sharedPreferences.getString("wetter","");

        List<String> testList = new ArrayList<>();
        for(WetterApp wetterApp: wetterAppList){

            String str1 = "Time: ";
            str1 += String.valueOf(wetterApp.timestamp);
            str1 += " ,Temp: ";
            str1 += String.valueOf(wetterApp.temperature);
            str1 += " ,Regen: ";
            str1 += String.valueOf(wetterApp.regen);
            str1 += " ,Wind: ";
            str1 += String.valueOf(wetterApp.wind);

            testList.add(str1);
        }

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(Zeigealleregentage.this,
                android.R.layout.simple_list_item_1, android.R.id.text1,testList);
        listViewRegentage.setAdapter(adapter);
    }
}
