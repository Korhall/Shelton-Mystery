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

    JTextArea mainText;
    JButton nextButton;
    JButton buttonAbout;
    JButton buttonSaveCurrentProgress;
    JTextField textFieldNextPoint;
    JLabel labelPointNumber;
    JLabel labelPreviousPoint;
    JLabel labelPreviousPointNumber;



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
        JFrame.setDefaultLookAndFeelDecorated(true); // изменяет внешний вид фрэйма. Возможно эту строку я удалю.

        gameText=new GameText();
        mainFrame = new JFrame("Тайна капитана Шелтона");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon iconNextButton = new ImageIcon("Symbol Forward 2.gif");
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
        labelPreviousPoint = new JLabel();
        labelPreviousPoint.setText("Предыдущий параграф :");
        labelPreviousPointNumber = new JLabel();


//      создание Box-ов
        menuBox = Box.createHorizontalBox();
        menuBox.setBorder(new TitledBorder("Меню"));

        characterBox = Box.createVerticalBox();
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
        manageBox.add(labelPreviousPoint);
        manageBox.add(Box.createHorizontalStrut(10));
        manageBox.add(labelPreviousPointNumber);
        manageBox.add(Box.createHorizontalStrut(10));



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
