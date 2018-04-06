/*
    PURPOSE: checking for stop words

    START DATE : 30/03/2018

    Java Assignment - Topic Analyser

    COMPILER: Intellij

*/

package File;

import java.util.*;

public class Check_for_stop_words {
    //attribute
    private ArrayList<String> arr_checking = new ArrayList<>();

    //array of stop words
    private String stop_words[] = {"a", "about", "above", "after", "again", "against", "all", "am", "an", "and", "any", "are", "aren't", "as", "at", "be", "because", "been", "before",
            "being", "below", "between", "both", "but", "by", "can't", "cannot", "could", "couldn't", "did", "didn't", "do", "does", "doesn't", "doing", "don't", "down",
            "during", "each", "few", "for", "from", "further", "had", "hadn't", "has", "hasn't", "have", "haven't", "having", "he", "he'd", "he'll", "he's", "her", "here",
            "here's", "hers", "herself", "him", "himself", "his", "how", "how's", "i", "i'd", "i'll", "i'm", "i've", "if", "in", "into", "is", "isn't", "it", "it's", "its",
            "itself", "let's", "me", "more", "most", "mustn't", "my", "myself", "no", "nor", "not", "of", "off", "on", "once", "only", "or", "other", "ought", "our", "ours",
            "ourselves", "out", "over", "own", "same", "shan't", "she", "she'd", "she'll", "she's", "should", "shouldn't", "so", "some", "such", "than", "that", "that's",
            "the", "their", "theirs", "them", "themselves", "then", "there", "there's", "these", "they", "they'd", "they'll", "they're", "they've", "this", "those", "through",
            "to", "too", "under", "until", "up", "very", "was", "wasn't", "we", "we'd", "we'll", "we're", "we've", "were", "weren't", "what", "what's", "when", "when's",
            "where", "where's", "which", "while", "who", "who's", "whom", "why", "why's", "with", "won't", "would", "wouldn't", "you", "you'd", "you'll", "you're", "you've",
            "your", "yours", "yourself", "yourselves"
    };



    //constructor
    public Check_for_stop_words(ArrayList<String> arr_checking) {
        this.arr_checking = arr_checking;
    }

    //getter and setter
    public ArrayList<String> getArr_checking() {
        return arr_checking;
    }

    public void setArr_checking(ArrayList<String> arr_checking) {
        this.arr_checking = arr_checking;
    }

    public String[] getStop_words() {
        return stop_words;
    }

    public void setStop_words(String[] stop_words) {
        this.stop_words = stop_words;
    }



    //methods
    public ArrayList<String> check() //to check if the content contains any stop words if so remove them.
    {

        //sort the array alphabetically
        Collections.sort(arr_checking);

        for (int i =0; i<stop_words.length; i++)
        {
            //check if the arraylist contains any stop words
            while(arr_checking.contains(stop_words[i]))
            {
                //print out what it contains
                //System.out.println("yes it contains: "+stop_words[i]);

                //remove the word from arraylist
                arr_checking.remove(stop_words[i]); //stop_word[i] = the word that is contained in the array list
            }

        }

       // System.out.println(arr_checking.size());
        //System.out.println(arr_checking);

        return arr_checking;

    }





}
