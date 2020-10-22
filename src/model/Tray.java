package model;

import java.sql.Timestamp;

/**
 * Created by Jean-Pierre on 27.10.2016.
 */
public class Tray {

    private Timestamp time;

    public Tray(){
        time = new Timestamp(System.currentTimeMillis());
    }

    /** Gibt einen Zeitstempel, zu dem das Objekt erstellt wurde, sowie den Speicherort des Objekts zurück.
     *
     * @return Zeitstempel - Klasse@Speicherort
     */
    public String getTimeAndInfo(){
        return time.toString()+" - "+this.toString();
    }
}
