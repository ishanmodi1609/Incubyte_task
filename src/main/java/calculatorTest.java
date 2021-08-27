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

    //This is test case made to check if custom delimiter is special regex then if some returns or not
    @Test
    public void customDelimiterAlsoBeSpecialRegex(){
        Assert.assertEquals(3,calculator.add("//.\n1.2"));
    }

    //This tetcase to check if exception is raised if negative value is present in the string
    @Test
    public void shouldRaiseException(){
        try {
            calculator.add("-1,2,3");
            Assert.fail("exception accepted");
        }
        catch (Exception e){
            Assert.assertEquals("Negatives are not allowed: -1",e.getMessage());
        }
    }

    //This is test case made to check if number greater than 1000 are ignored or not
    @Test
    public void greaterNumberShouldGetIgnored(){
        Assert.assertEquals(3,calculator.add("//.\n1.2.2000"));
    }

    //This is test case made to check on any length given custom delimiter
    @Test
    public void anyLengthCustomDelimiter(){
        Assert.assertEquals(6,calculator.add("//[***]\n1***2***3"));
    }

    //This tetcase is made for multiple dlimiter used in the string
    @Test
    public void multipleDelimeter() {
        Assert.assertEquals(6, calculator.add("//[*][%]\n1*2%3"));
    }

    //This testcase deals with multiple delimiter of various lenghtd each
    @Test
    public void mulCustomDelWithAnyLength()
    {
        Assert.assertEquals(6, calculator.add("//[**][%%%%]\n1**2%%3"));
    }
}
