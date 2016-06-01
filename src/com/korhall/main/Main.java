package com.korhall.main;

import com.korhall.objects.GUIClass;

import javax.swing.*;

public class Main {


    public static void main(String[] args) throws UnsupportedLookAndFeelException {

        GUIClass guiClass = new GUIClass();

/*        try {
            JFileChooser fileOpen = new JFileChooser();
            fileOpen.showOpenDialog(guiClass.mainFrame);
            BufferedReader reader = new BufferedReader(new FileReader(fileOpen.getSelectedFile()));
//            BufferedReader reader = new BufferedReader(new FileReader("game.txt"));
            String line = null;
            while ((line = reader.readLine()) != null) {
                mainText.setText(line);
            }
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();*/
       /* try{
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("game.ser"));
            GUIClass.labelCharacterHealthStatus= (JLabel) is.readObject();
            GUIClass.mainText= (JTextArea) is.readObject();

        }
        catch (Exception ex){
            ex.printStackTrace();
        }*/

        }


    }






