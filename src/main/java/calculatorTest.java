import org.junit.*;

public class calculatorTest {

    //This is the function to check output on empty string
    //Ans should be zero
    @Test
    public void shouldReturnZeroEmpty(){
        Assert.assertEquals(0,calculator.add(""));
    }

    //This is the function to check output on one digit string
    //Ans should be that number
    @Test
    public void shouldReturnNumber(){
        Assert.assertEquals(2,calculator.add("2"));
    }

    //This is the function to add 2 numbers involved in the string
    //Ans should be sum of those 2 nummbers
    @Test
    public void shouldReturnSumTwoNumber(){
        Assert.assertEquals(3,calculator.add("1,2"));
    }

    //This is the function to add 3 numbers involved in the string
    //Ans should be sum of those 3 nummbers
    @Test
    public void shouldReturnSumThreeNumber(){
        Assert.assertEquals(6,calculator.add("1,2,3"));
    }

    //This test case is used for checking '\n' delimiter
    @Test
    public void shouldAcceptNewLineAsValidDelimiter(){
        Assert.assertEquals(6,calculator.add("1\n2,3"));
    }

    //This is test case made to check custom delimiter
    @Test
    public void acceptCustomDelimiterSyntax(){
        Assert.assertEquals(3,calculator.add("//:\n1:2"));
    }
}
