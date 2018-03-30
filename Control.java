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

        //open and read the file
        Read_file fileReader = new Read_file("something.txt");
        fileReader.openFile();
        ArrayList<String> arr_word = fileReader.readLine();

       System.out.println(arr_word);

       //remove the stop words
       Check_for_stop_words testing = new Check_for_stop_words(arr_word);
       ArrayList<String> checked_arr = testing.check();

     //  System.out.println(checked_arr);


    }
}
