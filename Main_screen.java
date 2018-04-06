/*
    PURPOSE: Basic GUI with file chooser implemented

    START DATE: 01/04/2018

    JAVA ASSIGNMENT - TOPIC ANALYSER

    COMPILER: Intellij


*/




package File;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main_screen extends JFrame implements ActionListener
{
    //attributes

    private JButton chooseATextFileButton;
    private JButton showResultButton;
    private JLabel lab;
    private JButton b;



    //constructor
    public Main_screen(String title)
    {
        super(title);
        setSize(400,400);
        setLayout(new FlowLayout());


        //set colour JFrame to purple
        //getContentPane().setBackground(new java.awt.Color(135,86,106));
        //getContentPane().setBackground(new java.awt.Color(204,230,255));
        getContentPane().setBackground(new java.awt.Color(255,204,242));


        //label
        lab = new JLabel("Topic Analyser");
        lab.setHorizontalAlignment(JLabel.CENTER);
        lab.setVerticalAlignment(JLabel.CENTER);
        lab.setBounds(50,50,100,30);
        lab.setFont(new Font("plain", Font.BOLD, 46));
        //yellow
        //lab.setForeground(new java.awt.Color(216,229,75));
        //lab.setForeground(new java.awt.Color(255,230,204));
     //green   lab.setForeground(new java.awt.Color(131,178,57));

        lab.setForeground(new java.awt.Color(255,148,77));

        add(lab);
        //create button for file chooser
        chooseATextFileButton = new JButton("Choose a text file");
        add(chooseATextFileButton);
        //change colour for button
        //blue
        //chooseATextFileButton.setBackground(new java.awt.Color(86,134,135));
       // 204, 255, 217
        chooseATextFileButton.setBackground(new java.awt.Color(153,179,255));
        //chooseATextFileButton.setBackground(new java.awt.Color(179,236,255));

        //chooseATextFileButton.setForeground(new java.awt.Color(255,255,255));
        //chooseATextFileButton.setFont(chooseATextFileButton.getFont().deriveFont(Font.BOLD));
        chooseATextFileButton.addActionListener(this);

        //create a button for showing the result
        showResultButton = new JButton("Show Result");
        add(showResultButton);
        //green
       // showResultButton.setBackground(new java.awt.Color(87,135,83));
        //showResultButton.setBackground(new java.awt.Color(204,255,204));
        showResultButton.setBackground(new java.awt.Color(217,179,255));

        //showResultButton.setForeground(new java.awt.Color(255,255,255));
        showResultButton.addActionListener(this);

        setVisible(true);

    }


            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (e.getSource() == chooseATextFileButton)
                {
                    //-------------------------------file chooser
                    /*
                        The code below relating to JFileChooser is taken from this website:
                        https://www.mkyong.com/swing/java-swing-jfilechooser-example/
                     */
                    JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());


                    //filter to select only text files
                    jfc.setDialogTitle("Select a text file");
                    jfc.setAcceptAllFileFilterUsed(false);
                    FileNameExtensionFilter filter = new FileNameExtensionFilter("Text File only", "txt");
                    jfc.addChoosableFileFilter(filter);

                    int returnValue = jfc.showOpenDialog(null);
                    // int returnValue = jfc.showSaveDialog(null);

                    if (returnValue == JFileChooser.APPROVE_OPTION)
                    {
                        //File selectedFile = jfc.getSelectedFile();
                        String read_in_file = jfc.getSelectedFile().getPath();

                        System.out.println(read_in_file);

                        //instantiate the object calls filereader
                        Read_file fileReader = new Read_file(read_in_file);
                        //call the function to open the file
                        fileReader.openFile();
                        //return an array list as the result of read in the line from a file
                        ArrayList<String> arr_word = fileReader.readLine();


                        //remove the stop words
                        Check_for_stop_words testing = new Check_for_stop_words(arr_word);

                        ArrayList<String> checked_arr = testing.check(); //removed all the stop words.


                        //repeating words
                        Repeat_words repeating = new Repeat_words(checked_arr);
                        repeating.counting();

                    }
                }
                else if (e.getSource() == showResultButton)
                {
                    String lem = "the show button is clicked";
                    JOptionPane.showMessageDialog(this, lem);
                }
            }


}
