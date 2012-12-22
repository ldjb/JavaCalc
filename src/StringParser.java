import java.util.*;
public class StringParser {
	public static Object[] parse(String input) {
		ArrayList<Object> arrInput = new ArrayList<Object>();
		for (char i : input.toCharArray()) {
			if (Character.isDigit(i)) {
				arrInput.add(new Double(Character.getNumericValue(i)));
			}
			else {
				arrInput.add(Character.toString(i));
			}
		}
		return arrInput.toArray();
	}
}