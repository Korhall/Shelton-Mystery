package com.korhall.objects;

import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import org.pushingpixels.substance.api.skin.*;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;

/**
 * Created by srv3 on 27.01.2016.
 */

/*
* Для хранения истории переходов необходимо создаль arraylist и добавлять
* туда номер предыдущего параграфа при каждом переходе по кнопке далее
*
*
* */

public class  GUIClass implements Serializable
{
    transient public JFrame mainFrame;

    public static JTextArea mainText;
    JTextArea textAreaNotes;

    transient JButton nextButton;

    transient JButton buttonThrowDice;
    transient JButton buttonCharacterHealthUP;
    transient JButton buttonCharacterHealthDOWN;
    transient JButton buttonCharacterAttackUP;
    transient JButton buttonCharacterAttackDOWN;
    transient JButton buttonCharacterLuckUP;
    transient JButton buttonCharacterLuckDOWN;
    transient JButton buttonCharachterGoldUP;
    transient JButton buttonCharachterGoldDown;


    transient JTextField textFieldNextPoint;

    transient JLabel labelPointNumber;
    transient JLabel labelCharacterAttack;
    transient JLabel labelCharacterHealth;
    transient JLabel labelCurrentDiceStatus;
    transient JLabel labelDiceThrowResult;
    transient JLabel labelCharacterLuck;
    public static JLabel labelCharacterHealthStatus;
    public JLabel labelCharacterAttackStatus;
    public JLabel labelCharacterLuckStatus;
    JLabel labelAbout;
    JLabel labelSaveCurrentProgress;
    JLabel labelNewGame;
    transient JLabel labelGold;
    public JLabel labelGoldAmmount;

    transient JMenu mainMenu;

    transient JScrollPane scrollPaneNotes;

    transient GameText gameText;

    transient Box textBox;
    transient Box manageBox;

    transient JPanel characterBox;
    transient JPanel panelMenu;
    transient GridBagConstraints characterLayout;

    Frame frame = new Frame();

