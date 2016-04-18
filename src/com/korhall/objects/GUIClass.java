package com.korhall.objects;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*import org.pushingpixels.substance.api.*;
import org.pushingpixels.substance.api.skin.*;*/

/**
 * Created by srv3 on 27.01.2016.
 */

/*
* Для хранения истории переходов необходимо создаль arraylist и добавлять
* туда номер предыдущего параграфа при каждом переходе по кнопке далее
*
*
* */

public class GUIClass
{
    JFrame mainFrame;

    JTextArea mainText;
    JTextArea textAreaNotes;

    JButton nextButton;
    JButton buttonAbout;
    JButton buttonSaveCurrentProgress;
    JButton buttonNewGame;
    JButton buttonThrowDice;

    JTextField textFieldNextPoint;

    JLabel labelPointNumber;
    JLabel labelCharacterAttack;
    JLabel labelCharacterHealth;
    JLabel labelCurrentDiceStatus;
    JLabel labelDiceThrowResult;

    JScrollPane scrollPaneNotes;

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

    public class NewGame implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            mainText.setText(gameText.gameTextet[0]);
        }
    }


/*    public class HealthStatus implements MouseListener {

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

        JFrame.setDefaultLookAndFeelDecorated(true); // изменяет внешний вид фрэйма. Возможно эту строку я удалю.
        JDialog.setDefaultLookAndFeelDecorated(true);



        gameText=new GameText();
        mainFrame = new JFrame("Тайна капитана Шелтона");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(1024, 1280);

        ImageIcon iconNextButton = new ImageIcon("Symbol_Forward_2.gif");

        nextButton = new JButton("Далее", iconNextButton);
 //       nextButton.setPreferredSize(new Dimension(30, 100));
//        nextButton.setSize(60, 40);
        nextButton.addActionListener(new NextPoint());
        buttonAbout = new JButton("О программе");
        buttonSaveCurrentProgress = new JButton("Сохранить");
        buttonNewGame = new JButton("Новая игра");
        buttonNewGame.addActionListener(new NewGame());
        buttonThrowDice = new JButton("Бросить кубик");
        buttonThrowDice.addActionListener(new ThrowDice());


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
        //textAreaNotes.setToolTipText("Здесь вы можете делать заметки");
        textAreaNotes.setText("Здесь вы можете делать заметки");
     //   textAreaNotes.add(scrollPaneNotes);


        textFieldNextPoint = new JTextField(50);
        textFieldNextPoint.setBackground(Color.LIGHT_GRAY);
        textFieldNextPoint.setMaximumSize(new Dimension(60, 40));

        labelPointNumber = new JLabel();
        labelPointNumber.setText("Введите номер параграфа: ");
        labelCharacterAttack = new JLabel();
        labelCharacterAttack.setText("Атака:");
        labelCharacterHealth = new JLabel();
        labelCharacterHealth.setText("Здоровье: ");
//        labelCharacterHealth.setFont(new Font("Raster Fonts", Font.TRUETYPE_FONT, 14));
//        labelCharacterHealth.addMouseListener(new HealthStatus());
        labelCurrentDiceStatus = new JLabel("");
        labelDiceThrowResult = new JLabel("Результат броска кубика:");



//      создание Box-ов
        menuBox = Box.createHorizontalBox();
        menuBox.setBorder(new TitledBorder("Меню"));

        characterBox = Box.createHorizontalBox();
        characterBox.setBorder(new TitledBorder("Персонаж"));

        textBox = Box.createVerticalBox();
        textBox.setBorder(new TitledBorder("Тайна капитана Шелтона"));

        manageBox = Box.createHorizontalBox();
        manageBox.setBorder(new TitledBorder("Управление"));




        // добавление элементов к Box'ам
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



        characterBox.add(Box.createHorizontalStrut(10));
        characterBox.add(labelCharacterHealth);
        characterBox.add(Box.createHorizontalStrut(10));
//        characterBox.add(Box.createVerticalStrut(10));
        characterBox.add(labelCharacterAttack);
        characterBox.add(Box.createHorizontalStrut(10));

        textBox.add(mainText);
        textBox.add(Box.createVerticalStrut(10));
        textBox.add(textAreaNotes);
//        textBox.add(scrollPaneNotes);

        menuBox.add(Box.createHorizontalStrut(10));
        menuBox.add(buttonNewGame);
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
