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
    JTextField textFieldNextPoint;
    JLabel labelPointNumber;
    GameText gameText;


// listener для кнопки перехода к следующему фрагменту текста. Получает содержимое текстового поля и переводит его в Int
// после чего int используется в качестве индекса для массива с текстом книги.
    public class NextPoint implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int i = Integer.parseInt(textFieldNextPoint.getText());
            mainText.setText((String) gameText.gameTextet[i]);
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
//        nextButton.setPreferredSize(new Dimension(30, 100));

        mainText = new JTextArea();
        mainText.setEditable(false);
        mainText.setFont(new Font("Raster Fonts",Font.TRUETYPE_FONT,14));

        textFieldNextPoint = new JTextField(50);
        labelPointNumber = new JLabel();

//      создание Box-ов
        Box menuBox = Box.createVerticalBox();
        menuBox.setBorder(new TitledBorder("Меню"));

        Box characterBox = Box.createVerticalBox();
        characterBox.setBorder(new TitledBorder("Персонаж"));

        Box textBox = Box.createHorizontalBox();
        textBox.setBorder(new TitledBorder("Тайна капитана Шелтона"));

        Box manageBox = Box.createHorizontalBox();
        //        manageBox.setBorder(new TitledBorder(""));



        mainFrame.setSize(1024, 1280);
        textFieldNextPoint.setBackground(Color.LIGHT_GRAY);
        textFieldNextPoint.setMaximumSize(new Dimension(60, 40));
        nextButton.setSize(60, 40);

        labelPointNumber.setText("Введите номер параграфа: ");

        nextButton.addActionListener(new NextPoint());


        // добавление элементов к панелям
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
        textBox.add(mainText);


        //      блок настройки раскладки
        mainFrame.getContentPane().add(BorderLayout.EAST, characterBox);
        mainFrame.getContentPane().add(BorderLayout.CENTER, textBox);
        mainFrame.getContentPane().add(BorderLayout.NORTH, menuBox);
        mainFrame.getContentPane().add(BorderLayout.SOUTH, manageBox);

        mainFrame.setVisible(true);


    }







}
