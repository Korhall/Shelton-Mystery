package com.korhall.objects;

import javax.swing.*;
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
    JTextField textFieldNextPoint;


    public GUIClass ()
    {
        mainFrame = new JFrame("Тайна капитана Шелтона");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


//        блок инициализации графических компонентов
        textPanel = new JPanel();
        GUIPanel = new JPanel();
        charPanel = new JPanel();
        managePanel = new JPanel();
        nextButton = new JButton("Далее");
        mainText = new JTextArea();
        textFieldNextPoint = new JTextField();



// блок задания размеров элементов

        mainFrame.setSize(1024, 1280);
        textFieldNextPoint.setSize(100, 20); // не работает надо выяснить, почему


        // добавление элементов к панелям
        managePanel.add(textFieldNextPoint, FlowLayout.LEFT);



        managePanel.add(nextButton);
        textPanel.add(mainText);



       mainFrame.add(textPanel);
       mainFrame.add(GUIPanel);
       mainFrame.add(charPanel);
       mainFrame.add(managePanel);

        //      блок настройки раскладки

        mainFrame.getContentPane().add(BorderLayout.CENTER, textPanel);
        mainFrame.getContentPane().add(BorderLayout.NORTH, GUIPanel);
        mainFrame.getContentPane().add(BorderLayout.EAST, charPanel);
        mainFrame.getContentPane().add(BorderLayout.SOUTH, managePanel);



        mainFrame.setVisible(true);


    }







}
