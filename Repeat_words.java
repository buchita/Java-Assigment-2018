/*
    PURPOSE: To count how many times the word has occurred.

    DATE : 31/03/2018

    AUTHOR : BUCHITA

    reference: http://www.codevscolor.com/java-count-words-repeating-words/

*/



package File;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Repeat_words
{
    //attributes
    private ArrayList<String> arr_repeating = new ArrayList<>();
    int counter =0;

    //constructor
    public Repeat_words(ArrayList<String> arr_repeating) {
        this.arr_repeating = arr_repeating;
    }


    //getter and setter
    public ArrayList<String> getArr_repeating() {
        return arr_repeating;
    }

    public void setArr_repeating(ArrayList<String> arr_repeating) {
        this.arr_repeating = arr_repeating;
    }


    //method
    public void counting()
    {

        int count;

        //hashmap acts like dictionary in python. has keys and values. in this case its storing String and Integer
        //create HashMap to store each word and count of that word.
        //word is stored as key and count is stored as value
        HashMap<String, Integer> map = new HashMap<>();

        //scan each word in the array in. read in one by one.
        for (String word : arr_repeating)
        {
            //check if hashmap contains that word or not.
            if (map.containsKey(word))
            {
                //increment count
                count = map.get(word);
                //store the updated count as value or that word
                map.put(word, count+1);
            }
            else //no repeating the word
            {
                map.put(word, 1);
            }
        }

        //print out the keys and values in the hashmap
        for (Map.Entry<String, Integer> entry : map.entrySet())
        {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }


    }
}
