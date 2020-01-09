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
 * remember to INITIALIZE STRINGS
 * will convert strings to ints for future
 * produceAnswer("5_3/4 - 6_5/8") returns "whole:6 numerator:5 denominator:8"
 * 
 * CHECKPOINT 3:
 * create while loops for different operators and then use if statements within for underscores and slashes
 * eg: while (calc.contains("+")) {
 * 			finalW = convertedffW + convertedsfW;
 * 			if ((firstFrac.contains("_") && firstFrac.contains("/")) && (secondFrac.contains("_") && secondFrac.contains("/") {
 * 				finalN = convertedffN + convertedsfN;
 * 				finalD = convertedffD + convertedsfD;
 * 			}
 * 			and continue with if statements for any mix of "_"s and "/"s
 * MIGHT run into trouble with scope*** if it does, copy strings and variables into each while loop until find a more efficient way
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
    	int convertedffW = 0;
    	int convertedffN = 0;
    	int convertedffD = 0;
    	
    	int ffLength = firstFrac.length();	//length of firstFrac
    	int ffUnderscore = firstFrac.indexOf("_"); //firstFrac's indexOf underscore
    	int ffSlash = firstFrac.indexOf("/");	//firstFrac's indexOf slash
		
    	if (ffUnderscore > 0 && ffSlash > 0) {
    		ffW = firstFrac.substring(0, ffUnderscore);
    		convertedffW = Integer.parseInt(ffW);	//converts to ffWhole to int
    		ffN = firstFrac.substring(ffUnderscore + 1, ffSlash);
    		convertedffN = Integer.parseInt(ffN);	//converts ffNumerator to int
    		ffD = firstFrac.substring(ffSlash + 1, ffLength);
    		convertedffD = Integer.parseInt(ffD);	//converts ffDenominator to int
    	}
    	if (ffUnderscore == -1 && ffSlash == -1) {
    		ffW = firstFrac;
    		convertedffW = Integer.parseInt(ffW);	//converts to sfWhole to int
    	}
    	if (ffUnderscore == -1 && ffSlash > 0) {
    		ffN = firstFrac.substring(0, ffSlash);
    		convertedffN = Integer.parseInt(ffN);	//converts ffNumerator to int
    		ffD = firstFrac.substring(ffSlash + 1);
    		convertedffD = Integer.parseInt(ffD);	//converts ffDenominator to int
    	}
    	
    	int x = space + 3; //index of fraction after operator
    	String secondFrac = input.substring(x, length); //finds the second fraction
    	
    	String sfW = " ";
    	String sfN = " ";
    	String sfD = " ";
    	int convertedsfW = 0;
    	int convertedsfN = 0;
    	int convertedsfD = 0;
    	
    	int sfLength = secondFrac.length();	//length of secondFrac
    	int sfUnderscore = secondFrac.indexOf("_"); //secondFrac's indexOf underscore
    	int sfSlash = secondFrac.indexOf("/");	//secondFrac's indexOf slash
    	
    	if (sfUnderscore > 0 && sfSlash > 0) {	//mixed number
    		sfW = secondFrac.substring(0, sfUnderscore);
    		convertedsfW = Integer.parseInt(sfW);	//converts to sfWhole to int
    		sfN = secondFrac.substring(sfUnderscore + 1, sfSlash);
    		convertedsfN = Integer.parseInt(sfN);	//converts sfNumerator to int
    		sfD = secondFrac.substring(sfSlash + 1);
    		convertedsfD = Integer.parseInt(sfD);	//converts sfDenominator to int 
    	}
    	if (sfUnderscore == -1 && sfSlash == -1) {	//whole number
    		sfW = secondFrac;
			convertedsfW = Integer.parseInt(sfW);	//converts to sfWhole to int
    	}
    	if (sfUnderscore == -1 && sfSlash > 0) {	//only fraction
    		sfN = secondFrac.substring(sfUnderscore + 1, sfSlash);
			convertedsfN = Integer.parseInt(sfN);	//converts sfNumerator to int
			sfD = secondFrac.substring(sfSlash + 1);
			convertedsfD = Integer.parseInt(sfD);	//converts sfDenominator to int
    	}
    	
    	String operator = input.substring(space, space + 2); //finds the operator
    	String answer = " ";
    	
    	if (operator.contains("+")) {
    		answer = add(convertedffW, convertedffN, convertedffD, convertedsfW, convertedsfN, convertedsfD);
    		return answer;
    	}
    	
    	if (operator.contains("-")) {
    		answer = sub(convertedffW, convertedffN, convertedffD, convertedsfW, convertedsfN, convertedsfD);
    		return answer;
    	}
    	
    	if (operator.contains("*")) {
    		answer = mult(convertedffW, convertedffN, convertedffD, convertedsfW, convertedsfN, convertedsfD);
    		return answer;
    	}
    	
    	if (operator.contains("/")) {
    		answer = div(convertedffW, convertedffN, convertedffD, convertedsfW, convertedsfN, convertedsfD);
    		return answer;
    	}
    	
    	return answer;
    }
    
    
    public static String add(int cffW, int cffN, int cffD, int csfW, int csfN, int csfD) {
    	/* multiply fractions by each other's denom to create common denom
    	 * add together improper fracs
    	 * find common factor and reduce
    	 */	
    	String answer = " ";
    	int finalW = 0;
    	int finalN = 0;
    	int finalD = 1;
    	
    	int reducedW = 0;
    	int reducedN = 0;
    	int reducedD = 0;
    	
    	int newffN = 0;
    	int newsfN = 0;
    	int newffD = 1;
    	int newsfD = 1;
    	int commonD = 0;
    	
    	
    	if (cffN != 0 && csfN != 0) {		//both have fractions
    		if (cffW >= 0)	{
    			newffN = ((cffW * cffD) + cffN) * csfD;       		
    		} else {
    			newffN = ((cffW * cffD) - cffN) * csfD;        		
    		}
    		
    		if (csfW >= 0) {
    			newsfN = ((csfW * csfD) + csfN) * cffD;
    		} else {
    			newsfN = ((csfW * csfD) - csfN) * cffD;
    		}
    		
        	commonD = cffD * csfD;
    	}
    	if (cffN != 0 && csfN == 0) {		//second frac is whole number
    		if (cffW >= 0) {
    			newffN = ((cffW * cffD) + cffN) + (csfW * cffD);
    		} else {
    			newffN = ((cffW * cffD) - cffN) + (csfW * cffD);
    		}
    		
    		commonD = cffD;
    	}
    	if (cffN == 0 && csfN != 0) {		//first frac is a whole number
    		if (csfW >= 0) {
    			newsfN = ((csfW * csfD) + csfN) + (cffW * csfD);
    		} else {
    			newsfN = ((csfW * csfD) - csfN) + (cffW * csfD);
    		}
    		
    		commonD = csfD;
    	}
    	
    	System.out.println("cffW csfW: " + cffW + " " + csfW);
    	System.out.println("cffN csfN newffN newsfN: " + cffN + " " + csfN + " " + newffN + " " + newsfN);
    	System.out.println("cffD csfD newffD newsfD commonD: " + cffD + " " + csfD + " " + newffD + " " + newsfD + " " + commonD);
    	
    	
    	finalN = newffN + newsfN;
    	finalD = commonD;
    	
    	System.out.println("finalN and finalD: " + finalN + " " + finalD);
    	
    	//reduce fraction here
    	
    	if (finalD != 0) {
    		reducedW = finalN / finalD;
    		reducedN = finalN % finalD;
    	} else {
    		reducedW = 0;
    	}
    	
    	if (reducedW < 0) {
    		reducedN *= -1;
    	}
    	if (reducedW >= 0 && reducedN < 0) {
    		reducedN *= -1;
    	}
    	System.out.println("reducedW and reducedN: " + reducedW + " " + reducedN);
    	for (int i = reducedN; i > 0; i--) {
			if((reducedN % i == 0) && (finalD % i == 0)) {
				reducedN = reducedN / i;
				reducedD = finalD / i;
				
				break;
			}
		}
    	
    	if (finalN < 0) {
    		reducedN *= -1;
    	}
    	System.out.println("reducedN and reducedD: " + reducedN + " " + reducedD);
    	
    	
	
    	if (reducedW == 0) {		//if there are no whole numbers
    		answer = reducedN + "/" + reducedD;
    	}
    	if (reducedN == 0) {		//if a whole number
    		answer = Integer.toString(reducedW);
    	}
    	if (reducedW != 0 && reducedN != 0) {		//if a mixed fraction
    		answer = reducedW + "_" + reducedN + "/" + reducedD;
    	}
    	
    	return answer;
    }
    
    public static String sub(int cffW, int cffN, int cffD, int csfW, int csfN, int csfD) {
    	String answer = " ";
    	int finalW = 0;
    	int finalN = 0;
    	int finalD = 0;
    	
    	int reducedW = 0;
    	int reducedN = 0;
    	int reducedD = 0;
    	
    	int newffN = 0;
    	int newsfN = 0;
    	int newffD = 1;
    	int newsfD = 1;
    	int commonD = 1;
    	
    	if (cffN != 0 && csfN != 0) {		//both have fractions
    		if (cffW >= 0) {
    			newffN = ((cffW * cffD) + cffN) * csfD;
    		} else {
    			newffN = ((cffW * cffD) - cffN) * csfD;
    		}
    		
    		if (csfW >= 0) {
    			newsfN = ((csfW * csfD) + csfN) * cffD;
    		} else {
    			newsfN = ((csfW * csfD) + csfN) * cffD;
    		}
    		
        	commonD = cffD * csfD;
    	}
    	if (cffN != 0 && csfN == 0) {		//second frac is whole number
    		if (cffW >= 0) {
    			newffN = ((cffW * cffD) + cffN) + (csfW * cffD);
    		} else {
    			newffN = ((cffW * cffD) - cffN) + (csfW * cffD);
    		}
    		
    		commonD = cffD;
    	}
    	if (cffN == 0 && csfN != 0) {		//first frac is a whole number
    		if (csfW >= 0) {
    			newsfN = ((csfW * csfD) + csfN) + (cffW * csfD);
    		}
    		
    		commonD = csfD;
    	}
    	
    	System.out.println("cffW csfW: " + cffW + " " + csfW);
    	System.out.println("cffN csfN newffN newsfN: " + cffN + " " + csfN + " " + newffN + " " + newsfN);
    	System.out.println("cffD csfD newffD newsfD commonD: " + cffD + " " + csfD + " " + newffD + " " + newsfD + " " + commonD);
    	
    	
    	finalN = newffN - newsfN;
    	finalD = commonD;
    	
    	System.out.println("finalN and finalD: " + finalN + " " + finalD);
    	
    	
    	//in this space convert fraction back into a mixed number

    	if (finalD != 0) {
    		reducedW = finalN / finalD;
    		reducedN = finalN % finalD;
    	} else {
    		reducedW = 0;
    	}
    	
    	if (reducedW < 0) {
    		reducedN *= -1;
    	}
    	if (reducedW >= 0 && reducedN < 0) {
    		reducedN *= -1;
    	}
    	System.out.println("reducedW and reducedN: " + reducedW + " " + reducedN);
    	for (int i = reducedN; i > 0; i--) {
			if((reducedN % i == 0) && (finalD % i == 0)) {
				reducedN = reducedN / i;
				reducedD = finalD / i;
				
				break;
			}
		}
    	
    	if (finalN < 0) {
    		reducedN *= -1;
    	}
    	System.out.println("reducedN and reducedD: " + reducedN + " " + reducedD);
	
    	if (reducedW == 0) {		//if there are no whole numbers
    		answer = reducedN + "/" + reducedD;
    	}
    	if (reducedN == 0) {		//if a whole number
    		answer = Integer.toString(reducedW);
    	}
    	if (reducedW != 0 && reducedN != 0) {		//if a mixed fraction
    		answer = reducedW + "_" + reducedN + "/" + reducedD;
    	}
    	
    	return answer;
    }
    
    public static String mult(int cffW, int cffN, int cffD, int csfW, int csfN, int csfD) {
    	String answer = " ";
    	int finalW = 0;
    	int finalN = 0;
    	int finalD = 0;
    	
    	int reducedW = 0;
    	int reducedN = 0;
    	int reducedD = 0;
    	
    	int newffN = 0;
    	int newsfN = 0;
    	int newffD = 1;
    	int newsfD = 1;
    	int commonD = 1;
    	
    	if (cffN != 0 && csfN != 0) {		//both have fractions
    		
    		if (cffW >= 0) {
    			newffN = ((cffW * cffD) + cffN);
    		} else {
    			newffN = ((cffW * cffD) - cffN);
    		}
    		
    		if (csfW >= 0) {
    			newsfN = ((csfW * csfD) + csfN);
    		} else {
    			newsfN = ((csfW * csfD) - csfN);
    		}
    		commonD = cffD * csfD;	
    	}
    	if (cffN != 0 && csfN == 0) {		//second frac is whole number
    		
    		if (cffW >= 0) {
    			newffN = ((cffW * cffD) + cffN);
    		} else {
    			newffN = ((cffW * cffD) - cffN);
    		}
    		
    		newsfN = csfW;
    		commonD = cffD;
    	}
    	
    	if (cffN == 0 && csfN != 0) {		//first frac is a whole number
    		
    		if (csfW >= 0) {
    			newsfN = ((csfW * csfD) + csfN);
    		} else {
    			newsfN = ((csfW * csfD) + csfN);
    		}
    		
    		newffN = cffW;
    		commonD = csfD;
    	}
    	
    	System.out.println("cffW csfW: " + cffW + " " + csfW);
    	System.out.println("cffN csfN newffN newsfN: " + cffN + " " + csfN + " " + newffN + " " + newsfN);
    	System.out.println("cffD csfD newffD newsfD commonD: " + cffD + " " + csfD + " " + newffD + " " + newsfD + " " + commonD);
    	
    	
    
    	if (cffN != 0 && csfN != 0) {		//if both are fractions
    		finalN = newffN * newsfN;
    		finalD = commonD;
    	}
    	if (cffN != 0 && csfN == 0) {		//if only first is fraction, second is whole
    		finalN = newffN * newsfN;
    		finalD = commonD;
    	}
    	if (cffN == 0 && csfN != 0) {		//if only second is fraction, first is whole
    		finalN = newffN * newsfN;
    		finalD = commonD;
    	}
    	
    	System.out.println("finalN and finalD: " + finalN + " " + finalD);
    	
    	//in this space convert fraction back into a mixed number
    	
    	if (finalD != 0) {
    		reducedW = finalN / finalD;
    		reducedN = finalN % finalD;
    	} else {
    		reducedW = 0;
    	}
    	
    	if (reducedW < 0) {
    		reducedN *= -1;
    	}
    	if (reducedW >= 0 && reducedN < 0) {
    		reducedN *= -1;
    	}
    	System.out.println("reducedW and reducedN: " + reducedW + " " + reducedN);
    	for (int i = reducedN; i > 0; i--) {
			if((reducedN % i == 0) && (finalD % i == 0)) {
				reducedN = reducedN / i;
				reducedD = finalD / i;
				
				break;
			}
		}
    	
    	if (finalN < 0) {
    		reducedN *= -1;
    	}
    	System.out.println("reducedN and reducedD: " + reducedN + " " + reducedD);
    	
	
    	if (reducedW == 0) {		//if there are no whole numbers
    		answer = reducedN + "/" + reducedD;
    	}
    	if (reducedN == 0) {		//if a whole number
    		answer = Integer.toString(reducedW);
    	}
    	if (reducedW != 0 && reducedN != 0) {		//if a mixed fraction
    		answer = reducedW + "_" + reducedN + "/" + reducedD;
    	}
    	
    	return answer;
    }
    
    public static String div(int cffW, int cffN, int cffD, int csfW, int csfN, int csfD) {
    	String answer = " ";
    	int finalW = 0;
    	int finalN = 0;
    	int finalD = 0;
    	
    	int reducedW = 0;
    	int reducedN = 0;
    	int reducedD = 0;
    	
    	int newffN = 0;
    	int newsfN = 0;
    	int newffD = 0;
    	int newsfD = 0;
    	int commonD = 0;
    	
    	if (cffN != 0 && csfN != 0) {		//both have fractions
    		
    		if (cffW >= 0) {
    			newffN = ((cffW * cffD) + cffN);        		
    		} else {
    			newffN = ((cffW * cffD) - cffN);        		
    		}    	
    		
    		if (csfW >= 0) {
    			newsfN = ((csfW * csfD) + csfN);
    		} else {
    			newsfN = ((csfW * csfD) - csfN);
    		}    		
    		newffD = cffD;
        	newsfD = csfD;
    	}
    	
    	if (cffN != 0 && csfN == 0) {		//second frac is whole number
    		
    		if (cffW >= 0) {
    			newffN = ((cffW * cffD) + cffN);
    		} else {
    			newffN = ((cffW * cffD) - cffN);
    		}
    		
    		newsfN = csfW;
    		newffD = cffD;
    		newsfD = 1;
    	}
    	if (cffN == 0 && csfN != 0) {		//first frac is a whole number
    		if (csfW >= 0) {
    			newsfN = ((csfW * csfD) + csfN);
    		} else {
    			newsfN = ((csfW * csfD) - csfN);
    		}
    		
    		newffN = cffW;
    		newffD = 1;
    		newsfD = csfD;
    	}
    	
    	if (newsfN >= 0) {
    		commonD = newffD * newsfN;
    	} else {
    		commonD = newffD * newsfN;
    	}
    		
    	
    	System.out.println("cffW csfW: " + cffW + " " + csfW);
    	System.out.println("cffN csfN newffN newsfN: " + cffN + " " + csfN + " " + newffN + " " + newsfN);
    	System.out.println("cffD csfD newffD newsfD commonD: " + cffD + " " + csfD + " " + newffD + " " + newsfD + " " + commonD);
    	
    	
    	if (newffN != 0 && newsfN != 0) {
    		finalN = (newffN * newsfD) ;
    		finalD = commonD;
    	}
    	if (newffN != 0 && newsfN == 0) {
    		finalN = newffN;
    		finalD = commonD;
    	}
    	if (newffN == 0 && newsfN != 0) {
    		finalN = newsfN;
    		finalD = commonD;
    	}

    	System.out.println("finalN and finalD: " + finalN + " " + finalD);
    	
    	//in this space convert fraction back into a mixed number

    	if (finalD != 0) {
    		reducedW = finalN / finalD;
    		reducedN = finalN % finalD;
    	} else {
    		reducedW = 0;
    	}
    	
    	if (reducedW < 0) {
    		reducedN *= -1;
    	}
    	if (reducedW >= 0 && reducedN < 0) {
    		reducedN *= -1;
    	}
    	System.out.println("reducedW and reducedN: " + reducedW + " " + reducedN);
    	for (int i = reducedN; i > 0; i--) {
			if((reducedN % i == 0) && (finalD % i == 0)) {
				reducedN = reducedN / i;
				reducedD = finalD / i;
				
				break;
			}
		}
    	
    	if (reducedD < 0) {
    		reducedD *= -1;
    	}
    	
    	if (finalN < 0 && reducedN >= 0 && reducedW == 0) {
    		reducedN *= -1;
    	}
    	System.out.println("reducedN and reducedD: " + reducedN + " " + reducedD);
    	

    	if (reducedW == 0) {		//if there are no whole numbers
    		answer = reducedN + "/" + reducedD;
    	}
    	if (reducedN == 0) {		//if a whole number
    		answer = Integer.toString(reducedW);
    	}
    	if (reducedW != 0 && reducedN != 0) {		//if a mixed fraction
    		answer = reducedW + "_" + reducedN + "/" + reducedD;
    	}
    	
    	return answer;
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





