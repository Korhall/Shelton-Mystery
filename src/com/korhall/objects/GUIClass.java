package com.korhall.objects;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/*import org.pushingpixels.substance.api.*;
import org.pushingpixels.substance.api.skin.*;*/

/**
 * Created by srv3 on 27.01.2016.
 */

/*
* ��� �������� ������� ��������� ���������� ������� arraylist � ���������
* ���� ����� ����������� ��������� ��� ������ �������� �� ������ �����
*
*
* */

public class GUIClass
{
    JFrame mainFrame;

    JTextArea mainText;
    JTextArea textAreaNotes;

    JButton nextButton;

    JButton buttonThrowDice;
    JButton buttonCharacterHealthUP;
    JButton buttonCharacterHealthDOWN;
    JButton buttonCharacterAttackUP;
    JButton buttonCharacterAttackDOWN;
    JButton buttonCharacterLuckUP;
    JButton buttonCharacterLuckDOWN;

    JTextField textFieldNextPoint;

    JLabel labelPointNumber;
    JLabel labelCharacterAttack;
    JLabel labelCharacterHealth;
    JLabel labelCurrentDiceStatus;
    JLabel labelDiceThrowResult;
    JLabel labelCharacterLuck;
    JLabel labelCharacterHealthStatus;
    JLabel labelCharacterAttackStatus;
    JLabel labelCharacterLuckStatus;
    JLabel labelAbout;
    JLabel labelSaveCurrentProgress;
    JLabel labelNewGame;


    JScrollPane scrollPaneNotes;

    GameText gameText;

    Box menuBox;
//    Box characterBox;
    Box textBox;
    Box manageBox;

    JPanel characterBox;
    GridBagConstraints characterLayout;




// listener ��� ������ �������� � ���������� ��������� ������. �������� ���������� ���������� ���� � ��������� ��� � Int
// ����� ���� int ������������ � �������� ������� ��� ������� � ������� �����.
    public class NextPoint implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int i = Integer.parseInt(textFieldNextPoint.getText());
            mainText.setText(gameText.gameTextet[i]);

        }
    }

    public class ThrowDice implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int i=0;
            while (i == 0) {
                i = (int) (Math.random() * 7);
                String str = Integer.toString(i);
                labelCurrentDiceStatus.setText(str);
            }

        }


    }

    public class AboutThisProgramm implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    public class NewGame implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            mainText.setText(gameText.gameTextet[0]);
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            labelNewGame.setFont(new Font("Raster Fonts", Font.BOLD, 14));

        }

        @Override
        public void mouseExited(MouseEvent e) {
            labelNewGame.setFont(new Font("Raster Fonts", Font.TRUETYPE_FONT, 14));

        }
    }

    public class ChangeHealthUP implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int i = Integer.valueOf(labelCharacterHealthStatus.getText());
            i++;
            labelCharacterHealthStatus.setText(String.valueOf(i));
        }
    }

    public class ChangeHealthDOWN implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int i = Integer.valueOf(labelCharacterHealthStatus.getText());
            i--;
            if (i<0)
            {
                mainText.setText(gameText.gameTextet[0]);
            }
            else {
                labelCharacterHealthStatus.setText(String.valueOf(i));
            }
        }
    }

    public class ChangeAttackUP implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int i = Integer.valueOf(labelCharacterAttackStatus.getText());
            i++;
            labelCharacterAttackStatus.setText(String.valueOf(i));
        }
    }

    public class ChangeAttackDOWN implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int i = Integer.valueOf(labelCharacterAttackStatus.getText());
            i--;
            labelCharacterAttackStatus.setText(String.valueOf(i));
        }
    }

    public class ChangeLuckUP implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int i = Integer.valueOf(labelCharacterLuckStatus.getText());
            i++;
            labelCharacterLuckStatus.setText(String.valueOf(i));
        }
    }

    public class ChangeLuckDOWN implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int i = Integer.valueOf(labelCharacterLuckStatus.getText());
            i--;
            labelCharacterLuckStatus.setText(String.valueOf(i));
        }
    }
