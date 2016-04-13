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
        mainFrame = new JFrame("����� �������� �������");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


//        ���� ������������� ����������� �����������
        textPanel = new JPanel();
        GUIPanel = new JPanel();
        charPanel = new JPanel();
        managePanel = new JPanel();
        nextButton = new JButton("�����");
        mainText = new JTextArea();
        textFieldNextPoint = new JTextField();



// ���� ������� �������� ���������

        mainFrame.setSize(1024, 1280);
        textFieldNextPoint.setSize(100, 20); // �� �������� ���� ��������, ������


        // ���������� ��������� � �������
        managePanel.add(textFieldNextPoint, FlowLayout.LEFT);



        managePanel.add(nextButton);
        textPanel.add(mainText);



       mainFrame.add(textPanel);
       mainFrame.add(GUIPanel);
       mainFrame.add(charPanel);
       mainFrame.add(managePanel);

        //      ���� ��������� ���������

        mainFrame.getContentPane().add(BorderLayout.CENTER, textPanel);
        mainFrame.getContentPane().add(BorderLayout.NORTH, GUIPanel);
        mainFrame.getContentPane().add(BorderLayout.EAST, charPanel);
        mainFrame.getContentPane().add(BorderLayout.SOUTH, managePanel);



        mainFrame.setVisible(true);


    }







}