    public class NextPoint implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
//            int i = Integer.parseInt(textFieldNextPoint.getText());
            int i = Integer.valueOf(textFieldNextPoint.getText());
            mainText.setText(gameText.gameTextArray[i]);

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
        public void actionPerformed(ActionEvent e) { }
    }

    public class NewGame implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) { mainText.setText(gameText.gameTextArray[0]); }
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
            if (i<1)
            {
                mainText.setText(gameText.gameTextArray[0]);
            }
            else {
                labelCharacterHealthStatus.setText(String.valueOf(i));
            }
        }
    }

    public  class ChangeAttackUP implements ActionListener{

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

    public class ChangeGoldUP implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            int i = Integer.valueOf(labelGoldAmmount.getText());
            i++;
            labelGoldAmmount.setText(String.valueOf(i));
        }
    }

    public class ChangeGoldDOWN implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            int i = Integer.valueOf(labelGoldAmmount.getText());
            i--;
            if (i<0)
            {
                labelGoldAmmount.setText("0");
            }
            else {
                labelGoldAmmount.setText(String.valueOf(i));
            }
        }
    }

    public class SaveGameText implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) { }
        @Override
        public void mousePressed(MouseEvent e) {
            try
            {
                /*GUIClass gui = new GUIClass();
                gui.mainText.setText(mainText.getText());*/
                JFileChooser fileSave = new JFileChooser();
                fileSave.showSaveDialog(frame);
                try
                {
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileSave.getSelectedFile()));
                    bufferedWriter.write(mainText.getText());
                    /*bufferedWriter.write(labelCharacterHealthStatus.getText());
                    bufferedWriter.write(labelCharacterAttackStatus.getText());
                    bufferedWriter.write(labelCharacterLuckStatus.getText());
                    bufferedWriter.write(labelGoldAmmount.getText());
                    bufferedWriter.write(textAreaNotes.getText());*/

                    bufferedWriter.close();
                }
                catch (IOException ex)
                {
                    ex.printStackTrace();
                }
            }
            catch (Exception ex)
            { ex.printStackTrace(); }
        }
        @Override
        public void mouseReleased(MouseEvent e) { }
        @Override
        public void mouseEntered(MouseEvent e) { }
        @Override
        public void mouseExited(MouseEvent e) { }
    }

    public class SaveGame implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) { }
        @Override
        public void mousePressed(MouseEvent e) {
            try
            {
                ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("game.ser"));
                os.writeObject(GUIClass.this);
                os.close();
                System.out.println("Игра сохранена");
            }
            catch (Exception ex)
            { ex.printStackTrace(); }
        }
        @Override
        public void mouseReleased(MouseEvent e) { }
        @Override
        public void mouseEntered(MouseEvent e) { }
        @Override
        public void mouseExited(MouseEvent e) { }
    }

    public class LoadGameText  implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            try{
               JFileChooser fileOpen = new JFileChooser();
               fileOpen.showOpenDialog(frame);
                BufferedReader reader = new BufferedReader(new FileReader(fileOpen.getSelectedFile()));
//                BufferedReader reader = new BufferedReader(new FileReader("game.txt"));
                String line = null;
                while ((line = reader.readLine()) !=null)
                {mainText.setText(line);}
                reader.close();
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }
        @Override
        public void mousePressed(MouseEvent mouseEvent) { }
        @Override
        public void mouseReleased(MouseEvent mouseEvent) { }
        @Override
        public void mouseEntered(MouseEvent mouseEvent) { }
        @Override
        public void mouseExited(MouseEvent mouseEvent) { }
    }

    public class LoadGame  implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
         try{
             ObjectInputStream is = new ObjectInputStream(new FileInputStream("game.ser"));
//             GUIClass.labelCharacterHealthStatus=is.readObject();
         }
         catch (Exception ex){
             ex.printStackTrace();
         }
        }

        @Override
        public void mousePressed(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseEntered(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseExited(MouseEvent mouseEvent) {

        }
    }

    public void setupLAF()
    { try {

            SubstanceLookAndFeel.setSkin(new GraphiteGlassSkin());
            SubstanceLookAndFeel.setSkin("org.pushingpixels.substance.api.skin.GraphiteGlassSkin");
            UIManager.setLookAndFeel(new SubstanceGraphiteGlassLookAndFeel());
            UIManager.setLookAndFeel("org.pushingpixels.substance.api.skin.SubstanceGraphiteGlassLookAndFeel");

        } catch (Exception ex) {}
    }

    public void setupLAFBussinessBlackGlass ()
    { try {

            SubstanceLookAndFeel.setSkin(new BusinessBlackSteelSkin());
            SubstanceLookAndFeel.setSkin("org.pushingpixels.substance.api.skin.BusinessBlackSteelSkin");
            UIManager.setLookAndFeel(new SubstanceBusinessBlackSteelLookAndFeel());
            UIManager.setLookAndFeel("org.pushingpixels.substance.api.skin.SubstanceBusinessBlackSteelLookAndFeel");

        } catch (Exception ex) {}
    }
    public void setupLAFAqua ()
    { try {

            SubstanceLookAndFeel.setSkin(new MistAquaSkin());
            SubstanceLookAndFeel.setSkin("org.pushingpixels.substance.api.skin.MistAquaSkin");
            UIManager.setLookAndFeel(new SubstanceMistAquaLookAndFeel());
            UIManager.setLookAndFeel("org.pushingpixels.substance.api.skin.SubstanceMistAquaLookAndFeel");

        } catch (Exception ex) {}
    }    public void setupLAFGraphiteAqua ()
    { try {

            SubstanceLookAndFeel.setSkin(new GraphiteAquaSkin());
            SubstanceLookAndFeel.setSkin("org.pushingpixels.substance.api.skin.GraphiteAquaSkin");
            UIManager.setLookAndFeel(new SubstanceGraphiteAquaLookAndFeel());
            UIManager.setLookAndFeel("org.pushingpixels.substance.api.skin.SubstanceGraphiteAquaLookAndFeel");

        } catch (Exception ex) {}
    }

    public void setupLAFMistAquaSkin()
    { try {

            SubstanceLookAndFeel.setSkin(new MistAquaSkin());
            SubstanceLookAndFeel.setSkin("org.pushingpixels.substance.api.skin.MistAquaSkin");
            UIManager.setLookAndFeel(new SubstanceMistAquaLookAndFeel());
            UIManager.setLookAndFeel("org.pushingpixels.substance.api.skin.SubstanceMistAquaLookAndFeel");

        } catch (Exception ex) {}
    }

    public void setupLAFSaharaSkin()
    { try {

            SubstanceLookAndFeel.setSkin(new SaharaSkin());
            SubstanceLookAndFeel.setSkin("org.pushingpixels.substance.api.skin.SaharaSkin");
            UIManager.setLookAndFeel(new SubstanceSaharaLookAndFeel());
            UIManager.setLookAndFeel("org.pushingpixels.substance.api.skin.SubstanceSaharaLookAndFeel");

        } catch (Exception ex) {}
    }


    public void setDefualtDecor()
    {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);
    }

    public GUIClass () throws UnsupportedLookAndFeelException {
//    public void go () throws UnsupportedLookAndFeelException {

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
        saveGame.addMouseListener(new SaveGameText());
        JMenuItem loadGame = new JMenuItem("Загрузить игру");
        loadGame.addMouseListener(new LoadGameText());
        JMenuItem aboutThisProgramm = new JMenuItem("О программе");
        mainMenu.addSeparator();
        JMenuItem exitGame = new JMenuItem("Выход");
        exitGame.addActionListener(new ExitGame());



//      БЛОК ИНИЦИАЛИЗАЦИИ BUTTON
//______________________________________________________________________________________________________________________
        nextButton = new JButton("Далее");
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
        buttonCharachterGoldUP = new JButton("Золото +");
        buttonCharachterGoldUP.addActionListener(new ChangeGoldUP());
        buttonCharachterGoldDown = new JButton("Золото -");
        buttonCharachterGoldDown.addActionListener(new ChangeGoldDOWN());
//______________________________________________________________________________________________________________________

        mainText = new JTextArea();
        mainText.setEditable(false);
        mainText.setFont(new Font("Raster Fonts", Font.TRUETYPE_FONT, 16));
        mainText.setWrapStyleWord(true);
        mainText.setAutoscrolls(true);
        mainText.setText(gameText.gameTextArray[0]);
        mainText.setLineWrap(true);
        mainText.setBorder(new LineBorder(Color.DARK_GRAY));
   //     mainText.setMinimumSize(new Dimension(1200, 800));
        mainText.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));

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
        textAreaNotes.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
        textAreaNotes.setText("Здесь вы можете делать заметки");
     //   textAreaNotes.add(scrollPaneNotes);

        scrollPaneNotes = new JScrollPane(textAreaNotes);
        scrollPaneNotes.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPaneNotes.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

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
        labelGold = new JLabel();
        labelGold.setText("Золото");
        labelGold.setFont(new Font("Raster Fonts", Font.TRUETYPE_FONT, 14));
        labelGoldAmmount = new JLabel();
        labelGoldAmmount.setText("15");
        labelGoldAmmount.setFont(new Font("Raster Fonts", Font.BOLD, 14));

