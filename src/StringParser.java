// input: string inputted by user
// output: array formatted for shunting-yard converter

import java.util.*;
public class StringParser {
	public static Object[] parse(String input) {
		ArrayList<Object> arrInput = new ArrayList<Object>();
		boolean flgDigitEntered = false;
		boolean flgNegMode = false;
		boolean flgFractionMode = false;
		Double dblCurrentValue = new Double(0);
		int decimalPlaceCounter = 0;
		for (char i : input.toCharArray()) {
			if (Character.isDigit(i)) {
				flgDigitEntered = true;
				dblCurrentValue = dblCurrentValue * 10 +
								  new Double(Character.getNumericValue(i));
				if (flgFractionMode) {
					decimalPlaceCounter++;
				}
			}
			else if (i == '-' && flgDigitEntered == false) {
				flgNegMode = !flgNegMode;
			}
			else if (i == '.') {
				flgFractionMode = true;
			}
			else if (i != ' ') {
				if (flgDigitEntered) {
					if (flgFractionMode) {
						dblCurrentValue = dblCurrentValue / Math.pow(
										  10, decimalPlaceCounter);
						decimalPlaceCounter = 0;
						flgFractionMode = false;
					}
					if (flgNegMode) {
						arrInput.add(-dblCurrentValue);
						flgNegMode = false;
					}
					else {
						arrInput.add(dblCurrentValue);
					}
					dblCurrentValue = new Double(0);
					flgDigitEntered = false;
				}
				arrInput.add(Character.toString(i));
			}
		}
		if (flgDigitEntered) {
			if (flgFractionMode) {
				dblCurrentValue = dblCurrentValue /
								  Math.pow(10, decimalPlaceCounter);
			}
			if (flgNegMode) {
				arrInput.add(-dblCurrentValue);
			}
			else {
				arrInput.add(dblCurrentValue);
			}
		}
		return arrInput.toArray();
	}
}