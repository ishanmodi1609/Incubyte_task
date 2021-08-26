import org.junit.*;

public class calculatorTest {

    //This is the function to check output on empty string
    //Ans should be zero
    @Test
    public void shouldReturnZeroEmpty(){
        Assert.assertEquals(0,calculator.add(""));
    }
}
