package view;

import control.MainController;

import javax.swing.*;

/**
 * Created by Jean-Pierre on 27.10.2016.
 */
public class MainView extends JFrame {

    public MainView(MainController controller){
        this.setBounds(100,100,640,480);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.setContentPane(new MainPanelHandler(controller).getPanel());

        this.setVisible(true);
    }
}
