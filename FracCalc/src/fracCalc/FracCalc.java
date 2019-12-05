/* CHECKPOINT 1:
 * inside produceAnswer() find the length of the calculation
 * find indexOf the second space in the calculation
 * stringLength = length;	x = indexOf(" ") + 3;	substring(y, length);
 */


package fracCalc;
import java.util.*;

public class FracCalc {
	
    public static void main(String[] args) {
    	Scanner userInput = new Scanner (System.in);
    	System.out.print("What calculation should be performed? ");
    	String calc = userInput.nextLine();
    	produceAnswer(calc);
    	System.out.print(produceAnswer(calc)); //prints out the second fraction
    	
    	// TODO: Read the input from the user and call produceAnswer with an equation
    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input) {
    	int length = input.length(); //length of input; is end of string
    	int space = input.indexOf(" "); //index of first space
    	int x = space + 3; //index of fraction after operator
    	String secondFrac = input.substring(x, length); //finds the second fraction
    	
    	String firstFrac = input.substring(0, space); //finds the first fraction
    	
    	String operator = input.substring(space, space + 2); //finds the operator
    	
        return secondFrac;
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
