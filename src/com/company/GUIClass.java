package com.company;

import javax.swing.*;
import java.awt.ActiveEvent.*;
import java.awt.Event.*;
import java.awt.*;
/**
 * Created by srv3 on 27.01.2016.
 */
public class GUIClass
{
    JFrame mainFrame;
    JPanel textPanel;
    JPanel GUIPanel;
    JPanel charPanel;
    JPanel managePanel;
    JTextArea mainText;
    JButton nextButton;


    public GUIClass ()
    {
       mainFrame = new JFrame("Тайна капитана Шелтона");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textPanel = new JPanel();
        GUIPanel = new JPanel();
        charPanel = new JPanel();
        managePanel = new JPanel();
        nextButton = new JButton("Далее");

        mainText = new JTextArea();




        mainFrame.getContentPane().add(BorderLayout.CENTER, textPanel);
        mainFrame.getContentPane().add(BorderLayout.NORTH, GUIPanel);
        mainFrame.getContentPane().add(BorderLayout.EAST, charPanel);
        mainFrame.getContentPane().add(BorderLayout.SOUTH, textPanel);

        managePanel.add(nextButton);
        textPanel.add(mainText);







        mainFrame.add(textPanel);
       mainFrame.add(GUIPanel);
       mainFrame.add(charPanel);
       mainFrame.add(managePanel);



        mainFrame.setSize(1024, 1280);
        mainFrame.setVisible(true);


    }







}
