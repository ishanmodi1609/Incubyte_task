public class calculator {

    //returns zero on any given input of string
    public static int add(String test){
        if(test.isEmpty()){

            //This checks if string is empty than return 0
            return 0;
        }
        else{

            //If string contains digit then converts string to int and then returns that int
            return Integer.parseInt(test);
        }
    }
}
