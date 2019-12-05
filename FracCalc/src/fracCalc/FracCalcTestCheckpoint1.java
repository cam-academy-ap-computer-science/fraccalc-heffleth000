package fracCalc;
import java.util.*;
import org.junit.Test;

// Checkpoint 1-only tests
public class FracCalcTestCheckpoint1 {
    @Test public void testCheckpoint1_1() {  FracCalcTestALL.assertForEarlyCheckpoints("6_5/8", "whole:6 numerator:5 denominator:8", "12_3/8", FracCalc.produceAnswer("5_3/4 + 6_5/8"));}
    @Test public void testCheckpoint1_2() {FracCalcTestALL.assertForEarlyCheckpoints("20", "whole:20 numerator:0 denominator:1", "-20_3/7", FracCalc.produceAnswer("-3/7 - 20"));}
    @Test public void testCheckpoint1_3() {FracCalcTestALL.assertForEarlyCheckpoints("27/21", "whole:0 numerator:27 denominator:21", "-33_2/7", FracCalc.produceAnswer("-32 - 27/21"));}
	
    public static void main(String[] args) {
    	Scanner userInput = new Scanner (System.in);
    	System.out.print("What calculation should be performed? ");
    	String calc = userInput.nextLine();
    	produceAnswer(calc);
    	System.out.print(produceAnswer(calc)); //prints out the second fraction    	
    }
 
    public static String produceAnswer(String input) {
    	int length = input.length(); //length of input; is end of string
    	int space = input.indexOf(" "); //index of first space
    	int x = space + 3; //index of fraction after operator
    	String secondFrac = input.substring(x, length); //finds the second fraction
    	
    	String firstFrac = input.substring(0, space); //finds the first fraction
    	
    	String operator = input.substring(space, space + 2); //finds the operator
    	
        return secondFrac;
    }

}

