/* CHECKPOINT 1:
 * inside produceAnswer() find the length of the calculation
 * find indexOf the second space in the calculation
 * stringLength = length;	x = indexOf(" ") + 3;	substring(y, length);
 * firstFrac = input.substring(0, space);	operator = input.substring(space, space + 2);
 *
 * CHECKPOINT 2:
 * in main method, ask for userInput until "quit" is typed
 * in produceAnswer() break up each fraction into whole number, numerator, and denominator
 * use if statement about underscores and slashes "/"
 * produceAnswer("5_3/4 - 6_5/8") returns "whole:6 numerator:5 denominator:8"
 */

// Equations to test:
// 1_2/3 + 4_5/6		5_3/4 - 6_5/8		-3/7 - 20		-32 - 27/21

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
//** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
// This function takes a String 'input' and produces the result
//
// input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
//      e.g. input ==> "1/2 + 3/4"
//        
// The function should return the result of the fraction after it has been calculated
//      e.g. return ==> "1_1/4"