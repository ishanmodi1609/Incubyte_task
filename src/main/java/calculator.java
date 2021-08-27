import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static org.hamcrest.Matchers.*;

import  ch.lambdaj.Lambda.*;
import software.amazon.ion.SystemSymbols;

public class calculator {

    //returns zero on any given input of string
    public static int add(String test){
        if(test.isEmpty()){

            //This checks if string is empty than return 0
            return 0;
        }
        else{

            //If string contains elimiter than it first converts string into 2 tokens among delimiter
            // Ex:- "1,2" this converts into tokesn "1" and "2"
            //Delimiter invloved here are ',' and '\n'
            //'|' is used for sepereating delimoters

            String nums="";
            String CustomDelimiter="";
            String tokens[];

            //If string starts with '//' then we have defined our own custom delineter
            if(test.startsWith("//[")){
                tokens=splitOnAnyLengthCustomDelimiter(test);
            }
            else if(test.startsWith("//")){
                tokens=splitOnCustomDelimiter(test);
            }
            else{
                tokens=test.split(",|\n");
            }

            //We convert the array of token into the List of integer
            List<Integer> numbers=convert(tokens);

            //This list contains negative Integers which are filtered out

            List<Integer> negative = filter(0,numbers);

            //If atlease one negative number is in list it throws exception
            if(negative.size()>0){
                throw new RuntimeException("Negatives are not allowed: -1");
            }

            List<Integer>validNumbers=rangeNumber(numbers);

            //Return the sum of all the numbers present in the list
            return sum(validNumbers);
        }
    }

    //This function separtes the number from given string based on the first custom delimiter given in []
    private  static  String[] splitOnAnyLengthCustomDelimiter(String test){

        Matcher m = Pattern.compile("//(\\[.+\\])+\n(.*)").matcher(test);
        m.matches();
        String del = m.group(1);
        String delimeters = new String();

        int l = del.length(),last =0;
        for(int i =0; i<l ; i++)
        {
            if(del.charAt(i) == ']' && i != l-1)
            {
                delimeters += del.substring(last,i);
                delimeters += "]|";
                last = i+1;
            }

            else if(i == l-1)
                delimeters += del.substring(last,i) + "]";
        }
        String nums = m.group(2);

        //System.out.println(nums+"  "+delimeters);

        String tokens[];

        tokens=nums.split(delimeters);

        return tokens;
    }
    //This function is made to split the number form string having custom delimiter
    private static String[] splitOnCustomDelimiter(String test){

        String nums="";
        String tokens[];
        String CustomDelimiter="";

        Matcher m= Pattern.compile("//(.)\n(.*)").matcher(test);
        m.matches();
        CustomDelimiter=m.group(1);
        nums=m.group(2);
        tokens=nums.split(Pattern.quote(CustomDelimiter));

        return tokens;
    }
    //This function converts the tokens of string into list of integer then returs it
    private static List<Integer> convert(String tokens[]){

        //System.out.println("In cpnvert");
        List<Integer>numbers=new ArrayList<>();

        String q="";
        int e;

        for(int i=0;i<tokens.length;i++){
            System.out.println(tokens[i]);
            if(tokens[i].isEmpty()){
                numbers.add(0);
                continue;
            }

            Matcher mx = Pattern.compile("^(\\+|-)?\\d+$").matcher(tokens[i]);

            while(mx.find())
            {
            //    System.out.println("in");

                q = mx.group();
                e = Integer.parseInt(q);

            //    System.out.println("e:"+e);
                numbers.add(e);
            }

        }

        return numbers;
    }

    //This function calculate the sum of all inetger present in the list
    private static int sum(List<Integer>numbers){

        int sum=0;

        for(int i:numbers){
            sum=sum+i;
        }

        return sum;
    }
    //This is the method decalred private so that can used only in this file
    //It accepts the string then converts into int
    //If string does not contain it can throw NumberFormat exception , so throws is used with method

    private static int toInt(String s) throws NumberFormatException{
        return Integer.parseInt(s);
    }

    //This function used to extract all the numbers which are negatives and then return list containg negative number
    private  static  List<Integer> filter(int lessThan,List<Integer>numbers){

        List<Integer>negative=new ArrayList<>();

        for(int i:numbers){
            if(i<0)
                negative.add(i);
        }

        return negative;
    }

    //This function works to collect all the numbers which are less than 2000
    private  static  List<Integer> rangeNumber(List<Integer>numbers){

        List<Integer>rangeNumber=new ArrayList<>();

        for(int i:numbers){
            if(i<=1000 && i>=0)
            //    System.out.println(i);
                rangeNumber.add(i);
        }

        return rangeNumber;
    }
}
