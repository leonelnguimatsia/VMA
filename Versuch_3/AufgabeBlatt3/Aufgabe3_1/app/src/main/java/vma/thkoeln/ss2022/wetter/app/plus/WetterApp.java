package vma.thkoeln.ss2022.wetter.app.plus;

// Programmierung verteilter und mobiler Anwendungen
// Prof. Dr. Carsten Vogt
// Technische Hochschule Köln
// Fakultät für Informations-, Medien- und Elektrotechnik
// Stand: 11.3.2021

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

// Entity-Klasse
//
// Definiert die Form der Entities und damit eine Tabelle:
// Ein Entity-Objekt entspricht einer Zeile der Tabelle.

@Entity
public class WetterApp {

    @PrimaryKey
    public int id;

    @ColumnInfo(name = "Zeitstempel")
    public long timestamp;

    @ColumnInfo(name = "TemperaturWert")
    public double temperature;

    @ColumnInfo(name = "Regen")
    public boolean regen;

    @ColumnInfo(name = "Wind")
    public boolean wind;

    WetterApp(int _id, long _timestamp, double _temp, boolean regen, boolean wind) {
        this.id = _id;
        this.timestamp = _timestamp;
        this.temperature =_temp;
        this.regen = regen;
        this.wind = wind;

    }
    WetterApp(){

    }
}
