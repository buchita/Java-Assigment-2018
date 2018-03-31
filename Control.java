/*
    PURPOSE : Main - controlling the events

    DATE : 30/03/2018

    Java Assignment - topic analyser

*/


package File;

import java.util.ArrayList;

public class Control
{
    public static void main(String[] args)
    {

        //instantiate the object calls filereader
        Read_file fileReader = new Read_file("something.txt");
        //call the function to open the file
        fileReader.openFile();
        //return an array list as the result of read in the line from a file
        ArrayList<String> arr_word = fileReader.readLine();


       //remove the stop words
       Check_for_stop_words testing = new Check_for_stop_words(arr_word);

       ArrayList<String> checked_arr = testing.check(); //removed all the stop words.

       System.out.println(checked_arr);

       //repeating words
       Repeat_words repeating = new Repeat_words(checked_arr);
       repeating.counting();

    }
}
