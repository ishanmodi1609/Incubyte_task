import org.junit.*;

public class calculatorTest {
    @Test

    //This is the function to check output on empty string
    //Ans should be zero


    public void shouldReturnZeroEmpty(String s){
        Assert.assertEquals(0,calculator.add(""));
    }
}
