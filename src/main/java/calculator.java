import java.util.*;
import  ch.lambdaj.Lambda.*;

public class calculator {

    //returns zero on any given input of string
    public static int add(String test){
        if(test.isEmpty()){

            //This checks if string is empty than return 0
            return 0;
        }
        else if(test.contains(",")){

            //If string contains elimiter than it first converts string into 2 tokens among delimiter
            // Ex:- "1,2" this converts into tokesn "1" and "2"
            //Delimiter invloved here are ',' and '\n'
            //'|' is used for sepereating delimoters
            String tokens[]=test.split(",|\n");

            //We convert the array of token into the List of integer
            List<Integer> numbers=convert(tokens);

            //Return the sum of all the numbers present in the list
            return sum(numbers);
        }
        else{

            //If string contains digit then converts string to int and then returns that int
            return Integer.parseInt(test);
        }
    }

    //This function converts the tokens of string into list of integer then returs it
    private static List<Integer> convert(String tokens[]){

        List<Integer>numbers=new ArrayList<>();

        for(int i=0;i<tokens.length;i++){
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
