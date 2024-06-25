package vma.thkoeln.ss2022.wetter.app.plus;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Readfile extends AppCompatActivity {

    ListView listViewReadFile;
    String testReadFile;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_readfile);
        listViewReadFile = findViewById(R.id.liste_zeigeallefile);
        String dateinameInterns = "internetxt.txt";
        FileInputStream fis = null;
        BufferedReader bufferedReader= null;
        try{

            fis = Readfile.this.openFileInput(dateinameInterns);
            bufferedReader = new BufferedReader(new InputStreamReader(fis));

        }catch (Exception e){

            Toast.makeText(Readfile.this, "Fehler beim Öffnen: "+e.getClass(), Toast.LENGTH_SHORT).show();
            Log.v("DEMO",">>>> Fehler beim Öffnen: "+e.getClass());

        }
        try {

            String eingabe = bufferedReader.readLine();
            testReadFile = eingabe;
            Toast.makeText(Readfile.this, "Gelesen: "+eingabe, Toast.LENGTH_SHORT).show();
            Log.v("DEMO",">>>>Gelesen: "+eingabe);

        }catch(Exception e){

            Toast.makeText(Readfile.this,"Fehler beim Lesen: "+e.getClass(), Toast.LENGTH_LONG).show();
            Log.v("DEMO",">>>>Fehler beim Lesen: "+e.getClass());

        }
        try {

            bufferedReader.close();
            fis.close();

        }catch(Exception e){

            Toast.makeText(Readfile.this, "Fehler beim Schließen: "+e.getClass(), Toast.LENGTH_SHORT).show();
            Log.v("DEMO",">>>> Fehler beim Schließen: "+e.getClass());

        }

        Gson gson = new Gson();
        Type type = new TypeToken<List<WetterApp>>(){}.getType();
        ArrayList<WetterApp> wetterAppArrayList = gson.fromJson(testReadFile,type);
        List<String> testList = new ArrayList<>();
        for(WetterApp wetterApp: wetterAppArrayList){

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

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(Readfile.this,
                android.R.layout.simple_list_item_1, android.R.id.text1,testList);
        listViewReadFile.setAdapter(adapter);
    }
}
