import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import  ch.lambdaj.Lambda.*;

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
            if(test.startsWith("//")){

                Matcher m= Pattern.compile("//(.)\n(.*)").matcher(test);
                m.matches();
                CustomDelimiter=m.group(1);
                nums=m.group(2);
                tokens=nums.split(CustomDelimiter);
            }
            else{

                System.out.println("Inside2");
                tokens=test.split(",|\n");
            }

            //We convert the array of token into the List of integer
            List<Integer> numbers=convert(tokens);

            //Return the sum of all the numbers present in the list
            return sum(numbers);
        }
    }

    //This function converts the tokens of string into list of integer then returs it
    private static List<Integer> convert(String tokens[]){

        List<Integer>numbers=new ArrayList<>();

        for(int i=0;i<tokens.length;i++){
            System.out.println(tokens[i]);
            numbers.add(toInt(tokens[i]));
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
}
