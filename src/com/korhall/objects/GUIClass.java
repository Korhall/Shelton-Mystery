package com.korhall.objects;

import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import org.pushingpixels.substance.api.skin.BusinessBlackSteelSkin;
import org.pushingpixels.substance.api.skin.*;
import org.pushingpixels.substance.api.skin.GraphiteGlassSkin;
import org.pushingpixels.substance.api.skin.SaharaSkin;
import org.pushingpixels.substance.api.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    JMenu mainMenu;

    JScrollPane scrollPaneNotes;

   GameText gameText;

    Box textBox;
    Box manageBox;

    JPanel characterBox;
    JPanel panelMenu;
    GridBagConstraints characterLayout;

    Frame frame = new Frame();









// listener для кнопки перехода к следующему фрагменту текста. Получает содержимое текстового поля и переводит его в Int
// после чего int используется в качестве индекса для массива с текстом книги.
    public class NextPoint implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
//            int i = Integer.parseInt(textFieldNextPoint.getText());
            int i = Integer.valueOf(textFieldNextPoint.getText());
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
        public void actionPerformed(ActionEvent actionEvent) { mainText.setText(gameText.gameTextet[0]); }
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

    public class ExitGame implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }



   /* public static void setupSubstance() {
        try {
            final String fileName = System.getProperty("user.home") + System.getProperty("file.separator") + "insubstantial.txt";
            final Properties properties = new Properties();
            org.pushingpixels.substance.api.SubstanceLookAndFeel laf = new SubstanceGeminiLookAndFeel();
            UIManager.setLookAndFeel(laf);
            UIManager.put(SubstanceLookAndFeel.SHOW_EXTRA_WIDGETS, Boolean.TRUE);
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
            Runtime.getRuntime().addShutdownHook(new Thread() {
                @Override public void run() {
                    try {
                        String skinClassName = SubstanceLookAndFeel.getCurrentSkin().getClass().getCanonicalName();
                        properties.setProperty("skinClassName", skinClassName);
                        properties.store(new FileOutputStream(fileName), fileName);
                    } catch (Throwable t) {
                        t.printStackTrace();
                    }
                }
            });
            properties.load(new FileInputStream(fileName));
            String skinClassName = properties.getProperty("skinClassName");
            laf.setSkin(skinClassName);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
*/
    public void setupLAF()
    {
        try {

            SubstanceLookAndFeel.setSkin(new GraphiteGlassSkin());
            SubstanceLookAndFeel.setSkin("org.pushingpixels.substance.api.skin.GraphiteGlassSkin");
            UIManager.setLookAndFeel(new SubstanceGraphiteGlassLookAndFeel());
            UIManager.setLookAndFeel("org.pushingpixels.substance.api.skin.SubstanceGraphiteGlassLookAndFeel");

        } catch (Exception ex) {}
    }

    public void setDefualtDecor()
    {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);

    }

    public GUIClass () throws UnsupportedLookAndFeelException {

     setDefualtDecor();


         Font font = new Font("Verdana", Font.PLAIN, 11);
        JMenuBar menuBar = new JMenuBar();
        panelMenu = new JPanel();
        panelMenu.setLayout(new FlowLayout(FlowLayout.LEFT));



        gameText=new GameText();
        mainFrame = new JFrame("Тайна капитана Шелтона");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(1024, 1280);

//        БЛОК СОЗДАНИЯ МЕНЮ
        mainMenu = new JMenu("Файл");
        JMenuItem newGame = new JMenuItem("Новая игра");
        newGame.addActionListener(new NewGame());
        JMenuItem saveGame = new JMenuItem("Сохранить игру");
        JMenuItem loadGame = new JMenuItem("Загрузить игру");
        JMenuItem aboutThisProgramm = new JMenuItem("О программе");
        mainMenu.addSeparator();
        JMenuItem exitGame = new JMenuItem("Выход");
        exitGame.addActionListener(new ExitGame());









        ImageIcon iconNextButton = new ImageIcon("Symbol_Forward_2.gif");

//      БЛОК ИНИЦИАЛИЗАЦИИ BUTTON
//______________________________________________________________________________________________________________________
        nextButton = new JButton("Далее", iconNextButton);
        nextButton.addActionListener(new NextPoint());
        buttonThrowDice = new JButton("Бросить кубик");
        buttonThrowDice.addActionListener(new ThrowDice());
        buttonCharacterHealthUP = new JButton("Здоровье +");
        buttonCharacterHealthUP.addActionListener(new ChangeHealthUP());
        buttonCharacterHealthDOWN = new JButton("Здоровье -");
        buttonCharacterHealthDOWN.addActionListener(new ChangeHealthDOWN());
        buttonCharacterAttackUP = new JButton("Атака +");
        buttonCharacterAttackUP.addActionListener(new ChangeAttackUP());
        buttonCharacterAttackDOWN = new JButton("Атака -");
        buttonCharacterAttackDOWN.addActionListener(new ChangeAttackDOWN());
        buttonCharacterLuckUP = new JButton("Удача +");
        buttonCharacterLuckUP.addActionListener(new ChangeLuckUP());
        buttonCharacterLuckDOWN = new JButton("Удача -");
        buttonCharacterLuckDOWN.addActionListener(new ChangeLuckDOWN());
//______________________________________________________________________________________________________________________

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
        textAreaNotes.setText("Здесь вы можете делать заметки");
     //   textAreaNotes.add(scrollPaneNotes);


        textFieldNextPoint = new JTextField(50);
        textFieldNextPoint.setMaximumSize(new Dimension(60, 40));


//      БЛОК ИНИЦИАЛИЗАЦИИ LABEL
        labelPointNumber = new JLabel();
        labelPointNumber.setText("Введите номер параграфа: ");
        labelCharacterAttack = new JLabel();
        labelCharacterAttack.setText("Атака:");
        labelCharacterAttack.setFont(new Font("Raster Fonts", Font.TRUETYPE_FONT, 14));
        labelCharacterHealth = new JLabel();
        labelCharacterHealth.setText("Здоровье: ");
        labelCharacterHealth.setFont(new Font("Raster Fonts", Font.TRUETYPE_FONT, 14));
//        labelCharacterHealth.addMouseListener(new HealthStatus());
        labelCurrentDiceStatus = new JLabel("0");
        labelDiceThrowResult = new JLabel("Результат броска кубика:");
        labelCharacterLuck = new JLabel();
        labelCharacterLuck.setText("Удача");
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

//      БЛОК СОЗДАНИЯ BOX'ОВ

        characterBox = new JPanel();
        characterBox.setLayout(new GridBagLayout());
        characterLayout = new GridBagConstraints();
        characterLayout.fill = GridBagConstraints.HORIZONTAL;

        textBox = Box.createVerticalBox();
        textBox.setBorder(new TitledBorder("Тайна капитана Шелтона"));

        manageBox = Box.createHorizontalBox();
        manageBox.setBorder(new TitledBorder("Управление"));



        mainMenu.add(newGame);
        mainMenu.add(saveGame);
        mainMenu.add(loadGame);
        mainMenu.add(aboutThisProgramm);
        mainMenu.add(exitGame);

        menuBar.add(mainMenu);

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

//      БЛОК НАСТРОЙКИ GRIDBAG
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

        textBox.add(mainText);
        textBox.add(Box.createVerticalStrut(10));
        textBox.add(textAreaNotes);

        panelMenu.add(menuBar);



        //      блок настройки раскладки

        mainFrame.getContentPane().add(BorderLayout.EAST, characterBox);
        mainFrame.getContentPane().add(BorderLayout.CENTER, textBox);
        mainFrame.getContentPane().add(BorderLayout.NORTH, panelMenu);
        mainFrame.getContentPane().add(BorderLayout.SOUTH, manageBox);
        setupLAF();
        mainFrame.setVisible(true);





    }


//    БЛОК МОДАЛЬНЫХ ОКОН




}

