//      БЛОК СОЗДАНИЯ BOX'ОВ

        characterBox = new JPanel();
        characterBox.setLayout(new GridBagLayout());
        characterLayout = new GridBagConstraints();
        characterLayout.fill = GridBagConstraints.HORIZONTAL;
        characterLayout.insets=new Insets(5,5,5,5);

        textBox = Box.createVerticalBox();
        textBox.setBorder(new TitledBorder("Тайна капитана Шелтона"));
        textBox.add(scrollPaneNotes);

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
        characterBox.add(labelGold, characterLayout);

        characterLayout.fill=GridBagConstraints.HORIZONTAL;
        characterLayout.weightx = 1;
        characterLayout.gridx = 2;
        characterLayout.gridy = 3;
        characterBox.add(labelGoldAmmount, characterLayout);

        characterLayout.fill=GridBagConstraints.HORIZONTAL;
        characterLayout.weightx = 1;
        characterLayout.gridx = 1;
        characterLayout.gridy = 4;
        characterBox.add(buttonCharacterHealthUP, characterLayout);

        characterLayout.fill=GridBagConstraints.HORIZONTAL;
        characterLayout.weightx = 1;
        characterLayout.gridx = 2;
        characterLayout.gridy = 4;
        characterBox.add(buttonCharacterHealthDOWN, characterLayout);

        characterLayout.fill=GridBagConstraints.HORIZONTAL;
        characterLayout.weightx = 1;
        characterLayout.gridx = 1;
        characterLayout.gridy = 5;
        characterBox.add(buttonCharacterAttackUP, characterLayout);

        characterLayout.fill=GridBagConstraints.HORIZONTAL;
        characterLayout.weightx = 1;
        characterLayout.gridx = 2;
        characterLayout.gridy = 5;
        characterBox.add(buttonCharacterAttackDOWN, characterLayout);

        characterLayout.fill=GridBagConstraints.HORIZONTAL;
        characterLayout.weightx = 1;
        characterLayout.gridx = 1;
        characterLayout.gridy = 6;
        characterBox.add(buttonCharacterLuckUP, characterLayout);

        characterLayout.fill=GridBagConstraints.HORIZONTAL;
        characterLayout.weightx = 1;
        characterLayout.gridx = 2;
        characterLayout.gridy = 6;
        characterBox.add(buttonCharacterLuckDOWN, characterLayout);

        characterLayout.fill=GridBagConstraints.HORIZONTAL;
        characterLayout.weightx = 1;
        characterLayout.gridx = 1;
        characterLayout.gridy = 7;
        characterBox.add(buttonCharachterGoldUP, characterLayout);

        characterLayout.fill=GridBagConstraints.HORIZONTAL;
        characterLayout.weightx = 1;
        characterLayout.gridx = 2;
        characterLayout.gridy = 7;
        characterBox.add(buttonCharachterGoldDown, characterLayout);




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

//        setupLAFBussinessBlackGlass ();
//        setupLAFMistAquaSkin();
//        setupLAFSaharaSkin();
//        setupLAFAqua();
//        setupLAFGraphiteAqua ();

        mainFrame.pack();
        mainFrame.setVisible(true);





    }


//    БЛОК МОДАЛЬНЫХ ОКОН




}

























