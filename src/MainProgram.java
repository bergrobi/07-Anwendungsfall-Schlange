import control.MainController;
import view.MainView;

/**
 * Created by Jean-Pierre on 27.10.2016.
 */
public class MainProgram {
    public static void main(String[] args) {
        MainView view = new MainView(new MainController());
    }
}