/*    public class LabelChangeText implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            mainText.setText(gameText.gameTextet[4]);
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            labelCharacterHealth.setFont(new Font("Raster Fonts", Font.BOLD, 14));

        }

        @Override
        public void mouseExited(MouseEvent e) {
            labelCharacterHealth.setFont(new Font("Raster Fonts", Font.TRUETYPE_FONT, 14));

        }
    }*/






    public GUIClass ()
    {
      /*  SubstanceLookAndFeel laf = new SubstanceGeminiLookAndFeel();
        UIManager.setLookAndFeel(laf);*/

        JFrame.setDefaultLookAndFeelDecorated(true); // �������� ������� ��� ������. �������� ��� ������ � �����.
        JDialog.setDefaultLookAndFeelDecorated(true);



        gameText=new GameText();
        mainFrame = new JFrame("����� �������� �������");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(1024, 1280);

        ImageIcon iconNextButton = new ImageIcon("Symbol_Forward_2.gif");

//      ���� ������������� BUTTON
        nextButton = new JButton("�����", iconNextButton);
 //       nextButton.setPreferredSize(new Dimension(30, 100));
//        nextButton.setSize(60, 40);
        nextButton.addActionListener(new NextPoint());
        buttonThrowDice = new JButton("������� �����");
        buttonThrowDice.addActionListener(new ThrowDice());
        buttonCharacterHealthUP = new JButton("�������� +");
        buttonCharacterHealthUP.addActionListener(new ChangeHealthUP());
        buttonCharacterHealthDOWN = new JButton("�������� -");
        buttonCharacterHealthDOWN.addActionListener(new ChangeHealthDOWN());
        buttonCharacterAttackUP = new JButton("����� +");
        buttonCharacterAttackUP.addActionListener(new ChangeAttackUP());
        buttonCharacterAttackDOWN = new JButton("����� -");
        buttonCharacterAttackDOWN.addActionListener(new ChangeAttackDOWN());
        buttonCharacterLuckUP = new JButton("����� +");
        buttonCharacterLuckUP.addActionListener(new ChangeLuckUP());
        buttonCharacterLuckDOWN = new JButton("����� -");
        buttonCharacterLuckDOWN.addActionListener(new ChangeLuckDOWN());

        mainText = new JTextArea();
        mainText.setEditable(false);
        mainText.setFont(new Font("Raster Fonts", Font.TRUETYPE_FONT, 16));
        mainText.setWrapStyleWord(true);
        mainText.setAutoscrolls(true);
        mainText.setText(gameText.gameTextet[0]);
        mainText.setLineWrap(true);
        mainText.setBorder(new LineBorder(Color.DARK_GRAY));
   //     mainText.setMinimumSize(new Dimension(1200, 800));

       /* scrollPaneNotes = new JScrollPane();
        scrollPaneNotes.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPaneNotes.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
*/

        textAreaNotes = new JTextArea();
        textAreaNotes.setEditable(true);
        textAreaNotes.setFont(new Font("Raster Fonts", Font.TRUETYPE_FONT, 14));
        textAreaNotes.setWrapStyleWord(true);
        //textAreaNotes.setAutoscrolls(true);
        textAreaNotes.setLineWrap(true);
        textAreaNotes.setBorder(new LineBorder(Color.DARK_GRAY));
        //textAreaNotes.setToolTipText("����� �� ������ ������ �������");
        textAreaNotes.setText("����� �� ������ ������ �������");
     //   textAreaNotes.add(scrollPaneNotes);


        textFieldNextPoint = new JTextField(50);
        textFieldNextPoint.setBackground(Color.LIGHT_GRAY);
        textFieldNextPoint.setMaximumSize(new Dimension(60, 40));


//      ���� ������������� LABEL
        labelPointNumber = new JLabel();
        labelPointNumber.setText("������� ����� ���������: ");
        labelCharacterAttack = new JLabel();
        labelCharacterAttack.setText("�����:");
        labelCharacterAttack.setFont(new Font("Raster Fonts", Font.TRUETYPE_FONT, 14));
        labelCharacterHealth = new JLabel();
        labelCharacterHealth.setText("��������: ");
        labelCharacterHealth.setFont(new Font("Raster Fonts", Font.TRUETYPE_FONT, 14));
//        labelCharacterHealth.addMouseListener(new HealthStatus());
        labelCurrentDiceStatus = new JLabel("");
        labelDiceThrowResult = new JLabel("��������� ������ ������:");
        labelCharacterLuck = new JLabel();
        labelCharacterLuck.setText("�����");
        labelCharacterLuck.setFont(new Font("Raster Fonts", Font.TRUETYPE_FONT, 14));
        labelCharacterHealthStatus = new JLabel();
        labelCharacterHealthStatus.setText("0");
        labelCharacterHealthStatus.setFont(new Font("Raster Fonts", Font.BOLD, 14));
        labelCharacterAttackStatus = new JLabel();
        labelCharacterAttackStatus.setText("0");
        labelCharacterAttackStatus.setFont(new Font("Raster Fonts", Font.BOLD, 14));
        labelCharacterLuckStatus = new JLabel();
        labelCharacterLuckStatus.setText("0");
        labelCharacterLuckStatus.setFont(new Font("Raster Fonts", Font.BOLD, 14));
        // label � ����
        labelAbout = new JLabel("� ���������");
        labelAbout.setFont(new Font("Raster Fonts", Font.TRUETYPE_FONT, 14));
        labelSaveCurrentProgress = new JLabel("���������");
        labelSaveCurrentProgress.setFont(new Font("Raster Fonts", Font.TRUETYPE_FONT, 14));
        labelNewGame = new JLabel("����� ����");
        labelNewGame.setFont(new Font("Raster Fonts", Font.TRUETYPE_FONT, 14));
        labelNewGame.addMouseListener(new NewGame());






//      ���� �������� BOX'��
        menuBox = Box.createHorizontalBox();
        menuBox.setBorder(new TitledBorder("����"));

/*        characterBox = Box.createHorizontalBox();
        characterBox.setBorder(new TitledBorder("��������"));*/

        characterBox = new JPanel();
        characterBox.setLayout(new GridBagLayout());
        characterLayout = new GridBagConstraints();
        characterLayout.fill=GridBagConstraints.HORIZONTAL;
/*        characterLayout.weightx = 1;
        characterLayout.gridx = 0;
        characterLayout.gridy = 0;*/



        textBox = Box.createVerticalBox();
        textBox.setBorder(new TitledBorder("����� �������� �������"));

        manageBox = Box.createHorizontalBox();
        manageBox.setBorder(new TitledBorder("����������"));




        // ���������� ��������� � Box'��
        manageBox.add(Box.createHorizontalStrut(10));
        manageBox.add(labelPointNumber);

        manageBox.add(Box.createHorizontalStrut(10));
        manageBox.add(textFieldNextPoint);

        manageBox.add(Box.createHorizontalStrut(10));
        manageBox.add(nextButton);
        manageBox.add(Box.createHorizontalStrut(10));
        manageBox.add(labelDiceThrowResult);
        manageBox.add(Box.createHorizontalStrut(10));
        manageBox.add(labelCurrentDiceStatus);
        manageBox.add(Box.createHorizontalStrut(10));
        manageBox.add(buttonThrowDice);
        manageBox.add(Box.createHorizontalStrut(10));



//        characterBox.add(Box.createHorizontalStrut(10));

//      ���� ��������� GRIDBAG
        characterLayout.fill=GridBagConstraints.HORIZONTAL;
        characterLayout.anchor=GridBagConstraints.FIRST_LINE_START;
        characterLayout.weightx = 1;
        characterLayout.gridx = 1;
        characterLayout.gridy = 0;
        characterBox.add(labelCharacterHealth, characterLayout);

        characterLayout.fill=GridBagConstraints.HORIZONTAL;
        characterLayout.weightx = 1;
        characterLayout.gridx = 1;
        characterLayout.gridy = 1;
        characterBox.add(labelCharacterAttack, characterLayout);

        characterLayout.fill=GridBagConstraints.HORIZONTAL;
        characterLayout.weightx = 1;
        characterLayout.gridx = 1;
        characterLayout.gridy = 2;
        characterBox.add(labelCharacterLuck, characterLayout);

        characterLayout.fill=GridBagConstraints.HORIZONTAL;
        characterLayout.weightx = 1;
        characterLayout.gridx = 2;
        characterLayout.gridy = 0;
        characterBox.add(labelCharacterHealthStatus, characterLayout);

        characterLayout.fill=GridBagConstraints.HORIZONTAL;
        characterLayout.weightx = 1;
        characterLayout.gridx = 2;
        characterLayout.gridy = 1;
        characterBox.add(labelCharacterAttackStatus, characterLayout);

        characterLayout.fill=GridBagConstraints.HORIZONTAL;
        characterLayout.weightx = 1;
        characterLayout.gridx = 2;
        characterLayout.gridy = 2;
        characterBox.add(labelCharacterLuckStatus, characterLayout);

        characterLayout.fill=GridBagConstraints.HORIZONTAL;
        characterLayout.weightx = 1;
        characterLayout.gridx = 1;
        characterLayout.gridy = 3;
        characterBox.add(buttonCharacterHealthUP, characterLayout);

        characterLayout.fill=GridBagConstraints.HORIZONTAL;
        characterLayout.weightx = 1;
        characterLayout.gridx = 2;
        characterLayout.gridy = 3;
        characterBox.add(buttonCharacterHealthDOWN, characterLayout);

        characterLayout.fill=GridBagConstraints.HORIZONTAL;
        characterLayout.weightx = 1;
        characterLayout.gridx = 1;
        characterLayout.gridy = 4;
        characterBox.add(buttonCharacterAttackUP, characterLayout);

        characterLayout.fill=GridBagConstraints.HORIZONTAL;
        characterLayout.weightx = 1;
        characterLayout.gridx = 2;
        characterLayout.gridy = 4;
        characterBox.add(buttonCharacterAttackDOWN, characterLayout);

        characterLayout.fill=GridBagConstraints.HORIZONTAL;
        characterLayout.weightx = 1;
        characterLayout.gridx = 1;
        characterLayout.gridy = 5;
        characterBox.add(buttonCharacterLuckUP, characterLayout);

        characterLayout.fill=GridBagConstraints.HORIZONTAL;
        characterLayout.weightx = 1;
        characterLayout.gridx = 2;
        characterLayout.gridy = 5;
        characterBox.add(buttonCharacterLuckDOWN, characterLayout);






//        characterBox.add(labelCharacterHealth);
//        characterBox.add(Box.createHorizontalStrut(10));
//        characterBox.add(Box.createVerticalStrut(10));
//        characterBox.add(labelCharacterAttack);
//        characterBox.add(Box.createHorizontalStrut(10));



        textBox.add(mainText);
        textBox.add(Box.createVerticalStrut(10));
        textBox.add(textAreaNotes);
//        textBox.add(scrollPaneNotes);

        menuBox.add(Box.createHorizontalStrut(10));
        menuBox.add(labelNewGame);
        menuBox.add(Box.createHorizontalStrut(10));
        menuBox.add(labelSaveCurrentProgress);
        menuBox.add(Box.createHorizontalStrut(10));
        menuBox.add(labelAbout);



        //      ���� ��������� ���������
//        mainFrame.getContentPane().add(BorderLayout.EAST, characterBox);
        mainFrame.getContentPane().add(BorderLayout.EAST, characterBox);
        mainFrame.getContentPane().add(BorderLayout.CENTER, textBox);
        mainFrame.getContentPane().add(BorderLayout.NORTH, menuBox);
        mainFrame.getContentPane().add(BorderLayout.SOUTH, manageBox);

        mainFrame.setVisible(true);


    }







}
