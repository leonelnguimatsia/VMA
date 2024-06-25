package vma.thkoeln.ss2022.begrung_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private  Toolbar toolbar;

    boolean isDuzen, isSiezen;
    TextView textBegruess;
    EditText vorname, nachname;
    MenuItem itemDuzen, itemSiezen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Begrüßung");
        toolbar = findViewById(R.id.my_toolbar);
        textBegruess = findViewById(R.id.textbegruess);
        vorname = findViewById(R.id.edittextVorname);
        nachname = findViewById(R.id.edittextNachname);
        itemDuzen = findViewById(R.id.id_duzen);
        itemSiezen = findViewById(R.id.id_sizen);
        registerForContextMenu(textBegruess);

        setSupportActionBar(toolbar);   //display of tolbar on the layout
        getSupportActionBar().setDisplayShowHomeEnabled(true);    //enable the Image or icon on the Icon Bar
        getSupportActionBar().setIcon(R.drawable.icon_title);     //display the Image on the Toolbar


    }

    //Erzeugen der KontextMenu

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Wähle eine Tageszeit");
        menu.add(0,v.getId(),0,"Morgens");
        menu.add(0,v.getId(),0,"Mittags");
        menu.add(0,v.getId(),0,"Abends");
    }

    //Auswahlmöglichkeiten bei der Kontextmenu "Begrüß mich"

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        String morgen = "Guten morgen ";
        String mittags = "Guten Tag ";
        String abends = "Guten Abend ";

        if(isDuzen){

            morgen = "Moin ";
            mittags = "Hallo ";
            abends = "abend ";

        } else if(isSiezen){

            morgen ="Guten Morgen Herr/Frau ";
            mittags ="Guten Tag Herr/Frau ";
            abends = "Guten Abend Herr/Frau ";
        }



        if(!(TextUtils.isEmpty(vorname.getText().toString()) || TextUtils.isEmpty(nachname.getText().toString()))) {

            if (item.getTitle().equals("Morgens")) {

                Toast toastMorgen = Toast.makeText(MainActivity.this, morgen + vorname.getText() + " " + nachname.getText()+"!", Toast.LENGTH_LONG);
                toastMorgen.show();

            } else if (item.getTitle().equals("Mittags")) {


                Toast toastMittags = Toast.makeText(MainActivity.this, mittags + vorname.getText() + " " + nachname.getText()+"!", Toast.LENGTH_LONG);
                toastMittags.show();

            } else if (item.getTitle().equals("Abends")) {

                Toast toastAbends = Toast.makeText(MainActivity.this, abends + vorname.getText() + " " + nachname.getText()+"!", Toast.LENGTH_LONG);
                toastAbends.show();
            }

        }

        else {

            vorname.setError("Enter your Vorname und Nachname");
            nachname.setError("Enter your Vorname und Nachname");
        }

        return true;
    }


    // onCreateOptionsMenu() zeigt das Menu an, das durch res/menu/menu_alpha.xml definiert ist
    // - entweder permanent in der App Bar oder nach Betätigung der Menu-Taste.

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        Log.v("DEMO","##### Activity_main: onCreateOptionsMenu() #####");
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

                //openContextMenu(textBegruess);

            switch ((item.getItemId())) {

                case R.id.id_duzen:

                    isDuzen = true;
                    isSiezen = false;
                    break;

                case R.id.id_sizen:

                    isDuzen = false;
                    isSiezen = true;
                    break;


                default: return false;
            }

        return true;
    }
}