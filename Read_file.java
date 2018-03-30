/*
    PURPOSE: open, read a file and add the contents in arraylist

    DATE: 18/03/2018

    JAVA ASSIGNMENT - TOPIC ANALYSER
 */



package File;

import java.io.File;
import java.io.FileNotFoundException;
//import java.io.PrintWriter;
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
        String line = "no line in file";
        try
        {
            Scanner myScanner = new Scanner(fleExample);

            while(myScanner.hasNextLine())
            {
                //read in a line
                line = myScanner.nextLine();

                line = line.replaceAll(",","");
                line = line.replace(".","");
                line = line.replaceAll(":","");




                //split-whitespaces and put in the array
                String sp[] = line.split("\\s+");



                //transfer into an arraylist
                for (int i =0; i<sp.length; i++)
                {

                    //make all the letters to lowercase
                    sp[i] = sp[i].toLowerCase();


                    //add in the arraylist
                    words.add(sp[i]);
                }

            }

            //print out the entire array list

            System.out.println (words.size());

            myScanner.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }

        return words;
    } // readLine



}
