package vma.thkoeln.ss2022.wetter.app.plus;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.google.gson.Gson;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;

public class Meineliste extends AppCompatActivity {

    public List<WetterApp> wetterAppList;
    ListView listView;
    TextView textViewList;
    WetterAppDao wetterAppDao;
    WetterAppDatabase wetterAppDatabase;
    String testList ="";

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meineliste);
        String[] mobileArray = {"Anzeige aller Eintraege in der Datenbank",
                "Anzeige nur der Entraege für Regentage",
                "Export aller Datenbankeintraege in eine Textdatei",
                "Anzeige des Inhalts der TextDatei"};

        listView = (ListView) findViewById(R.id.mobile_liste);
        textViewList = (TextView) findViewById(R.id.textview_myList);
        wetterAppDatabase = Room.databaseBuilder(getApplicationContext(),WetterAppDatabase.class,"mein-wetterApp").allowMainThreadQueries().build();
        wetterAppDao = wetterAppDatabase.wetterAppDao();
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,android.R.id.text1,mobileArray);
        listView.setAdapter(adapter);
        Gson gson = new Gson();

        listView.setOnItemClickListener(new MyadapterView());
    }

    public class MyadapterView implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

            switch (position){

                case 0:
                    Intent intent = new Intent(Meineliste.this, Zeigeallewerte.class);
                    startActivity(intent);
                    break;

                case 1:
                    //List<WetterApp> wetterAppList1 = wetterAppDao.loadAllByRegen(true);
                    Intent intent1 = new Intent(Meineliste.this, Zeigealleregentage.class);
                    //Gson gson1 = new Gson();
                    //String json1 = gson1.toJson(wetterAppList1);
                    //myedit.putString("wetterApp",json1);
                    //myedit.commit();
                    startActivity(intent1);
                    break;

                case 2:
                    String dateinameIntern = "internetxt.txt";
                    Toast.makeText(getApplicationContext(),"Schreiben nach "+dateinameIntern+" (internes Haupt-dir der App)", Toast.LENGTH_LONG).show();
                    FileOutputStream fos = null;
                    PrintWriter printwriter = null;

                    try{

                        fos = Meineliste.this.openFileOutput(dateinameIntern,0);
                        printwriter = new PrintWriter(fos);

                    } catch (Exception e) {
                        Toast.makeText(Meineliste.this,"Fehler beim öffnen: "+e.getClass(), Toast.LENGTH_LONG).show();
                        Log.v("DEMO",">>>>Fehler beim Öffnen: "+e.getClass());
                    }

                    try {
                        wetterAppList = wetterAppDao.getAll();
                        Gson gson2 = new Gson();
                        String json2 = gson2.toJson(wetterAppList);
                        printwriter.println(json2);
                        Toast.makeText(Meineliste.this,"Schreiben beginnt nach "+dateinameIntern+" geschrieben", Toast.LENGTH_LONG).show();
                        Log.v("DEMO", ">>>> Schreiben beginnt nach "+dateinameIntern+" geschrieben");

                    } catch (Exception e){

                        Toast.makeText(Meineliste.this,"Fehler beim Schreiben: "+e.getClass(), Toast.LENGTH_LONG).show();
                        Log.v("DEMO",">>>> Fehler beim Schreiben: "+e.getClass());
                    }

                    try{

                        printwriter.close();
                        fos.close();
                    } catch (Exception e){

                        Toast.makeText(Meineliste.this,"Fehler beim Schließen: "+e.getClass(), Toast.LENGTH_LONG).show();
                        Log.v("DEMO",">>>> Fehler beim Schließen: "+e.getClass());
                    }
                    break;

                case 3:
                    Intent intent2 = new Intent(Meineliste.this, Readfile.class);
                    startActivity(intent2);
            }
        }
    }

    public List<WetterApp> getWetterAppList(){

        return wetterAppList;
    }

}
