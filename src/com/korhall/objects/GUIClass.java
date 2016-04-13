package com.korhall.objects;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    JLabel labelPointNumber;
    JLabel labelMainText;
    GameText gameText;





    public class NextPoint implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {
//            labelMainText.setText((String) gameText.gameTextet[0]);
            mainText.setText((String) gameText.gameTextet[0]);
        }
    }


    public GUIClass ()
    {
        JFrame.setDefaultLookAndFeelDecorated(true); // �������� ������� ��� ������. �������� ��� ������ � �����.

        gameText=new GameText();
        mainFrame = new JFrame("����� �������� �������");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


//        ���� ������������� ����������� �����������
        textPanel = new JPanel();
        GUIPanel = new JPanel();
        charPanel = new JPanel();
        managePanel = new JPanel();

        ImageIcon iconNextButton = new ImageIcon("Symbol Forward 2.gif");
        nextButton = new JButton("�����", iconNextButton);
        mainText = new JTextArea();
        textFieldNextPoint = new JTextField(50);
        labelPointNumber = new JLabel();
        labelMainText = new JLabel();


        mainText.setEditable(false);


        Box menuBox = Box.createVerticalBox();
        menuBox.setBorder(new TitledBorder("����"));

        Box characterBox = Box.createVerticalBox();
        characterBox.setBorder(new TitledBorder("��������"));

        Box textBox = Box.createHorizontalBox();
        textBox.setBorder(new TitledBorder("����� �������� �������"));
//        textBox.setBackground(Color.white);


        Box manageBox = Box.createHorizontalBox();
        //        manageBox.setBorder(new TitledBorder(""));


// ���� ������� �������� ���������

        mainFrame.setSize(1024, 1280);
//        mainFrame.setBackground(Color.white);
        textFieldNextPoint.setBackground(Color.LIGHT_GRAY);
        textFieldNextPoint.setMaximumSize(new Dimension(60, 40));
        nextButton.setSize(60, 40);

        labelPointNumber.setText("������� ����� ���������: ");

        nextButton.addActionListener(new NextPoint());


        // ���������� ��������� � �������
        /*managePanel.setLayout(new BoxLayout(managePanel, BoxLayout.X_AXIS));
        managePanel.add(labelPointNumber);
        managePanel.add(textFieldNextPoint);
        managePanel.add(nextButton);
        */

        manageBox.add(Box.createHorizontalStrut(10));
        manageBox.add(labelPointNumber);
        manageBox.add(Box.createHorizontalStrut(10));
        manageBox.add(textFieldNextPoint);
        manageBox.add(Box.createHorizontalStrut(10));
        manageBox.add(nextButton);
       // textBox.add(labelMainText);
       textBox.add(mainText);




        textPanel.add(mainText);



       mainFrame.add(textPanel);
       mainFrame.add(GUIPanel);
       mainFrame.add(charPanel);
       mainFrame.add(managePanel);

        //      ���� ��������� ���������

//        mainFrame.getContentPane().add(BorderLayout.CENTER, textPanel);
//        mainFrame.getContentPane().add(BorderLayout.EAST, charPanel);
//        mainFrame.getContentPane().add(BorderLayout.SOUTH, managePanel);
        mainFrame.getContentPane().add(BorderLayout.EAST, characterBox);
        mainFrame.getContentPane().add(BorderLayout.CENTER, textBox);

//        mainFrame.getContentPane().add(BorderLayout.NORTH, GUIPanel);
          mainFrame.getContentPane().add(BorderLayout.NORTH, menuBox);

        mainFrame.getContentPane().add(BorderLayout.SOUTH, manageBox);



        mainFrame.setVisible(true);


    }







}
