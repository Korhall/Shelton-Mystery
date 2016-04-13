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
    JTextField textFieldNextPoint;
    JLabel labelPointNumber;
    JLabel labelCharacterAttack;
    JLabel labelCharacterHealth;


    GameText gameText;

    Box menuBox;
    Box characterBox;
    Box textBox;
    Box manageBox;




// listener для кнопки перехода к следующему фрагменту текста. Получает содержимое текстового поля и переводит его в Int
// после чего int используется в качестве индекса для массива с текстом книги.
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





    public GUIClass ()
    {
      /*  SubstanceLookAndFeel laf = new SubstanceGeminiLookAndFeel();
        UIManager.setLookAndFeel(laf);*/

        JFrame.setDefaultLookAndFeelDecorated(true); // изменяет внешний вид фрэйма. Возможно эту строку я удалю.
        JDialog.setDefaultLookAndFeelDecorated(true);



        gameText=new GameText();
        mainFrame = new JFrame("Тайна капитана Шелтона");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon iconNextButton = new ImageIcon("Symbol_Forward_2.gif");

        nextButton = new JButton("Далее", iconNextButton);
 //       nextButton.setPreferredSize(new Dimension(30, 100));
//        nextButton.setSize(60, 40);
        nextButton.addActionListener(new NextPoint());
        buttonAbout = new JButton("О программе");
        buttonSaveCurrentProgress = new JButton("Сохранить");


        mainText = new JTextArea();
        mainText.setEditable(false);
        mainText.setFont(new Font("Raster Fonts", Font.TRUETYPE_FONT, 14));

        textFieldNextPoint = new JTextField(50);

        labelPointNumber = new JLabel();
        labelPointNumber.setText("Введите номер параграфа: ");
        labelCharacterAttack = new JLabel();
        labelCharacterAttack.setText("Атака:");
        labelCharacterHealth = new JLabel();
        labelCharacterHealth.setText("Здоровье: ");



//      создание Box-ов
        menuBox = Box.createHorizontalBox();
        menuBox.setBorder(new TitledBorder("Меню"));

        characterBox = Box.createHorizontalBox();
        characterBox.setBorder(new TitledBorder("Персонаж"));

        textBox = Box.createHorizontalBox();
        textBox.setBorder(new TitledBorder("Тайна капитана Шелтона"));

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
        menuBox.add(buttonSaveCurrentProgress);
        menuBox.add(Box.createHorizontalStrut(10));
        menuBox.add(buttonAbout);



        //      блок настройки раскладки
        mainFrame.getContentPane().add(BorderLayout.EAST, characterBox);
        mainFrame.getContentPane().add(BorderLayout.CENTER, textBox);
        mainFrame.getContentPane().add(BorderLayout.NORTH, menuBox);
        mainFrame.getContentPane().add(BorderLayout.SOUTH, manageBox);

        mainFrame.setVisible(true);


    }







}
