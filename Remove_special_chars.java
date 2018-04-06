/*package File;


    ArrayList<String> top_5 = new ArrayList<>();
        int counter = 0;
       // Iterator<String> itr = map.keySet().iterator();
        do {

            //find the max num of repeating in the map HashMap
            int maxValueInMap = (Collections.max(map.values()));
            System.out.println("The max num of repeating: "+maxValueInMap);


            //iterate through HashMap map
            for ( Map.Entry<String, Integer> entry : map.entrySet()) //.entryset() = get both value and key
            {
                //find the matches highest value with the key
                if (maxValueInMap==entry.getValue())
                {
                    counter++;
                    //display the key with the highest value.
                    System.out.println("The most repeated word: "+entry.getKey());

                    top_5.add(entry.getKey());

                    //map.remove(entry.getKey());
                }
                //print out the keys and values in the HashMap
                //System.out.println(entry.getKey()+":"+entry.getValue());
            }
        }while (counter<5);


public class Remove_special_chars
{
    //attribute
    private String sen;

    //constructor
    public Remove_special_chars(String sen) {
        this.sen = sen;
    }

    //getter and setter
    public String getSen() {
        return sen;
    }

    public void setSen(String sen) {
        this.sen = sen;
    }



    //function to remove all the special characters
    public String special_char()
    {

        //removes full stops
        //couldn't replaceAll since the dot is a regex meta character that will match anything.
        sen = sen.replace(".","");

        //removes commas
        sen = sen.replaceAll(",","");

        //removes colons
        sen = sen.replaceAll(":","");

        //removes semicolons
        sen = sen.replaceAll(";","");

        //removes square brackets
        sen = sen.replaceAll("\\[","").replaceAll("\\]","");

        //removes parenthesis
        sen =sen.replaceAll("[()]","");

        //removes curly brackets
        sen = sen.replaceAll("[{}]","");

        //removes all the special characters not a-z A-Z 0-9. \s is a string escape character
        sen = sen.replaceAll("[^a-zA-Z0-9\\s]","");

        return sen;

    }

}
*/