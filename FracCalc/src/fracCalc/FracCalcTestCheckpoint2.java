package fracCalc;

import org.junit.Test;

// Checkpoint 2-only tests
public class FracCalcTestCheckpoint2
{
    @Test public void testCheckpoint2_1() {  FracCalcTestALL.assertForEarlyCheckpoints(null, "whole:6 numerator:5 denominator:8", "12_3/8", FracCalc.produceAnswer("5_3/4 + 6_5/8"));}
    @Test public void testCheckpoint2_2() {  FracCalcTestALL.assertForEarlyCheckpoints(null, "whole:20 numerator:0 denominator:1", "-20_3/7", FracCalc.produceAnswer("-3/7 - 20"));}
    @Test public void testCheckpoint2_3() {  FracCalcTestALL.assertForEarlyCheckpoints(null, "whole:0 numerator:27 denominator:21", "-33_2/7", FracCalc.produceAnswer("-32 - 27/21"));}


}
/*
package fracCalc;
import java.util.*;

public class FracCalc {
	
    public static void main(String[] args) {
    	Scanner userInput = new Scanner (System.in);
    	System.out.print("What calculation should be performed? (type \"quit\" to stop) ");
    	String calc = userInput.nextLine();
    	if (calc.equals("quit")) {
    		System.out.println("Program stopped");	//stops program
    	 }
    	while (!calc.equals("quit")) {
        	System.out.println(produceAnswer(calc)); //prints out the second fraction
        	System.out.print("What calculation should be performed? (type \"quit\" to stop) ");
        	calc = userInput.nextLine();
        	if (calc.equals("quit")) {		//stops program
        		System.out.println("Program stopped");
        	}
    	}	
    	
    }
    
    
    public static String produceAnswer(String input) {
    	int length = input.length(); //length of input; is end of string
    	int space = input.indexOf(" "); //index of first space
    	
    	String firstFrac = input.substring(0, space); //finds the first fraction
    	String ffW = " ";
    	String ffN = " ";
    	String ffD = " ";
    	
    	int ffLength = firstFrac.length();	//length of firstFrac
    	int ffUnderscore = firstFrac.indexOf("_"); //firstFrac's indexOf underscore
    	int ffSlash = firstFrac.indexOf("/");	//firstFrac's indexOf slash
		
    	if (ffUnderscore > 0 && ffSlash > 0) {
    		ffW = firstFrac.substring(0, ffUnderscore);
    		int convertedffW = Integer.parseInt(ffW);	//converts to ffWhole to int
    		ffN = firstFrac.substring(ffUnderscore + 1, ffSlash);
    		int convertedffN = Integer.parseInt(ffN);	//converts ffNumerator to int
    		ffD = firstFrac.substring(ffSlash + 1, ffLength);
    		int convertedffD = Integer.parseInt(ffD);	//converts ffDenominator to int
    		firstFrac = "whole:" + convertedffW + " numerator:" + convertedffN + " denominator:" + convertedffD;
    	}
    	if (ffUnderscore == -1 && ffSlash == -1) {
    		firstFrac = "whole:" + firstFrac + " numerator:" + 0 + " denominator:1";
    	}
    	if (ffUnderscore == -1 && ffSlash > 0) {
    		ffN = firstFrac.substring(ffUnderscore + 1, ffSlash);
    		int convertedffN = Integer.parseInt(ffN);	//converts ffNumerator to int
    		ffD = firstFrac.substring(ffSlash + 1, ffLength);
    		int convertedffD = Integer.parseInt(ffD);	//converts ffDenominator to int
    		firstFrac = "whole:" + 0 + " numerator:" + convertedffN + " denominator:" + convertedffD;
    	}
    	
    	int x = space + 3; //index of fraction after operator
    	String secondFrac = input.substring(x, length); //finds the second fraction
    	String sfW = " ";
    	String sfN = " ";
    	String sfD = " ";
    	
    	int sfLength = secondFrac.length();	//length of secondFrac
    	int sfUnderscore = secondFrac.indexOf("_"); //secondFrac's indexOf underscore
    	int sfSlash = secondFrac.indexOf("/");	//secondFrac's indexOf slash
		
    	if (sfUnderscore > 0 && sfSlash > 0) {
    		sfW = secondFrac.substring(0, sfUnderscore);
    		int convertedsfW = Integer.parseInt(sfW);	//converts to sfWhole to int
    		sfN = secondFrac.substring(sfUnderscore + 1, sfSlash);
    		int convertedsfN = Integer.parseInt(sfN);	//converts sfNumerator to int
    		sfD = secondFrac.substring(sfSlash + 1, sfLength);
    		int convertedsfD = Integer.parseInt(sfD);	//converts sfDenominator to int
    		secondFrac = "whole:" + convertedsfW + " numerator:" + convertedsfN + " denominator:" + convertedsfD;
    	}
    	if (sfUnderscore == -1 && sfSlash == -1) {
    		secondFrac = "whole:" + secondFrac + " numerator:" + 0 + " denominator:1";
    	}
    	if (sfUnderscore == -1 && sfSlash > 0) {
    		sfN = secondFrac.substring(sfUnderscore + 1, sfSlash);
    		int convertedsfN = Integer.parseInt(sfN);	//converts sfNumerator to int
    		sfD = secondFrac.substring(sfSlash + 1, sfLength);
    		int convertedsfD = Integer.parseInt(sfD);	//converts sfDenominator to int
    		secondFrac = "whole:" + 0 + " numerator:" + convertedsfN + " denominator:" + convertedsfD;
    	}
    	
    	String operator = input.substring(space, space + 2); //finds the operator
    	
        return secondFrac;
    }
    
}
*/