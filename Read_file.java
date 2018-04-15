/*
    PURPOSE: open, read a file and add the contents in arraylist

    START DATE: 18/03/2018

    JAVA ASSIGNMENT - TOPIC ANALYSER

    COMPILER: Intellij


 */


package Com.TopicAnalyser;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Read_file
{
    // Attributes.
    private String fileName;
    private File fleExample;
    private ArrayList<String> words = new ArrayList<>();



    //Constructor just takes in the file name
    public Read_file(String fileName)
    {
        this.fileName = fileName;
    }



    //getters and setters
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public File getFleExample() {
        return fleExample;
    }

    public void setFleExample(File fleExample) {
        this.fleExample = fleExample;
    }

    public ArrayList<String> getWords() {
        return words;
    }

    public void setWords(ArrayList<String> words) {
        this.words = words;
    }



    //methods starts here
    //Open the file and convert from string to file
    public void openFile()
    {
        fleExample = new File(fileName);

    }


    // read a line from the file, return the line as a String
    public ArrayList<String> readLine()
    {
        String line;
        String sp[];

        try
        {
            Scanner myScanner = new Scanner(fleExample);

            //while its not the end of the file
            while(myScanner.hasNextLine())
            {
                //read in a line from the file
                line = myScanner.nextLine();

                //removes all the special characters not a-z A-Z 0-9. \s is a string escape character
                line = line.replaceAll("[^a-zA-Z0-9\\s]","");


                //split-whitespaces and put in the array
                sp = line.split("\\s+");

                //transfer into an arraylist
                for (int i =0; i<sp.length; i++)
                {

                    //make all the letters to lowercase
                    sp[i] = sp[i].toLowerCase();

                    //add in the arraylist
                    words.add(sp[i]);
                }

            }

            //close the scanner
            myScanner.close();
        }
        catch (FileNotFoundException e) //if there is no file found it will display the error message.
        {
            System.out.println(e.getMessage());
        }

        //return the array list back to main
        return words;
    } // readLine



}
