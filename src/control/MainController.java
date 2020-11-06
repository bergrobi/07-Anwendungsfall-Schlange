package control;

import model.Queue;
import model.Tray;

/**
 * Created by Jean-Pierre on 27.10.2016.
 */
public class MainController {

    private Queue<Tray> trayQueue; //TODO: 02 - Sobald die Queue implementiert ist, wird der Controller um die Datenstruktur erweitert. D.h. aus einer Referenz auf ein einzelnes Objekt, wird eine Refernz auf ein Objekt der Klasse Queue zur Verwaltung von vielen Tray-Objekten.

    /**
     * Ich bin kein Konstrkutor. Ich steh' hier nur so rum!
     */
    public MainController() {
        //Hier muss später eine Initialisierung der Queue stattfinden.
        trayQueue = new Queue<Tray>();
    }

    /**
     * Sobald die Datenstruktur Queue fertig ist, dient diese Methode der darstellerischen Ausgabe der Queue.
     * @return String-Array zu den Informationen, die in der Queue gespeichert sind.
     */
    public String[] showAllTrays() {
        //TODO: 06 - Bei einer Queue ist es unüblich, auf alle Daten innerhalb der Queue zuzugreifen. Gerade das ist hier aber nötig! Hier muss mit einem "Trick" gearbeitet werden, ohne die Klasse Queue zu überarbeiten.
        int size = getSize(trayQueue);
        String[] output = new String[size];

        if (!trayQueue.isEmpty()){
            Queue help = new Queue();
            for (int i = 0; i < size; i++) {
                output[i] = trayQueue.front().getTimeAndInfo();
                help.enequeue(trayQueue.front());
                trayQueue.dequeue();
            }

            trayQueue = help;
        } else {
            output = new  String[1];
            output[0] = "Nüx da! :O";
        }
        return output;
    }

    /**
     * Ein neues Tray-Objekt wird erstellt und der Queue hinzugefügt.
     *
     * @return Informationen zum Objekt.
     */
    public String addNewTray() {
        //TODO: 03 - Hinzufügen von Objekten in die Schlange. Aktuell wird nur die einzelne Referenz neu gesetzt.
        Tray newT = new Tray();
        trayQueue.enequeue(newT);
        return newT.getTimeAndInfo();
    }

    /**
     * Das vorderste Tray-Objekt wird aus der Schlange entfernt.
     *
     * @return Informationen zum Objekt.
     */
    public String releaseTray() {
        //TODO: 05 - Das vorderste Tray-Objekt wird entfernt.
        if (!trayQueue.isEmpty()) {
            String output = trayQueue.front().getTimeAndInfo();
            trayQueue.dequeue();
            return output;
        }
        return "---";
    }

    /**
     * Es wird nur die Speicherinformation des ersten Tray-Objekts aus der Queue dargestellt. Das Objekt wird dabei nicht entfernt.
     * Die Queue bleibt also unberührt.
     *
     * @return Informationen zum vordersten Objekt.
     */
    public String getInfoOfFirst() {
        //TODO: 04 - Ausgabe der Informationen zum vordersten Objekt.
        if (!trayQueue.isEmpty()) {
            return trayQueue.front().toString();
        }
        return "---";
    }

    private int getSize(Queue queue) {
        //Hilfsvariable zum zöhlen und später ausgeben
        int size = 0;

        //Hilfs-Queue
        Queue help = new Queue();

        //Solange Queue nicht leer ist...
        while (!queue.isEmpty()) {
            //Füge voderstes Objekt von queue in help ein
            help.enequeue(queue.front());
            //Entferne das vorderste Objekt aus queue
            queue.dequeue();
            //Zähle um 1 hoch
            size++;
        }

        //Solange help nicht leer ist, kopiere zurück!
        while (!help.isEmpty()) {
            //Füge voderstes Objekt von help in queue ein
            queue.enequeue(help.front());
            //Entferne das vorderste Objekt aus help
            help.dequeue();
            //Zähle um 1 hoch
            size++;
        }

        return size;
    }
}
