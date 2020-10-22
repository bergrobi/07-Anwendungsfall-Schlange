package view;

import control.MainController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jean-Pierre on 27.10.2016.
 */
public class MainPanelHandler {
    private JPanel panel;
    private JButton releaseButton;
    private JButton addNewButton;
    private JList completeQueue;
    private JTextArea outputArea;
    private JButton infoOfFirstButton;
    private MainController controller;

    public MainPanelHandler(MainController controller) {
        createButtons();
        this.controller = controller;

    }

    private void createButtons(){
        addNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTextToOutput("Neu :" + controller.addNewTray());
                update();
            }
        });
        releaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTextToOutput("Entfernt: " + controller.releaseTray());
                update();
            }
        });
        infoOfFirstButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTextToOutput("Info: " + controller.getInfoOfFirst());
            }
        });
    }

    private void update(){
        DefaultListModel listModel = new DefaultListModel();

        String[] output = controller.showAllTrays();
        for(int i = 0; i < output.length; i++){
            String outputText = output[i];
            listModel.addElement(outputText);
        }

        completeQueue.setModel(listModel);
    }

    private void addTextToOutput(String textToAdd){
        outputArea.setText(outputArea.getText() + "\n" + textToAdd);
    }

    public JPanel getPanel(){
        return panel;
    }
}
