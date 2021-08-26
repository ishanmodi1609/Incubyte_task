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
            String tokens[]=test.split(",");

            //both tokesn that is stored in an array gets converted into integr and then added
            return toInt(tokens[0])+toInt(tokens[1]);
        }
        else{

            //If string contains digit then converts string to int and then returns that int
            return Integer.parseInt(test);
        }
    }

    //This is the method decalred private so that can used only in this file
    //It accepts the string then converts into int
    //If string does not contain it can throw NumberFormat exception , so throws is used with method

    private static int toInt(String s) throws NumberFormatException{
        return Integer.parseInt(s);
    }
}
