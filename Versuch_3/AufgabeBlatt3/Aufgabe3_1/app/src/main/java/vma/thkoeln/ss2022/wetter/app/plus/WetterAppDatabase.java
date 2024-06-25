package vma.thkoeln.ss2022.wetter.app.plus;

// Prof. Dr. Carsten Vogt
// Technische Hochschule Köln
// Fakultät für Informations-, Medien- und Elektrotechnik
// Stand: 11.3.2021

import androidx.room.Database;
import androidx.room.RoomDatabase;

// Datenbank-Klasse
//
// Definiert die Datenbank-Konfiguration.
// Ein Objekt dieser Klasse ist der Hauptzugriffspunkt für die Datenbank.
// Die Tabellenstruktur wird in der Datei Woerterbuch.java festgelegt, auf die die Annotation @Database(entities = {Woerterbuch.class} ...

@Database(entities = {vma.thkoeln.ss2022.wetter.app.plus.WetterApp.class}, version = 1)
public abstract class WetterAppDatabase extends RoomDatabase{

    public abstract vma.thkoeln.ss2022.wetter.app.plus.WetterAppDao wetterAppDao();

}
