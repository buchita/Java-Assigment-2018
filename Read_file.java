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
    String fileName;
    File fleExample;
    ArrayList<String> words = new ArrayList<>();



    //Constructor just takes in the file name
    public Read_file(String fileName)
    {
        this.fileName = fileName;
    }



    //Open the file and convert from string to file
    public void openFile()
    {
        fleExample = new File(fileName);

    }


    // read a line from the file, return the line as a String
    public void readLine()
    {
        String line = "no line in file";
        try
        {
            // I don't need the scanner in any other method, so I can create it here.
            Scanner myScanner = new Scanner(fleExample);


            while(myScanner.hasNextLine())
            {

                    line = myScanner.nextLine();
                    words.add(line);
                    System.out.println (words);

                /*for (int i=0; i< myScanner.length(); i++)
                {
                    readin_arr[i] = myScanner.nextLine();
                }*/

            }


            myScanner.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }

        //return line;


    } // readLine

    @Override
    public String toString() {
        return "Read_file{" +
                "fileName='" + fileName + '\'' +
                ", fleExample=" + fleExample +
                '}';
    }

}
