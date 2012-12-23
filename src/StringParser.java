// input: string inputted by user
// output: array formatted for shunting-yard converter

import java.util.*;
public class StringParser {
	public static Object[] parse(String input) {
		ArrayList<Object> arrInput = new ArrayList<Object>();
		boolean flgDigitEntered = false;
		Double dblCurrentValue = new Double(0);
		for (char i : input.toCharArray()) {
			if (Character.isDigit(i)) {
				flgDigitEntered = true;
				dblCurrentValue = dblCurrentValue * 10 +
								  new Double(Character.getNumericValue(i));
			}
			else {
				if (flgDigitEntered) {
					arrInput.add(dblCurrentValue);
					dblCurrentValue = new Double(0);
					flgDigitEntered = false;
				}
				arrInput.add(Character.toString(i));
			}
		}
		if (flgDigitEntered) {
			arrInput.add(dblCurrentValue);
		}
		//System.out.println(arrInput);
		return arrInput.toArray();
	}
}