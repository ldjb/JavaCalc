/*******************************************************************************
** StringParser.java                                                          **
** -------------------------------------------------------------------------- **
** The parse() method takes a String as input and tokenises it, returning an  **
** Object array consisting of Double elements (for the numbers) and String    **
** elements (for the operators and parentheses).                              **
** -------------------------------------------------------------------------- **
** Developed by Leon Byford <ldjb20@bath.ac.uk>                               **
** Last modified: 26 December 2012                                            **
*******************************************************************************/

// import util package
import java.util.*;
public class StringParser {
	public static Object[] parse(String input) {
		// arrTokens holds tokenised values extracted from input
		ArrayList<Object> arrTokens = new ArrayList<Object>();
		// initialise 'flags'
		boolean flgDigitEntered = false;
		boolean flgNegMode = false;
		boolean flgFractionMode = false;
		// dblCurrentValue: variable to hold temporary values
		Double dblCurrentValue = 0d;
		// decimalPlaceCounter: used when a non-whole number is entered
		int decimalPlaceCounter = 0;
		// iterate over each character from input
		for (char i : input.toCharArray()) {
			// if the character is a digit (i.e. part of a number)
			if (Character.isDigit(i)) {
				// indicate that a digit has been entered
				flgDigitEntered = true;
				// update dblCurrentValue with the next digit
				dblCurrentValue = dblCurrentValue * 10 +
								  new Double(Character.getNumericValue(i));
				// if a fraction, move the decimal place
				if (flgFractionMode) {
					decimalPlaceCounter++;
				}
			}
			// if a '-' is encountered, toggle the negative mode
			else if (i == '-' && flgDigitEntered == false) {
				flgNegMode = !flgNegMode;
			}
			// if a '.' is encountered, turn on the fraction mode
			else if (i == '.') {
				flgFractionMode = true;
			}
			// if an operator or parenthesis is encountered
			else if (i != ' ') {
				// if a digit has been entered, add it to token array
				if (flgDigitEntered) {
					if (flgFractionMode) {
						dblCurrentValue = dblCurrentValue / Math.pow(
										  10, decimalPlaceCounter);
						decimalPlaceCounter = 0;
						flgFractionMode = false;
					}
					if (flgNegMode) {
						arrTokens.add(-dblCurrentValue);
						flgNegMode = false;
					}
					else {
						arrTokens.add(dblCurrentValue);
					}
					// reset values
					dblCurrentValue = 0d;
					flgDigitEntered = false;
				}
				// add operator/parenthesis to token array
				arrTokens.add(Character.toString(i));
			}
		}
		// if a digit has been entered, add it to token array
		if (flgDigitEntered) {
			if (flgFractionMode) {
				dblCurrentValue = dblCurrentValue /
								  Math.pow(10, decimalPlaceCounter);
			}
			if (flgNegMode) {
				arrTokens.add(-dblCurrentValue);
			}
			else {
				arrTokens.add(dblCurrentValue);
			}
		}
		// return token array as Object[] array
		return arrTokens.toArray();
	}
}