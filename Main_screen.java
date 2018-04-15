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

public class Main_screen extends JFrame implements ActionListener {

    //attributes
    private JButton choosetext1;
    private JButton addinstop;
    private JButton exit;
    private JLabel lab;
    private JButton b;


    //getters and setters
    public JButton getChoosetext1() {
        return choosetext1;
    }

    public void setChoosetext1(JButton choosetext1) {
        this.choosetext1 = choosetext1;
    }

    public JButton getChoosetext2() {
        return addinstop;
    }

    public void setChoosetext2(JButton choosetext2) {
        this.addinstop = addinstop;
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

    public JButton getAddinstop() {
        return addinstop;
    }
    public void setAddinstop(JButton addinstop) {
        this.addinstop = addinstop;
    }
    public JButton getExit() {
        return exit;
    }
    public void setExit(JButton exit) {
        this.exit = exit;
    }



    //constructor taken a string
    public Main_screen(String title)
    {
        super(title);
        setSize(400, 400);
        setLayout(new FlowLayout());


        //set colour JFrame to pink
        getContentPane().setBackground(new java.awt.Color(255, 204, 242));

        //label
        lab = new JLabel("Topic Analyser"); //name the label as topic analyser
        lab.setHorizontalAlignment(JLabel.CENTER);  //make the label center
        lab.setVerticalAlignment(JLabel.CENTER);    //make the label center
        lab.setFont(new Font("plain", Font.BOLD, 46));  //set font
        lab.setForeground(new java.awt.Color(255, 170, 0)); //set the colour of the label
        add(lab);   //add label to the JFrame

        //create button for file chooser
        choosetext1 = new JButton("Choose a text file");
        choosetext1.setBackground(new java.awt.Color(153, 179, 255));   //change colour for button
        add(choosetext1);
        choosetext1.addActionListener(this);

        //create a button for add in a stop word
        addinstop = new JButton("Add in a stop word");
        addinstop.setBackground(new java.awt.Color(217, 179, 255)); //change the colour for the button
        add(addinstop);
        addinstop.addActionListener(this);

        //close the window
        exit = new JButton("Close the window");
        exit.setBackground(new java.awt.Color(159,255,128));
        add(exit);
        exit.addActionListener(this);

        //set everything visible
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String line1;
        String line2;
        ArrayList<String> checkedarr1;
        ArrayList<String> checkedarr2;

        if (e.getSource() == choosetext1) {
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
                /* **************************************************************  */ {
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
                String sen = "The top 10 common words from " + read_in_file + " is: " + line1;
                JOptionPane.showMessageDialog(this, sen);

                        /*
                            The code that is relating to yes or no window is taken and modified from this website
                            https://alvinalexander.com/java/java-joptionpane-showoptiondialog-examples
                         */
                int choice = JOptionPane.showOptionDialog(null, "Select another file??", "File?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
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

                    if (returnValue2 == JFileChooser.APPROVE_OPTION) {

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

                        int choice2 = JOptionPane.showOptionDialog(null, "See the common words between these 2 files??", "Common Words?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

                        String word1[];
                        ArrayList<String> common = new ArrayList<>();

                        if (choice2 == JOptionPane.YES_OPTION) {
                            String commonstr = "";
                            String cmline;

                            //split-whitespaces and put in the array
                            word1 = line1.split("\\s+");

                            //check for the sub string from array in the string of top repeating words.
                            for (int i = 0; i < word1.length; i++) {
                                //if line 2 has a substring of element in the array from line 1
                                if (line2.contains(word1[i])) {
                                    //add the word in the array
                                    common.add(word1[i]);
                                }
                            }

                            //convert common words into a string to display in the GUI
                            for (int i = 0; i < common.size(); i++) {
                                commonstr = commonstr + " " + common.get(i);
                            }

                            System.out.println("the legth:" +commonstr.length());
                            //check if the string is empty i.e no common words
                            if (commonstr.length()>1) {
                                cmline =  "The common words between the 2 files:" + commonstr;
                            } else {
                                cmline = "There is no common word between these 2 files";
                            }

                            JOptionPane.showMessageDialog(this, cmline);
                        }

                    }//
                }
            }
        }
        else if (e.getSource() == addinstop)
        {
            /*
                The code below is taken from this website.
                https://alvinalexander.com/java/joptionpane-showinputdialog-examples
             */
            String stopword = JOptionPane.showInputDialog(this, "Enter a Stop word");
            /* *********************************************************************************************** */
            int sure = JOptionPane.showOptionDialog(null, "Are you sure you want to add this word in?", "Stop Word", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

            if (sure == JOptionPane.YES_OPTION) {
                Check_for_stop_words theword = new Check_for_stop_words(stopword);
                theword.addstopword();
            }
        }
        else if (e.getSource() == exit)
        {
            System.exit(0);
        }

    }

}