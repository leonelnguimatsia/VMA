package vma.thkoeln.ss2022.wetter.app.plus;

// Prof. Dr. Carsten Vogt
// Technische Hochschule Köln
// Fakultät für Informations-, Medien- und Elektrotechnik
// Stand: 11.3.2021

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

// DAO-Interface (DAO = Data Access Object)
//
// Interface für Data Access Objects (DAOs) mit Köpfen von Methoden zum Zugriff auf die Datenbank.
// Eine Klasse, die dieses Interface implementiert und damit Datenbank-Zugriffe ermöglicht, wird automatisch generiert.

@Dao
public interface WetterAppDao {

    // Für eine Abfrage-Methode muss man nur den Kopf mit dem entsprechenden SELECT-Befehl als Annotation hinschreiben.
    // Der zugehörige Methodenkörper mit dem Datenbank-Zugriff wird automatisch generiert.
    // Dabei wird insbesondere auch die Syntax des SELECT-Befehls geprüft.

    @Query("SELECT * FROM WetterApp")
    List<vma.thkoeln.ss2022.wetter.app.plus.WetterApp> getAll();

    @Query("SELECT * FROM WetterApp WHERE Regen LIKE :test")
    List<vma.thkoeln.ss2022.wetter.app.plus.WetterApp> loadAllByRegen(boolean test);



    // Für Insert- und Delete-Methoden genügen entsprechende Annotationen mit jeweils einem einfachen Schlüsselwort.
    // Auch ihre Körper werden automatisch generiert.

    @Insert
    void insertAll(vma.thkoeln.ss2022.wetter.app.plus.WetterApp... entries);

    @Delete
    void delete(vma.thkoeln.ss2022.wetter.app.plus.WetterApp entry);
}
