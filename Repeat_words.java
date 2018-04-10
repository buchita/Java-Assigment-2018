/*
    PURPOSE: To count how many times the word has occurred.

    START DATE : 31/03/2018

    AUTHOR : BUCHITA

    reference:  http://www.codevscolor.com/java-count-words-repeating-words/
                https://stackoverflow.com/questions/21465821/how-to-get-5-highest-values-from-a-hashmap

    COMPILER: Intellij

*/

package File;

import java.util.*;

public class Repeat_words
{
    //attributes
    private ArrayList<String> arr_repeating = new ArrayList<>();

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
        //HashMap acts like dictionary in python. Has keys and values. In this case it's storing String and Integer
        //create HashMap to store each word and count of that word.
        //word is stored as key and count is stored as value
        HashMap<String, Integer> map = new HashMap<>();
        int count;

        /*
            The code for counting repeating words is taken and modified from this website:
            http://www.codevscolor.com/java-count-words-repeating-words/
         */
        //scan each word in the array in . read in one by one.
        for(int i =0; i<arr_repeating.size(); i++)
        {
            //check if HashMap contains that word or not.
            if (map.containsKey(arr_repeating.get(i)))
            {
                //increment count
                count = map.get(arr_repeating.get(i));

                //store the updated count as value or that word
                map.put(arr_repeating.get(i), count+1);
            }
            else //no repeating the word
            {
                map.put(arr_repeating.get(i), 1);
            }
//            System.out.println(map);
        }

        /*
            The code below relating to iterator is taken and modified from this website:
            https://stackoverflow.com/questions/21465821/how-to-get-5-highest-values-from-a-hashmap
        */
        //create an iterator to keyset of hashmap in order to be able to remove an entry in the hashmap
        Iterator<Map.Entry<String, Integer>> entryItr = map.entrySet().iterator();

        //store the top 5
        ArrayList<Integer> top_5 = new ArrayList<>();
        ArrayList<String> top_five = new ArrayList<>();

        //keep track on the element which has been stored in the array
       // int counter = 0;

      // while (counter < 10){
            //while is not the end of HashMap
            while(entryItr.hasNext())
            {
                //find the highest value in the map
                int maxValueInMap = (Collections.max(map.values()));
                 System.out.println("The max num of repeating: "+maxValueInMap);

                //create 'entry' which stores all the elements from map
                Map.Entry<String, Integer> entry = entryItr.next();

                //find the matching value from the entry
                while (maxValueInMap==entry.getValue())
                {
                    //counter to get only 5 highest repeated words
                   // counter++;

                    //add in values and keys
                    top_5.add(entry.getValue());
                    //System.out.println(top_5);

                    top_five.add(entry.getKey());
                    //System.out.println(top_five);

                    //remove the element which is the highest
                    entryItr.remove();
                    System.out.println("max value is: "+maxValueInMap);

                }
            }
        //need only top 10 elements
       // }//while (counter<5);

        System.out.println(top_5);
        System.out.println(top_five);



    }
}
