package control;

import model.Tray;

/**
 * Created by Jean-Pierre on 27.10.2016.
 */
public class MainController {

    private Tray myOnlyTray; //TODO: 02 - Sobald die Queue implementiert ist, wird der Controller um die Datenstruktur erweitert. D.h. aus einer Referenz auf ein einzelnes Objekt, wird eine Refernz auf ein Objekt der Klasse Queue zur Verwaltung von vielen Tray-Objekten.

    /**
     * Ich bin kein Konstrkutor. Ich steh' hier nur so rum!
     */
    public MainController(){
        //Hier muss später eine Initialisierung der Queue stattfinden.
    }

    /**
     * Sobald die Datenstruktur Queue fertig ist, dient diese Methode der darstellerischen Ausgabe der Queue.
     * @return String-Array zu den Informationen, die in der Queue gespeichert sind.
     */
    public String[] showAllTrays(){
        //TODO: 06 - Bei einer Queue ist es unüblich, auf alle Daten innerhalb der Queue zuzugreifen. Gerade das ist hier aber nötig! Hier muss mit einem "Trick" gearbeitet werden, ohne die Klasse Queue zu überarbeiten.
        String[] output = new String[1];
        if(myOnlyTray != null){
            output[0] = myOnlyTray.getTimeAndInfo();
        }else{
            output[0] = "Nüx da! :O";
        }
        return output;
    }

    /**
     * Ein neues Tray-Objekt wird erstellt und der Queue hinzugefügt.
     * @return Informationen zum Objekt.
     */
    public String addNewTray(){
        //TODO: 03 - Hinzufügen von Objekten in die Schlange. Aktuell wird nur die einzelne Referenz neu gesetzt.
        myOnlyTray = new Tray();
        return myOnlyTray.getTimeAndInfo();
    }

    /**
     * Das vorderste Tray-Objekt wird aus der Schlange entfernt.
     * @return Informationen zum Objekt.
     */
    public String releaseTray(){
        //TODO: 05 - Das vorderste Tray-Objekt wird entfernt.
        if(myOnlyTray != null){
            String output = myOnlyTray.getTimeAndInfo();
            myOnlyTray = null;
            return output;
        }
        return "---";
    }

    /**
     * Es wird nur die Speicherinformation des ersten Tray-Objekts aus der Queue dargestellt. Das Objekt wird dabei nicht entfernt.
     * Die Queue bleibt also unberührt.
     * @return Informationen zum vordersten Objekt.
     */
    public String getInfoOfFirst(){
        //TODO: 04 - Ausgabe der Informationen zum vordersten Objekt.
        if(myOnlyTray != null) return myOnlyTray.toString();
        return "---";
    }
}
