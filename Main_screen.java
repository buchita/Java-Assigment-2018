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
    private JButton choosetext1;
    private JButton choosetext2;
    private JButton compare;
    private JLabel lab;
    private JButton b;

    public JButton getChoosetext1() {
        return choosetext1;
    }

    public void setChoosetext1(JButton choosetext1) {
        this.choosetext1 = choosetext1;
    }

    public JButton getChoosetext2() {
        return choosetext2;
    }

    public void setChoosetext2(JButton choosetext2) {
        this.choosetext2 = choosetext2;
    }

    public JLabel getLab() {
        return lab;
    }

    public void setLab(JLabel lab) {
        this.lab = lab;
    }

    public JButton getB() {
        return b;
    }

    public void setB(JButton b) {
        this.b = b;
    }



    //constructor
    public Main_screen(String title)
    {
        super(title);
        setSize(400,400);
        setLayout(new FlowLayout());


        //set colour JFrame to purple
        getContentPane().setBackground(new java.awt.Color(255,204,242));


        //label
        lab = new JLabel("Topic Analyser");
        lab.setHorizontalAlignment(JLabel.CENTER);
        lab.setVerticalAlignment(JLabel.CENTER);
        lab.setBounds(50,50,100,30);
        lab.setFont(new Font("plain", Font.BOLD, 46));
        lab.setForeground(new java.awt.Color(255,170,0)); //orange - 255,148,77
        add(lab);

        //create button for file chooser
        choosetext1 = new JButton("Choose a text file");
        add(choosetext1);

        //change colour for button
        choosetext1.setBackground(new java.awt.Color(153,179,255));
        choosetext1.addActionListener(this);

        //create a button for another file chooser
        choosetext2= new JButton("Choose another text file");
        add(choosetext2);

        //change the colour for the button
        choosetext2.setBackground(new java.awt.Color(217,179,255));
        choosetext2.addActionListener(this);

        //compare the 2 results
        compare = new JButton("Common Words between 2 files");
        add(compare);

        //change colour
        compare.setBackground(new java.awt.Color(159,255,128));
        compare.addActionListener(this);

        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
                String line1;
                String line2;
                ArrayList<String> checkedarr1;
                ArrayList<String> checkedarr2;

                if (e.getSource() == choosetext1)
                {
                    //-------------------------------file chooser
                    /*
                        The code below relating to JFileChooser is taken from this website:
                        https://www.mkyong.com/swing/java-swing-jfilechooser-example/
                    ----------*/

                    //instantiate a filechooser and get the window with the home directory
                    JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

                    //filter to select only text files
                    jfc.setDialogTitle("Select a text file");
                    //set filter to text file only
                    jfc.setAcceptAllFileFilterUsed(false);
                    FileNameExtensionFilter filter = new FileNameExtensionFilter("Text File only", "txt");
                    jfc.addChoosableFileFilter(filter);

                    int returnValue = jfc.showOpenDialog(null);

                    if (returnValue == JFileChooser.APPROVE_OPTION)
                    /* **************************************************************  */
                    {
                        //File selectedFile = jfc.getSelectedFile();
                        String read_in_file = jfc.getSelectedFile().getPath();

                        //System.out.println(read_in_file);

                        //instantiate the object calls filereader
                        Read_file fileReader = new Read_file(read_in_file);

                        //call the function to open the file
                        fileReader.openFile();

                        //return an array list as the result of read in the line from a file
                        ArrayList<String> arr_word = fileReader.readLine();


                        //remove the stop words
                        Check_for_stop_words testing = new Check_for_stop_words(arr_word);
                        checkedarr1 = testing.check(); //removed all the stop words.

                        //repeating words
                        Repeat_words repeating = new Repeat_words(checkedarr1);
                        line1 = repeating.counting();
                        String sen = "The top 10 common words from "+read_in_file+ " is: "+ line1;
                        JOptionPane.showMessageDialog(this, sen);

                        /*
                            The code that is relating to yes or no window is taken and modified from this website
                            https://alvinalexander.com/java/java-joptionpane-showoptiondialog-examples
                         */
                        int choice = JOptionPane.showOptionDialog(null, "Select another file??","File?",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,null,null);
                        /* ********************************************************************************* */
                        if (choice == JOptionPane.YES_OPTION) {

                            //-------------------------------file chooser
                            /*
                                The code below relating to JFileChooser is taken from this website:
                                https://www.mkyong.com/swing/java-swing-jfilechooser-example/
                            ----------*/

                            //instantiate a filechooser and get the window with the home directory
                            JFileChooser jfc2 = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());


                            //filter to select only text files
                            jfc2.setDialogTitle("Select a text file");
                            //set filter to text file only
                            jfc2.setAcceptAllFileFilterUsed(false);
                            FileNameExtensionFilter filter2 = new FileNameExtensionFilter("Text File only", "txt");
                            jfc2.addChoosableFileFilter(filter2);


                            int returnValue2 = jfc2.showOpenDialog(null);

                            if (returnValue2 == JFileChooser.APPROVE_OPTION)
                            {

                                String read_in_file2 = jfc2.getSelectedFile().getPath();

                                //instantiate the object calls filereader
                                Read_file fileReader2 = new Read_file(read_in_file2);

                                //call the function to open the file
                                fileReader2.openFile();

                                //return an array list as the result of read in the line from a file
                                ArrayList<String> arr_word2 = fileReader2.readLine();


                                //remove the stop words
                                Check_for_stop_words testing2 = new Check_for_stop_words(arr_word2);

                                checkedarr2 = testing2.check(); //removed all the stop words.


                                //repeating words
                                Repeat_words repeating2 = new Repeat_words(checkedarr2);

                                line2 = repeating2.counting();
                                String sen2 = "The top 10 common words from " + read_in_file + " is: " + line2;
                                JOptionPane.showMessageDialog(this, sen2);

                                int choice2 = JOptionPane.showOptionDialog(null, "See the common words between these 2 files??","Common Words?",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,null,null);

                                String word1[];
                                ArrayList<String> common = new ArrayList<>();
                                if (choice2 == JOptionPane.YES_OPTION)
                                {
                                    System.out.println(line1);
                                    System.out.println(line2);

                                    line2.replaceAll(" ","");
                                    //split-whitespaces and put in the array
                                    word1 = line1.split("\\s+");
                                    line2.replaceAll(" ","");


                                    for (int i =0; i<word1.length; i++)
                                    {
                                        System.out.println(" this is the array: "+word1[i]);
                                        if (line2.contains(word1[i]))
                                        {
                                            common.add(word1[i]);
                                        }
                                    }
                                    System.out.println(common);
                                }

                            }//
                        }
                    }
                }
                else if (e.getSource() == choosetext2)
                {
                    String lem = "the show button is clicked";
                    JOptionPane.showMessageDialog(this, lem);

                    }
                }
        /*        else if (e.getSource() == compare)
                {

                    if (isClicked1 = true) {
                        if (isClicked2 = true) {
                            String li = " helow";
                            JOptionPane.showMessageDialog(this, li);
                            isClicked1 = false;
                            isClicked2 = false;

                            System.out.println(line1);
                            System.out.println(line2);
                            //int sizeArr1 = checkedarr1.size();
                            //JOptionPane.showMessageDialog(this, sizeArr1);

                        }

                    }
                    else
                    {
                        String error = "Please Select 2 files";
                        JOptionPane.showMessageDialog(this, error);

                    }
                }*/
    }

