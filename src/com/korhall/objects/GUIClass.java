package com.korhall.objects;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*import org.pushingpixels.substance.api.*;
import org.pushingpixels.substance.api.skin.*;*/

/**
 * Created by srv3 on 27.01.2016.
 */
public class GUIClass
{
    JFrame mainFrame;

    JTextArea mainText;
    JButton nextButton;
    JButton buttonAbout;
    JButton buttonSaveCurrentProgress;
    JButton buttonNewGame;

    JTextField textFieldNextPoint;

    JLabel labelPointNumber;
    JLabel labelCharacterAttack;
    JLabel labelCharacterHealth;


    GameText gameText;

    Box menuBox;
    Box characterBox;
    Box textBox;
    Box manageBox;




// listener ��� ������ �������� � ���������� ��������� ������. �������� ���������� ���������� ���� � ��������� ��� � Int
// ����� ���� int ������������ � �������� ������� ��� ������� � ������� �����.
    public class NextPoint implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int i = Integer.parseInt(textFieldNextPoint.getText());
            mainText.setText((String) gameText.gameTextet[i]);

        }
    }

    public class AboutThisProgramm implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    public class NewGame implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            mainText.setText(gameText.gameTextet[0]);
        }
    }





    public GUIClass ()
    {
      /*  SubstanceLookAndFeel laf = new SubstanceGeminiLookAndFeel();
        UIManager.setLookAndFeel(laf);*/

        JFrame.setDefaultLookAndFeelDecorated(true); // �������� ������� ��� ������. �������� ��� ������ � �����.
        JDialog.setDefaultLookAndFeelDecorated(true);



        gameText=new GameText();
        mainFrame = new JFrame("����� �������� �������");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon iconNextButton = new ImageIcon("Symbol_Forward_2.gif");

        nextButton = new JButton("�����", iconNextButton);
 //       nextButton.setPreferredSize(new Dimension(30, 100));
//        nextButton.setSize(60, 40);
        nextButton.addActionListener(new NextPoint());
        buttonAbout = new JButton("� ���������");
        buttonSaveCurrentProgress = new JButton("���������");
        buttonNewGame = new JButton("����� ����");
        buttonNewGame.addActionListener(new NewGame());


        mainText = new JTextArea();
        mainText.setEditable(false);
        mainText.setFont(new Font("Raster Fonts", Font.TRUETYPE_FONT, 16));
        mainText.setWrapStyleWord(true);
        mainText.setAutoscrolls(true);
        mainText.setText(gameText.gameTextet[0]);
        mainText.setLineWrap(true);

        textFieldNextPoint = new JTextField(50);

        labelPointNumber = new JLabel();
        labelPointNumber.setText("������� ����� ���������: ");
        labelCharacterAttack = new JLabel();
        labelCharacterAttack.setText("�����:");
        labelCharacterHealth = new JLabel();
        labelCharacterHealth.setText("��������: ");



//      �������� Box-��
        menuBox = Box.createHorizontalBox();
        menuBox.setBorder(new TitledBorder("����"));

        characterBox = Box.createHorizontalBox();
        characterBox.setBorder(new TitledBorder("��������"));

        textBox = Box.createHorizontalBox();
        textBox.setBorder(new TitledBorder("����� �������� �������"));

        manageBox = Box.createHorizontalBox();
        //        manageBox.setBorder(new TitledBorder(""));


        mainFrame.setSize(1024, 1280);
        textFieldNextPoint.setBackground(Color.LIGHT_GRAY);
        textFieldNextPoint.setMaximumSize(new Dimension(60, 40));





        manageBox.add(Box.createHorizontalStrut(10));
        manageBox.add(labelPointNumber);

        manageBox.add(Box.createHorizontalStrut(10));
        manageBox.add(textFieldNextPoint);

        manageBox.add(Box.createHorizontalStrut(10));
        manageBox.add(nextButton);
        manageBox.add(Box.createHorizontalStrut(10));

        characterBox.add(Box.createHorizontalStrut(10));
        characterBox.add(labelCharacterHealth);
        characterBox.add(Box.createHorizontalStrut(10));
//        characterBox.add(Box.createVerticalStrut(10));
        characterBox.add(labelCharacterAttack);
        characterBox.add(Box.createHorizontalStrut(10));

        textBox.add(mainText);

        menuBox.add(Box.createHorizontalStrut(10));
        menuBox.add(buttonNewGame);
        menuBox.add(Box.createHorizontalStrut(10));
        menuBox.add(buttonSaveCurrentProgress);
        menuBox.add(Box.createHorizontalStrut(10));
        menuBox.add(buttonAbout);



        //      ���� ��������� ���������
        mainFrame.getContentPane().add(BorderLayout.EAST, characterBox);
        mainFrame.getContentPane().add(BorderLayout.CENTER, textBox);
        mainFrame.getContentPane().add(BorderLayout.NORTH, menuBox);
        mainFrame.getContentPane().add(BorderLayout.SOUTH, manageBox);

        mainFrame.setVisible(true);


    }







}
