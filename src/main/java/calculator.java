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
            return Integer.parseInt(tokens[0])+Integer.parseInt(tokens[1]);
        }
        else{

            //If string contains digit then converts string to int and then returns that int
            return Integer.parseInt(test);
        }
    }
}
