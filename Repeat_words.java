/*
    PURPOSE: To count how many times the word has occurred.

    START DATE : 31/03/2018

    AUTHOR : BUCHITA

    reference:  http://www.codevscolor.com/java-count-words-repeating-words/
                https://stackoverflow.com/questions/21465821/how-to-get-5-highest-values-from-a-hashmap

    COMPILER: Intellij

*/

package File;

import java.net.Inet4Address;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Repeat_words {
    //attributes
    private ArrayList<String> arr_repeating = new ArrayList<>();
    String line1;
    String line2;


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
    public String counting() {
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
        for (int i = 0; i < arr_repeating.size(); i++) {
            //check if HashMap contains that word or not.
            if (map.containsKey(arr_repeating.get(i))) {
                //increment count
                count = map.get(arr_repeating.get(i));

                //store the updated count as value or that word
                map.put(arr_repeating.get(i), count + 1);
            } else //no repeating the word
            {
                map.put(arr_repeating.get(i), 1);
            }
            // System.out.println(map);
        }
//----------------------------------------------------------------------------------------------------------------------
        /*
            The code below relating to iterator is taken and modified from this website:
            https://stackoverflow.com/questions/21465821/how-to-get-5-highest-values-from-a-hashmap
        */
        //create an iterator to keyset of hashmap in order to be able to remove an entry in the hashmap
        //       Iterator<Map.Entry<String, Integer>> entryItr = map.entrySet().iterator();


  /*      //keep track on the element which has been stored in the array
        int counter = 0;


            //while is not the end of HashMap
            while(entryItr.hasNext())
            {
                    //find the highest value in the map
                    int maxValueInMap = (Collections.max(map.values()));
                    System.out.println("The max num of repeating: " + maxValueInMap);

                    //create 'entry' which stores all the elements from map
                    Map.Entry<String, Integer> entry = entryItr.next();

                    //find the matching value from the entry
                    if (maxValueInMap == entry.getValue()) {
                        //counter to get only 5 highest repeated words
                        //counter++;

                        //add in values and keys
                        top_5.add(entry.getValue());
                        //System.out.println(top_5);

                        top_five.add(entry.getKey());
                        //System.out.println(top_five);

                        //remove the element which is the highest
                        entryItr.remove();
                        System.out.println("max value is: " + maxValueInMap);

                    }

            }
*/
        /*
            code below is taken from this website to sort values in ascending order in HashMap i
            https://stackoverflow.com/questions/109383/sort-a-mapkey-value-by-values
         */
        // map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).forEach(System.out::println);
      /*  for (String key: sorted.keySet())
        {
            System.out.println(key);
        }
*/

//        Stream<Map.Entry<String, Integer>> sorted = map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect();

//https://stackoverflow.com/questions/3605237/how-print-out-the-contents-of-a-hashmapstring-string-in-ascending-order-based
//-----------------------------------------------------------------------------------------------------------------------
        /*
            code below is taken from this website to sort the map ascending oder
            https://www.mkyong.com/java/how-to-sort-a-map-in-java/
         */
        //convert Hash Map to list of the map
        List<Map.Entry<String, Integer>> lis = new LinkedList<>(map.entrySet());

        //sort list with Collections.sort()
        //provide a custom comparator
        Collections.sort(lis, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                //this is the code to determine whether it will ascending or descending.
                //in this case it is ascending
                //for descending just swap o2 with o1
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        //loop the sorted list and put it into a new insertion order map linkedhashmap
        Map<String, Integer> sortedmap = new LinkedHashMap<>();

        for (Map.Entry<String, Integer> entry : lis) {
            sortedmap.put(entry.getKey(), entry.getValue());
        }
        /* ******************************************************************************* */
//        System.out.println(sortedmap);

        HashMap<String, Integer> words = new HashMap<>();
        ArrayList<String> top_word = new ArrayList<>();

        //store the words in ascending order in an array list
        for (Map.Entry<String, Integer> entry : sortedmap.entrySet()) {
            top_word.add(entry.getKey());

        }
        System.out.println(top_word);

        String line = "";
        for (int i = 0; i < 10; i++) {
            line = line + " " + top_word.get(i);
        }


        return line;


        //convert to treemap
        //init the tree map
        // TreeMap<String, Integer> tree = new TreeMap<String, Integer>();
        // tree.putAll(map);
        // System.out.println("this is the treemap: "+tree);

    }//end of counting


    public void calculation()
    {

    }
}
